package com.itheima.service;

import java.sql.SQLException;



import com.itheima.dao.UserDao;

public class UserService {

	public com.itheima.daomain.User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		UserDao dao=new UserDao();
		return  dao.login(username,password);
	}
	
}
