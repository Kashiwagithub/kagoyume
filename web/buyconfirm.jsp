<%-- 
    Document   : buyconfirm
    Created on : 2016/06/20, 13:16:40
    Author     : Wataru
--%>
<%@page import = "javax.servlet.http.HttpSession" %>
<%@page import ="java.util.*"%>
<%@page import="jums.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    HashMap<String,ItemDataBeans> Cart = (HashMap<String,ItemDataBeans>)hs.getAttribute("Cart");
    int sum = 0;
    JumsHelper jh = new JumsHelper();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入確認 -かごいっぱいのゆめ</title>
    </head>
    <body>
        <%
            for(String key: Cart.keySet()){
        %>
            <%=Cart.get(key).getName()%> <%=Cart.get(key).getPrice()%>円　<%=Cart.get(key).getNumber()%>個<br>
            小計:<%=Cart.get(key).getPrice() * Cart.get(key).getNumber()%>円<br><br>   
        <%
                sum += (Cart.get(key).getPrice() * Cart.get(key).getNumber());
            }
        %>
            合計<%=sum%>円  
            <form action ="Buycomplete" method ="POST">
                <% for(int i = 1; i<=3; i++){ %>
                <input type="radio" name="type" value="<%=i%>" checked>
                <%=jh.exTypenum(i)%>
                <%}%>
                <input type="hidden" name="sum" value="<%=sum%>">
                <input type="submit" value="上記の内容で購入する">
            <form action ="Cart" method ="POST">
                <input type="submit" value="カートに戻る">
            </form>
    </body>
</html>
