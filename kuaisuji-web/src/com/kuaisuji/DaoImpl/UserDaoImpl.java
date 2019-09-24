package com.kuaisuji.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kuaisuji.Dao.UserDao;
import com.kuaisuji.pojo.User;
import com.kuaisuji.utils.JdbcUtils;

public class UserDaoImpl implements UserDao{
	
	@Override
	public User selectUser(String useremail, String userpassword) {
		// TODO 自动生成的方法存根
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user = null;
		try {
			String sql = "select user_id,user_email,user_name,user_password,user_ip from user where user_email=? and user_password=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, useremail);
			pstm.setString(2, userpassword);
			rs = pstm.executeQuery();
			while(rs.next()){
				user = new User(rs.getInt("user_id"),rs.getString("user_email"),rs.getString("user_name"),rs.getString("user_password"),rs.getString("user_ip"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn, pstm,rs);
		}
		return user;	
	}
	@Override
	public int addUser(User user){
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = null;
		int flag = -1;
		String sql = "insert into user(user_email,user_name,user_password,user_ip)values(?,?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getUseremail());
			pstm.setString(2, user.getUsername());
			pstm.setString(3, user.getUserpassword());
			pstm.setString(4, user.getUserip());
			flag = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn, pstm);
		}
		return flag;
	}

	@Override
	public int changeUser(User user) {
		// TODO 自动生成的方法存根
		User old_user = selectUserById(user.getUserid());
		if(user.getUseremail()==null || user.getUseremail()=="" ){
			user.setUseremail(old_user.getUseremail());
		}
		if(user.getUsername()==null || user.getUsername()==""){
			user.setUsername(old_user.getUsername());
		}
		if(user.getUserpassword()==null || user.getUserpassword()==""){
			user.setUserpassword(old_user.getUserpassword());
		}
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = null;
		int flag = 0;
		String sql = "UPDATE user set user_email = ?,user_name=?,user_password=? where user_id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getUseremail());
			pstm.setString(2, user.getUsername());
			pstm.setString(3, user.getUserpassword());
			pstm.setInt(4, user.getUserid());
			flag = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn, pstm);
		}
		return flag;
	}
	
	//实现changeUser的附属方法；
	public User selectUserById(int id) {
		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			String sql = "select user_id,user_email,user_name,user_password,user_ip from user where user_id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while(rs.next()) {
				user = new User(rs.getInt("user_id"),rs.getString("user_email"),rs.getString("user_name"),rs.getString("user_password"),rs.getString("user_id"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn,pstm,rs);
		}
		return user;
	}
	@Override
	public Boolean checkUser(String userEmail) {

		Connection conn = JdbcUtils.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Boolean flag = false;
		try {
			String sql = "select user_id from user where user_email = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,userEmail);
			rs = pstm.executeQuery();
			while(rs.next()){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn, pstm, rs);
		}
		
		return flag;
	}

}
