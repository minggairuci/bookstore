package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet程序
 * @author Administrator
 */
public class BaseServlet extends HttpServlet{
	
	private static final long serialVersionUID = 4679517507435048715L;
	
	// 自己重写service方法
	@SuppressWarnings("all")
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 解决中文乱码的问题，解决的是POST中文乱码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// 自己编写
		// 要求用户：想访问哪个方法，传递一个参数
		/**
		 * 1.想访问哪个方法，传递一个method参数	?method=login
		 * 2.xxxServlet中方法的签名是：regist(HttpServletRequest request, HttpServletResponse response)
		 */
		String method = req.getParameter("method");
		// 如果用户忘记传method
		if(method == null){
			throw new RuntimeException("亲，干啥啊，不传method参数！");
		}
		
		// 反射 Class Method（代表方法的对象） 
		// 先获取当前类的Class对象
		Class clazz = this.getClass();
		Method m = null;
		try {
			// 获取方法的对象
			m = clazz.getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("亲，您传入名称为"+method+"方法不存在！");
		}
		
		try {
			// 让login方法执行就OK了，说明具体的方法中抛出异常
			m.invoke(this, req,resp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("亲，方法的内部错误吧！！");
		}
	}
	
}
