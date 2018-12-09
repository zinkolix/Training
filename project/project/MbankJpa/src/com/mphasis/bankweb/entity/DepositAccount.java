/**
 * Deposit Account entity class for the deposit account.
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bankweb.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;

@Entity
@Table(name = "Deposit_acnt")
public class DepositAccount {
	@Id
	@Column(name = "acnt_id", length = 10)
	private String acntId;

	@Column(name = "balance")
	private double balance;

	@OneToOne
	@JoinColumn(name = "cust_id")
	private Customer cust;
	
	@OneToMany(mappedBy = "deposit", cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	private Set<DepositTransaction> depositTxn;

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAcntId() {
		return acntId;
	}

	public void setAcntId(String acntId) {
		this.acntId = acntId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Set<DepositTransaction> getDepositTxn() {
		return depositTxn;
	}

	public void setDepositTxn(Set<DepositTransaction> depositTxn) {
		this.depositTxn = depositTxn;
	}
	
	

}
