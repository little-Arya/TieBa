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
<title>查找页面</title>
</head>
<body>
<a href="success.jsp">返回首页</a>	
<form><input type="text"name="name"required="required"><input type="submit"value="搜索"onclick="sel()"></form>

<script language="javascript">
 
 function sel(){
 
     document.thisform.submit();
 
}
 
</script>

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
                String vs=request.getParameter("name");
                String sql = "select * from Message where message like '%vs%'";  //查询语句
                stmt = conn.createStatement();  
                rs = stmt.executeQuery(sql);  
                out.print(" ");  
				out.print("<br/>");
                while (rs.next()) {%>
                  
     <div><br> <h2><%=rs.getString("sql") %> 
 <%}
}else{  
                out.print("连接失败！");
            }  
        }catch (Exception e) {
            out.print("数据库连接异常！");
        }%>


</body>
</html>