/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bankweb.service;


import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.util.BalanceException;

public interface DepositCustomerService {
	double minimumTxnAmount = 100; // should be constant
	
	boolean depositAmount(String acntId, double amount);
	boolean withdrawAmount(String acntId, double amount) throws BalanceException;
	boolean fundTransfer(DepositAccount src, DepositAccount dest, double amount) throws BalanceException;
	//Beneficiary account exists and amount greater than 100 ie minTxnAmount.
	//No logic inside the fund transfer just divert the call to deposit and withdrawAmount
	void printStatement();
	void downloadStatement();
	void showSummary();

}
