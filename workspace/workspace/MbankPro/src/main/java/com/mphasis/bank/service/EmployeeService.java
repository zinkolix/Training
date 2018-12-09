
package com.mphasis.bank.service;

import java.util.List;

import com.mphasis.bank.entity.Customer;
import com.mphasis.bank.util.AccountOpenProtocolException;
/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
public interface EmployeeService {

	boolean openAccount(Customer cust) throws AccountOpenProtocolException;
	boolean closeAccount(String custId) throws AccountOpenProtocolException;
	List<Customer> reports(int empId);
}
