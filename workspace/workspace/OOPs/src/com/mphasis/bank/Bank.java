package com.mphasis.bank;

public interface Bank {
	 int INIT_ACNT_NO = 1001;
	 double MIN_SAV_BAL = 1000;
	 double MIN_CUR_BAL = 0;
	 double INIT_CUR_BAL = 5000;
	 double OD_LIMIT = 10000;
	 
	 void deposit(double amount);
	 void withdraw(double amount) throws BalanceException;
	 void summary();
	 void statement();
}
