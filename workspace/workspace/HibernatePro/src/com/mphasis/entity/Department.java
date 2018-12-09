package com.mphasis.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments_table")
public class Department {
	@Id
	private int deptNo;
	@Column(name = "dname", length = 20)
	private String deptName;

	//Eager will fetch the data from the database on a single stretch and get in the memory for further use
	@OneToMany(mappedBy = "dept", cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	private Set<Employee> employees;

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
