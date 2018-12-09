package com.mphasis.bankweb.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.bankweb.dao.DepositCustomerDao;
import com.mphasis.bankweb.dao.DepositCustomerDaoImpl;
import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.entity.DepositTransaction;
import com.mphasis.bankweb.util.BalanceException;

@Service
public class DepositCustomerServiceImpl implements DepositCustomerService {
	@Autowired
	private DepositCustomerDao customerDao;
	private DepositAccount account;

	public boolean depositAmount(String acntId, double amount) {

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
			return false;

	}

	public boolean withdrawAmount(String acntId, double amount) throws BalanceException {
		account = customerDao.getAccount(acntId);
		if (account.getBalance() - 1000 < amount)
			return false;
		account.setBalance(account.getBalance() - amount);
		DepositTransaction depositTransaction = new DepositTransaction();
		depositTransaction.setAmount(amount);
		depositTransaction.setBalance(account.getBalance() - amount);
		depositTransaction.setTxnDate(new Date());
		depositTransaction.setTxnType("withdraw");
		depositTransaction.setTxnId(1);
		depositTransaction.setDeposit(account);
		if (amount > 100) {
			return customerDao.transaction(account);
		} else
			return false;

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

	public void printStatement() {
		// TODO Auto-generated method stub

	}

	public void downloadStatement() {
		// TODO Auto-generated method stub

	}

	public void showSummary() {
		// TODO Auto-generated method stub

	}

}
