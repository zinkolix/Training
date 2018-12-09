package com.mphasis.bank.dao;

import java.util.List;

import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.entity.DepositTransaction;
/**
 * @author Ashwini.Sharma08
 */
public interface DepositCustomerDao {

//	boolean depositAmount(String acntId,double amount);
//	boolean withdrawAmount(String acntId,double amount);
//	boolean fundTransfer(String srcId,String dest,double amount);
	List<DepositTransaction> getStatement(String acntId);
	DepositAccount getAccount (String acntId);
	DepositTransaction transaction(DepositAccount da);  
}
