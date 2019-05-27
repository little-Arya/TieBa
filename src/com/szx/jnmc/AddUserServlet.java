package com.szx.jnmc;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("utf-8");
        //response.setContentType("text/html;charset = utf-8");
        request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        //String role = request.getParameter("role");
        Date curTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String regtime = sdf.format(curTime);
        PrintWriter out = response.getWriter();
        ServletContext ctx = this.getServletContext();
        String server = ctx.getInitParameter("server");
        String dbname = ctx.getInitParameter("dbname");
        String dbuser = ctx.getInitParameter("dbuser");
        String dbpwd = ctx.getInitParameter("dbpwd");
        User user = new User();
        user.setUsername(username);
        user.setUserpass(userpass);
        user.setRegtime(regtime);
        //user.setRole(Integer.parseInt(role));
        
        UserDao dao = new UserDao();
        dao.getConn(server, dbname, dbuser, dbpwd);
        
        if(null==username||null==userpass||username.equals("")||userpass.equals(""))
        	{out.print("<br><a href = 'addUser.jsp'>注册名和密码都不能为空</a>");}
        
        else if(dao.addUser(user)){
          //  out.print("注册成功！");
            request.getRequestDispatcher("login.jsp").forward(request,response);//携带参数重定向到登录页面
        }
        else{
            out.print("注册失败！");
        }
        

    }

	

}
