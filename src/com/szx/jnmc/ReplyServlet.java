package com.szx.jnmc;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String Comment = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
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
		String username=(String)session.getAttribute("username");//获取登陆的用户名
		int to_id=Integer.valueOf((String)session.getAttribute("id")).intValue();//获取帖子ID
		String content=request.getParameter("content");//获取内容
		Date time=new Date(1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置成mysql能识别的datetime形式
		String createtime=sdf.format(time);
		//获取被评论者
		DBconn.Connect();
	//	String to_id=(String)session.getAttribute("id");
		
	//	int to_id=Integer.valueOf((String)session.getAttribute("id")).intValue();//获取帖子ID
		UserDao user=new UserDao();
		if( user.addContent(username,to_id,content,createtime)) {
		   // user.addComment(String comment){
		   //留言成功
			request.getRequestDispatcher("success.jsp").forward(request,response);//携带参数重定向到登录页面
		}else {
			//留言失败
			response.sendRedirect("Message.jsp"); 
		
        }
	
        
		
		
		
	}

}
