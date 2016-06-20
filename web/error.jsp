<%-- 
    Document   : error
    Created on : 2016/06/16, 16:49:25
    Author     : Wataru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>エラー</title>
    </head>
    <body>
        エラーが発生しました。以下の項目を確認してください。<br>
        <%=request.getAttribute("error")%><br><br>
        <a href ="top.jsp">トップページに戻る</a>
    </body>
</html>
