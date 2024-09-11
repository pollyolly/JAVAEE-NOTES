package com.Authentication;

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
 * Servlet Filter implementation class LogoutFilter
 */
@WebFilter("/LogoutFilter")
public class LogoutFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogoutFilter() {
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
		 HttpServletRequest request1 = (HttpServletRequest) request;
		    HttpServletResponse response1 = (HttpServletResponse) response;
		    HttpSession session = request1.getSession();         
		     if (session == null) {
		    response1.sendRedirect("Authentication"); // No logged-in user found, so redirect to login page.
		} else {
		    response1.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		    response1.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		    response1.setDateHeader("Expires", 0);
			chain.doFilter(request1, response1);
		}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
