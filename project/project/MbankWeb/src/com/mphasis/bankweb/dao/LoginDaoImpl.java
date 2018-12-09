package com.mphasis.bankweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.pojo.Login;

@Repository
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext(unitName = "mBank")
	private EntityManager entityManager;
	
	public Customer validateCustomer(Login custLogin) {
		try {
			Customer cust = entityManager.find(Customer.class, custLogin.getUserId()); 
			if (cust != null && cust.getPassword().equalsIgnoreCase(custLogin.getPassword()))
				return cust;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		return null;
	}

	public Employee validateEmployee(Login empLogin) {
		try {
			
			Employee emp = entityManager.find(Employee.class, empLogin.getUserId());
			if (emp != null && emp.getPassword().equalsIgnoreCase(empLogin.getPassword()))
				return emp;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		return null;

	}
}
