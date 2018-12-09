package com.mphasis.bankweb.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.bankweb.dao.DepositCustomerDao;
import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.entity.DepositTransaction;
import com.mphasis.bankweb.util.BalanceException;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Service
public class DepositCustomerServiceImpl implements DepositCustomerService {
	@Autowired
	private DepositCustomerDao customerDao;
	private DepositAccount account;

	public boolean depositAmount(String acntId, double amount) throws BalanceException {
		if (amount > 99) {
			account = customerDao.getAccount(acntId);
			double balance = account.getBalance();
			account.setBalance(balance + amount);
			DepositTransaction depositTransaction = new DepositTransaction();
			depositTransaction.setAmount(amount);
			depositTransaction.setBalance(balance + amount);
			depositTransaction.setTxnDate(new Date());
			depositTransaction.setTxnType("deposit");
			Set<DepositTransaction> depositTxn = new HashSet<DepositTransaction>();
			depositTxn.add(depositTransaction);
			account.setDepositTxn(depositTxn);
			depositTransaction.setDeposit(account);

			return customerDao.transaction(account);
		} else
			throw new BalanceException("Amount is less than 100");

	}

	public boolean withdrawAmount(String acntId, double amount) throws BalanceException {
		account = customerDao.getAccount(acntId);
		if (account.getBalance() - 1000 < amount)
			throw new BalanceException("Minimum limit is 1000");
		double balance = account.getBalance() - amount;
		account.setBalance(balance);
		DepositTransaction depositTransaction = new DepositTransaction();
		depositTransaction.setAmount(amount);
		depositTransaction.setBalance(balance);
		depositTransaction.setTxnDate(new Date());
		depositTransaction.setTxnType("withdraw");
		Set<DepositTransaction> depositTxn = new HashSet<DepositTransaction>();
		depositTxn.add(depositTransaction);
		account.setDepositTxn(depositTxn);
		depositTransaction.setDeposit(account);
		
		if (amount > 100) {
			return customerDao.transaction(account);
		} else
			throw new BalanceException("Amount is less than 100");

	}

	public boolean fundTransfer(DepositAccount src, DepositAccount dest, double amount) throws BalanceException {
		if (amount > 100) {
			if (withdrawAmount(src.getAcntId(), amount) == true && depositAmount(dest.getAcntId(), amount) == true)
				return true;
			else
				return false;
		} else
			return false;
	}

	public Set<DepositTransaction> printStatement(String acntId) {
		DepositAccount account = customerDao.getAccount(acntId);
		Set<DepositTransaction> transactions = account.getDepositTxn();
		return transactions;
	}

}
