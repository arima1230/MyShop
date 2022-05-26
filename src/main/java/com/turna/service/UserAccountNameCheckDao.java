package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.turna.dao.DBAccess;

public class UserAccountNameCheckDao extends DBAccess {

	public String Check(String account_name) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "select account_name from users where account_name = ?";
		String flag = null;
		ResultSet rs = null;
		
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1,account_name);
			rs = ps.executeQuery();
			while(rs.next()) {
				flag = rs.getString("account_name");
			}
		
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return flag;
	}

}
