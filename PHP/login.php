<?php
/*
ログイン用ファイル
idでDBからパスワードを受け取り、入力されたパスワードをハッシュ化したものと比較する
一致したら情報をセッションへ登録し、index.phpへ遷移
一致しなかった場合、そのままindex.phpへ遷移
*/
    session_start();
    // DB接続
    $dsn = "pgsql:host=localhost;dbname=album";
    $username = "postgres";
    $password = "system";
    $pdo = new PDO($dsn, $username, $password);
    
    // パラメータ受取
    $inpPass = $_POST["password"] ?? "";
    $user_id = $_POST["user_id"] ?? "";
    echo $user_id;
    // ユーザー検索
    $stmt = $pdo->prepare("SELECT users.* FROM users WHERE user_id = ?");
    $stmt->execute([$user_id]);
    $result = $stmt->fetch(PDO::FETCH_ASSOC);
    if($result && password_verify($inpPass, $result["password"])) {
        // ログイン成功
        $_SESSION["id"] = $result["id"];
        $_SESSION["name"] = $result["name"];
        $_SESSION["icon"] = $result["icon"];
        $_SESSION["user_id"] = $result["user_id"];
        $_SESSION["logged_in"] = true;
        $_SESSION["message"] = "ログインに成功しました。";
    } else {
        $_SESSION["message"] = "パスワードまたはユーザーIDが違います。";
    }
    header("Location: index.php");
?>