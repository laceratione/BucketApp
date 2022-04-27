<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="css/post.css">
    </head>
    <body>
        <div align="center" class="container">
            <div class="card">
                <form:form class="card-form" action="addDesc" method="post" enctype="multipart/form-data">
                    <table border="0" cellpadding="5">
                        <tr>
                            <td>Select a file to upload</td>
                        </tr>

                        <tr>
                            <td><input type="file" name="file" /></td>
                        </tr>

                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="Upload Photo" class="action-button">
                            </td>
                        </tr>
                    </table>
                </form:form>
            <div>
        </div>
    </body>
</html>