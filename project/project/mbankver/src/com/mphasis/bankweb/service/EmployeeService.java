
package com.mphasis.bankweb.service;

import java.util.List;

import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.util.AccountFoundNotException;
import com.mphasis.bankweb.util.AccountOpenProtocolException;
/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
public interface EmployeeService {

	String openAccount(Object cust) throws AccountOpenProtocolException;
	boolean closeAccount(String custId) throws AccountFoundNotException;
	List<Customer> reports(String empId);
}
