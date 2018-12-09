package com.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.account.util.HibernateUtil;
import com.account.util.JdbcUtil;
import com.mphasis.pojo.Account;
import com.mphasis.pojo.AccountTransaction;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class AccountDaoImpl implements AccountDao {

	@Override
	public int addAccount(Account a1) {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction txn = session.getTransaction();
			try {
				txn.begin();
				session.save(a1);
				txn.commit();
				return a1.getAcntNo();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return 0;
		}	
		
	
	@Override
	public double withdraw(Account a, AccountTransaction at) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Transaction txn = session.getTransaction();
		txn.begin();
		session.update(a);
		txn.commit();
		return a.getBalance();
	
	}
	@Override
	public Object deposit(Object a) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Transaction txn = session.getTransaction();
		txn.begin();
		session.update(a);
		txn.commit();
		return a;
		
		
	}


	@Override
	public Account getAccount(int acntId) {
	
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Transaction txn = session.beginTransaction();
		Account a = (Account)session.get(Account.class, acntId);
		txn.commit();
		return a;
	}
	
	

}
