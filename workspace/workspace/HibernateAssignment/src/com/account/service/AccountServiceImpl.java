package com.account.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.account.dao.AccountDao;
import com.account.dao.AccountDaoImpl;
import com.account.util.BalanceExeption;
import com.mphasis.pojo.Account;
import com.mphasis.pojo.AccountTransaction;

public class AccountServiceImpl implements AccountService {
	AccountDao dao = new AccountDaoImpl();;
	
	
	public AccountServiceImpl() {
		
	}

	@Override
	public double addAccount(String holder) {
	Account a = new Account();
	a.setHolder(holder);
	a.setBalance(10000);
	
	AccountTransaction at = new AccountTransaction();
	at.setTxnType("New Account");
	at.setTxnDate(new Date());
	at.setAmount(a.getBalance());
	at.setBalance(a.getBalance());
	at.setAcnt(a);
	
	Set<AccountTransaction> txns = new HashSet();
	txns.add(at);
	a.setTransactions(txns);
	return dao.addAccount(a);
	}

	@Override
	public double withdraw(int acntId, double amount) throws BalanceExeption {
	Account a = dao.getAccount(acntId);
	if(amount <= a.getBalance() - 1000){
		a.setBalance(a.getBalance() - 1000);
		
		AccountTransaction at = new AccountTransaction();
		at.setTxnType("New Account");
		at.setTxnDate(new Date());
		at.setAmount(a.getBalance());
		at.setBalance(a.getBalance());
		at.setAcnt(a);
		return dao.withdraw(a,at);
	}else
	{
		throw new BalanceExeption("Insufficient funds");
	}
		
	
	}

	@Override
	public double deposit(int acntId, double amount) {
		Account a = dao.getAccount(acntId);
		a.setBalance(a.getBalance() + amount);
		AccountTransaction at =  new AccountTransaction();
		at.setTxnType("Deposit");
		at.setTxnDate(new Date());
		at.setAmount(amount);
		at.setBalance(a.getBalance());
		at.setAcnt(a);
		a.getTransactions().add(at);
		Account acnt = (Account) dao.deposit(a);
		return acnt.getBalance();
	}



}
