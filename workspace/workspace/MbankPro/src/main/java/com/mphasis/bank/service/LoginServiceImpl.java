package com.mphasis.bank.service;

import com.mphasis.bank.dao.LoginDao;
import com.mphasis.bank.dao.LoginDaoImpl;
import com.mphasis.bank.pojo.Login;

public class LoginServiceImpl implements LoginService {

	LoginDao dao;
	Login login;
	public LoginServiceImpl() {
		dao = new LoginDaoImpl();
	}

	public boolean validateCustomer(Login login) {
		if (dao.validateCustomer(login))
			return true;
		else

			return false;
	}

	public boolean validateEmployee(Login login) {
		if (dao.validateEmployee(login))
			return true;
		else

			return false;
	}

}
