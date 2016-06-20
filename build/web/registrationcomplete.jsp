<%-- 
    Document   : registrationcomplete
    Created on : 2016/06/16, 11:20:02
    Author     : Wataru
--%>

<%@page import="jums.UserData"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  HttpSession hs = request.getSession();
  UserData ud = (UserData)hs.getAttribute("ud");  
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録完了 -かごいっぱいのゆめ</title>
        <link rel ="stylesheet" href ="stylesheet.css">
    </head>
    <body>
        <jsp:include page="/footer.jsp" /><br>
        <ul>
            <li>
        ユーザー名:<%=ud.getUsername()%><br>
        パスワード:********<br>
        メールアドレス:<%=ud.getMail()%><br>
        住所:<%=ud.getAddress()%><br>
            </li>
        </ul>
        「以上の内容で登録しました。」
    </body>
</html>
