package com.kuaisuji.test;


import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.kuaisuji.Dao.AccountDao;
import com.kuaisuji.Dao.TypeDao;
import com.kuaisuji.Dao.UserDao;
import com.kuaisuji.DaoImpl.AccountDaoImpl;
import com.kuaisuji.DaoImpl.TypeDaoImpl;
import com.kuaisuji.DaoImpl.UserDaoImpl;
import com.kuaisuji.pojo.Account;
import com.kuaisuji.pojo.Type;
import com.kuaisuji.pojo.User;

public class JdbcUtilsTest {
	UserDao userDao = new UserDaoImpl();
	AccountDao accountDao = new AccountDaoImpl();
	TypeDao typeDao = new TypeDaoImpl();
	
	@Test
	public void chackUserTest(){
		System.out.println(userDao.checkUser("123456@163.com"));
	}
	
	@Test
	public void getAllType() {
		
		Map<Integer,Type> typeMap = typeDao.getAllType();
		
		for(Integer i: typeMap.keySet()) {
			System.out.println(typeMap.get(i).getAccount_item_name());
		}
	}
	
	@Test
	public void getAllAccountTest() {
		List<Account> accountList = accountDao.getAllAccount(1);
		
		for(Account a : accountList) {
			System.out.println(a.getAccount_id()+"|"+a.getAccount_amount());
		}
	}
	

	
	@Test
	public void addAccountTest() {
		Account account = new Account();
		account.setUser_id(1);
		account.setAccount_type(1);
		account.setAccount_item(1);
		account.setAccount_amount("0");
		account.setAccount_date("2000-1-1");
		account.setAccount_remark("addaccountTest");
		int flag = accountDao.addAccountDao(account);
		if(flag>0) {
			System.out.println("addAccountTest�ɹ�");
		}else {
			System.out.println("addAccountTestʧ��");
		}
	}
	
	
	@Test
	public void selectUserTest() {
		String useremail = "123456@163.com";
		String userpassword ="123456";
		User user = userDao.selectUser(useremail, userpassword);
		System.out.println(user);
	}
	@Test
	public void changeUserTest() {
		String useremail = "";
		String userpassword = null;//""��null����ʾ���ı�
		String username = "ʱ";
		User user = new User(1,useremail,username,userpassword);
		int flage = userDao.changeUser(user);
		
		if(flage>0) {
			System.out.println("changeUser���Գɹ�");
		}else {
			System.out.println("changeUser����ʧ��");
		}
		
	}
	@Test
	public void addUserTest() {
		String useremail = "addTest";
		String userpassword = "addTest";
		User user = new User();
		user.setUseremail(useremail);
		user.setUserpassword(userpassword);
		int flag = userDao.addUser(user);
		if(flag>0) {
			System.out.println("ע���û����Գɹ�");
		}else {
			System.out.println("ע���û�����ʧ��");
		}
	}

}
