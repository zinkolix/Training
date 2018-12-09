package com.market.service;

import java.util.List;

import com.market.bean.LoginBean;
import com.market.bean.ProductBean;
import com.market.bean.UserBean;

public interface ShoppingService {

	boolean authenticate(LoginBean login);
	boolean persist(UserBean user);
	int getAge(String birthdate);
	
	List<ProductBean> getCatalog();
	ProductBean getProduct(int code);
}
