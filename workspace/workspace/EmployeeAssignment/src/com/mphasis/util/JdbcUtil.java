package com.mphasis.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class JdbcUtil {
	private JdbcUtil() {
	}

	public static Connection getConnection() throws SQLException {
		Properties db = new Properties();
	
		
		try {
			db.load(new FileReader("src/oracle.info"));
			Class.forName(db.getProperty("driver"));
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
			
		}
		Connection conn = DriverManager.getConnection(db.getProperty("uri"),db.getProperty("user"),db.getProperty("pass"));
		return conn;
	}

}
