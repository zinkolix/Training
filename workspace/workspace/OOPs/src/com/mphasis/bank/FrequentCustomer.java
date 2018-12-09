package com.mphasis.bank;

import com.mphasis.org.Customer;

public class FrequentCustomer extends Customer {

	public FrequentCustomer() {
		
	}

	public FrequentCustomer(String custName) {
		super(custName, 10000);
		
	}

}
