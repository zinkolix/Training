
package com.mphasis.bankweb.dao;

import java.util.List;

import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.LoanAccount;
import com.mphasis.bankweb.util.AccountFoundNotException;



/**
 * @author Ashwini.Sharma08
 */
public interface EmployeeDao {

	boolean openAccount(Customer c);
	boolean closeAccount(String custId) throws AccountFoundNotException;
	List<Customer> reports(String empId);
	boolean checkExistingPan(String pan);

}
