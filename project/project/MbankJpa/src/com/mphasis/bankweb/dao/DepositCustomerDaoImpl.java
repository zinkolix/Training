package com.mphasis.bankweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.entity.DepositTransaction;

@Repository
public class DepositCustomerDaoImpl implements DepositCustomerDao {

	@PersistenceContext(unitName = "mBank")
	private EntityManager entityManager;

	@Transactional
	public List<DepositTransaction> getStatement(String acntId) {

		List<DepositTransaction> depositTxn = null;
		Query query = entityManager.createQuery("from AccountTransaction where acntId=" + acntId + "");
		depositTxn = query.getResultList();
		return depositTxn;

	}

	@Transactional
	public DepositAccount getAccount(String acntId) {

		DepositAccount da = entityManager.find(DepositAccount.class, acntId);
		return da;

	}

	@Transactional
	public boolean transaction(DepositAccount da) {

		entityManager.merge(da);
		return true;
	}

}
