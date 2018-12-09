package com.account.dao;

import com.mphasis.pojo.Account;
import com.mphasis.pojo.AccountTransaction;

public interface AccountDao {

	int addAccount(Account a);
	Account getAccount(int acnt_id);
	public double withdraw(Account a, AccountTransaction at);
	Object deposit(Object a);
}
