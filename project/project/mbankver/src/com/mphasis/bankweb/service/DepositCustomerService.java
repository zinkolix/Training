
package com.mphasis.bankweb.service;

import java.util.Set;

import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.entity.DepositTransaction;
import com.mphasis.bankweb.util.BalanceException;

/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
public interface DepositCustomerService {
	double minimumTxnAmount = 100; // should be constant
	
	boolean depositAmount(String acntId, double amount) throws BalanceException;
	boolean withdrawAmount(String acntId, double amount) throws BalanceException;
	boolean fundTransfer(DepositAccount src, DepositAccount dest, double amount) throws BalanceException;
	Set<DepositTransaction> printStatement(String acntId);

}
