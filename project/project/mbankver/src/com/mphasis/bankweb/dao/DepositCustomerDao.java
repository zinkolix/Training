package com.mphasis.bankweb.dao;

import java.util.List;

import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.entity.DepositTransaction;

/**
 * @author Ashwini.Sharma08
 */
public interface DepositCustomerDao {

	List<DepositTransaction> getStatement(String acntId);

	DepositAccount getAccount(String acntId);

	boolean transaction(DepositAccount da);

	DepositAccount getAccountFromCustId(String custId);
}
