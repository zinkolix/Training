package com.mphasis.bank.dao;

public interface LoginDao {
	
	public boolean validateCustomer(String custId, String password);
	public boolean validateEmployee(String custId, String password);

}
