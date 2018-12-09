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

	public boolean depositAmount(String acntId, double amount) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.beginTransaction();
		DepositAccount	da = (DepositAccount)session.get(DepositAccount.class, acntId);
		da.setBalance(da.getBalance() + amount);
		try {
			txns.begin();
			session.save(da);
			txns.commit();
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public boolean withdrawAmount(String acntId, double amount) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.beginTransaction();
		DepositAccount	da = (DepositAccount)session.get(DepositAccount.class, acntId);
		da.setBalance(da.getBalance() - amount);
		try {
			txns.begin();
			session.save(da);
			txns.commit();
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public boolean fundTransfer(String srcId, String dest, double amount) {
		withdrawAmount(srcId,amount);
		depositAmount(dest,amount);
			return true;
	}

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
		DepositAccount	da = (DepositAccount)session.get(DepositAccount.class, acntId);
		
		Transaction txns = session.beginTransaction();
		txns.commit();
		return da;
		
	}

	public DepositTransaction transaction(DepositAccount da) {
		
		return null;
	}

}
