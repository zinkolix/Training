package com.mphasis.org;
public abstract class Employee {
	private int empNo;
	private String empName;
	private double salary;
	
	private static int autogen;
	
	static { //static initializer block
		
		autogen = 1001;
		System.out.println("Employee class loaded... ");			
	}
	
	//Default and parameterized constructors
	public Employee() {
	this("Anshu", 25000);
	}
	
	
	public Employee(String empName, double salary) {
		this.empNo = autogen ++;
		this.empName = empName;
		this.salary = salary;
	}

	
	public double getSalary() {
		return salary;
	}


	public void payslip() {
		System.out.println( "EmpNo: " + empNo + "\nName: " + empName + "\nSalary: " + salary );
	}
}
