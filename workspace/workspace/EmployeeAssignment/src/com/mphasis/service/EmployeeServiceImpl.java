package com.mphasis.service;

import java.util.List;

import com.mphasis.dao.EmployeeDao;
import com.mphasis.dao.EmployeeDaoImpl;
import com.mphasis.pojo.Employee;
import com.mphasis.util.InvalidEmployeeException;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao dao;
	
	public EmployeeServiceImpl() {
		dao = new EmployeeDaoImpl();
	}
	@Override
	public boolean addEmployee(Employee e) throws InvalidEmployeeException {
		if(e.getEmpNo() > 0)
			return dao.addEmployee(e);
		throw new InvalidEmployeeException("Employee Number is invalid");
	}

	@Override
	public List<Employee> showAllEmployee() throws InvalidEmployeeException {
		
		return dao.showAllEmployee();
	}

	@Override
	public boolean updateSalary(int empNo) throws InvalidEmployeeException {
		
		return dao.updateSalary(empNo);
	}

	@Override
	public boolean deleteEmployee(int empNo) throws InvalidEmployeeException {
		
		return dao.deleteEmployee(empNo);
	}

}
