package com.turna.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.turna.dao.Basedao;
import com.turna.entity.Item;

public class ItemDao {
	/**
	 * 全部カテゴリを取得
	 * 
	 * @return
	 */
	public static ArrayList<Item> selectAll() {
		ArrayList<Item> list = new ArrayList<Item>();

		// 実際の値を取得
		ResultSet rs = null;
		// DB接続
		Connection conn = Basedao.getconn();
		// SQLを設定する
		PreparedStatement ps = null;
		try {
			String sql = "select * from items";
			ps = conn.prepareStatement(sql);
			// SQL文を発行する
			rs = ps.executeQuery();
			while (rs.next()) {
				Item item = new Item(rs.getInt("item_id"), rs.getString("item_code"), rs.getString("item_name"),
						rs.getInt("price"), rs.getInt("category_id"), rs.getString("detail"), rs.getInt("stock"),
						rs.getString("image_path"), rs.getInt("delete_flag"));
				list.add(item);
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
	 * 追加
	 * 
	 * @param item
	 * @return
	 */
	public static int insert(Item item) {
		String sql = "insert into items(item_id,item_code,item_name,price,category_id,detail,stock,image_path,deleteflag) values(null,?,?,?,?,?,?,?,?)";
		Object[] params = { item.getItem_code(), item.getItem_name(), item.getPrice(), item.getCategory_id(),
				item.getDetail(), item.getStock(), item.getImage_path(), item.getDelete_flag() };
		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * idによりDBから探す
	 * 
	 * @param id
	 * @return
	 */
	public static Item selectById(int id) {
		Item item = null;

		// 実際の値を取得
		ResultSet rs = null;
		// DB接続
		Connection conn = Basedao.getconn();
		// SQLを設定する
		PreparedStatement ps = null;
		try {
			String sql = "select * from items where item_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			// SQL文を発行する
			rs = ps.executeQuery();
			while (rs.next()) {
				item = new Item(rs.getInt("item_id"), rs.getString("item_code"), rs.getString("item_name"),
						rs.getInt("price"), rs.getInt("category_id"), rs.getString("detail"), rs.getInt("stock"),
						rs.getString("image_path"), rs.getInt("delete_flag"));
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return item;
	}

	/**
	 * 商品の編集
	 * 
	 * @param it
	 * @return
	 */
	public static int update(Item it) {
		String sql = "update items set item_code=?,item_name=?,price=?,category_id=?,detail=?,stock=?,image_path=?,deleteflag=? where item_id =?";
		Object[] params = { it.getItem_code(), it.getItem_name(), it.getPrice(), it.getCategory_id(), it.getDetail(),
				it.getStock(), it.getImage_path(), it.getDelete_flag(), it.getItem_id() };
		return Basedao.exectuIUD(sql, params);
	}

	/**
	 * 商品の削除
	 * 
	 * @param id
	 * @return
	 */
	public static int del(Item it) {
		String sql = "update items set delete_flag = '1' WHERE item_code =? and item_name=?";
		Object[] params = { it.getItem_code(), it.getItem_name() };
		return Basedao.exectuIUD(sql, params);
	}
}

