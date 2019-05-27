<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@page import="com.szx.jnmc.User"%>
<%@page import="com.szx.jnmc.DBconn" %>
<%@ page language="java"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>评论页面</title>
<link rel="stylesheet" type="text/css" href="message.css"/>
</head>
<body>
<script>function checkText(){
		var flag=true;
		var text=document.getElementById("text").value;
		if ("" == text){
			alert("请输入内容！");
			flag = false;
		}
		return flag;
	}</script>
	
<style>div{text-align:center}
hs{position: absolute;left:400px;}</style>

<a href="success.jsp">返回首页</a>	
  <div>    <h3>评论</h3> </div>
  <br>
 
	<div>
	<div class="container">
 <form  method="post"action="ReplyServlet" onsubmit="return checkText()">
 <textarea id="text"type="text"name="content"value="${content}"placeholder="请输入内容"required="required"style="text-align:center;width:300px; height:200px" >
</textarea> &nbsp;&nbsp;<input type="submit" value="提交发布"  />&nbsp;&nbsp;
<input type="reset"value="重置" />
</div>
</form>
</div>

<% String id1=request.getParameter("id");
session.setAttribute("id", id1);
String id=(String)session.getAttribute("id");

%>

<%  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  ////驱动程序名
            String url = "jdbc:mysql://localhost:3306/A20170512"; //数据库名
            String username = "root";  //数据库用户名
            String password = "123456";  //数据库用户密码
            Connection conn = DriverManager.getConnection(url, username, password);  //连接状态

            if(conn != null){  
                out.print(" ");  
                out.print("<br />"); 
%>

<%
                Statement stmt = null;  
                ResultSet ps =null;               
               String rep="select * from Comment where to_id='"+id+"' ";//查询语句   这里好像复制多来不行，要重新打一遍
            // String rep="SELECT * FROM Comment WHERE to_id='id' ";
             //   ArrayList<Comment> list = new ArrayList<Comment>(); 
                stmt = conn.createStatement();  
                ps = stmt.executeQuery(rep);
                out.print(" ");  
				out.print("<br/>");
                while (ps.next()) {%>
                  
     <br>
 <br>
 
 
<hs> <img style="width:40px; height:40px;"src ="images/01.png" />&nbsp;&nbsp;
    <%=ps.getString("username") %><br></br>
&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=ps.getString("content") %></hs><br><br><br><br>
 </br><br/>   
 <%}
}else{  
                out.print("连接失败！");
            }  
        }catch (Exception e) {
            out.print("数据库连接异常！");
        }%>

</body>
</html>