package com.mphasis.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.entity.DepositTransaction;
import com.mphasis.bank.entity.LoanTransaction;
import com.mphasis.bank.util.HibernateUtil;

public class DepositCustomerDaoImpl implements DepositCustomerDao {



	public List<DepositTransaction> getStatement(String acntId) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		List<DepositTransaction> loanTxn = null;
		Transaction txns = session.beginTransaction();
		DepositAccount	emp = (DepositAccount)session.get(DepositAccount.class, acntId);
	
			Query query = session.createQuery("from AccountTransaction where acntId="+acntId+"");
			loanTxn = query.list();
			txns.commit();
			return loanTxn;
	
		
	}

	public DepositAccount getAccount(String acntId) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.beginTransaction();
		DepositAccount	da = (DepositAccount)session.get(DepositAccount.class, acntId);
		
		
		txns.commit();
		session.close();
		return da;
		
	}

	public boolean transaction(DepositAccount da) {
		
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.getTransaction();
//		DepositAccount	da = (DepositAccount)session.get(DepositAccount.class, acntId);
//		da.setBalance(da.getBalance() - amount);
		try {
			txns.begin();
			session.saveOrUpdate(da);
			txns.commit();
			return true;
		} catch (Exception e) {
			txns.rollback();
			e.printStackTrace();
			return false;
		}
	}

}
