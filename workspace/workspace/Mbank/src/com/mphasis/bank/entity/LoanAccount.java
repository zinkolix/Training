/**
 * Loan account entity class for the loan account.
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan_acnt")
public class LoanAccount {

	@Id
	@Column(name = "acnt_id", length = 10)
	private String acntId;
	private double principle;
	private double balance;

	@OneToOne
	@JoinColumn(name = "cust_id")
	private Customer cust;

	public String getAcntId() {
		return acntId;
	}

	public void setAcntId(String acntId) {
		this.acntId = acntId;
	}

	public double getPrinciple() {
		return principle;
	}

	public void setPrinciple(int principle) {
		this.principle = principle;
	}

}
