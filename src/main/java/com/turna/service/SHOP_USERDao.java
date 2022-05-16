package com.turna.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.turna.dao.Basedao;
import com.turna.entity.SHOP_USER;

public class SHOP_USERDao {

	/*
	 * ユーザの追加
	 * 
	 * @param u
	 * 
	 * @return
	 */
	public static int insert(SHOP_USER u) {
		String sql = "insert into SHOP_USER values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
		Object[] params = { u.getUser_id(), u.getUser_name(), u.getUser_password(), u.getUser_sex(),
				u.getUser_birthday(), u.getUser_idenity_code(), u.getUser_email(), u.getUser_phone(),
				u.getUser_address(), u.getUser_status() };
		return Basedao.exectuIUD(sql, params);
	}

	/*
	 * ユーザ情報の表示
	 * 
	 * @param u
	 * 
	 * @return
	 */
	public static ArrayList<SHOP_USER> selectAll() {
		ArrayList<SHOP_USER> list = new ArrayList<SHOP_USER>();

		// 実際の値を取得
		ResultSet rs = null;
		// DB接続
		Connection conn = Basedao.getconn();

		// SQLを設定する
		PreparedStatement ps = null;

		try {
			String sql = "select * from SHOP_USER order by user_birthday";
			ps = conn.prepareStatement(sql);
			// SQL文を発行する
			rs = ps.executeQuery();

			while (rs.next()) {
				SHOP_USER u = new SHOP_USER(rs.getString("user_id"), rs.getString("user_name"),
						rs.getString("user_password"), rs.getString("user_sex"), rs.getString("user_birthday"),
						rs.getString("user_idenity_code"), rs.getString("user_email"), rs.getString("user_phone"),
						rs.getString("user_address"), rs.getInt("user_status"));
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
		}finally {
			Basedao.closeall(rs, ps, conn);
		}

		return count;
	}
}
