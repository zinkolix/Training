package com.mphasis.bankweb.dao;

import java.util.List;

import com.mphasis.bankweb.entity.LoanAccount;
import com.mphasis.bankweb.entity.LoanTransaction;
/**
 * 
 * @author Ashwini.Sharma08
 *
 */
public interface LoanCustomerDao {

	boolean partPayment(LoanAccount account);
	boolean foreClosure(String acntId);
	LoanAccount getAccount (String acntId);
	List<LoanTransaction> getStatement(String accntId);
}
