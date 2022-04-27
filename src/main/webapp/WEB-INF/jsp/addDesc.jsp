<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="css/post.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="../js/getData.js"></script>

    </head>
    <body>
        <div align="center" class="container">
            <div class="card">
                <form:form class="card-form">
                    <table border="0" cellpadding="5">
                        <tr>
                            <td>File:</td>
                        </tr>
                        <tr>
                            <td>${fileName}</td>
                        </tr>
                        <tr>
                            <td>Add description at Photo</td>
                        </tr>
                        <tr>
                            <td><input type="text" id="desc" class="input-field"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="button" value="Upload Post" class="action-button" onclick="doAjaxPost()">
                            </td>
                        </tr>
                    </table>
                </form:form>
            <div>
        </div>
    </body>
</html>