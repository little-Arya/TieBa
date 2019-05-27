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
<title>首页</title>
<link rel="stylesheet" type="text/css" href="success.css"/>
<style>div{text-align:center}</style>
</head>
<body>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎来到此贴吧
       

				<img src="images/02.gif" width="26" height="23" style="margin-bottom:-4px" />&nbsp;<a href="success.jsp">首页</a> 
				| <a href="topic.jsp">发起话题</a>  		
				| <a href="search.jsp"><input type="text"name="name"><button>搜索</button></a>	
		     	| <a href="addUser.jsp">新用户注册</a>		
				| <a href="login.jsp">登录</a>
				| <a href="LogoutServlet">注销</a>
			
				
               
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
                ResultSet rs = null;  
                ResultSet ps =null;
                String sql = "SELECT * FROM Message";  //查询语句
               // String rep="SELECT * FROM Comment ";
                stmt = conn.createStatement();  
                rs = stmt.executeQuery(sql);  
              //  ps = stmt.executeQuery(rep);
                out.print(" ");  
				out.print("<br/>");
                while (rs.next()) {%>
     <div class ="all">            
     <div><br> <h2><%=rs.getString("title") %> </h2>
         <p><h4><%=rs.getString("message") %></h4></p>
      <li><%=rs.getString("username") %>&nbsp;&nbsp;&nbsp;<a href="Message.jsp?id=<%=rs.getString("id")%>">评论</a>&nbsp;</li>
 <br>
 
 </div></br><br/>   </div> 
 <%}
}else{  
                out.print("连接失败！");
            }  
        }catch (Exception e) {
            out.print("数据库连接异常！");
        }%>


</body>
</html>