<%@page import="java.sql.*"%>
<%@page import="com.szx.jnmc.User"%>
<%@page import="com.szx.jnmc.DBconn" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
<link rel="stylesheet" type="text/css" href="addUser.css"/>
</head>
<body>
 <div class="wrap">
        <div class="container"><br><br><br><br>
            <h1>Welcome</h1>
<form action = "AddUserServlet" method = "POST">
    <input id="username" type = "text" name = "username"required="required" placeholder="user login"onblur="send()"><span id="error"></span>
    <input type = "password" name = "userpass"placeholder="password">
    <input type = "submit" value = "注册">
    <input type = "reset" value = "重置">
    </form>
     </div>
    </div>

</body>
</html>