package com.exam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		httpResponse.setHeader("Cache-Control","no-cache");
		httpResponse.setHeader("Cache-Control","no-store");
		httpResponse.setHeader("Pragma","no-cache");
		httpResponse.setDateHeader ("Expires", 0);
/*
		if(session.getAttribute("token")== null) {
			  httpResponse.sendRedirect("forms/user/userlogin.html");
    	}*/
		//httpResponse.sendRedirect("forms/user/userlogin.html");//redirection code
		chain.doFilter(request, response);
	}

    public void init(FilterConfig config) throws ServletException {
    	
    	
    }

    public void destroy() {
        //add code to release any resource
    }
}
