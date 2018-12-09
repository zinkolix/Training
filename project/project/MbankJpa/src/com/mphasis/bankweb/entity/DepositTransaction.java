/**
 *Deposit transaction entity class for the transaction done by the customer having the deposit account. 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bankweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "deposit_txn_table")
public class DepositTransaction {
	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	private int txnId;

	@Column(name = "txn_date")
	@Temporal(TemporalType.DATE)
	private Date txnDate;

	@Column(name = "txn_type", length = 12)
	private String txnType;

	@Column(length=10)
	private double balance;
	
	@Column(length=10)
	private double amount;


	@ManyToOne
	@JoinColumn(name = "acntId")
	private DepositAccount deposit;

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

	public DepositAccount getDeposit() {
		return deposit;
	}

	public void setDeposit(DepositAccount deposit) {
		this.deposit = deposit;
	}


}
