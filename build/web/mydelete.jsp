<%-- 
    Document   : mydelete
    Created on : 2016/06/17, 15:40:48
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
        <title>ユーザー削除確認ページ</title>
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
        このユーザーをマジで削除しますか？
        <form action="Mydeleteresult" method="POST">
            <input type="submit" name="yes" value="はい">    
        </form>
        <form action="/top.jsp" method="POST">
            <input type="submit" name="no" value="いいえ">    
        </form>
    </body>
</html>
