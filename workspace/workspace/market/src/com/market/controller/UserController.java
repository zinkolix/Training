package com.market.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.market.bean.LoginBean;
import com.market.bean.UserBean;
import com.market.service.ShoppingService;
import com.market.service.ShoppingServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet(name = "User", urlPatterns = { "/User.do" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingService service;

	@Override
	public void init() throws ServletException {
		service = new ShoppingServiceImpl(); // In servelet we use life cycle
												// and instantiate the objects
												// inside init
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String referer = request.getHeader("referer");
		// Referer returns whole url and checks whether the url contains home

		if (referer.contains("home")) {
			// Request coming from homepage for login authentication

			LoginBean login = new LoginBean();
			login.setUserId(request.getParameter("userid"));
			login.setPassword(request.getParameter("password"));

			if (service.authenticate(login)) {

				// login successful - Storing userId in session scope
				HttpSession session = request.getSession();
				session.setAttribute("USER", login.getUserId());
				
				response.sendRedirect("Shopping.do");
			} else {
				// login failed
				response.sendRedirect("home.jsp?invalid=yes");
			}

		} else if(referer.contains("register")){
			// Request coming from register page for user registration
			UserBean user = new UserBean();
			int age = service.getAge(request.getParameter("birthdate"));
			
			user.setName(request.getParameter("name"));
			user.setUserId(request.getParameter("userid"));
			user.setPassword(request.getParameter("password"));
			user.setAge(age);
			user.setCity(request.getParameter("city"));
			user.setEmail(request.getParameter("email"));
			user.setPhone(request.getParameter("phone"));
			
			if(service.persist(user)){
				response.sendRedirect("home.jsp");
			} else {
				response.sendRedirect("Registration.jsp");
			}
					
		}else {
			HttpSession session = request.getSession();
			session.invalidate(); // Destroy session
			response.sendRedirect("home.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
