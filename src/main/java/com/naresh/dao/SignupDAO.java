package com.naresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.naresh.bean.UserBean;
import com.naresh.db.DBConnection;

public class SignupDAO {
	private int k;
	
	public int register(UserBean employee) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement insert = con.prepareStatement("INSERT INTO USERS_UAMS VALUES(SQ1_UAMS.NEXTVAL,?,?,?)");

			insert.setString(1, employee.getUsername());
			insert.setString(2, employee.getPassword());
			insert.setString(3, employee.getRole());
			
			k = insert.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
