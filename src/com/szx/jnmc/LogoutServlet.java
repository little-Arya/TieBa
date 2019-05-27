package com.szx.jnmc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
/*		 request.getSession().removeAttribute("user");
		HttpSession session = request.getSession();	       
	     String username = (String) session.getAttribute("username");
		 Cookie cookie = new Cookie("username",username);
		 cookie.setPath(request.getContextPath());
		 cookie.setMaxAge(60*60*24*30);
         response.addCookie(cookie);
         response.sendRedirect(request.getContextPath()+"/success.jsp");*/
		 
		 HttpSession session=request.getSession();
	        if (session==null){
	            response.sendRedirect("login.jsp");
	            return;
	        }
	        else {
	        session.removeAttribute("user");
	        session.removeAttribute("username");
	        response.sendRedirect("success.jsp");}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
