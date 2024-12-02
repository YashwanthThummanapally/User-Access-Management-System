package com.naresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.naresh.db.DBConnection;

public class FetchEmployeeDAO {
	private String employeeName;
	public String getEmployee(int id) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement("SELECT USERNAME FROM USERS_UAMS WHERE ID=?");
			select.setInt(1, id);
			
			ResultSet rs = select.executeQuery();
			if(rs.next()) {
				employeeName = rs.getString(1);
			}
		}catch(Exception e) {e.printStackTrace();}
		
		return this.employeeName;
	}
}
