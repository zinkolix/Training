package com.mphasis.bankweb.pojo;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Component
public class EmployeeBean {

	private String name;
	private String dob;
	private String pan;
	private String deptId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}



}
