package com.kuaisuji.serviceImpl;

import java.util.List;

import com.kuaisuji.Dao.AccountDao;
import com.kuaisuji.DaoImpl.AccountDaoImpl;
import com.kuaisuji.pojo.Account;
import com.kuaisuji.service.AccountService;

public class AccountServiceImpl implements AccountService{

	AccountDao accountDao = new AccountDaoImpl();
	@Override
	public int addAccount(Account account) {

		return accountDao.addAccountDao(account);
	}
	@Override
	public List<Account> getAllAccount(Integer user_id) {
		// TODO �Զ����ɵķ������
		return accountDao.getAllAccount(user_id);
	}
	@Override
	public List<Account> getAllAccountByType(Integer user_id, Integer accountType) {
		// TODO �Զ����ɵķ������
		return accountDao.getAllAccountByType(user_id, accountType);
	}
	@Override
	public List<Account> getAllAccountByItem(Integer user_id, Integer accountItem) {
		// TODO �Զ����ɵķ������
		return accountDao.getAllAccountByItem(user_id, accountItem);
	}
	
}
