package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.turna.dao.DBAccess;
import com.turna.entity.Item;

public class ItemDao extends DBAccess {

	public ArrayList<Item> getItemDetail( int item_id) {
		System.out.println(item_id);;
		ArrayList<Item> list = new ArrayList<Item>();

		// SQL文を作成する
		String sql = "SELECT * FROM items WHERE item_id = 1";

		try {

			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			// SQLを発行する
			ResultSet rs = ps.executeQuery();
			
			// ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				Item bean = new Item();
					bean.setItem_id(rs.getInt("item_id"));
					bean.setItem_code(rs.getString("item_code"));
					bean.setItem_name(rs.getString("item_name"));
				    bean.setPrice(rs.getInt("price"));
					bean.setDetail(rs.getString("detail"));
				    bean.setStock(rs.getInt("stock"));
				    bean.setImage_path(rs.getString("image_path"));
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