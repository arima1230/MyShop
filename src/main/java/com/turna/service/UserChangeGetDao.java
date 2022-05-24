package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.turna.dao.DBAccess;

public class UserChangeGetDao extends DBAccess{


		public String get_account_name(String user_id) {
			String sql = "select account_name from users where user_id = ?";
			String account_name = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					account_name = rs.getString("account_name");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return account_name;
		}
		
		public String gget_user_name(String user_id) {
			String sql = "select user_name from users where user_id = ?";
			String account_name = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					account_name = rs.getString("account_name");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return account_name;
		}


}
