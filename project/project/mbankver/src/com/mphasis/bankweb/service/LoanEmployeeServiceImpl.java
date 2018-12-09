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
import com.mphasis.bankweb.entity.LoanAccount;
import com.mphasis.bankweb.entity.LoanCustomer;
import com.mphasis.bankweb.entity.LoanTransaction;
import com.mphasis.bankweb.pojo.LoanAccountBean;
import com.mphasis.bankweb.util.AccountFoundNotException;
import com.mphasis.bankweb.util.AccountOpenProtocolException;
import com.mphasis.bankweb.util.BankUtil;
import com.mphasis.bankweb.util.LoanAccountCheck;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Service("loan")
public class LoanEmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("daoCust")
	private EmployeeDao ed;

	@Autowired
	@Qualifier("util")
	private BankUtil util;

	public String openAccount(Object cust) throws AccountOpenProtocolException {

		LoanAccountBean bean = (LoanAccountBean) cust;
		LoanCustomer cust1 = new LoanCustomer();
		LoanAccount da = new LoanAccount();
		if (ed.checkExistingPan(bean.getPan())) {
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(bean.getDob().toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (LoanAccountCheck.getAgeChecking(bean.getDob().toString()) >= 18) {

				double principle = bean.getPrinciple();//
				double salary = bean.getSalary();
				double tenure = bean.getTenure();

				double roi = LoanAccountCheck.roiChecking(principle, bean.getDob().toString());
				if (roi != 0) {
					double emi = LoanAccountCheck.Emicalculate(principle, roi, tenure);
					if (LoanAccountCheck.checkEmieligible(emi, salary)) {

						double outstanding = LoanAccountCheck.Outstandingcalc(principle, roi, tenure);
						String custId = util.genCustomerNo();
						cust1.setPassword(bean.getPan());
						cust1.setBirthDate(date);
						cust1.setCustName(bean.getCustName());
						cust1.setPan(bean.getPan());
						cust1.setAcntType("loan");
						cust1.setCustId(custId);
						cust1.setStatus("active");
						da.setAcntId(util.genLNAccountNo());
						da.setCust_sal(bean.getSalary());
						da.setPrinciple(bean.getPrinciple());
						da.setOutstanding(outstanding);
						da.setRoi(bean.getTenure());
						da.setEmi(emi);
						da.setTenure(bean.getTenure());
						da.setCust(cust1);
						cust1.setAcnt(da);
						LoanTransaction transaction = new LoanTransaction();
						transaction.setAmount(bean.getPrinciple());
						transaction.setOutstanding(outstanding);
						transaction.setTxnType("open Account");
						transaction.setTxnDate(new Date());
						transaction.setLa(da);

						Set<LoanTransaction> txn = new HashSet();
						txn.add(transaction);

						da.setLoanTxns(txn);
						ed.openAccount(cust1);
						return custId;
					} else
						throw new AccountOpenProtocolException("Not Eligible for Loan ");
				} else
					throw new AccountOpenProtocolException("check age/principle amount ");
			} else
				throw new AccountOpenProtocolException("Age should be more than 18 years");
		} else
			throw new AccountOpenProtocolException("User Exist");

	}

	public List<Customer> reports(String empId) {
		return ed.reports(empId);
	}

	public boolean closeAccount(String custId) throws AccountFoundNotException {
		return ed.closeAccount(custId);
	}

}
