package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.turna.dao.DBAccess;
import com.turna.entity.StockBean;

public class StockDao extends DBAccess {


	public ArrayList<StockBean> selectAll(){
		ArrayList<StockBean> list = new ArrayList<StockBean> ();
	
		String sql = "SELECT * FROM items";
		
		try {
			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			// SQLを発行する
			ResultSet rs = ps.executeQuery();

			// ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				StockBean bean = new StockBean();
				bean.setItem_code(rs.getString("item_code"));
				bean.setItem_name(rs.getString("item_name"));
				bean.setStock(rs.getInt("stock"));
				list.add(bean);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
		
		
		}
	
	//idで検索するメソッド
	public StockBean getItems(String item_code){
		StockBean bean = new StockBean();
		String sql = "select item_code,item_name,stock from items where item_code = ? ";
		
		try {
			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, item_code);
			// SQLを発行する
			ResultSet rs = ps.executeQuery();

			// ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				bean.setItem_code(rs.getString("item_code"));
				bean.setItem_name(rs.getString("item_name"));
				bean.setStock(rs.getInt("stock"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return bean;
		
		
		}

	//アップデート
	public int update(int stock,String item_code) {
		// SQL文を作成する
		String sql = "UPDATE items SET stock = ? where item_code = ?";
		int rs = 0;
		try {

			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1,stock);
			ps.setString(2,item_code);
			// SQLを発行する
			rs = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return rs;
		
	}

	}

