/**
	 * @author Ashwini.Sharma08
 */
package com.mphasis.bankweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.mphasis.bankweb.entity.LoanAccount;
import com.mphasis.bankweb.entity.LoanTransaction;

@Repository
public class LoanCustomerDaoImpl implements LoanCustomerDao {

	@PersistenceContext(unitName="mBank")
	private EntityManager entityManager;
	
	public boolean partPayment(LoanAccount account) {

		entityManager.merge(account);
		return true;

	}

	public boolean foreClosure(String acntId) {
		LoanAccount account = getAccount(acntId);
		entityManager.merge(account);
			return false;
//		}
	}

	public LoanAccount getAccount(String accntId) {
		LoanAccount la = entityManager.find(LoanAccount.class, accntId);
		return la;
	}

	public List<LoanTransaction> getStatement(String accntId) {
	
		List<LoanTransaction> loanTxn = null;
		Query query = entityManager.createQuery("from AccountTransaction where acntId=" + accntId + "");
		loanTxn = query.getResultList();
		return loanTxn;
			}



}
