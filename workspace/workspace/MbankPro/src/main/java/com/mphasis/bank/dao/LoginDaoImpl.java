package com.mphasis.bank.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mphasis.bank.entity.Customer;
import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.entity.Employee;
import com.mphasis.bank.pojo.Login;
import com.mphasis.bank.util.HibernateUtil;

public class LoginDaoImpl implements LoginDao {

	public boolean validateCustomer(Login custLogin) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.getTransaction();
		try {
			txns.begin();
			Customer cust = (Customer) session.get(Customer.class, custLogin.getUserId());
			if (cust != null && cust.getPassword().equals(custLogin.getPassword()))
				return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean validateEmployee(Login empLogin) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.getTransaction();
		try {
			txns.begin();
			Employee emp = (Employee) session.get(Employee.class, empLogin.getUserId());
			if (emp != null && emp.getPassword().equals(empLogin.getPassword()))
				return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return false;

	}
}
