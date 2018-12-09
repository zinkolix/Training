package com.mphasis.bankweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.pojo.Login;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Repository
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext(unitName = "mBank")
	private EntityManager entityManager;
	
	public Customer validateCustomer(Login custLogin) {
		try {
			Customer cust = entityManager.find(Customer.class, custLogin.getUserId()); 
			if (cust != null && cust.getPassword().equals(custLogin.getPassword()))
				return cust;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		return null;
	}

	public Employee validateEmployee(Login empLogin) {
//		try {
			System.out.println("yo");
			Employee emp = (Employee)entityManager.find(Employee.class, empLogin.getUserId());
			if (emp != null && emp.getPassword().equals(empLogin.getPassword())){
				System.out.println("yo yo");
				return emp;
			}
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			return null;
//		}
		return null;

	}
}
