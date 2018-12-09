package com.mphasis.bankweb.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.bank.dao.util.IdVerification;
import com.mphasis.bank.util.BankUtil;
import com.mphasis.bankweb.dao.EmployeeDao;
import com.mphasis.bankweb.dao.EmployeeDaoImpl;
import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.LoanAccount;
import com.mphasis.bankweb.entity.LoanCustomer;
import com.mphasis.bankweb.entity.LoanTransaction;

@Service("loan")
public class LoanEmployeeServiceImpl implements EmployeeService {

	IdVerification idVerification;
	@Autowired
	private EmployeeDao ed;

//	public LoanEmployeeServiceImpl() {
//		ed = new EmployeeDaoImpl();
//	}

	public boolean openAccount(Customer cust1) {
		double roi = 0;
		int age = 0;
		BankUtil util = new BankUtil();
		LoanCustomer cust = (LoanCustomer) cust1;
		LoanAccount da = new LoanAccount();

		cust.setPassword("please");
		cust.setBirthDate(new Date());
		cust.setCustName("Anshu");
		cust.setPan("ABCD2414");
		cust.setAcntType("loan");
		cust.setCustId("MLA24879");
		da.setAcntId("LN13691");
		da.setCust_sal(10000);
		da.setPrinciple(100000);
		da.setOutstanding(10000);
		da.setRoi(10);
		da.setTenure(2);
		da.setCust(cust);
		cust.setAcnt(da);
		LoanTransaction transaction = new LoanTransaction();
		transaction.setAmount(1000);
		transaction.setOutstanding(10000);
		transaction.setTxnType("open Account");
		transaction.setTxnDate(new Date());
		transaction.setLa(da);

		Set<LoanTransaction> txn = new HashSet();
		txn.add(transaction);

		da.setLoanTxns(txn);

		return ed.openAccount(cust1);
	}

	public List<Customer> reports(int empId) {
		return ed.reports(empId);
	}

	public boolean closeAccount(String custId) {
		// if(idVerification.checkExistingcustId(custId)){
		return ed.closeAccount(custId);
		// }

	}

}
