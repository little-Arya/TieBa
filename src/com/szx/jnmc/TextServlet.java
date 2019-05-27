package com.szx.jnmc;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TextServlet
 */
@WebServlet("/TextServlet")
public class TextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TextServlet() {
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
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
	    HttpSession session=request.getSession(); 
	    String username=(String)session.getAttribute("username");
		//获取当前时间
		//long l = System.currentTimeMillis();
		Date time=new Date(1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置成mysql能识别的datetime形式
		String time1=sdf.format(time);
		//获取留言标题
		String title=request.getParameter("title");
		//获取留言内容
		String message=request.getParameter("message");
		UserDao user=new UserDao();
		if( user.addText(username,title,message,time1)) {
			//留言成功
			request.getRequestDispatcher("success.jsp").forward(request,response);//携带参数重定向到登录页面
		}else {
			//留言失败
			response.sendRedirect("topic.jsp"); 
		
        }
        
		}
		
	/*	
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset = utf-8");
        String username = request.getParameter("username");
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        Date time=new Date(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time1=sdf.format(time);
      //  PrintWriter out = response.getWriter();
        ServletContext ctx = this.getServletContext();
        String server = ctx.getInitParameter("server");
        String dbname = ctx.getInitParameter("dbname");
        String dbuser = ctx.getInitParameter("dbuser");
        String dbpwd = ctx.getInitParameter("dbpwd");
        User user = new User();
        user.setUsername(username);
        user.setTitle(title);
        user.setMessage(message);
        //user.setRole(Integer.parseInt(role));
        
        UserDao dao = new UserDao();
        dao.getConn(server, dbname, dbuser, dbpwd);
        
        if( user.addText(username,title,message,time1)) {
			//留言成功
			request.getRequestDispatcher("success.jsp").forward(request,response);//携带参数重定向到登录页面
		}else {
			//留言失败
			response.sendRedirect("topic.jsp"); 
		
        }
        

    }

	*/
	

}
