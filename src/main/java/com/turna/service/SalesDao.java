package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.turna.dao.DBAccess;
import com.turna.entity.SalesBean;


public class SalesDao extends DBAccess {
	
	
	public ArrayList<SalesBean> getDate(String create_at){
		ArrayList<SalesBean> list1 = new ArrayList<SalesBean> ();
	
		String sql = "select * from items where create_at = ? ";
		
		try {
			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, create_at);
			// SQLを発行する
			ResultSet rs = ps.executeQuery();
			
			// ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				SalesBean bean = new SalesBean();
				bean.setItem_code(rs.getString("item_code"));
				bean.setItem_name(rs.getString("item_name"));
				bean.setCategory_name(rs.getString("category_name"));
				bean.setPrice(rs.getInt("price"));
				bean.setNum_of_items(rs.getInt("num_of_items"));
				bean.setSub_total(rs.getInt("sub_total"));
				list1.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list1;
		
		
		}
	
	
	public ArrayList<SalesBean> getTotal(String create_at) {
		ArrayList<SalesBean> list2 = new ArrayList<SalesBean> ();
		String sql = "select * from items where create_at = ? ";
		
		try {
			// Connectionオブジェクトを取得する
			connect();
			// ステートメントを作成する
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, create_at);
			// SQLを発行する
			ResultSet rs = ps.executeQuery();

			// ResultSetからbeanにユーザ情報を設定する
			while (rs.next()) {
				SalesBean bean = new SalesBean();
				bean.setTotal_price(rs.getInt("total_price"));
				list2.add(bean);

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list2;
		
		
		
		
	}

}
