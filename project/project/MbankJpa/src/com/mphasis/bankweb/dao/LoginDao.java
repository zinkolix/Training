package com.mphasis.bankweb.dao;

import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.pojo.Login;

public interface LoginDao {
	
	public Customer validateCustomer(Login custLogin);
	public Employee validateEmployee(Login empLogin);

}
