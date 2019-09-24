package com.kuaisuji.Dao;

import java.util.List;

import com.kuaisuji.pojo.Account;

public interface AccountDao {

	//记一笔
	public int addAccountDao(Account account);
	//获得用户全部账目信息
	public List<Account> getAllAccount(Integer user_id);
	//根据type获取用户的账目信息
	public List<Account> getAllAccountByType(Integer user_id,Integer accountType);
	//根据item获取用户的账目信息
	public List<Account> getAllAccountByItem(Integer user_id,Integer accountItem);
	

}
