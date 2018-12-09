package com.account.service;

import com.account.util.BalanceExeption;

public interface AccountService {

	public double addAccount(String holder);
//	public double withdraw(double amount);
	public double deposit(int acntId,double amount);
	double withdraw(int acntId, double amount) throws BalanceExeption;
	
}
 