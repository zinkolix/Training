/**
 * Deposit customer entity class for the deposit account holders.
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bank_customer")
@DiscriminatorValue("Deposit")
public class DepositCustomer extends Customer {

	@OneToOne(mappedBy = "cust")
	private DepositAccount acnt;

	public DepositAccount getAcnt() {
		return acnt;
	}

	public void setAcnt(DepositAccount acnt) {
		this.acnt = acnt;
	}

}
