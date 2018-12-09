/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.service;

public interface ManagerService extends EmployeeService{

	boolean addStaff(String deptId);
	boolean removeStaff(int empId);
	
}
