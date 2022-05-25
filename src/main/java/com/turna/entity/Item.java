package com.turna.entity;

public class Item {
	private int item_id;
	private String item_code;
	private String item_name;
	private int price;
	private int category_id;
	private String detail;
	private int stock;
	private String image_path;
	private int delete_flag;

	public Item(int item_id, String item_code, String item_name, int price, int category_id, String detail, int stock,
			String image_path, int deleteflag) {
		super();
		this.item_id = item_id;
		this.item_code = item_code;
		this.item_name = item_name;
		this.price = price;
		this.category_id = category_id;
		this.detail = detail;
		this.stock = stock;
		this.image_path = image_path;
		this.delete_flag = deleteflag;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public int getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(int deleteflag) {
		this.delete_flag = deleteflag;
	}

}

