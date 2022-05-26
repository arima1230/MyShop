package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.turna.dao.DBAccess;

public class UserEditDao extends DBAccess {

	public void Edit(String account_name, String user_name, String kana, String pass, String sex, String birthday,
			String email, String phone_number, String post_code, String adress, String building, String room_number, String user_id) {
		
		String sql = "update users set account_name = '?' ,user_name = '?',kana = '?',sex = '?',pass = '?',post_code = '?',adress = '?',building = '?',room_number = '?',birthday = '?',phone_number = '?',email = '?' where user_id = ?";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1,account_name);//
			ps.setString(2,user_name);//
			ps.setString(3,kana);//
			ps.setString(4,sex);//
			ps.setString(5,pass);//
			ps.setString(6,post_code);//
			ps.setString(7,adress);//
			ps.setString(8,building);//
			ps.setString(9,room_number);//
			ps.setString(10,birthday);//
			ps.setString(11,phone_number);
			ps.setString(12,email);
			ps.setString(13,user_id);
			
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
			
	}

	public void Editaccount_name(String account_name, String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "update users set account_name = ? where user_id = ?";
		
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1,account_name);
			ps.setString(2,user_id);
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}

	public void Edituser_name(String user_name, String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "update users set user_name = ? where user_id = ?";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1,user_name);
			ps.setString(2,user_id);
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}

	public void Editkana(String kana, String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "update users set kana = ? where user_id = ?";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1,kana);
			ps.setString(2,user_id);
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}

	public void Editpass(String pass, String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "update users set pass = ? where user_id = ?";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1,pass);
			ps.setString(2,user_id);
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		
	}

	public void Editsex(String sex, String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "update users set sex = ? where user_id = ?";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1,sex);
			ps.setString(2,user_id);
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		
	}

	public void Editbirthday(String birthday, String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "update users set birthday = ? where user_id = ?";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1,birthday);
			ps.setString(2,user_id);
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

	public void Editemail(String email, String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "update users set email = ? where user_id = ?";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1,email);
			ps.setString(2,user_id);
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}

	public void Editphone_number(String phone_number, String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "update users set phone_number = ? where user_id = ?";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1,phone_number);
			ps.setString(2,user_id);
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}

	public void Editpost_code(String post_code, String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "update users set post_code = ? where user_id = ?";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1,post_code);
			ps.setString(2,user_id);
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}

	}

	public void Editadress(String adress, String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "update users set adress = ? where user_id = ?";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1,adress);
			ps.setString(2,user_id);
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

	public void Editbuilding(String building, String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "update users set building = ? where user_id = ?";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1,building);
			ps.setString(2,user_id);
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

	public void Editroom_number(String room_number, String user_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "update users set room_number = ? where user_id = ?";
		try {
			connect();
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1,room_number);
			ps.setString(2,user_id);
			int rs= ps.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			disconnect();
		}

		
	}
}


