package com.mphasis.bank.dao;

import java.util.List;

import com.mphasis.bank.entity.LoanAccount;
import com.mphasis.bank.entity.LoanTransaction;
/**
 * 
 * @author Ashwini.Sharma08
 *
 */
public interface LoanCustomerDao {

	LoanAccount partPayment(String accntId);
	boolean foreClosure(String custId);
	LoanAccount getAccount (String acntId);
	List<LoanTransaction> getStatement(String accntId);

}
