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
				Category cate = new Category(rs.getInt("category_id"), rs.getString("category_name"),
						rs.getInt("category_parents_id"));
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
		String sql = "insert into categories(category_id,category_name,category_parents_id) values(null,?,?)";
		Object[] params = { cate.getCategory_name(), cate.getCategory_parents_id() };
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

		String sql = "select * from categories where category_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				cate = new Category(rs.getInt("category_id"), rs.getString("category_name"),
						rs.getInt("category_parents_id"));
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
		String sql = "update categories set category_name=?,category_parents_id=? where category_id =?";
		Object[] params = { cate.getCategory_name(), cate.getCategory_parents_id(), cate.getCategory_id() };
		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * カテゴリの削除
	 * 
	 * @param id
	 * @return
	 */
	public static int del(int id) {
		String sql = "delete from categories where  category_id =?";
		Object[] params = { id };
		return Basedao.exectuIUD(sql, params);
	}
	/**
	 * 
	 * カテゴリを検索：親分類と子分類
	 * 
	 * @param flag
	 * @return
	 */

	public static ArrayList<Category> selectCat(String flag) {
		ArrayList<Category> list = new ArrayList<Category>();
		// 実際の値を取得
		ResultSet rs = null;
		// DB接続
		Connection conn = Basedao.getconn();

		PreparedStatement ps = null;
		try {
			String sql = null;
			if (flag != null && flag.equals("father")) {
				sql = "select * from categories where category_parents_id=0";
			} else {
				sql = "select * from categories where category_parents_id!=0";
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Category cate = new Category(rs.getInt("category_id"), rs.getString("category_name"),
						rs.getInt("category_parents_id"));
				list.add(cate);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}

		return list;
	}
}
