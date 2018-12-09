
package com.mphasis.bankweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.DepositCustomer;
import com.mphasis.bankweb.entity.Employee;

/**
 * @author Ashwini.Sharma08
 */
@Repository("daoCust")
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext(unitName = "mBank")
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public boolean openAccount(Customer c) {
//		c.setStatus("active");
		entityManager.persist(c);
		return true;
	}

	@Transactional
	public boolean closeAccount(String custId) {
		DepositCustomer cust = entityManager.find(DepositCustomer.class, custId);
		cust.setStatus("disabled");
		entityManager.merge(cust);
		return true;

	}

	public List<Customer> reports(String empId) {
		return null;
			//write a query object Query query = session.createQuery("from customer");
//		SessionFactory factory =  HibernateUtil.getSessionFactory();
//		Session session = factory.openSession();
//		List<Customer> customer;
//		Transaction txns = session.beginTransaction();
//		Employee emp = (Employee)session.get(Employee.class, empId);
//		if(emp.getEmpType().equalsIgnoreCase("deposit")){
//			Query query = session.createQuery("from customer where acntType='deposit'");
//			customer = query.list();
//			txns.commit();
//			return customer;
//		}else if(emp.getEmpType().equalsIgnoreCase("loan")){
//			Query query = session.createQuery("from customer where acntType='loan'");
//			customer = query.list();
//			txns.commit();
//			return customer;
//		}else
//		{
//			Query query = session.createQuery("from customer");
//			customer = query.list();
//			txns.commit();
//			return customer;
//		}

//		String sql = null;
//		txn.begin();
//		String dept = emp.getDept().getDeptName();
		
	}

	@Transactional
	public boolean checkExistingPan(String pan) {

	
//		Employee	emp = (Employee)session.bySimpleNaturalId(Employee.class).load(pan);
//		if(emp == null)
//		{
			Customer cust = (Customer) entityManager.unwrap(Session.class).bySimpleNaturalId(Customer.class).load(pan);
			if(cust == null){
				return true;
//			}
		}
		return false;
	}

	@Override
	public List<Customer> reports(int empId) {
		System.out.println(empId);
		Employee emp = entityManager.find(Employee.class, empId);
		List<Customer> customer = null;
		System.out.println(emp.getEmpName());
		if(emp.getEmpType().equalsIgnoreCase("E")){
			Query query = (Query)entityManager.createQuery("from Customer where acntType='deposit'");
			customer = query.getResultList();
			return customer;
		}
		return null;
	}



}
