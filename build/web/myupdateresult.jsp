<%-- 
    Document   : myupdateresult
    Created on : 2016/06/17, 17:34:40
    Author     : Wataru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.UserData"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%
    HttpSession hs = request.getSession();
    UserData ud = (UserData)hs.getAttribute("ud");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザー情報更新完了 -かごいっぱいのゆめ</title>
        <link rel ="stylesheet" href ="stylesheet.css">
        <jsp:include page="/footer.jsp" /><br>
        <ul>
            <li>
        ユーザー名:<%=ud.getUsername()%><br>
        パスワード:********<br>
        メールアドレス:<%=ud.getMail()%><br>
        住所:<%=ud.getAddress()%><br>
            </li>
        </ul>
        「以上の内容で更新しました。」
    </head>
    <body>
        
    </body>
</html>
