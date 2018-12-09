package com.mphasis.bank;

import com.mphasis.org.Customer;

public class SeasonalCustomer extends Customer {

	public SeasonalCustomer() {
		
	}

	public SeasonalCustomer(String custName) {
		super(custName, 2000);
		
	}

}
