package com.demo.BucketApp.controller;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.s3.transfer.TransferManager;

import java.io.*;

public class S3NinjaBucket {
    String accessKey = "AKIAIOSFODNN7EXAMPLE";
    String secretKey = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
    String NINJA_URL = "http://localhost:9444/s3";
    AWSCredentials credentials;
    AmazonS3 s3;
    TransferManager transferManager;

    public S3NinjaBucket() {
        s3 = AmazonS3Client.builder()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://192.168.99.100:9444/s3", null))
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(accessKey, secretKey)))
                .withPathStyleAccessEnabled(true)
                .withClientConfiguration(new ClientConfiguration().withSignerOverride("S3SignerType"))
                .build();
    }

    public void createBucket(String bucketName) {
        s3.createBucket(bucketName);
    }

    public void uploadFile(File file, String bucketName) {
        try {
            s3.putObject(new PutObjectRequest(bucketName, file.getName(), file));
            System.out.println("Upload file done!");
        } catch (AmazonServiceException e) {
            System.exit(1);
        }
    }

    public File downloadFile(String bucketName, String keyName) {
        try {
            S3Object object = s3.getObject(bucketName, keyName);
            InputStream reader = new BufferedInputStream(object.getObjectContent());
            File file = new File(keyName);
            OutputStream writer = new BufferedOutputStream(new FileOutputStream(file));

            int read = -1;
            while ((read = reader.read()) != -1) {
                writer.write(read);
            }

            writer.flush();
            writer.close();
            reader.close();
            System.out.println("Download file from bucket done!");
            return file;
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public void deleteBucket(String bucketName) {
        s3.deleteBucket(bucketName);
    }

}
