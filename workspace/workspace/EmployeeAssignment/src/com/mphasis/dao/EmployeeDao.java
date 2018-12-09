package com.mphasis.dao;

import java.util.List;

import com.mphasis.pojo.Employee;

public interface EmployeeDao {

	boolean addEmployee(Employee e);
	List<Employee> showAllEmployee();
	boolean updateSalary(int empNo);
	boolean deleteEmployee(int empNo);
}
