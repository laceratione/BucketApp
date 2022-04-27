package com.demo.BucketApp.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class MainController {
    String filePath;
    String fileName;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/addPhoto", method = RequestMethod.GET)
    public String getTestPage(Model model) {
        return "addPhoto";
    }

    @RequestMapping(value = "/addDesc", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model) {
        try{
            fileName = multipartFile.getOriginalFilename();
            model.addAttribute("fileName", fileName);
            File image = convertMultiToFile(multipartFile);
            S3NinjaBucket bucket = new S3NinjaBucket();
            bucket.uploadFile(image, "oleg");
        } catch (Exception e){
            e.printStackTrace();
        }
        return "addDesc";
    }

    @RequestMapping(value="/getData", method=RequestMethod.POST)
    public @ResponseBody
    JsonResponse addUser(@RequestParam("param1") String s) throws IOException {
        String desc = s;

        //загружаем изображение из бакета
        S3NinjaBucket bucket = new S3NinjaBucket();
        File file = bucket.downloadFile("oleg", fileName);
        byte[] image =  Files.readAllBytes(file.toPath());
        String imageBase64 = Base64.encodeBase64String(image);

        JsonResponse response = new JsonResponse();

        if(desc != ""){
            String text ="                    <div class=\"post\">\n" +
                    "                        <div class=\"info\">\n" +
                    "                            <div class=\"user\">\n" +
                    "                                <div class=\"profile-pic\"><img src=\"/images/cover 1.png\" alt=\"\"></div>\n" +
                    "                                <p class=\"username\">user_account</p>\n" +
                    "                            </div>\n" +
                    "                            <img src=\"/images/option.PNG\" class=\"options\" alt=\"\">\n" +
                    "                        </div>\n" +
                    "                        <img src=\"data:image/png;base64, " + imageBase64 + "\" alt=\"\" class=\"post-image\">\n" +
                    "                        <div class=\"post-content\">\n" +
                    "                            <div class=\"reaction-wrapper\">\n" +
                    "                                <img src=\"/images/like.PNG\" class=\"icon\" alt=\"\">\n" +
                    "                                <img src=\"/images/comment.PNG\" class=\"icon\" alt=\"\">\n" +
                    "                                <img src=\"/images/send.PNG\" class=\"icon\" alt=\"\">\n" +
                    "                                <img src=\"/images/save.PNG\" class=\"save icon\" alt=\"\">\n" +
                    "                            </div>\n" +
                    "                            <p class=\"likes\">1,012 likes</p>\n" +
                    "                            <p class=\"description\"><span>username_another </span>" + desc + "</p>\n" +
                    "                            <p class=\"post-time\">2 minutes ago</p>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"comment-wrapper\">\n" +
                    "                            <img src=\"/images/smile.PNG\" class=\"icon\" alt=\"\">\n" +
                    "                            <input type=\"text\" class=\"comment-box\" placeholder=\"Add a comment\">\n" +
                    "                            <button class=\"comment-btn\">post</button>\n" +
                    "                        </div>\n" +
                    "                    </div>";

            response.setStatus("SUCCESS");
            response.setResult(text);
        }else{
            response.setStatus("FAIL");
            response.setResult("ERROR");
        }

        return response;
    }

    private File convertMultiToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(multipartFile.getBytes());
        fos.close();
        return file;
    }

}
