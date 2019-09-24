package com.kuaisuji.service;

import java.util.Map;

import com.kuaisuji.pojo.Type;

public interface TypeService {

	//获取全部type,以account_item为map的键
	public Map<Integer,Type> getAllType();
}
