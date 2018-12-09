
package com.mphasis.bankweb.service;

import java.util.List;

import com.mphasis.bankweb.entity.Customer;
/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
public interface EmployeeService {

	boolean openAccount(Customer cust);
	boolean closeAccount(String custId);
	List<Customer> reports(int empId);
}
