
package com.mphasis.bank.dao;

import java.util.List;

import com.mphasis.bank.entity.Customer;


/**
 * @author Ashwini.Sharma08
 */
public interface EmployeeDao {

	boolean openAccount(Customer c);
	boolean closeAccount(String custId);
	List<Customer> reports(int empId);
	boolean checkExistingPan(String pan);

}
