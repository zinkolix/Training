package com.mphasis.bankweb.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mphasis.bankweb.dao.EmployeeDao;
import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.entity.DepositCustomer;
import com.mphasis.bankweb.entity.DepositTransaction;
import com.mphasis.bankweb.pojo.DepositAccountBean;
import com.mphasis.bankweb.util.AccountFoundNotException;
import com.mphasis.bankweb.util.AccountOpenProtocolException;
import com.mphasis.bankweb.util.BankUtil;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Service("deposit")
public class DepositEmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("daoCust")
	private EmployeeDao ed;
 
	@Autowired
	@Qualifier("util")
	private BankUtil util;

	public String openAccount(Object cust) throws AccountOpenProtocolException {

		DepositAccountBean bean = (DepositAccountBean) cust;
		if (ed.checkExistingPan(bean.getPan())) {
			DepositCustomer cust1 = new DepositCustomer();
			DepositAccount da = new DepositAccount();
			System.out.println(bean.getDob());
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(bean.getDob().toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (util.getAgeChecking(bean.getDob().toString()) >= 18) {
				String custId = util.genCustomerNo();
				cust1.setPassword(bean.getPan());
				cust1.setBirthDate(date);
				cust1.setCustName(bean.getCustName());
				cust1.setPan(bean.getPan());
				cust1.setCustId(custId);
				cust1.setStatus("active");
				da.setBalance(bean.getAmount());
				da.setAcntId(util.getSBAccountNo());
				da.setCust(cust1);
				cust1.setAcnt(da);
				DepositTransaction transaction = new DepositTransaction();
				transaction.setAmount(bean.getAmount());
				transaction.setTxnType("open Account");
				transaction.setTxnDate(new Date());
				transaction.setBalance(bean.getAmount());
				transaction.setDeposit(da);

				Set<DepositTransaction> txn = new HashSet<DepositTransaction>();
				txn.add(transaction);

				da.setDepositTxn(txn);
				ed.openAccount(cust1);
				return custId;
			} else
				throw new AccountOpenProtocolException("Age is below limit");
		} else
			throw new AccountOpenProtocolException("User Exist");
	}

	public boolean closeAccount(String custId) throws AccountFoundNotException {
		
		return ed.closeAccount(custId);

	}

	@Override
	public List<Customer> reports(String empId) {

		List<Customer> cust = ed.reports(empId);
		return cust;
	}

}
