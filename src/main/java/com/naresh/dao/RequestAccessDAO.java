package com.naresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.naresh.bean.RequestBean;
import com.naresh.db.DBConnection;

public class RequestAccessDAO {
	private int k;
	public int insertRequestAccess(RequestBean request) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement insert = con.prepareStatement("INSERT INTO REQUESTS_UAMS VALUES(SQ3_UAMS.NEXTVAL,?,?,?,?,?)");
			
			insert.setInt(1, request.getUserId());
			insert.setInt(2, request.getSoftwareId());
			insert.setString(3, request.getAccessType());
			insert.setString(4, request.getReason());
			insert.setString(5, request.getStatus());
			
			k = insert.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}		
		return k;
	}
}
