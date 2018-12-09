/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bankweb.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "loan_txns")
public class LoanTransaction {

	@Id
	@GeneratedValue
	private int txnId;

	@Column(name = "txn_date")
	@Temporal(TemporalType.DATE)
	private Date txnDate;

	@Column(name = "txn_type", length = 12)
	private String txnType;

	@Column(length = 10)
	private double amount;
	
	@Column(length=14)
	private double outstanding;

	@ManyToOne
	@JoinColumn(name = "acntId")
	private LoanAccount la;

	public int getTxnId() {
		return txnId;
	}

	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}

	public LoanAccount getLa() {
		return la;
	}

	public void setLa(LoanAccount la) {
		this.la = la;
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

	public double getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

//	public Set<LoanAccount> getLa() {
//		return la;
//	}
//
//	public void setLa(Set<LoanAccount> la) {
//		this.la = la;
//	}


}
