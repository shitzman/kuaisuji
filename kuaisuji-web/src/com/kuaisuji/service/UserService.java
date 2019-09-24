package com.kuaisuji.service;

import com.kuaisuji.pojo.User;

public interface UserService {
	
	
	//用户登录
	public User selectUser(String useremail, String userpassword);
	//注册用户操作
	public int addUser(User user);
	//修改用户信息操作
	public int changeUser(User user);
	//查询用户名是否冲突
	public Boolean checkUser(String userEmail);

	
}
