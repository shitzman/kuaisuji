package com.kuaisuji.service;

import com.kuaisuji.pojo.User;

public interface UserService {
	
	
	//�û���¼
	public User selectUser(String useremail, String userpassword);
	//ע���û�����
	public int addUser(User user);
	//�޸��û���Ϣ����
	public int changeUser(User user);
	//��ѯ�û����Ƿ��ͻ
	public Boolean checkUser(String userEmail);

	
}
