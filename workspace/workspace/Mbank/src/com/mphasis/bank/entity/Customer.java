/**
 * Customer class entity for individual customer of the bank
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "bank_customer")
public class Customer {

	@Id
	@Column(name = "cust_id")
	private String custId;

	@Column(name = "password", length = 15)
	private String password;

	@Column(name = "cust_name", length = 30)
	private String custName;

	@Column(name = "birth_date")
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Column(name = "pan", length = 10)
	private String pan;

	@Column(name = "acnt_type", nullable = false, updatable = false, insertable = false)
	private String acntType;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

}
