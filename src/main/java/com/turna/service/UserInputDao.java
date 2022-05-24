package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.turna.dao.DBAccess;

public class UserInputDao extends DBAccess {

	public void input(String account_name, String user_name, String kana, String pass, String sex, String birthday,
			String email, String phone_number, String post_code, String adress, String building, String room_number) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "insert into users(account_name,user_name,kana,pass,sex,birthday,email,phone_number,post_code,adress,building,room_number) value(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1,account_name);
			ps.setString(2,user_name);
			ps.setString(3,kana);
			ps.setString(4,pass);
			ps.setString(5,sex);
			ps.setString(6,birthday);
			ps.setString(7,email);
			ps.setString(8,phone_number);
			ps.setString(9,post_code);
			ps.setString(10,adress);
			ps.setString(11,building);
			ps.setString(12,room_number);
			
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
			
	}

}
