package com.kuaisuji.DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.kuaisuji.Dao.TypeDao;
import com.kuaisuji.pojo.Type;
import com.kuaisuji.utils.JdbcUtils;

public class TypeDaoImpl implements TypeDao {

	
	@Override
	public Map<Integer, Type> getAllType() {
		// TODO 自动生成的方法存根
		Connection conn = JdbcUtils.getConnection();
		Statement stm = null;
		ResultSet rs = null;
		Map<Integer,Type> typeMap = new HashMap<Integer,Type>();
		try {
			stm = conn.createStatement();
			String sql = "select account_type,account_item,account_item_name,item_img_src from type";
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				int account_item = rs.getInt("account_item");
				Type type = new Type();
				type.setAccount_type(rs.getInt("account_type"));
				type.setAccount_item(account_item);
				type.setAccount_item_name(rs.getString("account_item_name"));
				type.setItem_img_src(rs.getString("item_img_src"));
				typeMap.put(account_item, type);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn, stm,rs);
		}
		return typeMap;
	}

}
