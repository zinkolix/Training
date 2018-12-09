package com.mphasis.bankweb.controller;

import java.util.Map;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.pojo.DepositAccountBean;
import com.mphasis.bankweb.service.EmployeeService;
import com.mphasis.bankweb.util.AccountFoundNotException;
import com.mphasis.bankweb.util.AccountOpenProtocolException;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Controller
@RequestMapping("/deposit/*")
public class DepositEmployeeController {

	@Autowired
	@Qualifier("deposit")
	private EmployeeService service;

	public String goHome() {
		return "depositcustframe";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String openAccount(DepositAccountBean bean, HttpServletRequest request) throws AccountOpenProtocolException {
		try {
			String id = service.openAccount(bean);
			if(id != null){
				request.setAttribute("created", "Account opened successfully");
				request.setAttribute("id", "CustomerId: " + id);
				return "depositcustomer";
			}else{
				request.setAttribute("unsuccesful", " Unsuccessful");
				return "depositcustomer";
			}
		} catch (AccountOpenProtocolException e) {
			request.setAttribute("error", e.getMessage());
			return "depositcustomer";
		}
	}

	@RequestMapping(value = "/close", method = RequestMethod.POST)
	public String closeAccount(String custId, HttpServletRequest request) throws AccountFoundNotException {
		try {
			if(service.closeAccount(custId)){
				request.setAttribute("success", "Account closed successfully");
				return "removecust";
			}else
			{
				request.setAttribute("fail", "Check CustomerId");
				return "removecust";	
			}
		} catch (AccountFoundNotException e) {
			request.setAttribute("error", e.getMessage());
			return "removecust";
		}

	}

	@RequestMapping(value = "/report")
	public String report(@RequestParam("view") String viewType, Map model, HttpSession session) {
		Object emp = session.getAttribute("user");
		Employee employee = (Employee) emp;
		model.put("customers", service.reports(employee.getEmpId()));
		if (viewType.equals("pdf"))
			return "DepositReportsPdf";
		else
			return "report";
	}

}
