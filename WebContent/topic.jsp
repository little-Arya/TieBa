<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>发布页</title>
<link rel="stylesheet" type="text/css" href="topic.css"/>
<style>dis{text-align:center}</style>
</head>
<body>
<script type="text/javascript">
function checkTitle(){
	var flag = true;
	var title = document.getElementById("title").value;
	if ("" == title){
		alert("请输入标题！");
		flag = false;
	}
	return flag;
}
function checkText(){
	var flag=true;
	var text=document.getElementById("text").value;
	if ("" == text){
		alert("请输入内容！");
		flag = false;
	}
	return flag;
}
 function checkAll(){  
	          
	          var title = checkTitle();  
	          var text = checkText();    		         
	          if(title&&text){  
	              return true;  
	          }else{  
	              return false;  
	          }  
	      }
</script>
<a href="success.jsp">返回首页</a>	
  <div style="width:1000px;text-align:center">
 <b>发起话题</b><br><br>
 <form  method="post"action="TextServlet" onsubmit="return checkAll()">
 <input  id="title"type="text"name="title"value="${title}"placeholder="请输入标题"style="width:300px; height:20px;text-align:center;background:transparent;border:1px solid #ffffff" /><br><br>
 <textarea id="text"type="text"name="message"value="${message}"placeholder="请输入内容"style="width:300px; height:300px;text-align:center;background:transparent;border:1px solid #ffffff">
</textarea><br><br>
<input type="submit" value="提交发布"  />&nbsp;&nbsp;
<input type="reset"value="重置" />
 </form></div>
</body>
</html>