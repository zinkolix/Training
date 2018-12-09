/**
 * 
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.entity;

import java.util.Date;

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
@Table(name = "loan_txn")
public class LoanTransaction {

	@Id
	@GeneratedValue
	private int txnId;

	@Column(name = "txn_date")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "txn_type", length = 12)
	private String txnType;

	private double outstanding;

	@ManyToOne
	@JoinColumn(name = "acnt_id")
	private LoanAccount acnt;

	public int getTxnId() {
		return txnId;
	}

	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public LoanAccount getAcnt() {
		return acnt;
	}

	public void setAcnt(LoanAccount acnt) {
		this.acnt = acnt;
	}

}
