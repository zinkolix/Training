
package com.mphasis.bankweb.service;

import java.util.Set;

import com.mphasis.bankweb.entity.LoanTransaction;
import com.mphasis.bankweb.util.BalanceException;

/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
public interface LoanCustomerService {

	boolean partPayment(String acntId, double emi) throws BalanceException;

	// Part payment should be equal to the loan amount.
	boolean foreClosure(String acntId, double amount) throws BalanceException;

	// fore closure should be = outstanding.
	double showOutstanding(String acntId);

	Set<LoanTransaction> printStatement(String accntId);

}
