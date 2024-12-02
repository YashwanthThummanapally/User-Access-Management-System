package com.naresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.naresh.bean.UserBean;
import com.naresh.db.DBConnection;

public class LoginDAO {
	private UserBean user;
	
	public UserBean login(String username, String password) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement("SELECT * FROM USERS_UAMS WHERE USERNAME=? AND PASSWORD=?");
			
			select.setString(1, username);
			select.setString(2, password);
			ResultSet rs = select.executeQuery();
			
			if(rs.next()) {
				user = new UserBean();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
			}
		} catch (SQLException e) { e.printStackTrace(); }
		
		return user;
	}
}
