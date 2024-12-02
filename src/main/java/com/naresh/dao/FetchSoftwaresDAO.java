package com.naresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naresh.bean.SoftwareBean;
import com.naresh.db.DBConnection;

public class FetchSoftwaresDAO {
	private List<SoftwareBean> softwares = new ArrayList<>();
	public List<SoftwareBean> selectAllSoftware(){
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement select = con.prepareStatement("SELECT * FROM SOFTWARE_UAMS");
			ResultSet rs = select.executeQuery();
			
			while(rs.next()) {
				SoftwareBean software = new SoftwareBean();
				software.setSoftwareId(rs.getInt(1));
				software.setSoftwareName(rs.getString(2));
				software.setDescription(rs.getString(3));
				software.setAccessLevels(rs.getString(4));
				
				softwares.add(software);
			}
		} catch (SQLException e) { e.printStackTrace();	}
		
		return softwares;
	}
}
