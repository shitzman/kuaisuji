package com.kuaisuji.Dao;

import java.util.Map;

import com.kuaisuji.pojo.Type;

public interface TypeDao {
	
	//��ȡȫ��type,��account_itemΪmap�ļ�
	public Map<Integer,Type> getAllType();
}
