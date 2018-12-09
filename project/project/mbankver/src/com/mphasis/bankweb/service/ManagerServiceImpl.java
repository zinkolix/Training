package com.mphasis.bankweb.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mphasis.bankweb.dao.ManagerDao;
import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.Department;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.pojo.EmployeeBean;
import com.mphasis.bankweb.util.AccountFoundNotException;
import com.mphasis.bankweb.util.AccountOpenProtocolException;
import com.mphasis.bankweb.util.BankUtil;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Service("manager")
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	@Qualifier("managerDao")
	private ManagerDao ed;

	@Autowired
	@Qualifier("util")
	private BankUtil util;

	public String addStaff(EmployeeBean bean) throws AccountOpenProtocolException{

		Department dept = ed.getAccount(bean.getDeptId());
		if (ed.checkExistingPan(bean.getPan())) {
			Employee emp = new Employee();
			String empId = util.genEmpNo();
			emp.setEmpId(empId);
			emp.setEmpName(bean.getName());
			emp.setEmpType("E");
			emp.setPan(bean.getPan());
			emp.setPassword(bean.getPan());
			emp.setDept(dept);
			Set<Employee> emps = new HashSet();
			emps.add(emp);
			dept.setEmployees(emps);
			ed.addStaff(emp);
			return empId;
		}else 
			throw new AccountOpenProtocolException("User Exist");

	}

	public boolean removeStaff(String empId) throws AccountFoundNotException {
		return ed.removeStaff(empId);
	}

	public String openAccount(Object cust) {
//		DepositAccountBean bean = (DepositAccountBean) cust;
//		DepositCustomer cust1 = new DepositCustomer();
//		DepositAccount da = new DepositAccount();
//		System.out.println(bean.getDob());
//		Date date = null;
//		try {
//			date = new SimpleDateFormat("yyyy-MM-dd").parse(bean.getDob().toString());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		System.out.println(date);
//		cust1.setPassword(bean.getPan());
//		cust1.setBirthDate(date);
//		cust1.setCustName(bean.getCustName());
//		cust1.setPan(bean.getPan());
//		cust1.setCustId("MLA19158");
//		cust1.setStatus("active");
//		da.setBalance(bean.getAmount());
//		da.setAcntId("SB4398");
//		da.setCust(cust1);
//		cust1.setAcnt(da);
//		DepositTransaction transaction = new DepositTransaction();
//		transaction.setAmount(1000);
//		transaction.setTxnType("open Account");
//		transaction.setTxnDate(new Date());
//		transaction.setDeposit(da);
//
//		Set<DepositTransaction> txn = new HashSet<DepositTransaction>();
//		txn.add(transaction);
//
//		da.setDepositTxn(txn);
//		System.out.println("i got everything inside the customer");
//		return ed.openAccount(cust1);
		return "none";
	}

	public boolean closeAccount(String custId) throws AccountFoundNotException {

		return ed.closeAccount(custId);

	}

	public List<Customer> reports(String empId) {
		return ed.reports(empId);
	}

}
