package com.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.market.bean.LoginBean;
import com.market.bean.ProductBean;
import com.market.bean.UserBean;
import com.market.util.JdbcUtil;

public class ShoppingDaoImpl implements ShoppingDao {

	@Override
	public boolean validate(LoginBean login) {
		String sql = "select * from users where user_id=? and password=?";
		Connection conn = null;

		ResultSet rs;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login.getUserId());
			stmt.setString(2, login.getPassword());
			rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean persist(UserBean user) {
		String sql = "insert into users values (?,?,?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getUserId());
			stmt.setString(3, user.getPassword());
			stmt.setInt(4, user.getAge());
			stmt.setString(5, user.getCity());
			stmt.setString(6, user.getEmail());
			stmt.setString(7, user.getPhone());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public ProductBean getProduct(int code) {

		String sql = "select * from products where code=?";
		Connection conn = null;
		ProductBean product = null;

		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				product = new ProductBean();
				product.setCode(rs.getInt(1));
				product.setDescription(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setImage(rs.getString(4));
				product.setStock(rs.getInt(5));

			}
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<ProductBean> getCatalog() {

		String sql = "select * from products";
		Connection conn = null;
		List<ProductBean> catalog = new ArrayList<ProductBean>();
		try {
			conn = JdbcUtil.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				ProductBean product = new ProductBean();
				product.setCode(rs.getInt(1));
				product.setDescription(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setImage(rs.getString(4));
				product.setStock(rs.getInt(5));
				catalog.add(product);
			}
			return catalog;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
