<?php

/*
リアクション処理ファイル
リアクションを行うユーザーIDと対象の投稿IDを受け取り、
未リアクションならDBへ登録し、index.phpへ遷移する。
*/
    session_start();
    if(isset($_SESSION["logged_in"]) && $_SESSION["logged_in"]) {
        if(isset($_POST["post_id"]) && $_POST["post_id"] != "") {
            $user_id = $_SESSION["id"];
            $post_id = $_POST["post_id"];

            $dsn = "pgsql:host=localhost;dbname=album";
            $username = "postgres";
            $password = "system";
            $pdo = new PDO($dsn, $username, $password);

            $stmt = $pdo->prepare("SELECT COUNT(*) FROM post_likes WHERE user_id = ? AND post_id = ?");
            $stmt->bindParam(1, $user_id, PDO::PARAM_INT);
            $stmt->bindParam(2, $post_id, PDO::PARAM_INT);
            $stmt->execute();
            $count = $stmt->fetchColumn();
            if($count <= 0) {
                $stmt = $pdo->prepare("INSERT INTO post_likes (user_id, post_id) VALUES(:user_id, :post_id)");
                $stmt->bindParam("user_id", $user_id, PDO::PARAM_INT);
                $stmt->bindParam("post_id", $post_id, PDO::PARAM_INT);
                $stmt->execute();
            } else {

            }

        } else {
        }
    } else {
    }
    header("Location: index.php");
    exit;
?>