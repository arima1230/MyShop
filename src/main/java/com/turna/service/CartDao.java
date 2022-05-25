package com.turna.service;

import java.sql.PreparedStatement;

import com.turna.dao.DBAccess;

public class CartDao extends DBAccess {
	public int createCart() {
		// SQL文を作成する
		String sql = "INSERT INTO carts (user_id) VALUES (1);";
		int count = 0;
		try {
			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			// SQLを発行する
			ps.executeQuery();
			count = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;
	}
}
