<%-- 
    Document   : registrationconfirm
    Created on : 2016/06/16, 1:09:50
    Author     : Wataru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.Registrationconfirm" %>
<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%@page import="java.util.*" %>

<%
    JumsHelper jh =new JumsHelper();
    HttpSession hs = request.getSession();
    UserData ud = (UserData)hs.getAttribute("ud");
    ArrayList<String> checkList = ud.checkproperties();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認 -かごいっぱいのゆめ</title>
        <link rel ="stylesheet" href ="stylesheet.css">
    </head>
    <body>
        <h1>登録確認</h1>
        <jsp:include page="/footer.jsp" /><br>
        <%if(checkList.size()==0){ %>
        <ul>
            <li>
        ユーザー名:<%=ud.getUsername()%><br>
        パスワード:********<br>
        メールアドレス:<%=ud.getMail()%><br>
        住所:<%=ud.getAddress()%><br>
            </li>
        </ul>
        「上記の内容で登録いたします。よろしいですか？」
        <form action="Registrationcomplete" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
        <%}else{ %>
        <p>入力が不完全です</p>
        <%=jh.checkinput(checkList) %>
        <% } %>
        <form action="registration.jsp" method="POST">
            <input type="submit" name="no" value="いいえ">
            <input type="hidden" name="mode" value="REINPUT">
        </form>
    </body>
</html>
