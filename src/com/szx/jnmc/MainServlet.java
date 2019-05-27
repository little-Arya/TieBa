package com.szx.jnmc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
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
		  // request.setCharacterEncoding("GBK");
	      // response.setContentType("text/html;charaset = GBK");
	      // PrintWriter out = response.getWriter();
	       // HttpSession session = request.getSession();
	      // String username = (String)session.getAttribute("username");
	     //  String logtime = (String)session.getAttribute("logtime");
	      //  out.println("登录名:"+username+"&nbsp;&nbsp;&nbsp;&nbsp;登陆时间:"+logtime);
	      // out.println("欢迎"+username);
	        
	       response.setContentType("text/html;charset=utf-8");
	       
	       PrintWriter out=response.getWriter();
	        
	      // out.print("<script language='javascript'>alert('登录已成功即将跳转到贴吧页面');window.open ('success.jsp') ;</script>");
	  //    out.print("<br><a href = 'success.jsp'>跳转到贴吧页面</a>");
	      request.getRequestDispatcher("success.jsp").forward(request,response);//携带参数重定向到登录页面
	    }
	}

	
