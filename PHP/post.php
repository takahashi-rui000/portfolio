<?php
/*
投稿表示ページ
*/
    $pdo = new PDO($dsn, $username, $password);
    // 投稿取得
    $stmt = $pdo->prepare("SELECT posts.* FROM posts WHERE id = ?");
    $stmt->execute([$post_id]);
    $post = $stmt->fetch(PDO::FETCH_ASSOC);
    // ユーザーID取得
    $user_id = $post["user_id"];
    // ユーザー取得
    $stmt = $pdo->prepare("SELECT users.* FROM users WHERE id = ?");
    $stmt->execute([$user_id]);
    $user = $stmt->fetch(PDO::FETCH_ASSOC);
    // グッド数取得
    $stmt = $pdo->prepare("SELECT COUNT(*) FROM post_likes WHERE post_id = ?");
    $stmt->execute([$post["id"]]);
    $good = $stmt->fetchColumn();
    // 画像取得
    $stmt = $pdo->prepare("SELECT post_images.path FROM post_images WHERE post_id = ?");
    $stmt->execute([$post["id"]]);
    $image = $stmt->fetchColumn();
    // 操作しているユーザ－ID取得
    $currentUser = isset($_SESSION["id"]) ? $_SESSION["id"] : 0;
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Document</title>
</head>
<body>
    <div class="post-container">
        <div class="post-info">
            <div class="user-info">
                <?php
                // ユーザーのアイコンと名前を表示
                echo "<div><img src='" , $user["icon"], "' class='icon'></div>";
                echo "<div class='user_name'>" , $user["name"], "</div>";
                ?>
            </div>
            <div class="created_at">
                <?php
                // 投稿時間
                echo $post["created_at"];
                ?>
            </div>
            <div class="post-action">
                <div class="goods">
                    <?php
                    // リアクション数を表示・リアクション用PHPファイルへ遷移
                    echo "
                    <form action='good.php' method='post'>
                        <input type='hidden' name='post_id' value='$post_id' >
                        <button class='good-button' type='submit'>
                        👍 $good
                        </button>
                    </form>
                    
                    ";
                    ?>
                </div>
                <div class="post-delete">
                    <?php
                    // 投稿の削除ボタン・削除用PHPファイルへ遷移
                    if($currentUser == $post["user_id"]) {
                        echo "
                        <form action='delete.php' method='post'>
                        <input type='hidden' name='post_id' value='$post_id' >
                        <button type='submit' class='delete'>DELETE</button>
                        </form>
                        ";
                    }
                    ?>
                </div>
            </div>
        </div>
        <div class="post-content">
            <div class="post-text">
                <div class="post-title">
                    <?php
                    // 投稿のタイトル
                    echo htmlspecialchars($post["title"], ENT_QUOTES, 'UTF-8');
                    ?>
                </div>
                <div class="post-description">
                    <?php
                    // 投稿の本文
                    echo htmlspecialchars($post["description"], ENT_QUOTES, 'UTF-8');
                    ?>
                </div>
            </div>
            <div class="post-image">
                <?php
                // 画像があれば画像を表示
                echo "<img src='".$image."'>";
                ?>
            </div>
        </div>
    </div>
</body>
</html>