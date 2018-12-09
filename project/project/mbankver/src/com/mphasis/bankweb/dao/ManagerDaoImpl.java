
package com.mphasis.bankweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.Department;
import com.mphasis.bankweb.entity.DepositCustomer;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.util.AccountFoundNotException;

/**
 * @author Ashwini.Sharma08
 */
@Repository("managerDao")
public class ManagerDaoImpl implements ManagerDao {

	@PersistenceContext(unitName = "mBank")
	private EntityManager entityManager;

	@Transactional
	public boolean addStaff(Employee e1) {

		try {
			e1.setStatus("active");
			entityManager.persist(e1);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean removeStaff(String empId) throws AccountFoundNotException {
		Employee emp = entityManager.find(Employee.class, empId);
		if (emp == null) {
			return false;
		} else if (emp.getStatus().equalsIgnoreCase("disabled")) {
			return false;
		}
		try {
			if (emp.getEmpType().equalsIgnoreCase("E")) {
				emp.setStatus("disabled");
			}
			entityManager.merge(emp);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Transactional
	public boolean openAccount(Customer c) {
		entityManager.persist(c);
		return true;
	}

	@Transactional
	public boolean closeAccount(String custId) {
		Customer cust = entityManager.find(Customer.class, custId);
		cust.setStatus("disabled");
		entityManager.merge(cust);
		return true;
	}

	@Transactional
	public List<Customer> reports(String empId) {

		Employee emp = entityManager.find(Employee.class, empId);
		List<Customer> customer = null;
		if (emp.getEmpType().equals("M")) {
			Query query = (Query) entityManager.createQuery("from Customer where acntType='Deposit'");
			customer = query.getResultList();
			return customer;
		}
		return null;
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

	@Transactional
	public Department getAccount(String deptId) {

		Department da = entityManager.find(Department.class, deptId);

		return da;

	}

}
