package com.kuaisuji.serviceImpl;

import com.kuaisuji.Dao.UserDao;
import com.kuaisuji.DaoImpl.UserDaoImpl;
import com.kuaisuji.pojo.User;
import com.kuaisuji.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User selectUser(String useremail, String userpassword) {
		// TODO �Զ����ɵķ������
		return userDao.selectUser(useremail, userpassword);
	}

	@Override
	public int addUser(User user) {
		// TODO �Զ����ɵķ������
		return userDao.addUser(user);
	}

	@Override
	public int changeUser(User user) {
		// TODO �Զ����ɵķ������
		return userDao.changeUser(user);
	}

	@Override
	public Boolean checkUser(String userEmail) {
		// TODO Auto-generated method stub
		return userDao.checkUser(userEmail);
	}

}
