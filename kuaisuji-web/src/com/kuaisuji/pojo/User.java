package com.kuaisuji.pojo;

public class User {
	
	private int userid;
	private String useremail;
	private String username;
	private String userpassword;
	private String userip;
	
	public User() {
		super();
	}

	public User(String useremail, String username, String userpassword, String userip) {
		super();
		this.useremail = useremail;
		this.username = username;
		this.userpassword = userpassword;
		this.userip = userip;
	}
	public User(String useremail, String username, String userpassword) {
		super();
		this.useremail = useremail;
		this.username = username;
		this.userpassword = userpassword;
	}
	public User(int userid,String useremail, String username, String userpassword) {
		super();
		this.userid = userid;
		this.useremail = useremail;
		this.username = username;
		this.userpassword = userpassword;
	}
	public User(int userid,String useremail, String username, String userpassword, String userip) {
		super();
		this.userid = userid;
		this.useremail = useremail;
		this.username = username;
		this.userpassword = userpassword;
		this.userip = userip;
	}

	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUserip() {
		return userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}
	
	public int getUserid() {
		return userid;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", useremail=" + useremail + ", username=" + username + ", userpassword="
				+ userpassword + ", userip=" + userip + "]";
	}


	


	
	

}
