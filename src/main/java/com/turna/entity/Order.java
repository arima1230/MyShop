package com.turna.entity;
/**
 * @author 中内
 */
public class Order {
		private int order_id;
		private int user_id;
		private int cart_id;
		private String post_code;
		private String adress;
		private String building;
		private String room_number;
		private String pay_status;
		private String deli_status;
		private String create_at;
		private String update_at;

		
		public int getOrder_id() {
			return order_id;
		}
		public void setOrder_id(int order_id) {
			this.order_id = order_id;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public int getCart_id() {
			return cart_id;
		}
		public void setCart_id(int cart_id) {
			this.cart_id = cart_id;
		}
		public String getPostcode() {
			return post_code;
		}
		public void setPostcode(String postcode) {
			this.post_code = postcode;
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
			return room_number;
		}
		public void setRoomnumber(String roomnumber) {
			this.room_number = roomnumber;
		}
		public String getPay_status() {
			return pay_status;
		}
		public void setPay_status(String pay_status) {
			this.pay_status = pay_status;
		}
		public String getCreate_at() {
			return create_at;
		}
		public void setCreate_at(String create_at) {
			this.create_at = create_at;
		}
		public String getUpdate_at() {
			return update_at;
		}
		public void setUpdate_at(String update_at) {
			this.update_at = update_at;
		}
		public String getDeli_status() {
			return deli_status;
		}
		public void setDeli_status(String deli_status) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

			}
		