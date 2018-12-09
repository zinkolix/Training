
package com.mphasis.bankweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.entity.LoanAccount;
import com.mphasis.bankweb.util.AccountFoundNotException;
import com.mphasis.bankweb.util.BalanceException;

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
		try {

			entityManager.persist(c);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean closeAccount(String custId) throws AccountFoundNotException {
		Customer cust = entityManager.find(Customer.class, custId);
		if (cust == null)
			return false;
		else if (cust.getStatus().equalsIgnoreCase("disabled"))
			return false;
		else {
			cust.setStatus("disabled");
			entityManager.merge(cust);
			return true;
		}

	}

	@Transactional
	public boolean checkExistingPan(String pan) {

		Employee emp = (Employee) entityManager.unwrap(Session.class).bySimpleNaturalId(Employee.class).load(pan);
		if (emp == null) {
			Customer cust = (Customer) entityManager.unwrap(Session.class).bySimpleNaturalId(Customer.class).load(pan);
			if (cust == null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Customer> reports(String empId) {
		Employee emp = entityManager.find(Employee.class, empId);
		List<Customer> customer = null;
		if (emp.getEmpType().toString().equals("M")) {
			System.out.println(emp.getEmpType());
			Query query = (Query) entityManager.createQuery("from Customer where acntType='Loan'");
			customer = query.getResultList();
			return customer;
		} else if (emp.getEmpType().toString().equals("E") && emp.getDept().getDeptId().equalsIgnoreCase("dept01")) {
			Query query = (Query) entityManager.createQuery("from Customer where acntType='Deposit'");
			customer = query.getResultList();
			return customer;
		} else if (emp.getEmpType().toString().equals("E") && emp.getDept().getDeptId().equalsIgnoreCase("dept02")) {
			Query query = (Query) entityManager.createQuery("from Customer where acntType='Loan'");
			customer = query.getResultList();
			return customer;
		}
		return customer;

	}

}
