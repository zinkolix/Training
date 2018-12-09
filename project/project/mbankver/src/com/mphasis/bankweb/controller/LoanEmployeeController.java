package com.mphasis.bankweb.controller;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.pojo.LoanAccountBean;
import com.mphasis.bankweb.service.EmployeeService;
import com.mphasis.bankweb.util.AccountFoundNotException;
import com.mphasis.bankweb.util.AccountOpenProtocolException;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Controller
@RequestMapping("/loan/*")
public class LoanEmployeeController {

	@Autowired
	@Qualifier("loan")
	private EmployeeService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String openAccount(LoanAccountBean bean,HttpServletRequest request) throws AccountOpenProtocolException {
		try {
			String id = service.openAccount(bean);
			if(id != null){
				request.setAttribute("created", "Account Created Successfully");
				request.setAttribute("id", "CustomerId: " + id);
				return "loancustomer";
			}else
			{
				request.setAttribute("unsuccessful", "Account Not Created!");
				return "loancustomer";
			}
			
		} catch (AccountOpenProtocolException e) {
			request.setAttribute("error", e.getMessage());
			return "loancustomer";
		}
	}

	@RequestMapping(value = "/close", method = RequestMethod.POST)
	public String closeAccount(String custId, HttpServletRequest request){
		try {
			if(service.closeAccount(custId)){
				request.setAttribute("success", "Account closed successfully");
				return "removeloancust";
			}else{
				request.setAttribute("fail", "Check CustomerId");
				return "removeloancust";
			}
		} catch (AccountFoundNotException e) {
			request.setAttribute("error", e.getMessage());
			return "removeloancust";
		}

	}

	@RequestMapping(value = "/report")
	public String report(@RequestParam("view") String viewType, Map model, HttpSession session) {
		Object emp = session.getAttribute("user");
		Employee employee = (Employee) emp;
		model.put("customers", service.reports(employee.getEmpId()));
		if (viewType.equals("pdf"))
			return "LoanReportsPdf";
		else
			return "loanreport";
	}
}
