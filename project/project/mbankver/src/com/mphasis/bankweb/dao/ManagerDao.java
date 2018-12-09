
package com.mphasis.bankweb.dao;

import com.mphasis.bankweb.entity.Department;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.util.AccountFoundNotException;

/**
 * @author Ashwini.Sharma08
 */
public interface ManagerDao extends EmployeeDao  {

	boolean addStaff(Employee e);
	boolean removeStaff(String empId) throws AccountFoundNotException;
	Department getAccount(String deptId);

}
