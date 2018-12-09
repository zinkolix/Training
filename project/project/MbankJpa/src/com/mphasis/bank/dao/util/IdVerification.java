package com.mphasis.bank.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mphasis.bank.util.HibernateUtil;
import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.entity.LoanAccount;

public class IdVerification {

	
	public boolean checkExistingEmpId(String empId){
//		SessionFactory factory =  HibernateUtil.getSessionFactory();
//		Session session = factory.openSession();
//		Transaction txns = session.beginTransaction();
//		Employee	emp = (Employee)session.get(Employee.class, empId);
//		if(emp != null)
//			return true;
//		else
			return false;
		
	}
	public boolean checkExistingcustId(String custId){
//		SessionFactory factory =  HibernateUtil.getSessionFactory();
//		Session session = factory.openSession();
//		Transaction txns = session.beginTransaction();
//		Customer cust = (Customer)session.get(Customer.class, custId);
//		if(cust != null)
//			return true;
//		else
			return false;
	
		
	}
	public boolean depositAcntId(String acntId){
//		SessionFactory factory =  HibernateUtil.getSessionFactory();
//		Session session = factory.openSession();
//		Transaction txns = session.beginTransaction();
//		DepositAccount da = (DepositAccount)session.get(DepositAccount.class, acntId);
//		if(da != null)
//			return true;
//		else
			return false;
		
	}
	public boolean loanAcntId(String acntId){
//		SessionFactory factory =  HibernateUtil.getSessionFactory();
//		Session session = factory.openSession();
//		Transaction txns = session.beginTransaction();
//		LoanAccount la = (LoanAccount)session.get(LoanAccount.class, acntId);
//		if(la != null)
//			return true;
//		else
			return false;
		
	}
}
