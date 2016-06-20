<%-- 
    Document   : footer
    Created on : 2016/06/17, 14:12:44
    Author     : Wataru
--%>

<%@page language="java" contentType="text/html; charset =UTF-8" pageEncoding="UTF-8"%>
<%@page import="jums.UserData"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
  HttpSession hs= request.getSession();
  UserData ud = new UserData();
    if(hs.getAttribute("ud")!= null){
        ud = (UserData)hs.getAttribute("ud");
    }
        if(ud.getUserID()!=0){
%>
            ようこそ<a href="Mydata"><%=ud.getUsername()%></a>さん
            <a href="Cart">買い物かご</a>
            <a href="Logout">ログアウト</a>
<%         
        }else{
%>
            <a href="Login">ログイン</a>
    <%  }   %>

             
    

