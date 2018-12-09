package com.market.dao;

import java.util.List;

import com.market.bean.LoginBean;
import com.market.bean.ProductBean;
import com.market.bean.UserBean;


public interface ShoppingDao {

	boolean validate(LoginBean login);
	boolean persist(UserBean user);
	ProductBean getProduct(int code);
	List<ProductBean> getCatalog();
}
