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

}
