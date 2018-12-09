package com.mphasis.service;

import java.util.List;

import com.mphasis.pojo.Employee;
import com.mphasis.util.InvalidEmployeeException;

public interface EmployeeService {

	boolean addEmployee(Employee e) throws InvalidEmployeeException;
	List<Employee> showAllEmployee() throws InvalidEmployeeException;
	boolean updateSalary(int empNo) throws InvalidEmployeeException;
	boolean deleteEmployee(int empNo) throws InvalidEmployeeException;
}
