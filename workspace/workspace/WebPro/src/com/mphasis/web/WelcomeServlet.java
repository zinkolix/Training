package com.mphasis.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet(
		name = "Welcome", 
		urlPatterns = { "/Welcome.as" }, 
		initParams = { 
				@WebInitParam(name = "USER", value = "Ashwini Sharma")
		})
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int counter;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Grabbing config object from servlet
		ServletConfig config = getServletConfig();
		
		// Reading the init-param from config
		String initParam = config.getInitParameter("USER");
		
		PrintWriter out = response.getWriter();
		
		out.println("<body bgcolor=olive text=beige");
		out.println("<h1>Hello " + initParam + "</h1><hr>");
		counter ++;
		out.println("<h2> You're visitor no. " + counter);
		Date visitTime = new Date();
		out.println("<h2>Visit time: " + visitTime);
		out.println("</h2></body>");
	}

}
