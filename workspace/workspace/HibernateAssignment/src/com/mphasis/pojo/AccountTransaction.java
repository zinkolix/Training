package com.mphasis.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class AccountTransaction {
	@Id
	@GeneratedValue
	private int txnId;

	@Column(name = "txn_date")
	@Temporal(TemporalType.DATE)
	private Date txnDate;

	@Column(name = "txn_type", length = 12)
	private String txnType;

	@Column(name = "balance")
	private double balance;
	
	@Column(name = "amount")
	private double amount;

	@ManyToOne
	@JoinColumn(name = "acnt_no")
	private Account acnt;

	
	
	public Account getAcnt() {
		return acnt;
	}

	public void setAcnt(Account acnt) {
		this.acnt = acnt;
	}

	public int getTxnId() {
		return txnId;
	}

	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}

	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
