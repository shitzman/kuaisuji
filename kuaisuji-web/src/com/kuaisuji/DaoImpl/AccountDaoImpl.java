package com.kuaisuji.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kuaisuji.Dao.AccountDao;
import com.kuaisuji.pojo.Account;
import com.kuaisuji.utils.JdbcUtils;

public class AccountDaoImpl implements AccountDao {

	
	public int addAccountDao(Account account) {
		// TODO 自动生成的方法存根
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = null;
		int flag = -1;
		try {
			String sql = "INSERT INTO accounts (user_id,account_type,account_item,account_amount,account_date,account_remark)"
					+ " VALUES (?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,account.getUser_id());
			pstm.setInt(2, account.getAccount_type());
			pstm.setInt(3, account.getAccount_item());
			pstm.setString(4, account.getAccount_amount());
			pstm.setString(5, account.getAccount_date());
			pstm.setString(6, account.getAccount_remark());
			flag = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn, pstm);
		}
		return flag;
	}

	@Override
	public List<Account> getAllAccount(Integer user_id) {
		
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Account> accountList = new ArrayList<Account>();
		
		try {
			String sql = "select account_id,account_type,account_item,account_amount,account_date,account_remark from accounts where user_id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, user_id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Account account = new Account(rs.getInt("account_id"));
				account.setAccount_type(rs.getInt("account_type"));
				account.setAccount_item(rs.getInt("account_item"));
				account.setAccount_amount(rs.getString("account_amount"));
				account.setAccount_date(rs.getString("account_date"));
				account.setAccount_remark(rs.getString("account_remark"));
				accountList.add(account);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn, pstm, rs);
		}
		
		
		return accountList;
	}

	@Override
	public List<Account> getAllAccountByType(Integer user_id, Integer accountType) {

		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Account> accountListByType = new ArrayList<Account>();
		
		try {
			String sql = "select account_id,account_type,account_item,account_amount,account_date,account_remark from accounts where user_id = ? and account_type = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, user_id);
			pstm.setInt(2, accountType);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Account account = new Account(rs.getInt("account_id"));
				account.setAccount_type(rs.getInt("account_type"));
				account.setAccount_item(rs.getInt("account_item"));
				account.setAccount_amount(rs.getString("account_amount"));
				account.setAccount_date(rs.getString("account_date"));
				account.setAccount_remark(rs.getString("account_remark"));
				accountListByType.add(account);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn, pstm,rs);
		}
		return accountListByType;
	}

	@Override
	public List<Account> getAllAccountByItem(Integer user_id, Integer accountItem) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Account> accountListByItem = new ArrayList<Account>();
		try {
			String sql = "select account_id,account_type,account_item,account_amount,account_date,account_remark from accounts where user_id = ? and account_item = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,user_id);
			pstm.setInt(2, accountItem);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Account account = new Account(rs.getInt("account_id"));
				account.setAccount_type(rs.getInt("account_type"));
				account.setAccount_item(rs.getInt("account_item"));
				account.setAccount_amount(rs.getString("account_amount"));
				account.setAccount_date(rs.getString("account_date"));
				account.setAccount_remark(rs.getString("account_remark"));
				accountListByItem.add(account);
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn, pstm, rs);
		}
		return accountListByItem;
	}

}
