package com.mphasis.bankweb.service;

import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.pojo.Login;

public interface LoginService {
	
	public Customer validateCustomer(Login login);
	public Employee validateEmployee(Login login);

}
