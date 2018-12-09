/**
 * Department class entity for the departments of the bank.
 * @author Ashwini.Sharma08
 * @version 1.0
 */
package com.mphasis.bankweb.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="department")
public class Department {
	@Id
	@Column(name="dept_id")
	private String deptId;
	@Column(name = "dept_name")
	private String deptName;
	
	@OneToMany(mappedBy = "dept", cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	private Set<Employee> employees;
	

	
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
		
}
