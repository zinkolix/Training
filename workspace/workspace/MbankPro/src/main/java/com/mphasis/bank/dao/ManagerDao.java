
package com.mphasis.bank.dao;

import com.mphasis.bank.entity.Department;
import com.mphasis.bank.entity.Employee;
/**
 * @author Ashwini.Sharma08
 */
public interface ManagerDao extends EmployeeDao  {

	boolean addStaff(Employee e);
	boolean removeStaff(int empId);
	Department getAccount(String deptId);

}
