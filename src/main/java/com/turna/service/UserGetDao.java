package com.turna.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.turna.dao.DBAccess;

public class UserGetDao extends DBAccess{


		public String get_account_name(String user_id) {
			String sql = "select account_name from users where user_id = ?";
			String account_name = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					account_name = rs.getString("account_name");
					System.out.print(account_name);
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return account_name;
		}
		
		public String get_user_name(String user_id) {
			String sql = "select user_name from users where user_id = ?";
			String user_name = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					user_name = rs.getString("user_name");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return user_name;
		}
		
		public String get_kana(String user_id) {
			String sql = "select kana from users where user_id = ?";
			String kana = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					kana = rs.getString("kana");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return kana;
		}

		public String get_pass(String user_id) {
			String sql = "select pass from users where user_id = ?";
			String pass = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					pass = rs.getString("pass");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return pass;
		}
		
		public String get_sex(String user_id) {
			String sql = "select sex from users where user_id = ?";
			String sex = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					sex = rs.getString("sex");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return sex;
		}
		
		public String get_birthday(String user_id) {
			String sql = "select birthday from users where user_id = ?";
			String birthday = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					birthday = rs.getString("birthday");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return birthday;
		}
		
		public String get_email(String user_id) {
			String sql = "select email from users where user_id = ?";
			String email = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					email = rs.getString("email");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return email;
		}
		
		public String get_phone_number(String user_id) {
			String sql = "select phone_number from users where user_id = ?";
			String phone_number = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					phone_number = rs.getString("phone_number");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return phone_number;
		}
		
		public String get_post_code(String user_id) {
			String sql = "select post_code from users where user_id = ?";
			String post_code = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					post_code = rs.getString("post_code");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return post_code;
		}
		
		public String get_adress(String user_id) {
			String sql = "select adress from users where user_id = ?";
			String adress = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					adress = rs.getString("adress");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return adress;
		}
		
		public String get_building(String user_id) {
			String sql = "select building from users where user_id = ?";
			String building = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					building = rs.getString("building");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return building;
		}
		
		public String get_room_number(String user_id) {
			String sql = "select room_number from users where user_id = ?";
			String room_number = null;
			ResultSet rs = null;
			
			try {
				connect();
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					room_number = rs.getString("room_number");
				}
			
			}catch (SQLException e){
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return room_number;
		}
}
