package com.mphasis.pojo;

import java.sql.Date;

public class Employee {

	private int empNo;
	private String eName;
//	private String job;
//	private int mgr;
//	private Date hireDate;
	private double salary;
	private double comm;
//	private int deptNo;
	
	public Employee() {
		
	}

	public Employee(int empNo, String eName, double salary, double comm) {
		this.empNo = empNo;
		this.eName = eName;
		
		this.salary = salary;
		this.comm = comm;
		
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}


	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	
	
}
