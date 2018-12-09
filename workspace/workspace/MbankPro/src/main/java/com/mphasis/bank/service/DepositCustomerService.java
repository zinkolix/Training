/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.service;


import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.util.BalanceException;

public interface DepositCustomerService {
	double minimumTxnAmount = 100; 
	
	boolean depositAmount(String acntId, double amount) throws BalanceException;
	boolean withdrawAmount(String acntId, double amount) throws BalanceException;
	boolean fundTransfer(DepositAccount src, DepositAccount dest, double amount) throws BalanceException;
	void printStatement(String acntId);
	void downloadStatement();
	void showSummary(String acntId);

}
