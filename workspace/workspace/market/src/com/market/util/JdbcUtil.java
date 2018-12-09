package com.market.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.jdbc.driver.OracleDriver;

public final class JdbcUtil {
	private JdbcUtil() {
	}

	public static Connection getConnection() throws SQLException {
//		OracleDriver driver = new OracleDriver();
//		DriverManager.registerDriver(driver);
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		Connection conn = DriverManager.getConnection(url,"xchange","mphasis");
		//Standard for jdbc to create the pool of database 
		
		try {
			Context initContext = new InitialContext();
			// Context to look up in the JNDI
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			// Data source refers to the connection pool
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			// getConnection gives the connection
			Connection conn = ds.getConnection();
			return conn;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
