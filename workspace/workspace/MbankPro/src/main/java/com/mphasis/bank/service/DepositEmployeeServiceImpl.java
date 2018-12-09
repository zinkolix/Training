package com.mphasis.bank.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mphasis.bank.dao.EmployeeDao;
import com.mphasis.bank.dao.EmployeeDaoImpl;
import com.mphasis.bank.dao.util.IdVerification;
import com.mphasis.bank.entity.Customer;
import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.entity.DepositCustomer;
import com.mphasis.bank.entity.DepositTransaction;
import com.mphasis.bank.util.BankUtil;

public class DepositEmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao;
	IdVerification idVerification;

	public DepositEmployeeServiceImpl() {

		dao = new EmployeeDaoImpl();
	}

	public boolean openAccount(Customer cust) {
		BankUtil util = new BankUtil();
		DepositCustomer cust1 = (DepositCustomer) cust;
		DepositAccount da = new DepositAccount();
		cust1.setPassword("please");
		cust1.setBirthDate(new Date());
		cust1.setCustName("Anshu");
		cust1.setPan("ABCD6809");
		cust1.setCustId("MLA15567");
		cust1.setStatus("active");
		da.setBalance(1000);
		da.setAcntId("SB13479");
		da.setCust(cust1);
		cust1.setAcnt(da);
		DepositTransaction transaction = new DepositTransaction();
		transaction.setAmount(1000);
		transaction.setTxnType("open Account");
		transaction.setTxnDate(new Date());
		transaction.setDeposit(da);

		Set<DepositTransaction> txn = new HashSet<DepositTransaction>();
		txn.add(transaction);

		da.setDepositTxn(txn);

		return dao.openAccount(cust);

	}

	public boolean closeAccount(String custId) {
		if (idVerification.checkExistingcustId(custId)) {
			return dao.closeAccount(custId);

		} else {
			return false;
		}

	}

	public List<Customer> reports(int empId) {
		return dao.reports(empId);
	}

}
