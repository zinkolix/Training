package com.mphasis.bank.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.mphasis.bank.dao.DepositCustomerDao;
import com.mphasis.bank.dao.DepositCustomerDaoImpl;
import com.mphasis.bank.entity.DepositAccount;
import com.mphasis.bank.entity.DepositTransaction;
import com.mphasis.bank.util.BalanceException;

public class DepositCustomerServiceImpl implements DepositCustomerService {
	private DepositCustomerDao customerDao;
	private DepositAccount account;

	public DepositCustomerServiceImpl() {

		customerDao = new DepositCustomerDaoImpl();
	}

	public boolean depositAmount(String acntId, double amount) throws BalanceException {

		account = customerDao.getAccount(acntId);
		account.setBalance(account.getBalance() + amount);
		DepositTransaction depositTransaction = new DepositTransaction();
		depositTransaction.setAmount(amount);
		depositTransaction.setBalance(account.getBalance() + amount);
		depositTransaction.setTxnDate(new Date());
		depositTransaction.setTxnType("account");
		Set<DepositTransaction> depositTxn = new HashSet<DepositTransaction>();
		depositTxn.add(depositTransaction);
		account.setDepositTxn(depositTxn);
		depositTransaction.setDeposit(account);
		if (amount > 100) {
			return customerDao.transaction(account);
		} else
			throw new BalanceException("Amount is less than 100");
	}

	public boolean withdrawAmount(String acntId, double amount) throws BalanceException {
		if (amount >= 100) {
			account = customerDao.getAccount(acntId);
			if (account.getBalance() >= 1000 + amount) {

				try {
					account.setBalance(account.getBalance() - amount);
					DepositTransaction depositTransaction = new DepositTransaction();
					depositTransaction.setAmount(amount);
					depositTransaction.setBalance(account.getBalance() - amount);
					depositTransaction.setTxnDate(new Date());
					depositTransaction.setTxnType("withdraw");
					depositTransaction.setTxnId(1);
					depositTransaction.setDeposit(account);

					return customerDao.transaction(account);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			} else
				throw new BalanceException("The minimum Balance should be 1000 Rs.");
		} else
			throw new BalanceException("Withdraw amount is less than 100");
	}

	
	public boolean fundTransfer(DepositAccount src, DepositAccount dest, double amount) throws BalanceException {
		if (amount > 100) {
			if (withdrawAmount(src.getAcntId(), amount) == true && depositAmount(dest.getAcntId(), amount) == true)
				return true;
			else
				return false;
		} else
			throw new BalanceException("Amount is less than 100");
	}

	public void printStatement(String acntId) {
		account = customerDao.getAccount(acntId);
		Set<DepositTransaction> transactions = account.getDepositTxn();
		for (DepositTransaction depositTransaction : transactions) {
			System.out.println("Transaction Id: " + depositTransaction.getTxnId() + "Amount: "
					+ depositTransaction.getAmount() + " Transaction Type: " + depositTransaction.getTxnType());
		}
	}

	public void downloadStatement() {

	}

	public void showSummary(String acntId) {

		account = customerDao.getAccount(acntId);
		System.out.println("Customer Name: " + account.getCust().getCustName());
		System.out.println("Customer Balance: " + account.getBalance());
	}

}
