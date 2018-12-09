
package com.mphasis.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mphasis.bank.entity.Customer;
import com.mphasis.bank.entity.Department;
import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.entity.DepositCustomer;
import com.mphasis.bank.entity.Employee;
import com.mphasis.bank.util.HibernateUtil;
/**
 * @author Ashwini.Sharma08
 */
public class ManagerDaoImpl implements ManagerDao {

	public boolean addStaff(Employee e1) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction txn = session.getTransaction();

		try {
			txn.begin();
			session.save(e1);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			session.close();
			factory.close();
		}
	}

	public boolean removeStaff(int empId) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();
			Employee emp = (Employee) session.get(Employee.class, empId);
			session.delete(emp);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			factory.close();
			session.close();
		}

	}

	public boolean openAccount(Customer c) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction txn = session.getTransaction();

		try {
			txn.begin();
			session.save(c);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			factory.close();
		}
	}

	public boolean closeAccount(String custId) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction txn = session.getTransaction();
		try {
			txn.begin();
			DepositCustomer cust = (DepositCustomer) session.get(DepositCustomer.class, custId);
			session.delete(cust);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			factory.close();
		}
	}

	public List<Customer> reports(int empId) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		List<Customer> customer;
		Transaction txns = session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, empId);
		if (emp.getEmpType().equalsIgnoreCase("deposit")) {
			Query query = session.createQuery("from customer where acntType='deposit'");
			customer = query.list();
			txns.commit();
			return customer;
		} else if (emp.getEmpType().equalsIgnoreCase("loan")) {
			Query query = session.createQuery("from customer where acntType='loan'");
			customer = query.list();
			txns.commit();
			return customer;
		} else {
			Query query = session.createQuery("from customer");
			customer = query.list();
			txns.commit();
			return customer;
		}
	}

	public boolean checkExistingPan(String pan) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.beginTransaction();
		 Employee emp =
		 (Employee)session.bySimpleNaturalId(Employee.class).load(pan);
//		 if(emp == null)
//		 {
		Customer cust = (Customer) session.bySimpleNaturalId(Customer.class).load(pan);
		if (cust == null) 
			return true;
//		else
//			return false;
//		}
		else
		return false;
	}
	
	public Department getAccount(String deptId) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txns = session.beginTransaction();
		Department	da = (Department)session.get(Department.class, deptId);
		txns.commit();
		session.close();
		return da;
		
	}

}
