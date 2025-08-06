<?php
// 既存のセッションを初期化し、新しいセッションを取得、index.phpへ遷移
    session_start();
    $_SESSION = [];
    $_SESSION["message"] = "ログアウトします。";
    header("Location: index.php");
?>