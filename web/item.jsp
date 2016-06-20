<%-- 
    Document   : item
    Created on : 2016/06/13, 15:27:24
    Author     : Wataru
--%>

<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@page import = "javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.JumsHelper" %>

<%
    HttpSession hs = request.getSession();
    JsonNode jsonnode = (JsonNode)hs.getAttribute("jsonnode");
    int i = Integer.parseInt(request.getParameter("code"));
    JumsHelper jh = new JumsHelper();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=jh.getName(jsonnode, i)%> -かごいっぱいのゆめ
        </title>
        <link rel ="stylesheet" href ="stylesheet.css">
    </head>
    <body>
        <jsp:include page="/footer.jsp" /><br>
        <%=jh.getName(jsonnode, i)%><br>
        <img src ="<%=jh.getImage(jsonnode, i)%>">
        価格:<%=jh.getPrice(jsonnode, i)%>円<br><br>
        商品説明<br><br><%=jh.getDescription(jsonnode, i)%><br><br>
        評価:<%=jh.getReview(jsonnode, i)%><br>
        <%
            if(jh.getReview(jsonnode, i) == 0.00){
                out.println("評価なし");
            }
        %>
        <br><br>
        <form action ="Add" method ="GET">
            <select name="number">
                <%for(int j=1; j<=999; j++){ %>
            <option value="<%=j%>"> <%=j%></option>
            <% } %>
            </select>
            <input type="submit" value="カートに追加">
            <input type="hidden" name="code" value="<%=i%>">
        </form>
    </body>
</html>
