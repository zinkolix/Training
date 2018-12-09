package com.mphasis.bankweb.pojo;


import org.springframework.stereotype.Component;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Component
public class LoanAccountBean {

	private String custName;
	private String dob;
	private String pan;
	private double salary;
	private double tenure;
	private double principle;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getTenure() {
		return tenure;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}

	public double getPrinciple() {
		return principle;
	}

	public void setPrinciple(double principle) {
		this.principle = principle;
	}

}
