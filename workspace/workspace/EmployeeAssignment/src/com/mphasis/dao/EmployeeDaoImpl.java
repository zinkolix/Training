package com.mphasis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mphasis.pojo.Employee;

import com.mphasis.util.JdbcUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	Scanner scan = new Scanner(System.in);

	@Override
	public boolean addEmployee(Employee e) {
		String sql = "insert into employee(empno,ename,salary,comm) values (?,?,?,?)";
		Connection conn = null;
		
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, e.getEmpNo());
			stmt.setString(2, e.geteName());
			stmt.setDouble(3, e.getSalary());
			stmt.setDouble(4, e.getComm());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}	finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	}

	@Override
	public List<Employee> showAllEmployee() {
		String sql = "select * from employee ";
		List<Employee> employees = new ArrayList<Employee>();
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt(1) + "\t"+rs.getString(2)+  "\t"+ rs.getDouble(3)+  "\t"+ rs.getDouble(4));
//				employees.add( new Employee(rs.getInt(1),rs.getString(2), rs.getDouble(3),rs.getDouble(4)));
			}
			return employees;
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
	

	@Override
	public boolean updateSalary(int empNo) {
		System.out.println("Enter the new salary");
		double sal = scan.nextDouble();
		String upt = "update employee set salary =" + sal + " where empno=" + empNo;
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(upt);
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}			
	}

	@Override
	public boolean deleteEmployee(int empNo) {
		String del = "delete from employee where empno =" + empNo +"";
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(del);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
