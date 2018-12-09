package com.mphasis.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.pojo.Person;
import com.mphasis.util.JdbcUtil;

public class PersonDaoImpl implements PersonDao {

	@Override
	public boolean addPerson(Person p) {
		String sql = "insert into person values(?,?,?)";
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, p.getName());
			stmt.setInt(2, p.getAge());
			stmt.setString(3, p.getCity());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 	finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Person findPerson(String name) {
		String sql = "select * from person where name ='" + name +"'";
		Connection conn = null;
		Person p = null;
		
		try {
			conn = JdbcUtil.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if(rs.next()){
				p = new Person(rs.getString(1),rs.getInt(2), rs.getString(3));
			}
			return p;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}finally{
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Person> getAll() {
		String sql = "select * from person";
		List<Person> persons = new ArrayList<Person>();
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()){
				persons.add( new Person(rs.getString(1),rs.getInt(2), rs.getString(3)));
			}
			return persons;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
