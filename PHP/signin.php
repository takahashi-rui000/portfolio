<!DOCTYPE html>
<?php
/*
サインインページ
*/
session_start();
if(isset($_SESSION["message"]) && $_SESSION["message"] != null) {
    $message = $_SESSION["message"];
    include("notification.php");
    unset($_SESSION["message"]);
} 
?>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <header>
            <div class="title">
                <h1>PhotoAlbum</h1>
            </div>
        </header>
        <div class="form" id="signin-form">
            <h2>Sign in</h2>
            <form action="signin-process.php" method="post" enctype="multipart/form-data">
                <div class="form-item">
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name" maxlength="50" required>
                </div>
                <div class="form-item">
                    <label for="id">ID</label>
                    <input type="text" name="user_id" id="id" maxlength="50" required>
                </div>
                <div class="form-item">
                    <label for="password">PASSWORD</label>
                    <input type="password" name="password" id="password" maxlength="50" required>
                </div>
                <div class="form-item" id="inpImg">
                    <label for="image">Icon Image</label>
                    <input type="file" id="fileElem" style="display:none" name="image" required/><button id="fileSelect" type="button">Choose file</button>
                </div>
                <button type="submit">submit</button>
            </form>
        </div>
    </div>
    <footer>
        <p>PhotoAlbum</p>
    </footer>

    <!-- スクリプト -->
    <script>
    const fileSelect = document.getElementById("fileSelect");
    const fileElem = document.getElementById("fileElem");

    fileSelect.addEventListener("click", (e) => {
    if (fileElem) {
        fileElem.click();
    }
    }, false);
    </script>
    <!-- スクリプト終わり -->
     
</body>
</html>