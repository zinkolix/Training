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

import com.mphasis.bankweb.dao.LoanCustomerDao;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.entity.LoanAccount;
import com.mphasis.bankweb.entity.LoanCustomer;
import com.mphasis.bankweb.service.LoanCustomerService;
import com.mphasis.bankweb.util.BalanceException;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Controller
@RequestMapping("/loancust/*")
public class LoanCustomerController {

	@Autowired
	@Qualifier("loanservice")
	LoanCustomerService service;

	@Autowired
	LoanCustomerDao dao;
	

	@RequestMapping(value = "/partpayment", method = RequestMethod.POST)
	public String partPayment(double amount, HttpSession session, HttpServletRequest request) throws BalanceException {
		Object cust = session.getAttribute("user");
		LoanCustomer customer = (LoanCustomer) cust;
		LoanAccount account = dao.getAccountFromCustId(customer.getCustId());
		try {
			if(service.partPayment(account.getAcntId(), amount)){
				request.setAttribute("success", "Fund Deposited");
				return "partpayment";
			}else{
				request.setAttribute("fail", "Transaction Failed");
				return "partpayment";
			}
		} catch (BalanceException e) {
			request.setAttribute("error", e.getMessage());
			return "partpayment";
		}
		
	}
	
	@RequestMapping(value = "/foreclosure", method = RequestMethod.POST)
	public String foreclosure(double amount, HttpSession session, HttpServletRequest request) throws BalanceException {
		Object cust = session.getAttribute("user");
		LoanCustomer customer = (LoanCustomer) cust;
		LoanAccount account = dao.getAccountFromCustId(customer.getCustId());
		try {
			if(service.foreClosure(account.getAcntId(), amount)){
				request.setAttribute("success", "Success");
				return "foreclosure";	
			}else{
				request.setAttribute("fail", "Transaction Failed");
				return "foreclosure";
			}
			
		} catch (BalanceException e) {
			request.setAttribute("error", e.getMessage());
			return "foreclosure";
		}
	}
	
	@RequestMapping(value = "/printstatment")
	public String printStatement(@RequestParam("view")String viewType,Map model, HttpSession session){
		Object cust = session.getAttribute("user");
		LoanCustomer customer = (LoanCustomer) cust;
		LoanAccount account = dao.getAccountFromCustId(customer.getCustId());
		model.put("customers", service.printStatement(account.getAcntId()));
		return "printloanstatment";
	}
}
