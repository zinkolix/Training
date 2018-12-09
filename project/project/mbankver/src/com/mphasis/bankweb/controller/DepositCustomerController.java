package com.mphasis.bankweb.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mphasis.bankweb.dao.DepositCustomerDao;
import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.entity.DepositCustomer;
import com.mphasis.bankweb.service.DepositCustomerService;
import com.mphasis.bankweb.util.BalanceException;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Controller
@RequestMapping("/customer/*")
public class DepositCustomerController {

	@Autowired
	DepositCustomerService service;

	@Autowired
	DepositCustomerDao dao;

	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public String depositAccount(double amount, HttpSession session, HttpServletRequest request)
			throws Exception {
		Object cust = session.getAttribute("user");
		DepositCustomer customer = (DepositCustomer) cust;
		DepositAccount account = dao.getAccountFromCustId(customer.getCustId());
		if (service.depositAmount(account.getAcntId(), amount)) {
			request.setAttribute("success", "Fund Deposited");
			return "deposit";
		} else {
			request.setAttribute("fail", "Transaction Failed");
			return "deposit";
		}

	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String withdrawAccount(String acntId, double amount, HttpSession session, HttpServletRequest request)
			throws BalanceException {
		Object cust = session.getAttribute("user");
		DepositCustomer customer = (DepositCustomer) cust;
		DepositAccount account = dao.getAccountFromCustId(customer.getCustId());
		try {
			if (service.withdrawAmount(account.getAcntId(), amount)) {
				request.setAttribute("success", "Success");
				return "withdraw";
			} else {
				request.setAttribute("fail", "Transaction Failed");
				return "withdraw";
			}
		} catch (BalanceException e) {
			request.setAttribute("error", e.getMessage());
			return "withdraw";
		}
	}

	@RequestMapping(value = "/ft", method = RequestMethod.POST)
	public String fundTransfer(String benId, double amount, HttpSession session, HttpServletRequest request)
			throws Exception {
		Object cust = session.getAttribute("user");
		DepositCustomer customer = (DepositCustomer) cust;
		DepositAccount account = dao.getAccountFromCustId(customer.getCustId());
		DepositAccount src = dao.getAccount(account.getAcntId());
		DepositAccount dest = dao.getAccount(benId);
		if(account.getAcntId().equalsIgnoreCase(benId)){
			request.setAttribute("same", "Incorrect Account Id");
			return "fundtransfer";
		}
		if (service.fundTransfer(src, dest, amount)) {
			request.setAttribute("success", "Success");
			return "fundtransfer";
		} else {
			request.setAttribute("fail", "Transaction Failed");
			return "fundtransfer";
		}
	}

	@RequestMapping(value = "/printstatment")
	public String printStatement(@RequestParam("view") String viewType, Map model, HttpSession session) {
		Object cust = session.getAttribute("user");
		DepositCustomer customer = (DepositCustomer) cust;
		DepositAccount account = dao.getAccountFromCustId(customer.getCustId());
		model.put("customers", service.printStatement(account.getAcntId()));
		return "printstatment";
	}
}
