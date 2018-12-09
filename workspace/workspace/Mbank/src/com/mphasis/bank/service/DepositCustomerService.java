/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.service;


import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.util.BalanceException;

public interface DepositCustomerService {
	
	void depositAmount(double amount);
	void withdrawAmount(double amount) throws BalanceException;
	boolean fundTransfer(DepositAccount src, DepositAccount dest, double amount) throws BalanceException;
	void printStatement();
	void downloadStatement();
	

}
