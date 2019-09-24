package com.kuaisuji.pojo;

public class Account {
	private int account_id;
	private int user_id;
	private int account_type;
	private int account_item;
	private String account_amount;
	private String account_date;
	private String account_remark;
	public Account() {
		super();
	}
	public Account(int user_id, int account_type, int account_item, String account_amount, String account_date,
			String account_remark) {
		super();
		this.user_id = user_id;
		this.account_type = account_type;
		this.account_item = account_item;
		this.account_amount = account_amount;
		this.account_date = account_date;
		this.account_remark = account_remark;
	}

	public Account(int account_id) {
		super();
		this.account_id = account_id;
	}
	public int getAccount_id() {
		return account_id;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getAccount_type() {
		return account_type;
	}
	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}
	public int getAccount_item() {
		return account_item;
	}
	public void setAccount_item(int account_item) {
		this.account_item = account_item;
	}
	public String getAccount_amount() {
		return account_amount;
	}
	public void setAccount_amount(String account_amount) {
		this.account_amount = account_amount;
	}
	public String getAccount_date() {
		return account_date;
	}
	public void setAccount_date(String account_date) {
		this.account_date = account_date;
	}
	public String getAccount_remark() {
		return account_remark;
	}
	public void setAccount_remark(String account_remark) {
		this.account_remark = account_remark;
	}
	
	
	
	
}
