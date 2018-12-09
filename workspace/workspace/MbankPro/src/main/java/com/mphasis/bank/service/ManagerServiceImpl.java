package com.mphasis.bank.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mphasis.bank.dao.EmployeeDao;
import com.mphasis.bank.dao.EmployeeDaoImpl;
import com.mphasis.bank.dao.ManagerDao;
import com.mphasis.bank.dao.ManagerDaoImpl;
import com.mphasis.bank.entity.Customer;
import com.mphasis.bank.entity.Department;
import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.entity.DepositCustomer;
import com.mphasis.bank.entity.DepositTransaction;
import com.mphasis.bank.entity.Employee;
import com.mphasis.bank.util.BankUtil;

public class ManagerServiceImpl implements ManagerService {

	private ManagerDao ed;

	public ManagerServiceImpl() {
		 ed = new ManagerDaoImpl();
	}

	public boolean addStaff(String deptId) {
		Department dept = ed.getAccount(deptId);
		Employee emp = new Employee();
		emp.setEmpId(12347);
		emp.setEmpName("Shama");
		emp.setEmpType("E");
		emp.setPan("ABCD1011");
		emp.setPassword("hello");
		emp.setDept(dept);
		Set<Employee> emps = new HashSet();
		emps.add(emp);
		dept.setEmployees(emps);

		return ed.addStaff(emp);

	}

	public boolean removeStaff(int empId) {
		return ed.removeStaff(empId);
	}

	public boolean openAccount(Customer cust) {
		ManagerDao ed = new ManagerDaoImpl();
		BankUtil util = new BankUtil();
		DepositCustomer cust1 = (DepositCustomer) cust;
		DepositAccount da = new DepositAccount();
		cust1.setPassword("please");
		cust1.setBirthDate(new Date());
		cust1.setCustName("Anshu");
		cust1.setPan("ABCD9872");
		// if(ed.checkExistingPan("ABCD9872") == true){
		// System.out.println();
		// }

		cust1.setCustId(util.generteCustomerId());
		da.setBalance(1000);
		da.setAcntId(util.generateSBAccountId());
		da.setCust(cust1);
		cust1.setAcnt(da);
		DepositTransaction transaction = new DepositTransaction();
		transaction.setAmount(1000);
		transaction.setTxnType("open Account");
		transaction.setTxnDate(new Date());
		transaction.setDeposit(da);

		Set<DepositTransaction> txn = new HashSet();
		txn.add(transaction);

		da.setDepositTxn(txn);

		return ed.openAccount(cust);
	}

	public boolean closeAccount(String custId) {

		return ed.closeAccount(custId);

	}

	public List<Customer> reports(int empId) {
		return ed.reports(empId);
	}

}
