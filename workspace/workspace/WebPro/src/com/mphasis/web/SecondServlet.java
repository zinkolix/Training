package com.mphasis.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet(name = "Second", urlPatterns = { "/Second.as" })
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<body bgcolor=cyan text=blue>");
		out.println("<h1>This is my second Servlet :P</h1><hr>");
		out.println("<h2>The quick brown fox jumps over the lazy dog.</h2></body>");
	}

}
