package com.itheima.dao;

import java.sql.SQLException;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.daomain.User;
import com.itheima.utils.MyJdbcUtils;

public class UserDao {

	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(MyJdbcUtils.getDataSource());
		String sql="select * from user where username=? and password =?";
		return runner.query(sql, new BeanHandler<User>(User.class),username,password);
		
		
		
	}

}
