package com.mphasis.bankweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.pojo.Login;
import com.mphasis.bankweb.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	@RequestMapping("/showlogin")
	public String show(@ModelAttribute("login")Login login){
		return "login";
	}
	
	@RequestMapping("/authenticate")
	public String authenticate(@ModelAttribute("login")@Validated Login login, BindingResult bindingResult){
		if(login.getRole().equals("Customer")){
			Customer cust = service.validateCustomer(login);
			if(cust.getAcntType().equalsIgnoreCase("deposit"))
				return "depositcust";
			else
				return "loancust";
		}else {
			Employee emp = service.validateEmployee(login);
			if(emp == null)
				return "home";
			else if(emp.getEmpType().equalsIgnoreCase("E") && emp.getDept().getDeptId().equalsIgnoreCase("dept01"))
				return "depositemp";
			else if(emp.getEmpType().equalsIgnoreCase("E") && emp.getDept().getDeptId().equalsIgnoreCase("dept02"))
				return "loanemp";
			else return "manager";
		}
	}

}
