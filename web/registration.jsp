<%-- 
    Document   : registration
    Created on : 2016/06/15, 19:35:35
    Author     : Wataru
--%>

<%@page import="jums.UserData"%>
<%@page import="jums.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "javax.servlet.http.HttpSession" %>

<%
    HttpSession hs = request.getSession();
    JumsHelper jh = new JumsHelper();
    UserData ud = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        ud = (UserData)hs.getAttribute("ud");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規会員登録 - かごいっぱいのゆめ</title>
        <link rel ="stylesheet" href ="stylesheet.css">
    </head>
    <script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
        
    <body>
        <jsp:include page="/footer.jsp" /><br>
        <form action ="Registrationconfirm" method="POST">
            ユーザー名:<input type="text" name="username" size="30" maxlength="30" value="<% if(reinput){out.print(ud.getUsername());}%>"><br>
            パスワード:<input type="password" name="password" size="30" maxlength="30"><br>
            E-mail:<input type="email" name="email" size="30" maxlength="50" value="<% if(reinput){out.print(ud.getMail());}%>"><br>
            
            <%--郵便番号から住所を自動入力--%>
            郵便番号:〒<input type="text" name="zip21" size="3" maxlength="3">-<input type="text" name="zip22" size="4" maxlength="4" onKeyUp="AjaxZip3.zip2addr('zip21','zip22','address','address');">
            <a href ="http://www.post.japanpost.jp/zipcode/">郵便番号検索</a><br>
            住所:<input type="text" name="address" value="<% if(reinput){out.print(ud.getAddress());}%>">
            <input type="submit" value="送信">
        </form>
    </body>
</html>
