package com.mphasis.bank;

import java.util.Vector;

/**
 * This class represents the generalized back account.
 * @author Ashwini Sharma
 * @version 1.0
 */
public abstract class Account implements Bank {
	private int acntNo;
	private String holder;
	protected double balance;
	
	//Fields for statement of transactions.
//	protected Transaction[] txns;
//	protected int idx;
	protected Vector<Transaction> txnsVec;
	
	private static int autogen = INIT_ACNT_NO;
	
	/**
	 * This is default constructor.
	 */
	
	public Account() {
		
	}
	
	/**
	 * 
	 * This is parameterized constructor. 
	 */

	public Account(String holder, double balance) {
		// Assigning next generated account number
		this.acntNo = autogen ++;
		this.holder = holder;
		this.balance = balance;
		txnsVec = new Vector<Transaction>();
		//Creates 10 references of transactions type
//		txns = new Transaction[10];
//		if(idx <= txns.length)
//			txns[idx ++] = new Transaction("0B",balance, balance);
		
		txnsVec.add(new Transaction("0b", balance,balance));		
	}
	
	/**
	 * This is summary method for printing the Account Details.
	 */
	
	public void summary() {
		System.out.println("Account No: " + acntNo);
		System.out.println("Holder: " + holder);
		System.out.println("Balance: " + balance);
		
	}
	
	/**
	 * 
	 * This is a deposit method for debiting the balance
	 */
	
	public  void deposit(double amount) {
		balance += amount;
//		if(idx <= txns.length)
//			txns[idx ++] = new Transaction("Cr",amount, balance);
		txnsVec.add(new Transaction("0b", balance,balance));
	}

	@Override
	public void statement() {
		System.out.println("Statement of A/C No: " + acntNo);
//		for(int i = 0; i < idx; i++){
//			//txns[i].print();
//		}
		for (Transaction t : txnsVec) {
			t.print();
		}
		
		
	}
	
	
	
	
	
	

}
