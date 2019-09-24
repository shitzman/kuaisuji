package com.kuaisuji.Dao;

import java.util.List;

import com.kuaisuji.pojo.Account;

public interface AccountDao {

	//��һ��
	public int addAccountDao(Account account);
	//����û�ȫ����Ŀ��Ϣ
	public List<Account> getAllAccount(Integer user_id);
	//����type��ȡ�û�����Ŀ��Ϣ
	public List<Account> getAllAccountByType(Integer user_id,Integer accountType);
	//����item��ȡ�û�����Ŀ��Ϣ
	public List<Account> getAllAccountByItem(Integer user_id,Integer accountItem);
	

}
