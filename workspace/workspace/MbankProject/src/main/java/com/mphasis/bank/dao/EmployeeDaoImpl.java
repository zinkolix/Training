
package com.mphasis.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mphasis.bank.entity.Customer;
import com.mphasis.bank.entity.DepositCustomer;
import com.mphasis.bank.entity.Employee;
import com.mphasis.bank.util.HibernateUtil;
/**
 * @author Ashwini.Sharma08
 */
public class EmployeeDaoImpl implements EmployeeDao {

	public boolean openAccount(Customer c) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		System.out.println("Hey i m here");
		Transaction txn = session.getTransaction();
		
		try {
			txn.begin();						
			session.save(c);
			System.out.println("I m inside try");
			txn.commit();
			return true;
		} catch (Exception e) {			
			e.printStackTrace();
			txn.rollback();
			return false;
		}finally{
			session.close();
			factory.close();
		}
	}

	public boolean closeAccount(String custId) {
		
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Transaction txn = session.getTransaction();
		try {
			txn.begin();
			DepositCustomer cust = (DepositCustomer)session.get(DepositCustomer.class, custId);//check for the customer and put this into if-else statement
			session.delete(cust);
			txn.commit();								//Test- check for the custId with assert whether the customer exist or not
			return true;
		} catch (Exception e) {			
			e.printStackTrace();
			txn.rollback();
			return false;
		}finally{
			factory.close();
		}
	}

	public List<Customer> reports(String empId) {
			//write a query object Query query = session.createQuery("from customer");
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		List<Customer> customer;
		Transaction txns = session.beginTransaction();
		Employee emp = (Employee)session.get(Employee.class, empId);
		if(emp.getEmpType().equalsIgnoreCase("deposit")){
			Query query = session.createQuery("from customer where acntType='deposit'");
			customer = query.list();
			txns.commit();
			return customer;
		}else if(emp.getEmpType().equalsIgnoreCase("loan")){
			Query query = session.createQuery("from customer where acntType='loan'");
			customer = query.list();
			txns.commit();
			return customer;
		}else
		{
			Query query = session.createQuery("from customer");
			customer = query.list();
			txns.commit();
			return customer;
		}
		
	}

	public boolean checkExistingPan(String pan) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.beginTransaction();
//		Employee	emp = (Employee)session.bySimpleNaturalId(Employee.class).load(pan);
//		if(emp == null)
//		{
			Customer cust = (Customer)session.bySimpleNaturalId(Customer.class).load(pan);
			if(cust == null){
				return true;
//			}
		}
		return false;
	}

}
