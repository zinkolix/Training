package com.mphasis.bankweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.pojo.Login;
import com.mphasis.bankweb.service.LoginService;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Controller
public class LoginController {

	@Autowired
	private LoginService service;

	@RequestMapping("/showlogin")
	public String show(@ModelAttribute("login") Login login) {
		return "login";
	}

	@RequestMapping("/authenticate")
	public String authenticate(@ModelAttribute("login") Login login,HttpServletRequest request, HttpSession session) {
		if (login.getRole().equals("Customer")) {
			Customer cust = service.validateCustomer(login);
			if (cust == null){
				request.setAttribute("failed", "Invalid CustomerId/Password");
				return "login";
			}else if(cust.getStatus().equalsIgnoreCase("disabled")){
				request.setAttribute("inactive", "Customer is Inactive");
				return "login";
			}
			if (cust.getAcntType().equalsIgnoreCase("deposit")) {
				session.setAttribute("user", cust);
				return "depositframe";
			} else {
				session.setAttribute("user", cust);
				return "loanframe";
			}

		} else {
			Employee emp = service.validateEmployee(login);
			System.out.println("hi i m here");
			System.out.println(emp);
			if (emp == null){
				request.setAttribute("failed", "Invalid CustomerId/Password");
				return "login";
			}else if(emp.getStatus().equalsIgnoreCase("disabled")){
				request.setAttribute("inactive", "Employee Inactive");
				return "login";
			}
			else if (emp.getEmpType().equalsIgnoreCase("E") && emp.getDept().getDeptId().equalsIgnoreCase("dept01")) {
				session.setAttribute("user", emp);
				return "depositcustframe";
			} else if (emp.getEmpType().equalsIgnoreCase("E") && emp.getDept().getDeptId().equalsIgnoreCase("dept02")) {
				session.setAttribute("user", emp);
				return "loancustframe";
			} else {
				session.setAttribute("user", emp);
				return "managerframe";
			}
		}
	}

	@RequestMapping("/logout")
	public String logout(@ModelAttribute("login") Login login, HttpSession session) {
		session.invalidate();
		return "login";
	}

}
