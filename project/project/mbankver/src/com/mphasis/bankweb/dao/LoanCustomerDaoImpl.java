
package com.mphasis.bankweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.mphasis.bankweb.entity.LoanAccount;
import com.mphasis.bankweb.entity.LoanTransaction;

/**
 * @author Ashwini.Sharma08
*/
@Repository
public class LoanCustomerDaoImpl implements LoanCustomerDao {

	@PersistenceContext(unitName = "mBank")
	private EntityManager entityManager;

	@Transactional
	public boolean partPayment(LoanAccount account) {
		try {
			entityManager.unwrap(Session.class).saveOrUpdate(account);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Transactional
	public boolean foreClosure(LoanAccount account) {
		account.getCust().setStatus("disabled");
		try {
			entityManager.unwrap(Session.class).saveOrUpdate(account);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public LoanAccount getAccount(String accntId) {
		LoanAccount la = entityManager.find(LoanAccount.class, accntId);
		return la;
	}

	public List<LoanTransaction> getStatement(String accntId) {

		List<LoanTransaction> loanTxn = null;
		Query query = entityManager.createQuery("from LoanTransaction where acntId=" + accntId + "");
		loanTxn = query.getResultList();
		return loanTxn;
	}

	@Transactional
	public LoanAccount getAccountFromCustId(String custId) {
		Query query = (Query) entityManager.createQuery("from LoanAccount where cust_id='" + custId + "'");
		LoanAccount acc = (LoanAccount) query.getSingleResult();
		return acc;
	}

}
