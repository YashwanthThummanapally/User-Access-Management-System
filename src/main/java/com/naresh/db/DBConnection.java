package com.naresh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection con;
	
	private DBConnection() {}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(DBInfo.dbUrl, DBInfo.username, DBInfo.password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		return con;
	}
}
