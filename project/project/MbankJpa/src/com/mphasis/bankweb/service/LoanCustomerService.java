/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bankweb.service;

public interface LoanCustomerService {
	
	boolean partPayment(String acntId, double emi);
	//Part payment should be equal to the loan amount.
	boolean foreClosure(String acntId, double amount);
	//fore closure should be = outstanding.
	double showOutstanding(String acntId);
	void downloadStatement();
	void printStatement(String accntId);

}
