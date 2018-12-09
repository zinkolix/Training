
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

/**
 * Loan account entity class for the loan account.
 * @author Ashwini.Sharma08
 * @version 1.0
 */
@Entity
@Table(name = "loan_acnts")
public class LoanAccount {

	@Id
	@Column(name = "acnt_id", length = 10)
	private String acntId;
	
	@Column(name="principle",length=10)
	private double principle;
	
	
	@Column(name="tenure",length=10)
	private double tenure;
	
	@Column(name="roi",length=10)
	private double roi;
	
	@Column(name = "emi",length =10)
	private double emi;
	
	@Column(name="cust_sal",length=10)
	private double cust_sal;
	
	@Column(name="outstanding",length=10)
	private double outstanding;
	
	@OneToOne
	@JoinColumn(name = "cust_id")
	private Customer cust;
	
	@OneToMany(mappedBy="la", cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	private Set<LoanTransaction> loanTxns;

	public String getAcntId() {
		return acntId;
	}
	

	public double getOutstanding() {
		return outstanding;
	}


	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
	}


	public Set<LoanTransaction> getLoanTxns() {
		return loanTxns;
	}


	public void setLoanTxns(Set<LoanTransaction> loanTxns) {
		this.loanTxns = loanTxns;
	}


	public void setAcntId(String acntId) {
		this.acntId = acntId;
	}

	public double getPrinciple() {
		return principle;
	}

	public void setPrinciple(double d) {
		this.principle = d;
	}

	public double getTenure() {
		return tenure;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}

	public double getRoi() {
		return roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}

	public double getCust_sal() {
		return cust_sal;
	}

	public void setCust_sal(double cust_sal) {
		this.cust_sal = cust_sal;
	}

	public Customer getCust() {
		return cust;
	}



	public double getEmi() {
		return emi;
	}


	public void setEmi(double emi) {
		this.emi = emi;
	}


	public void setCust(Customer cust) {
		this.cust = cust;
	}
	

}
