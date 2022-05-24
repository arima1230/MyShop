package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.turna.dao.DBAccess;
import com.turna.entity.User;

public class UserDao extends DBAccess {

	// ユーザー一覧を取得する
	public ArrayList<User> getUserList() {

		ArrayList<User> list = new ArrayList<User>();

		// SQL文を作成する
		String sql = "SELECT * FROM users";

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
	// ユーザを取得する ！危険！消すかも
		public String checkAdminr(String account_name , String pass) {
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

	/**
	 * ユーザの追加
	 * 
	 * @param u
	 * @return
	 */
//	public static int insert(User u) {
//		String sql = "insert into users values(?,?,?,?,?,?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?)";
//		Object[] params = { u.getUser_id(), u.getUser_name(),u.getKana(), u.getPass(), u.getPostcode(),
//				u.getAdress(), u.getBuilding(), u.getRoomnumber(),u.getSex(),u.getBirthday(), u.getPhonenumber(),
//				u.getEmail() };
//		return Basedao.exectuIUD(sql, params);
//	}

//	/**
//	 * ユーザ情報の表示
//	 * 
//	 * @return
//	 */
//	public static ArrayList<User> selectAll() {
//		ArrayList<User> list = new ArrayList<User>();
//
//		// 実際の値を取得
//		ResultSet rs = null;
//		// DB接続
//		Connection conn = Basedao.getconn();
//
//		// SQLを設定する
//		PreparedStatement ps = null;
//
//		try {
//			String sql = "select * from users order by user_id";
//			ps = conn.prepareStatement(sql);
//			// SQL文を発行する
//			rs = ps.executeQuery();
////
//			while (rs.next()) {
//				User u = new User(rs.getInt("user_id"), rs.getString("user_name"),rs.getString("kana") ,rs.getString("pass"),
//						rs.getString("postcode"),rs.getString("adress"),rs.getString("building"),rs.getString("roomnumber"),
//						rs.getString("sex"), rs.getString("birthday"), rs.getString("phonenumber"),rs.getString("email") );
//				list.add(u);
//			}
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} finally {
//			Basedao.closeall(rs, ps, conn);
//		}
//
//		return list;
//	}


	/**
	 * 
	 * idによって
	 * 
	 * @param id
	 * @return
	 */
//	public static int selectById(int id) {
//		int count = 0;
//
//		// 実際の値を取得
//		ResultSet rs = null;
//		// DB接続
//		Connection conn = Basedao.getconn();
//
//		// SQLを設定する
//		PreparedStatement ps = null;
//
//		// SQL文を発行する
//		try {
//			String sql = "select count(*) from SHOP_USER where user_id =?";
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
//
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				count = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} finally {
//			Basedao.closeall(rs, ps, conn);
//		}
//
//		return count;
//	}

