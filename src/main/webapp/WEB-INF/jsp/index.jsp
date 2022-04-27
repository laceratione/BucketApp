<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="../js/ajaxCom.js"></script>

    </head>
    <body>

        <nav class="navbar">
            <div class="nav-wrapper">
                <img src="../images/logo.PNG" class="brand-img" alt=""/>
                <input type="text" class="search-box" placeholder="search">
                <div class="nav-items">
                    <img src="../images/home.PNG" class="icon" alt="">

                    <img src="../images/messenger.PNG" class="icon" alt="">

                    <a href="http://localhost:8080/addPhoto" target = "_blank">
                        <img src="../images/add.PNG" class="icon" alt="">
                    </a>

                    <img src="../images/explore.PNG" class="icon" alt="">
                    <img src="../images/like.PNG" class="icon" alt="">
                    <div class="icon user-profile"></div>
                </div>
            </div>
        </nav>


        <section class="main">
            <div class="wrapper" id="container">
                <div class="left-col" id="test">

                    <div class="status-wrapper">
                        <div class="status-card">
                            <div class="profile-pic"><img src="../images/cover 1.png" alt=""></div>
                            <p class="username">username1</p>
                        </div>
                        <div class="status-card">
                            <div class="profile-pic"><img src="../images/cover 1.png" alt=""></div>
                            <p class="username">username2</p>
                        </div>
                        <div class="status-card">
                            <div class="profile-pic"><img src="../images/cover 1.png" alt=""></div>
                            <p class="username">username3</p>
                        </div>
                        <div class="status-card">
                            <div class="profile-pic"><img src="../images/cover 1.png" alt=""></div>
                            <p class="username">username4</p>
                        </div>
                        <div class="status-card">
                            <div class="profile-pic"><img src="../images/cover 1.png" alt=""></div>
                            <p class="username">username5</p>
                        </div>

                    </div>

                    <div class="post">
                        <div class="info">
                            <div class="user">
                                <div class="profile-pic"><img src="../images/cover 2.png" alt=""></div>
                                <p class="username">user_account</p>
                            </div>
                            <img src="../images/option.PNG" class="options" alt="">
                        </div>
                        <img src="../images/cover 1.png" class="post-image" alt="">
                        <div class="post-content">
                            <div class="reaction-wrapper">
                                <img src="../images/like.PNG" class="icon" alt="">
                                <img src="../images/comment.PNG" class="icon" alt="">
                                <img src="../images/send.PNG" class="icon" alt="">
                                <img src="../images/save.PNG" class="save icon" alt="">
                            </div>
                            <p class="likes">1,515 likes</p>
                            <p class="description"><span>username_another </span> Description user_account</p>
                            <p class="post-time">5 minutes ago</p>
                        </div>
                        <div class="comment-wrapper">
                            <img src="../images/smile.PNG" class="icon" alt="">
                            <input type="text" class="comment-box" placeholder="Add a comment">
                            <button class="comment-btn">post</button>
                        </div>
                    </div>
                </div>

            </div>

        </section>

    </body>
</html>