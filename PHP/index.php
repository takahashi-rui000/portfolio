<?php
/*
入口ページ
ログイン/サインイン/ログアウトや、投稿一覧、投稿フォームがある。
*/
session_start();
if(isset($_SESSION["logged_in"]) && $_SESSION["logged_in"]) {
    $icon = $_SESSION["icon"];
    $name = $_SESSION["name"];
}
$dsn = "pgsql:host=localhost;dbname=album";
$username = "postgres";
$password = "system";

// 投稿idリストを取得
$pdo = new PDO($dsn, $username, $password);
$stmt = $pdo->prepare("SELECT posts.id FROM posts ORDER BY id DESC");
$stmt->execute();
$post_ids = $stmt->fetchAll(PDO::FETCH_COLUMN);
// セッション"message"が存在していれば通知用ページをインクルードする
if(isset($_SESSION["message"]) && $_SESSION["message"] != null) {
    $message = $_SESSION["message"];
    include("notification.php");
    unset($_SESSION["message"]);
} 
?>
<!DOCTYPE html>
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
            <!-- タイトル -->
            <div class="title">
                <h1>PhotoAlbum</h1>
            </div>
            <!-- タイトル終わり -->
            <?php
            // プロフィール
                if(isset($_SESSION["logged_in"]) && $_SESSION["logged_in"]) {
                    echo "
                    <div class='profile'>
                        <div class='icon'><img src=$icon alt='' class='icon'></div>
                        <div class='name'>$name</div>
                        <a href='logout.php' class='logout_btn'>LOGOUT</a>
                    </div>
                    ";
            // プロフィール終わり
                }else {
            // ログイン
                    echo"
                    <div id='login-form'>
                        <form action='login.php' method='post'>
                            <input type='text' name='user_id' placeholder='ID' maxlength='20' required>
                            <div class='passwordField'>
                                <input type='password' id='password' name='password' placeholder='Password' maxlength='30' required><br>
                                <button type='button' onclick='togglePassword()'>
                                <img id='tglImg' src='./images/eye.svg'>
                                </button>
                            </div>
                            <a href='signin.php'><button id='signinBtn' type='button'>SIGNIN</button></a>
                            <button id='loginBtn'type='submit' name='login'>LOGIN</button>
                        </form>
                    </div>
                    ";
            // ログイン終わり
                }
            ?>
        </header>
        <?php
        // 投稿送信エリア
        if(isset($_SESSION["logged_in"]) && $_SESSION["logged_in"]) {    
        ?>
        <div class="post-area">
            <div class="form" id="post-form">
                <form action="post_create.php" method="post" enctype="multipart/form-data">
                    <div class="form-item">
                        <label for="title">Title</label>
                        <input type="text" name="title" maxlength="100" required>
                    </div>
                    <div class="form-item">
                        <label for="description">Discription</label>
                        <textarea name="description" maxlength="1000" required></textarea>
                    </div>
                    <div class="form-item" id="inpImg">
                        <label for="image">Image</label>
                        <input type="file" id="fileElem" style="display:none" name="image"/><button id="fileSelect" type="button">Choose file</button>
                    </div>
                    <button type="submit" class="submit">submit</button>
                </form>
            </div>
        </div>
        <?php
        }
        // 投稿送信エリア終わり
        ?>
        <div class="posts">
            <?php
            // 投稿閲覧エリア
            foreach($post_ids as $post_id) {
                include("post.php");
            }
            ?>
        </div>

    </div>
    <footer>
        <p>PhotoAlbum</p>
    </footer>

    <!-- スクリプト -->
    <script>
    const fileSelect = document.getElementById("fileSelect");
    const fileElem = document.getElementById("fileElem");
    // ファイル読み込み用
    fileSelect.addEventListener("click", (e) => {
        if (fileElem) {
            fileElem.click();
        }
    }, false);
    // パスワード入力欄の切り替えボタンを押した際の処理
    // typeをpasswordとtextで切り替え、画像も応じて切り替える
    function togglePassword() {
        const passField = document.getElementById('password');
        const tglImg = document.getElementById('tglImg');
        if(passField.type === 'password') {
            passField.type = 'text';
            tglImg.src = './images/eye.svg';
        } else {
            passField.type = 'password';
            tglImg.src = './images/eye-slash.svg';
        }
    }

    </script>
    <!-- スクリプト終わり -->
</body>
</html>