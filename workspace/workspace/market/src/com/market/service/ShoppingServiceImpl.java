package com.market.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import com.market.bean.LoginBean;
import com.market.bean.ProductBean;
import com.market.bean.UserBean;
import com.market.dao.ShoppingDao;
import com.market.dao.ShoppingDaoImpl;

public class ShoppingServiceImpl implements ShoppingService {

	private ShoppingDao dao;
	
	public ShoppingServiceImpl() {
		dao = new ShoppingDaoImpl();
	}
	
	@Override
	public boolean authenticate(LoginBean login) {
		if(dao.validate(login))
			return true;
		else
			return false;
	}

	@Override
	public boolean persist(UserBean user) {
		ShoppingDao dao = new ShoppingDaoImpl();
		if(user.getAge() > 18){
			dao.persist(user);
			return true;
		}else
		return false;
	}

	@Override
	public int getAge(String birthdate) {
		String[] dob = birthdate.split("-");
		int yr = Integer.parseInt(dob[0]);
		int mon = Integer.parseInt(dob[1]);
		int dt = Integer.parseInt(dob[2]);
		
		LocalDate birth = LocalDate.of(yr,mon ,dt);
		LocalDate today = LocalDate.now();
		
		Period period = Period.between(birth, today);
		return period.getYears();
	}

	@Override
	public List<ProductBean> getCatalog() {
		
		return dao.getCatalog();
	}

	@Override
	public ProductBean getProduct(int code) {
		
		return dao.getProduct(code);
	}

}
