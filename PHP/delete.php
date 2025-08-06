<?php
/*
削除用ファイル
ユーザーIDと投稿IDをもらい、投稿したユーザーと操作したユーザーが一致したならばDBから削除する
index.phpへ遷移する
*/
    session_start() ;
    // echo isset($_SESSION["logged_in"]);
    $dsn = "pgsql:host=localhost;dbname=album";
    $username = "postgres";
    $password = "system";
    $pdo = new PDO($dsn, $username, $password);
    if(isset($_SESSION["logged_in"]) && $_SESSION["logged_in"]) {
        $post_id = $_POST["post_id"];
        $user_id = $_SESSION["id"];
        $stmt = $pdo->prepare("SELECT posts.* FROM posts WHERE id = ?");
        $stmt->execute([$post_id]);
        $post = $stmt->fetch(PDO::FETCH_ASSOC);

        if($user_id == $post["user_id"]) {
            $stmt = $pdo->prepare("DELETE FROM posts WHERE id = ?");
            $stmt->execute([$post_id]);
            $_SESSION["message"] = "投稿を削除しました。";
            header("Location: index.php");
            return;
        }
        }else {
        }
        // echo $_SESSION["logged_in"];
        $_SESSION["message"] = "不正な操作です。";
        header("Location: index.php");
        return;
?>