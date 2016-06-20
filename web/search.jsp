<%-- 
    Document   : search
    Created on : 2016/06/13, 15:27:08
    Author     : Wataru
--%>

<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>

<%
    HttpSession hs = request.getSession();
    JsonNode jsonnode = (JsonNode)hs.getAttribute("jsonnode");
    JumsHelper jh = new JumsHelper();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Yahoo!ショッピング検索結果</title>
        <link rel ="stylesheet" href ="stylesheet.css">
    </head>
    <body>
        <jsp:include page="/footer.jsp" /><br>
        <% 
            String searchword = request.getParameter("product_name");
        %>
            検索キーワード:<%=searchword%><br><br>
            <%=searchword%>の検索結果:<%=jh.getTotalresult(jsonnode)%>件<br><br>
        
        <%
            for(int i=0; i<20; i++){
        %>
                <li>
                    <a href = "Item?code=<%=i%>">
                        <%=jh.getName(jsonnode, i)%>
                    </a>
                </li>   
                <img src ="<%=jh.getImage(jsonnode, i)%>">
                価格:<%=jh.getPrice(jsonnode, i)%>円<br>
            <%}%>
        </a>   
    </body>
</html>