package com.naresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.naresh.bean.RequestBean;
import com.naresh.db.DBConnection;

public class ViewPendingRequestsDAO {
	private List<RequestBean> requests = new ArrayList<>();
	
	public List<RequestBean> viewPendingRequets(){
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement("SELECT * FROM REQUESTS_UAMS WHERE STATUS='PENDING'");
			ResultSet rs = select.executeQuery();
			
			while(rs.next()) {
				RequestBean request = new RequestBean();
				request.setRequestId(rs.getInt(1));
				request.setUserId(rs.getInt(2));
				request.setSoftwareId(rs.getInt(3));
				request.setAccessType(rs.getString(4));
				request.setReason(rs.getString(5));
				request.setStatus(rs.getString(6));
				
				requests.add(request);
			}
		}catch(Exception e) {e.printStackTrace();}
		
		return requests;
	}
}
