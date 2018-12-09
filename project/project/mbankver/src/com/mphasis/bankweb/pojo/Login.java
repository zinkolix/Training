package com.mphasis.bankweb.pojo;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Ashwini.Sharma08
 *
 */
@Component
public class Login {

	private String userId;
	private String password;
	private String role;

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
