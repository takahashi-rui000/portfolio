<!DOCTYPE html>
<?php
/*
通知用ページ
インクルード元から文字列を受け取り、それを表示する
*/
?>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notification</title>
    <link rel="stylesheet" href="css/notification.css">
</head>
<body>
    <div id="notification">
        <!-- 変数messageが存在していれば表示する -->
        <div class="message"><?php echo isset($message) && $message != "" ? $message : "" ?></div>
    </div>
</body>
    <script>
        const noti = document.getElementById('notification');
        const message = document.querySelector(".message");

        // 2秒後にフェードアウトし、id要素を消す
        let opacity = 100;
        setTimeout(() => {
            const fadeOut = setInterval(()=> {
                opacity -= 10;
                noti.style.opacity = opacity + "%";
                if(opacity <= 0) {
                    clearInterval(fadeOut);
                    noti.remove();
                }
            }, 100);
        }, 2000);
    </script>
</html>