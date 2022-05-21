package com.turna.entity;
import java.io.Serializable;

public class User implements Serializable {
	
	private int user_id;
	private String user_name;
	private String kana;
	private String pass;
	private String postcode;
	private String adress;
	private String building;
	private String roomnumber;
	private String sex;
	private String birthday;
	private String phonenumber;
	private String email;

	//public User(int user_id, String user_name, String kana, String pass, String postcode, String adress,
			//String building, String roomnumber, String sex, String birthday, String phonenumber, String email) {
		//super();
		
//		this.user_id = user_id;
//		this.user_name = user_name;
//		this.kana = kana;
//		this.pass = pass;
//		this.postcode = postcode;
//		this.adress = adress;
//		this.building = building;
//		this.roomnumber = roomnumber;
//		this.sex = sex;
//		this.birthday = birthday;
//		this.phonenumber = phonenumber;
//		this.email = email;
//	}

	
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

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
