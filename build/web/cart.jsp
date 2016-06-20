<%-- 
    Document   : cart
    Created on : 2016/06/20, 10:47:56
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
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>買い物かご -かごいっぱいのゆめ</title>
    </head>
    <body>
        <%
            if(Cart!=null){
            for(String key: Cart.keySet()){
                
        %>
        <a href = "Item?code=<%=Cart.get(key).getCode()%>">
            <%=Cart.get(key).getName()%>
        </a>
            <%=Cart.get(key).getPrice()%>円　<%=Cart.get(key).getNumber()%>個<br>
                <img src="<%=Cart.get(key).getImage()%>"><br>
            小計:<%=Cart.get(key).getPrice() * Cart.get(key).getNumber()%>円<br>
            <form action ="Deletecart" method ="POST">
                <input type="submit" name="delete" value="削除">
            </form><br>
        <%        
                sum += (Cart.get(key).getPrice() * Cart.get(key).getNumber());        
           }
        %>
            合計<%=sum%>円
            <form action ="Buyconfirm" method ="POST">
                <input type="submit" name="buy" value="購入する">
            </form>
        <%    
            }
            else{
                    out.print("カートには何も入っていません");
            }
        %>
    </body>
</html>
