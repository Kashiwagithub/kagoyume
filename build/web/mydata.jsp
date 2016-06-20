<%-- 
    Document   : mydata
    Created on : 2016/06/17, 11:59:02
    Author     : Wataru
--%>

<%@page import="jums.UserData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%
    HttpSession hs = request.getSession();
    UserData ud = (UserData)hs.getAttribute("ud");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザー情報 -かごいっぱいのゆめ</title>
        <link rel ="stylesheet" href ="stylesheet.css">
    </head>
    <body>
        <jsp:include page="/footer.jsp" /><br>
        ユーザー情報
        <ul>
            <li>
        ユーザー名:<%=ud.getUsername()%><br>
        パスワード:********<br>
        メールアドレス:<%=ud.getMail()%><br>
        住所:<%=ud.getAddress()%><br>
        合計金額:<%=ud.getTotal()%><br>
            </li>
        </ul>
        <form action ="Myupdate" method ="POST">
            <input type="submit" value="ユーザー情報の更新">
        </form>
        <form action ="Mydelete" method ="POST">
            <input type="submit" value="ユーザーの削除">
        </form>
    </body>
</html>
