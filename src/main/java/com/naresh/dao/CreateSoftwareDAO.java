package com.naresh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.naresh.bean.SoftwareBean;
import com.naresh.db.DBConnection;

public class CreateSoftwareDAO {
	private int k;

	public int createSoftware(SoftwareBean software) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement insert = con.prepareStatement("INSERT INTO SOFTWARE_UAMS VALUES(SQ2_UAMS.NEXTVAL,?,?,?)");
			insert.setString(1, software.getSoftwareName());
			insert.setString(2, software.getDescription());
			insert.setString(3, software.getAccessLevels());
			k = insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return k;
	}
}
