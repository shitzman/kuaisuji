package com.kuaisuji.serviceImpl;

import java.util.Map;

import com.kuaisuji.Dao.TypeDao;
import com.kuaisuji.DaoImpl.TypeDaoImpl;
import com.kuaisuji.pojo.Type;
import com.kuaisuji.service.TypeService;

public class TypeServiceImpl implements TypeService {
	TypeDao typeDao = new TypeDaoImpl();


	@Override
	public Map<Integer, Type> getAllType() {
		// TODO 自动生成的方法存根
		return typeDao.getAllType();
	}
	

}
