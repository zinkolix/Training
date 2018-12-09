package com.mphasis.bankweb.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.bank.util.BankUtil;
import com.mphasis.bankweb.dao.EmployeeDao;
import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.entity.DepositCustomer;
import com.mphasis.bankweb.entity.DepositTransaction;

@Service
public class DepositEmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao ed;

	// private IdVerification idVerification;

	// public DepositEmployeeServiceImpl() {
	// EmployeeDao ed = new EmployeeDaoImpl();
	// }
	public boolean openAccount(Customer cust) {
		BankUtil util = new BankUtil();
		DepositCustomer cust1 = (DepositCustomer) cust;
		DepositAccount da = new DepositAccount();
		cust1.setPassword("please");
		cust1.setBirthDate(new Date());
		cust1.setCustName("Anshu");
		cust1.setPan("ABCD4545");
		cust1.setCustId("MLA23457");
		cust1.setStatus("active");
		da.setBalance(1000);
		da.setAcntId("SB23446");
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
		System.out.println("i got everything inside the customer");
		return ed.openAccount(cust1);

	}

	public boolean closeAccount(String custId) {
		
		return ed.closeAccount(custId);

	}

	@Override
	public List<Customer> reports(int empId) {
		List<Customer> cust = ed.reports(empId);
		 System.out.println(cust.get(1).getCustName());
		 return null;
	}

}
