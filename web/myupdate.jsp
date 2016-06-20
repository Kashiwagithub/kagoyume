<%-- 
    Document   : myupdate
    Created on : 2016/06/17, 16:39:34
    Author     : Wataru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.UserData"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="jums.JumsHelper"%>

<%
    HttpSession hs = request.getSession();
    UserData ud = (UserData)hs.getAttribute("ud");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザーデータ更新 -かごいっぱいのゆめ</title>
    </head>
    <body>
        <jsp:include page="/footer.jsp" /><br>
        <form action ="Myupdateresult" method="POST">
            ユーザー名:<input type="text" name="username" size="30" maxlength="30" value="<%=ud.getUsername()%>"><br>
            パスワード:<input type="password" name="password" size="30" maxlength="30"<%=ud.getPassword()%>"><br>
            E-mail:<input type="email" name="email" size="30" maxlength="50" value="<%=ud.getMail()%>"><br>
            住所:<input type="text" name="address" value="<%=ud.getAddress()%>">
            <input type="submit" value="送信">
        </form>
    </body>
</html>
