package com.mphasis.bankweb.dao.util;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.entity.LoanAccount;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Repository("checkId")
public class CheckExistingIdDaoImpl implements CheckExistingIdDao {
	@PersistenceContext(unitName = "mBank")
	private EntityManager entityManager;

	@Override
	@Transactional
	public boolean checkExistingEmpId(String empId) {
		Employee emp = entityManager.find(Employee.class, empId);
		if (emp == null)
			return true;
		else
			return false;
			}

	@Override
	@Transactional
	public boolean checkExistingCustId(String custId) {
		Customer cust = entityManager.find(Customer.class, custId);
		if (cust == null)
			return true;
		else
			return false;
			}

	@Override
	@Transactional
	public boolean checkExistingDepositAccntId(String accntId) {
		DepositAccount da = entityManager.find(DepositAccount.class, accntId);
		if (da == null)
			return true;
		else
			return false;
	}

	@Override
	@Transactional
	public boolean checkExistingLoanAccntId(String accntId) {
		LoanAccount la = entityManager.find(LoanAccount.class, accntId);
		if (la == null)
			return true;
		else
			return false;
	}
}



