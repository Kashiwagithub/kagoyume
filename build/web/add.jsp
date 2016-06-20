<%-- 
    Document   : add
    Created on : 2016/06/15, 13:46:47
    Author     : Wataru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "javax.servlet.http.HttpSession" %>
<%@page import ="java.util.*"%>
<%@page import="jums.ItemDataBeans"%>

<%
    HttpSession hs = request.getSession();
    HashMap<String,ItemDataBeans> Cart = (HashMap<String,ItemDataBeans>)hs.getAttribute("Cart");
    String code = (String)request.getAttribute("Code");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カート -かごいっぱいのゆめ</title>
    </head>
    <body>
        <jsp:include page="/footer.jsp" /><br>
        <%out.print(Cart.get(code).getName());%>を<%out.print(Cart.get(code).getNumber());%>個カートに追加しました<br>
    </body>
</html>
