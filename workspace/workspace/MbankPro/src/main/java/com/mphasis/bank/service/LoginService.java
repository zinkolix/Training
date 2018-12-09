package com.mphasis.bank.service;

import com.mphasis.bank.pojo.Login;

public interface LoginService {
	
	public boolean validateCustomer(Login login);
	public boolean validateEmployee(Login login);

}
