package com.mphasis.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

@WebServlet(name = "Hello", urlPatterns = { "/Hello.as" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	//setting response MIME type
	response.setContentType("text/html");
	
	//Grabbing output stream for writing HTML response to client.
	PrintWriter out = response.getWriter();
	
	//Writing HTML to response stream
	out.println("<body bgcolor=aqua text=blue>");
	out.println("<h1>Hello Beautiful World</h1><hr>");
	out.println("<h2>Welcome to my First Servlet</h2></body>");
	}

}
