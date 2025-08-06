<?php
/*
サインインファイル
ユーザー名とパスワードのフォーマットを制限
ユーザーIDが重複していなければ、入力された情報をもとにDBへ登録
*/
    session_start();
    try{
        // 画像のチェック
        // 拡張子チェック（例：jpg, png, gifのみ許可）
        $allowed_ext = ['jpg', 'jpeg', 'png', 'gif', 'svg', 'jfif', 'avif'];
        $ext = strtolower(pathinfo($_FILES['image']['name'], PATHINFO_EXTENSION));
        if (!in_array($ext, $allowed_ext)) {
            $_SESSION["message"] = "画像ファイル形式が許可されていません";
            header("Location: signin.php");
            exit;
        }
        if (!isset($_FILES['image']) || $_FILES['image']['error'] !== UPLOAD_ERR_OK) {
            $_SESSION["message"] = "画像のアップロードに失敗しました。" . ($_FILES['image']['error'] ?? 'ファイルが選択されていません');
            header("Location: signin.php");
            exit;
        }

        // DB接続
        $dsn = "pgsql:host=localhost;dbname=album";
        $username = "postgres";
        $password = "system";
        $pdo = new PDO($dsn, $username, $password);

        // パラメータ受取
        $name = $_POST["name"] ?? "";
        $raw_pass = $_POST["password"] ?? "";
        $hash_pass = password_hash($raw_pass, PASSWORD_DEFAULT);
        $user_id = $_POST["user_id"] ?? "";

        // 文字種チェック
        if(!preg_match('/^[a-zA-Z0-9_]{3,20}$/', $user_id)) {
            $_SESSION["message"] = "ユーザー名は3~20文字以内の英数字とアンダースコアで入力してください。";
            header("Location: signin.php");
                exit;
        }else if(!preg_match('/^[a-zA-Z0-9_]{3,30}$/', $raw_pass)){
            $_SESSION["message"] = "パスワードは3~30文字以内の英数字とアンダースコアで入力してください";
            header("Location: signin.php");
                exit;
        }else {
            // ユーザーID重複チェック
            $stmt = $pdo->prepare("SELECT * FROM users WHERE user_id = ?");
            $stmt->execute([$user_id]);
            if ($stmt->rowCount() > 0) {
                $_SESSION["message"] = "そのユーザーIDは既に使われています。";
                header("Location: signin.php");
                exit;
            } else {
                // ユーザー追加
                $stmt = $pdo->prepare("INSERT INTO users (name, password, user_id) VALUES(:name, :password, :user_id)");
                $stmt->bindParam(':name', $name, PDO::PARAM_STR);
                $stmt->bindParam(':password', $hash_pass, PDO::PARAM_STR);
                $stmt->bindParam(':user_id', $user_id, PDO::PARAM_STR);
                $stmt->execute();
                // ID取得
                $insId = $pdo->lastInsertId();

                // 画像をiconsフォルダへ保存
                $filename = $_FILES["image"]["name"];
                $target_dir = "icons/";
                $ext = strtolower(pathinfo($filename, PATHINFO_EXTENSION));
                $target_file = $target_dir . $insId . "." . $ext;
                if (move_uploaded_file($_FILES["image"]["tmp_name"], $target_file)) {
                    $stmt = $pdo->prepare("UPDATE users SET icon = :icon WHERE id = :id");
                    $stmt->bindParam(':icon', $target_file, PDO::PARAM_STR);
                    $stmt->bindParam(':id', $insId, PDO::PARAM_INT);
                    if($stmt->execute()) {
                        $_SESSION["id"] = $insId;
                        $_SESSION["name"] = $name;
                        $_SESSION["icon"] = $target_file;
                        $_SESSION["user_id"] = $user_id;
                        $_SESSION["logged_in"] = true;
                        $_SESSION["message"] = "アカウントの作成に成功しました。";
                        header("Location: index.php");
                        exit;
                    }
                }else {

                }
            }

        }
    }catch(PDOException $e) {
        $_SESSION["message"] = "登録に失敗しました。";
        header("Location: signin.php");
        exit;
    }


?>
