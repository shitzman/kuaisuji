package com.kuaisuji.service;

import java.util.List;

import com.kuaisuji.pojo.Account;

public interface AccountService {
	
	//��һ��
	public int addAccount(Account account);
	//����û�ȫ����Ŀ��Ϣ
	public List<Account> getAllAccount(Integer user_id);
	//����type��ȡ�û�����Ŀ��Ϣ
	public List<Account> getAllAccountByType(Integer user_id,Integer accountType);
	//����item��ȡ�û�����Ŀ��Ϣ
	public List<Account> getAllAccountByItem(Integer user_id,Integer accountItem);

}
