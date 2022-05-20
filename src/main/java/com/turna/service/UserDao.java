package com.turna.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.turna.dao.Basedao;
import com.turna.entity.User;

public class UserDao {

	/**
	 * ユーザの追加
	 * 
	 * @param u
	 * @return
	 */
	public static int insert(User u) {
		String sql = "insert into users values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
		Object[] params = { u.getUser_id(), u.getUser_name(), u.getPass(), u.getSex(),
				u.getUser_birthday(),  u.getUser_email(), u.getUser_phone(),
				u.getUser_address() };
		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * ユーザ情報の表示
	 * 
	 * @return
	 */
	public static ArrayList<User> selectAll() {
		ArrayList<User> list = new ArrayList<User>();

		// 実際の値を取得
		ResultSet rs = null;
		// DB接続
		Connection conn = Basedao.getconn();

		// SQLを設定する
		PreparedStatement ps = null;

		try {
			String sql = "select * from users order by birthday";
			ps = conn.prepareStatement(sql);
			// SQL文を発行する
			rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User(rs.getString("user_id"), rs.getString("user_name"), rs.getString("pass"),
						rs.getString("sex"), rs.getString("birthday"), rs.getString("user_idenity_code"),
						rs.getString("email"), rs.getString("phonenumber"), rs.getString("address"),
						rs.getInt("user_status"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}

	/**
	 * 
	 * idによって
	 * 
	 * @param id
	 * @return
	 */
	public static int selectById(String id) {
		int count = 0;

		// 実際の値を取得
		ResultSet rs = null;
		// DB接続
		Connection conn = Basedao.getconn();

		// SQLを設定する
		PreparedStatement ps = null;

		// SQL文を発行する
		try {
			String sql = "select count(*) from SHOP_USER where user_id =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return count;
	}
}
