/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.service;

public class LoanCustomerServiceImpl implements LoanCustomerService {

	@Override
	public void emiPayment() {
		System.out.println("This is emiPayment method");

	}

	@Override
	public void partPayment() {
		System.out.println("This is part payment method");

	}

	@Override
	public void foreClosure() {
		System.out.println("This is foreclosure method");

	}

	@Override
	public void printStatement() {
		System.out.println("This is print Statement method");

	}

	@Override
	public void downloadStatement() {
		System.out.println("This is download statement method");

	}

}
