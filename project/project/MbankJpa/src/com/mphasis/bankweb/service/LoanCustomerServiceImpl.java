package com.mphasis.bankweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.bank.dao.util.IdVerification;
import com.mphasis.bankweb.dao.LoanCustomerDao;
import com.mphasis.bankweb.entity.LoanAccount;
import com.mphasis.bankweb.entity.LoanTransaction;

@Service
public class LoanCustomerServiceImpl implements LoanCustomerService {

//	IdVerification idVerification;

	@Autowired
	LoanCustomerDao customerDao;

//	public LoanCustomerServiceImpl() {
//		customerDao = new LoanCustomerDaoImpl();
//	}

	public boolean partPayment(String acntId, double emi) {
		LoanAccount account = customerDao.getAccount(acntId);
//		if(idVerification.loanAcntId(acntId)){
			if(emi == account.getEmi()){
				account.setOutstanding(account.getOutstanding() - emi);
				return customerDao.partPayment(account);
			}
//		}
		return false;
	}

	public boolean foreClosure(String acntId, double amount) {
		LoanAccount account = new LoanAccount();
//		if (idVerification.loanAcntId(acntId)) {
			account = customerDao.getAccount(acntId);

			if (amount == account.getOutstanding()) {
				return customerDao.foreClosure(acntId);
			} else
				return false;
//		} else
//			return false;
	}

	public double showOutstanding(String acntId) {
		LoanAccount account = new LoanAccount();
//		if (idVerification.loanAcntId(acntId)) {
			account = customerDao.getAccount(acntId);
			return account.getOutstanding();
//		} else
//			return 0;

	}

	public void downloadStatement() {

	}

	public void printStatement(String accntId) {

		List<LoanTransaction> list = customerDao.getStatement(accntId);
		for (LoanTransaction transaction : list) {
			System.out.println(transaction.getAmount());
		}
		
	}

}
