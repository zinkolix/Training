package com.market.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.market.bean.ProductBean;
import com.market.service.ShoppingService;
import com.market.service.ShoppingServiceImpl;

/**
 * Servlet implementation class ShoppingController
 */
@WebServlet(name = "Shopping", urlPatterns = { "/Shopping.do" })
public class ShoppingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingService service;

	@Override
	public void init() throws ServletException {
		service = new ShoppingServiceImpl();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Creating a httpsession for the adding the product inside the cart
		HttpSession session = request.getSession();
		
		//from the request getting the code of the product
		if(request.getParameter("code") != null){
			// Request is for adding product to shopping cart
			int code = Integer.parseInt(request.getParameter("code"));
			ProductBean product = service.getProduct(code);
			
			// Adding product to shopping cart
			ArrayList<ProductBean> cart;
			//Getting cart from session, if session is old, list may exist there
			cart = (ArrayList)session.getAttribute("CART");
			
			// no existing cart found, instantiate for the first use
			if(cart == null)
				cart = new ArrayList<ProductBean>();
			
			cart.add(product);
			
			// Add or update session with cart object
			
			session.setAttribute("CART", cart);
			
			// Putting product into request scope to display on summary page
			request.setAttribute("PRODUCT", product);
			getServletContext().getRequestDispatcher("/summary.jsp").forward(request, response);
		}
	else{// Current scope of catalog is Page scope
		List<ProductBean> catalog = service.getCatalog();
		
		// Putting catalog into request scope
		request.setAttribute("CATALOG", catalog);
		
		// forwarding control to catalog page
		getServletContext().getRequestDispatcher("/catalog.jsp").forward(request, response);
		
		// Alternate or detailed forward statement
//		ServletContext context = getServletContext();
//		RequestDispatcher rd = context.getRequestDispatcher("/catalog.jsp");
//		rd.forward(request, response);
	}
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
