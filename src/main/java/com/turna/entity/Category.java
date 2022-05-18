package com.turna.entity;

/**
 * @author fu.zhirao
 */
public class Category {
	private int cate_id;
	private String cate_name;
	private int cate_parent_id;
	private String create_at;
	private String update_at;

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

	public Category(int cate_id, String cate_name, int cate_parent_id, String create_at, String update_at) {
		super();
		this.cate_id = cate_id;
		this.cate_name = cate_name;
		this.cate_parent_id = cate_parent_id;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public Category(int cate_id, String cate_name, int cate_parent_id) {
		super();
		this.cate_id = cate_id;
		this.cate_name = cate_name;
		this.cate_parent_id = cate_parent_id;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public int getCate_parent_id() {
		return cate_parent_id;
	}

	public void setCate_parent_id(int cate_parent_id) {
		this.cate_parent_id = cate_parent_id;
	}
}
