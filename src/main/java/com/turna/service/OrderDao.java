package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.turna.dao.DBAccess;
import com.turna.entity.Order;

public class OrderDao extends DBAccess {

	// ユーザー一覧を取得する
	public ArrayList<Order> getOrderList() {

		ArrayList<Order> list = new ArrayList<Order>();

		// SQL文を作成する
		String sql = "SELECT * FROM orders LEFT OUTER JOIN deliveries ON orders.order_id = deliveries.order_id";

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
				bean.setPostcode(rs.getString("post_code"));
				bean.setAdress(rs.getString("adress"));
				bean.setBuilding(rs.getString("building"));
				bean.setRoomnumber(rs.getString("room_number"));
				bean.setPay_status(rs.getString("pay_status"));
				bean.setCreate_at(rs.getString("create_at"));
				bean.setDeli_status(rs.getString("deli_status"));
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
	public Order getOrder(String select) {
		Order bean = new Order();

		// SQL文を作成する
		String sql = "SELECT * FROM orders WHERE order_id = ?";

		try {

			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, select);
			// SQLを発行する
			ResultSet rs = ps.executeQuery();

			// ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				bean.setOrder_id(rs.getInt("order_id"));
				bean.setUser_id(rs.getInt("user_id"));
				bean.setCart_id(rs.getInt("cart_id"));
				bean.setPostcode(rs.getString("post_code"));
				bean.setAdress(rs.getString("adress"));
				bean.setBuilding(rs.getString("building"));
				bean.setRoomnumber(rs.getString("room_number"));
				bean.setPay_status(rs.getString("pay_status"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return bean;
	}

	// creat_atを取得する
	public Order getDay(String string) {
		Order bean = new Order();

		// SQL文を作成する
		String sql = "SELECT * FROM orders WHERE create_at LIKE =?&";

		try {

			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, string);
			// SQLを発行する
			ResultSet rs = ps.executeQuery();

			// ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				bean.setOrder_id(rs.getInt("order_id"));
				bean.setUser_id(rs.getInt("user_id"));
				bean.setCart_id(rs.getInt("cart_id"));
				bean.setPostcode(rs.getString("post_code"));
				bean.setAdress(rs.getString("adress"));
				bean.setBuilding(rs.getString("building"));
				bean.setRoomnumber(rs.getString("room_number"));
				bean.setPay_status(rs.getString("pay_status"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return bean;
	}

	// オーダー情報を更新する
	public void update(String deli_status, String pay_status) {

		// SQL文を作成するSELECT テーブル 1.カラム名,テーブル 2.カラム名, …
		String id_table = "deliveries LEFT(RIGHT) JOIN orders ON deliveries.user_id = orders.user_id;";
		String sql = "UPDATE id_tbl SET  , deli_status=? ,pay_status= ? ,WHERE user_id = ?";

		try {

			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);

			ps.setString(1, deli_status);
			ps.setString(2, pay_status);
			// SQLを発行する
			int rs = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}
}
