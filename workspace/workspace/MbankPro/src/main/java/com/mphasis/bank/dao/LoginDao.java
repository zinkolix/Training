package com.mphasis.bank.dao;

import com.mphasis.bank.entity.Customer;
import com.mphasis.bank.entity.Employee;
import com.mphasis.bank.pojo.Login;

public interface LoginDao {
	
	public boolean validateCustomer(Login custLogin);
	public boolean validateEmployee(Login empLogin);

}
