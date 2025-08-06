<?php
/*
ポスト投稿用ファイル
タイトルと本文、画像をアップロードしていれば画像を受け取る
画像をimagesフォルダに保存し、タイトルと本文、保存した画像のパス、投稿日時、ユーザーIDをDBに保存する
index.phpへ遷移する
*/

    session_start();
    // 画像のチェック
    // 拡張子チェック（例：jpg, png, gifのみ許可）
    $allowed_ext = ['jpg', 'jpeg', 'png', 'gif', 'svg', 'jfif', 'avif'];
    $ext = strtolower(pathinfo($_FILES['image']['name'], PATHINFO_EXTENSION));
    if (isset($_FILES['image']) && $_FILES['image']['error'] === UPLOAD_ERR_OK) {
        if (!in_array($ext, $allowed_ext)) {
        $_SESSION["message"] = "画像ファイル形式が許可されていません";
        header("Location: index.php");
        exit;
    }
    }
    // DB接続
    $dsn = "pgsql:host=localhost;dbname=album";
    $username = "postgres";
    $password = "system";
    $pdo = new PDO($dsn, $username, $password);
    $user_id = $_SESSION["id"];
    $created_at = $today = date("Y-m-d");
    if((!isset($_POST["title"]) && $_POST["title"] == null) || !isset($_PST["description"]) && $_POST["description"] == null) {
        $_SESSION["message"] = "タイトルと本文を入力してください。";
        header("Location: index.php");
        exit;
    }else {
        $title = $_POST["title"];
        $description = $_POST["description"];
    }
    // 各情報を取得し、INSERT文へセット
    $stmt = $pdo->prepare("INSERT INTO posts (user_id, created_at, title, description) VALUES(:user_id, :created_at, :title, :description)");
    $stmt->bindParam(':user_id', $user_id, PDO::PARAM_INT);
    $stmt->bindParam(':created_at', $created_at, PDO::PARAM_STR);
    $stmt->bindParam(':title', $title, PDO::PARAM_STR);
    $stmt->bindParam(':description', $description, PDO::PARAM_STR);
    // 実行できたなら
    if($stmt->execute()) {
        // 保存した投稿IDを取得
        $post_id = $pdo->lastInsertId();
        // 画像が存在している場合
        if(isset($_FILES["image"])) {
            // imagesフォルダへ保存
            $filename = $_FILES["image"]["name"];
            $target_dir = "post_images/";
            $ext = strtolower(pathinfo($filename, PATHINFO_EXTENSION));
            $target_file = $target_dir . $post_id . "." . $ext;
            if (move_uploaded_file($_FILES["image"]["tmp_name"], $target_file)) {
                // 画像テーブルへ登録
                $stmt = $pdo->prepare("INSERT INTO post_images (path, post_id) VALUES(:path, :post_id)");
                $stmt->bindParam("path", $target_file, PDO::PARAM_STR);
                $stmt->bindParam("post_id", $post_id, PDO::PARAM_INT);
                $stmt->execute();
                // 登録した画像IDを取得
                $image_id = $pdo->lastInsertId();
                // 保存した投稿へ画像IDを登録
                $stmt = $pdo->prepare("UPDATE posts SET image_id = :image_id WHERE id = :post_id");
                $stmt->bindParam("image_id", $image_id, PDO::PARAM_INT);
                $stmt->bindParam("post_id", $post_id, PDO::PARAM_INT);
                if($stmt->execute()) {
                }
            }
        }
        $_SESSION["message"] = "投稿に成功しました。";
    }else {
        $_SESSION["message"] = "投稿に失敗しました。";
    }
    // index.php遷移
    header("Location: index.php");
    exit;
?>