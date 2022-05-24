package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.turna.dao.DBAccess;
import com.turna.entity.Item;
import com.turna.entity.User;

public class ItemDao extends DBAccess {

	public ArrayList<Item> getItemDetail() {

		ArrayList<Item> list = new ArrayList<Item>();

		// SQL文を作成する
		String sql = "SELECT * FROM items WHERE id = ";

		try {

			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			// SQLを発行する
			ResultSet rs = ps.executeQuery();

			// ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				User bean = new User();
					bean.setUser_id(rs.getInt("user_id"));
					bean.setUser_name(rs.getString("user_name"));
					bean.setKana(rs.getString("kana"));
				    bean.setPostcode(rs.getString("post_code"));
				    bean.setAdress(rs.getString("adress"));
					bean.setBuilding(rs.getString("building"));
				    bean.setRoomnumber(rs.getString("room_number"));
				    bean.setPhonenumber(rs.getString("phone_number"));
					bean.setEmail(rs.getString("email"));
					list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
