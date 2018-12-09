package com.mphasis.org;

public class Customer {
	private int custId;
	private String custName;
	private int creditLimit;
	
	private static int autogen;
	
	static {
		autogen = 1001;
	}
	
	public Customer() {
		
	}

	public Customer(String custName, int creditLimit) {
		this.custId = autogen ++;
		this.custName = custName;
		this.creditLimit = creditLimit;
	}
	
	public void display() {
		System.out.println("Customer Id: " + custId);
		System.out.println("Customer Name: " + custName);
		System.out.println("Credit Limit: " + creditLimit);
	}
	

}
