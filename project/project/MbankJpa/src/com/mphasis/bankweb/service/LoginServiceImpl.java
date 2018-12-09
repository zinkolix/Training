package com.mphasis.bankweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.bankweb.dao.LoginDao;
import com.mphasis.bankweb.dao.LoginDaoImpl;
import com.mphasis.bankweb.entity.Customer;
import com.mphasis.bankweb.entity.Employee;
import com.mphasis.bankweb.pojo.Login;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao dao;

	Login login;

	public Customer validateCustomer(Login login) {
		return dao.validateCustomer(login);
	}

	public Employee validateEmployee(Login login) {

		return dao.validateEmployee(login);

	}

}
