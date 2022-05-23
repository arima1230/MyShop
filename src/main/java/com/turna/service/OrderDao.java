package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.turna.dao.DBAccess;
import com.turna.entity.Order;
import com.turna.entity.User;

public class OrderDao extends DBAccess {

	// ユーザー一覧を取得する
	public ArrayList<Order> getOrderList() {

		ArrayList<Order> list = new ArrayList<Order>();

		// SQL文を作成する
		String sql = "SELECT * FROM orders";

		try {
			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			// SQLを発行する
			ResultSet rs = ps.executeQuery();

			// ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				 Order bean = new Order();
					bean.setOrder_id(rs.getInt("order_id"));
					bean.setUser_id(rs.getInt("user_id"));
					bean.setCart_id(rs.getInt("cart_id"));
					商品名
					価格
					個数
					氏名
					電話番号
					メールアドレス
					住所
				    bean.setPostcode(rs.getString("post_code"));
				    bean.setAdress(rs.getString("adress"));
					bean.setBuilding(rs.getString("building"));
				    bean.setRoomnumber(rs.getString("roomnumber"));
				    bean.setPay_status(rs.getString("pay_status"));
					list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	// オーダーidを取得する ！危険！消すかも
		public Order getOrder(int order_id) {
			Order bean = new Order();
			
			// SQL文を作成する
			String sql = "SELECT * FROM users WHERE order_id = ?";
			
			try {

				// Connectionオブジェクトを取得する
				connect();
				// ステートメントを作成する
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setInt(1, order_id);
				// SQLを発行する
				ResultSet rs = ps.executeQuery();

				// ResultSetからbeanにユーザ情報を設定する
				while (rs.next()) {
					bean.setOrder_id(rs.getInt("order_id"));
					bean.setUser_id(rs.getInt("user_id"));
					bean.setCart_id(rs.getInt("cart_id"));
				    bean.setPostcode(rs.getString("postcode"));
				    bean.setAdress(rs.getString("adress"));
					bean.setBuilding(rs.getString("building"));
				    bean.setRoomnumber(rs.getString("roomnumber"));
				    bean.setPay_status(rs.getString("pay_status"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return bean;
		}
}

