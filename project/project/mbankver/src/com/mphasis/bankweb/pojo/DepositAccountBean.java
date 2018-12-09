package com.mphasis.bankweb.pojo;

import java.util.Date;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
public class DepositAccountBean {
	private String custName;
	private String dob;
	private String pan;
	private double amount;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
