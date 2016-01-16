package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itheima.daomain.User;
import com.itheima.excepiton.MyException;
import com.itheima.service.UserService;

public class UserServlet extends BaseServlet {

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MyException {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			UserService us=new UserService();
			try {
				User existUser=us.login(username,password);
				if(existUser==null){
					request.setAttribute("msg", "用户名或密码错误了");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				else{
				request.getSession().setAttribute("existUser", existUser);
				request.getRequestDispatcher("/index.jsp").forward(request,response);}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MyException("denglu yichang");
				
			}
	}

	
}
