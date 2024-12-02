package com.naresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.naresh.db.DBConnection;

public class PendingRequestsDAO {
	private int k;
	public int updateStatus(int requestId, String status) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement update = con.prepareStatement("UPDATE REQUESTS_UAMS SET STATUS=? WHERE ID=?");
			update.setString(1, status);
			update.setInt(2, requestId);
			k = update.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
