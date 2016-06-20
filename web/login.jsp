<%-- 
    Document   : login
    Created on : 2016/06/15, 23:07:05
    Author     : Wataru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン -かごいっぱいのゆめ</title>
        <link rel ="stylesheet" href ="stylesheet.css">
    </head>
    <body>
        <a href="Registration">新規会員登録</a>
        <form action ="Loginresult" method="POST">
            ユーザー名:<input type="text" name="username" size="30" maxlength="30"><br>
            パスワード:<input type="password" name="password" size="30" maxlength="30"><br>
            <input type="submit" value="ログイン">
        </form>
    </body>
</html>
