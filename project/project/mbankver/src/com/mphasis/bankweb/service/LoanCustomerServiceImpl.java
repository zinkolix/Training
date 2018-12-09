package com.mphasis.bankweb.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.bankweb.dao.LoanCustomerDao;
import com.mphasis.bankweb.entity.DepositAccount;
import com.mphasis.bankweb.entity.DepositTransaction;
import com.mphasis.bankweb.entity.LoanAccount;
import com.mphasis.bankweb.entity.LoanTransaction;
import com.mphasis.bankweb.util.BalanceException;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Service("loanservice")
public class LoanCustomerServiceImpl implements LoanCustomerService {


	@Autowired
	LoanCustomerDao customerDao;

	public boolean partPayment(String acntId, double emi) throws BalanceException {
		LoanAccount account = customerDao.getAccount(acntId);
		LoanTransaction transaction = new LoanTransaction();
		if (emi == account.getEmi()) {
			double outstanding = account.getOutstanding() - emi;
			account.setOutstanding(outstanding);
			transaction.setOutstanding(outstanding);
			transaction.setTxnDate(new Date());
			transaction.setTxnType("Part Payment");
			transaction.setAmount(emi);
			Set<LoanTransaction> loanTxn = new HashSet<LoanTransaction>();
			loanTxn.add(transaction);
			account.setLoanTxns(loanTxn);
			transaction.setLa(account);
			return customerDao.partPayment(account);
		} else
			throw new BalanceException("Emi is less");
	}

	public boolean foreClosure(String acntId, double amount) throws BalanceException {
		LoanAccount account = new LoanAccount();
		account = customerDao.getAccount(acntId);
		LoanTransaction transaction = new LoanTransaction();
		if (amount == account.getOutstanding()) {
			double outstanding = account.getOutstanding() - amount;
			account.setOutstanding(outstanding);
			transaction.setOutstanding(outstanding);
			transaction.setTxnType("Fore Closure");
			transaction.setAmount(outstanding);
			transaction.setTxnDate(new Date());
			Set<LoanTransaction> loanTxn = new HashSet<LoanTransaction>();
			loanTxn.add(transaction);
			account.setLoanTxns(loanTxn);
			transaction.setLa(account);
			return customerDao.foreClosure(account);
		} else
			throw new BalanceException("Amount is less");
	}

	public double showOutstanding(String acntId) {
		LoanAccount account = new LoanAccount();
		// if (idVerification.loanAcntId(acntId)) {
		account = customerDao.getAccount(acntId);
		return account.getOutstanding();
		// } else
		// return 0;

	}

	public void downloadStatement() {

	}

	public Set<LoanTransaction> printStatement(String acntId) {

		LoanAccount account = customerDao.getAccount(acntId);
		Set<LoanTransaction> transactions = account.getLoanTxns();
		return transactions;

	}

}
