package com.turna.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.turna.dao.Basedao;
import com.turna.entity.Category;

/**
 * @author fu.zhirao
 */
public class CategoryDao {
	/**
	 * 全部カテゴリを取得
	 * 
	 * @return
	 */
	public static ArrayList<Category> selectAll() {
		ArrayList<Category> list = new ArrayList<Category>();

		// 実際の値を取得
		ResultSet rs = null;
		// DB接続
		Connection conn = Basedao.getconn();
		// SQLを設定する
		PreparedStatement ps = null;
		try {
			String sql = "select * from categories";
			ps = conn.prepareStatement(sql);
			// SQL文を発行する
			rs = ps.executeQuery();
			while (rs.next()) {
				Category cate = new Category(rs.getInt("cate_id"), rs.getString("cate_name"),
						rs.getInt("cate_parent_id"));
				list.add(cate);
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
	 * カテゴリ追加
	 * 
	 * @param cate
	 * @return
	 */
	public static int insert(Category cate) {
		String sql = "insert into categories values(null,?,?,null,null)";
		Object[] params = { cate.getCate_name(), cate.getCate_parent_id() };
		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * idによってカテゴリを取得
	 * 
	 * @param id
	 * @return
	 */
	public static Category selectById(int id) {
		Category cate = null;
		// 実際の値を取得
		ResultSet rs = null;
		// DB接続
		Connection conn = Basedao.getconn();
		// SQLを設定する
		PreparedStatement ps = null;

		String sql = "select * from categories where cate_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				cate = new Category(rs.getInt("cate_id"), rs.getString("cate_name"), rs.getInt("cate_parent_id"), null,
						null);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return cate;
	}

	/**
	 * カテゴリの変更
	 * 
	 * @param cate
	 * @return
	 */
	public static int update(Category cate) {
		String sql = "update categories set cate_name=?,cate_parent_id=? where cate_id =?";
		Object[] params = { cate.getCate_name(), cate.getCate_parent_id(), cate.getCate_id() };
		return Basedao.exectuIUD(sql, params);
	}

}
