package com.mphasis.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("*.jsp")
public class LogFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here for request interception
		System.out.println("Request Time " + new Date());
		System.out.println("Requester IP " + request.getRemoteAddr());
		// pass the request along the filter chain
		chain.doFilter(request, response);
		// place your code here to intercept response.
		PrintWriter out = response.getWriter();
		out.println("<hr>&copy; Copyright 2020 Mphasis Corp. ");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
