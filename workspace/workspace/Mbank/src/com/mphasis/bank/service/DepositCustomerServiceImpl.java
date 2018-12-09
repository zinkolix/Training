/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.service;

import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.util.BalanceException;

public class DepositCustomerServiceImpl implements DepositCustomerService {

	@Override
	public void depositAmount(double amount) {
		
		System.out.println("This is depositAmount method");
	}

	@Override
	public void withdrawAmount(double amount) throws BalanceException {
		System.out.println("This is withdraw amount method");

	}

	@Override
	public void printStatement() {
		System.out.println("This is print statement method");

	}

	@Override
	public void downloadStatement() {
		System.out.println("This is downloadStatement method");

	}

	@Override
	public boolean fundTransfer(DepositAccount src, DepositAccount dest, double amount) throws BalanceException {
		
		return false;
	}

}
