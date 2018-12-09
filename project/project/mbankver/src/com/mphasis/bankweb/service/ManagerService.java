/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bankweb.service;

import com.mphasis.bankweb.pojo.EmployeeBean;
import com.mphasis.bankweb.util.AccountFoundNotException;
import com.mphasis.bankweb.util.AccountOpenProtocolException;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
public interface ManagerService extends EmployeeService{

	String addStaff(EmployeeBean bean) throws AccountOpenProtocolException;
	boolean removeStaff(String empId) throws AccountFoundNotException;
	
}
