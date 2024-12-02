package com.naresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.naresh.db.DBConnection;

public class FetchSoftwareDAO {
	private int softwareId;
	private String softwareName;
	public int getSoftwareId(String softwareName) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement("SELECT ID FROM SOFTWARE_UAMS WHERE NAME=?");
			select.setString(1, softwareName);
			ResultSet rs = select.executeQuery();
			if(rs.next()) {
				softwareId = rs.getInt(1);
			}
		}catch(Exception e) {e.printStackTrace();} 
		return softwareId;
	}
	
	public String getSoftwareName(int id) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement("SELECT NAME FROM SOFTWARE_UAMS WHERE ID=?");
			select.setInt(1, id);
			ResultSet rs = select.executeQuery();
			if(rs.next()) {
				softwareName = rs.getString(1);
			}
		}catch(Exception e) {e.printStackTrace();}
		
		return this.softwareName;
	}
}
