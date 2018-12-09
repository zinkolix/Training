package com.mphasis.bank.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mphasis.bank.entity.Customer;
import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.entity.Employee;
import com.mphasis.bank.util.HibernateUtil;

public class LoginDaoImpl implements LoginDao {

	public boolean validateCustomer(String custId, String password) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.beginTransaction();
		Customer  cust = (Customer)session.get(Customer.class, custId);
		Query query = session.createQuery("from Customer where custId="+custId+"password="+password);
		int result = query.executeUpdate();
		txns.commit();
		if(result == 0){
			return false;
		}else
			return true;
	}

	public boolean validateEmployee(String empId, String password) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.beginTransaction();
		Employee  cust = (Employee)session.get(Employee.class, empId);
		Query query = session.createQuery("from Employee where empId="+empId+"password="+password);
		int result = query.executeUpdate();
		txns.commit();
		if(result == 0){
			return false;
		}else
			return true;
	}

}
