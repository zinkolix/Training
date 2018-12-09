package com.mphasis.bank.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mphasis.bank.dao.EmployeeDao;
import com.mphasis.bank.dao.EmployeeDaoImpl;
import com.mphasis.bank.dao.util.IdVerification;
import com.mphasis.bank.entity.Customer;
import com.mphasis.bank.entity.LoanAccount;
import com.mphasis.bank.entity.LoanCustomer;
import com.mphasis.bank.entity.LoanTransaction;
import com.mphasis.bank.util.AccountOpenProtocolException;
import com.mphasis.bank.util.BankUtil;
import com.mphasis.bank.util.LoanAccountCheck;

public class LoanEmployeeServiceImpl implements EmployeeService {

	IdVerification idVerification;
	private EmployeeDao ed;

	public LoanEmployeeServiceImpl() {
		ed = new EmployeeDaoImpl();
	}

	public boolean openAccount(Customer cust1) throws AccountOpenProtocolException {
		double roi = 0;
		int age = 0;
		EmployeeDao ed = new EmployeeDaoImpl();
		BankUtil util = new BankUtil();
		LoanCustomer cust = (LoanCustomer) cust1;
		LoanAccount da = new LoanAccount();
		if (ed.checkExistingPan(cust.getPan())) {
			String date = "1996-06-06";
			Date d = null;
			try {
				d = new SimpleDateFormat("YYYY-MM-DD").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (LoanAccountCheck.getAgeChecking(date) >= 18) {
				cust.setPassword("please");
				cust.setBirthDate(new Date());
				cust.setCustName("suchith");
				cust.setPan("ABCD2114");
				cust.setAcntType("loan");
				cust.setCustId("MLA14879");
				da.setAcntId("LN13641");
				da.setCust_sal(10000);
				da.setPrinciple(100000);
				da.setRoi(10);
				da.setTenure(2);
				da.setCust(cust);
				cust.setAcnt(da);
				LoanTransaction transaction = new LoanTransaction();
				transaction.setAmount(1000);
				transaction.setTxnType("open Account");
				transaction.setTxnDate(new Date());
				transaction.setLa(da);

				Set<LoanTransaction> txn = new HashSet();
				txn.add(transaction);

				da.setLoanTxns(txn);

				return ed.openAccount(cust);
			} else
				throw new AccountOpenProtocolException("emi is not valid with customer salary");
	
	}else throw new AccountOpenProtocolException("age should be more than 18 years");

}


	public List<Customer> reports(int empId) {
		return ed.reports(empId);
	}

	public boolean closeAccount(String custId) {
		 if(idVerification.checkExistingcustId(custId)){
		return ed.closeAccount(custId);
		 }
		return false;

	}

}
