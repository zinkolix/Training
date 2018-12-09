/**
 * @author Ashwini.Sharma08
 */
package com.mphasis.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mphasis.bank.entity.Customer;
import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.entity.Employee;
import com.mphasis.bank.entity.LoanAccount;
import com.mphasis.bank.entity.LoanTransaction;
import com.mphasis.bank.util.HibernateUtil;

public class LoanCustomerDaoImpl implements LoanCustomerDao {

	public LoanAccount partPayment(String accntId) {


		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.beginTransaction();
		LoanAccount la = (LoanAccount)session.get(LoanAccount.class, accntId);
		la.setPrinciple(la.getPrinciple());
		try {
			txns.begin();
			session.save(la);
			txns.commit();
			return la;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public boolean foreClosure(String custId) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.beginTransaction();
		Customer cust = (Customer)session.get(Customer.class, custId);
		try {
			txns.begin();
			session.delete(cust);
			txns.commit();
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	public LoanAccount getAccount(String accntId) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		LoanAccount	la = (LoanAccount)session.get(LoanAccount.class, accntId);
		
		Transaction txns = session.beginTransaction();
		txns.commit();
		return la;
	}

	public List<LoanTransaction> getStatement(String accntId) {
	
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		List<LoanTransaction> loanTxn;
		Transaction txns = session.beginTransaction();
		LoanTransaction emp = (LoanTransaction)session.get(LoanTransaction.class, accntId);
		
			Query query = session.createQuery("from loan_account");
			loanTxn = query.list();
			txns.commit();
			return loanTxn;
			}



}
