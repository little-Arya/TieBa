package com.szx.jnmc;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		// ��������������Ҫ�õ�request,response,session����
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
       HttpSession session = servletRequest.getSession();

       // ����û������URI
       //String path = servletRequest.getRequestURI();
        //System.out.println(path);
       
        // ��session��ȡԱ��������Ϣ
       
       String username = (String) session.getAttribute("username");

       /*������Constants.java������д����������˵�ҳ��
        for (int i = 0; i < Constants.NoFilter_Pages.length; i++) {

            if (path.indexOf(Constants.NoFilter_Pages[i]) > -1) {
                chain.doFilter(servletRequest, servletResponse);
                return;
            }
        }*/
        
        // ��½ҳ���������
       // if(path.indexOf("/login.jsp") > -1) {
       //     chain.doFilter(servletRequest, servletResponse);
        //  return;
      // }

        // �ж����û��ȡ��Ա����Ϣ,����ת����½ҳ��
        if (username == null || "".equals(username)) {
            // ��ת����½ҳ��
        	System.out.print("�㻹û�е�¼�����ȵ�¼");
            servletResponse.sendRedirect("login.jsp");
        } else {
            // �Ѿ���½,�����˴�����
            chain.doFilter(request, response);}

		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
