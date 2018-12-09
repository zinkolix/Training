/**
 * Employee entity class for the employees of the bank.
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bankweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@Column(name = "emp_id")
	private int empId;
	
	@Column(name="emp_name",length=10)
	private String empName;
	
	@Column(name="emp_type", length = 20)
	private String empType;

	@Column(length=10)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department dept;
	
	@NaturalId
	@Column(length=10)
	private String pan;
	
	@Column(name = "status")
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	
	
	
}
