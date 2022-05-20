package com.turna.entity;

/**
 * @author fu.zhirao
 *
 */
public class User {
	private int user_id;
	private String user_name;
	private String pass;
	private String birthday;
	private String email;
	private String phonenumber;
	private String address;
	private String kana;
	

	public User(int user_id, String user_name, String pass,  String birthday,
			 String email, String phonenumber, String address) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.pass = pass;
		this.birthday = birthday;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
	

