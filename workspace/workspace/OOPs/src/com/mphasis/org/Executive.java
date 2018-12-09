package com.mphasis.org;

public class Executive extends Employee {
	private double commission;

	public Executive() {
		
	}

	public Executive(String empName, double salary, double commission) {  		//Add local attribute in the constructor
		// Constructor chaining -  calling constructor of super class with matching signature.
		super(empName, salary);
		this.commission = commission;
		
	}

	@Override 								// overriding the methods present in the parent class.
	public double getSalary() {
	
		return super.getSalary() + commission;
	}

	@Override
	public void payslip() {
		
		super.payslip();
		System.out.println("Commission: " + commission);
	}
	

}
