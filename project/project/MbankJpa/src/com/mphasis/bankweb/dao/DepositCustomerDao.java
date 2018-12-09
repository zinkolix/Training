package com.mphasis.bankweb.dao;

import java.util.List;

import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.entity.DepositTransaction;
/**
 * @author Ashwini.Sharma08
 */
public interface DepositCustomerDao {

//	boolean depositAmount(String acntId,double amount);
//	boolean withdrawAmount(String acntId,double amount);
//	boolean fundTransfer(String srcId,String dest,double amount);
	List<DepositTransaction> getStatement(String acntId);
	DepositAccount getAccount (String acntId);
	boolean transaction(DepositAccount da);  // Changed DepositTransaction to boolean for checking
}
