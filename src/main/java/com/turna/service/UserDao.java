package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.turna.dao.DBAccess;

public class UserDao extends DBAccess {

		public String checkAdmin(String account_name , String pass) {
			// SQL文を作成する
			String sql = "SELECT * FROM users WHERE account_name = ? and pass = ?";
			String msg = null;
			try {
				// Connectionオブジェクトを取得する
				connect();
				// ステートメントを作成する
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, account_name);
				ps.setString(2, pass);
				// SQLを発行する
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					 msg = "ok";
				}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					disconnect();
				}
				return msg;
			}
}



