/**
 * Loan Customer entity class for the loan account holders.
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Loan")
public class LoanCustomer extends Customer {

	@OneToOne(mappedBy = "cust", cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
	private LoanAccount acnt;

	public LoanAccount getAcnt() {
		return acnt;
	}

	public void setAcnt(LoanAccount acnt) {
		this.acnt = acnt;
	}

}
