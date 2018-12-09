package com.mphasis.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts_t")
public class Account {

	@Id
	@Column(name = "acnt_no")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int acntNo;
	
	@Column(name = "holder")
	private String holder;
	
	@Column(name = "balance")
	protected double balance;
	
	@OneToMany(mappedBy = "acnt", cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	Set<AccountTransaction> Transactions;
	
	public Set<AccountTransaction> getTransactions() {
		return Transactions;
	}

	public void setTransactions(Set<AccountTransaction> txns) {
		Transactions = txns;
	}

	public int getAcntNo() {
		return acntNo;
	}

	public void setAcntNo(int acntNo) {
		this.acntNo = acntNo;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
