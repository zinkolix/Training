
package com.mphasis.bankweb.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;


/**
 * Deposit customer entity class for the deposit account holders.
 * @author Ashwini.Sharma08
 * @version 1.0
 */
@Entity
@DiscriminatorValue("Deposit")
public class DepositCustomer extends Customer {

	@OneToOne(mappedBy = "cust", cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	private DepositAccount acnt;

	public DepositAccount getAcnt() {
		return acnt;
	}

	public void setAcnt(DepositAccount acnt) {
		this.acnt = acnt;
	}

}
