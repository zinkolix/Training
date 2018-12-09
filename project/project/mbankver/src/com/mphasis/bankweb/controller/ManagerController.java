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
import com.mphasis.bankweb.pojo.DepositAccountBean;
import com.mphasis.bankweb.pojo.EmployeeBean;
import com.mphasis.bankweb.service.ManagerService;
import com.mphasis.bankweb.util.AccountFoundNotException;
import com.mphasis.bankweb.util.AccountOpenProtocolException;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Controller
@RequestMapping("/manager/*")
public class ManagerController {

	@Autowired
	@Qualifier("manager")
	private ManagerService service;

	public String goHome() {
		return "managercustframe";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStaff(EmployeeBean bean, HttpServletRequest request) throws AccountOpenProtocolException {
		try {
			String id = service.addStaff(bean);
			if (id != null) {
				request.setAttribute("created", "Account Created Successfully");
				request.setAttribute("id", "EmployeeId: " + id);
				return "addstaff";

			} else {
				request.setAttribute("unsuccessful", "Account Not Created!");
				return "addstaff";
			}

		} catch (AccountOpenProtocolException e) {
			request.setAttribute("error", e.getMessage());
			return "addstaff";
		}
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removeStaff(String empId, HttpServletRequest request)  {
		try {
			if(service.removeStaff(empId)){
				request.setAttribute("success", "Account closed successfully");
				return "removestaff";
			}else
			{
				request.setAttribute("fail", " Check EmployeeId");
				return "removestaff";
			}
		} catch (AccountFoundNotException e) {
			request.setAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
			return "removestaff";
		}
		
	}

	@RequestMapping(value = "/depositreport")
	public String reportDeposit(@RequestParam("view") String viewType, Map model, HttpSession session) {
		Object emp = session.getAttribute("user");
		Employee employee = (Employee) emp;
		model.put("customers", service.reports(employee.getEmpId()));
		if (viewType.equals("pdf"))
			return "DepositReportsPdf";
		else
			return "report";
	}

}
