<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆页面</title>
<link rel="stylesheet" type="text/css" href="login.css"/>
</head>
<body> 

<div id="login_frame">
<p id="image_logo"><img src="images/01.png"></p>

<form method = "POST" action = "LoginServlet">
<p><label class="label_input">用户名</label><input type = "text" name = "username"class="text_field"/><br><br></p>
<p><label class="label_input">密码</label><input type = "password" name = "userpass"class="text_field"/><br><br></p>
   <div id="login_control">
<input type = "submit" value = "登陆">&nbsp;&nbsp;&nbsp;
<input type = "reset" value = "重置"></div>
 </form>
</div>
</body>
</html>