package com.itheima.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.daomain.PageBean;
import com.itheima.daomain.Product;
import com.itheima.excepiton.MyException;
import com.itheima.utils.MyJdbcUtils;

public class ProductDao {
	/**
	 * dao层操作数据库实现 添加商品的方法
	 * @param p
	 * @throws SQLException 
	 * @throws MyException 
	 */
	public void add(Product p) throws SQLException, MyException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(MyJdbcUtils.getDataSource());
		String sql="insert into products values(?,?,?,?,?,?,?)";
		Object[] prams={p.getPid(),p.getPname(),p.getPrice(),p.getCategory(),p.getPnum(),p.getImgurl(),p.getDescription()};
		
		int i=runner.update(sql,prams);
		if(i!=1){
		
				throw new MyException("添加商品失败");
			
		}
	}
	/**
	 * dao层 查询所有商品
	 * @return
	 * @throws MyException 
	 * @throws SQLException 
	 */
	public List<Product> findAll() throws SQLException   {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(MyJdbcUtils.getDataSource());
		String sql="select * from products";
		
		
			return runner.query(sql, new BeanListHandler<Product>(Product.class));
		
	}
	public Product findById(String pid) throws MyException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(MyJdbcUtils.getDataSource());
		String sql="select * from products where pid=?";
		
		try {
			return runner.query(sql, new BeanHandler<Product>(Product.class),pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyException("shuwule");
		}
		
	}
	/**
	 * dao 层实现数据的保存至数据库
	 * @param p
	 * @throws MyException 
	 */
	
	public void update(Product p) throws MyException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(MyJdbcUtils.getDataSource());
		String sql="update products set pname=?,price=? ,pnum=?, category=?,imgurl=?, description=? where pid=?";
		Object[] params={p.getPname(),p.getPrice(),p.getPnum(),p.getCategory(),p.getImgurl(),p.getDescription(),p.getPid()};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MyException("xiugaiyichang");
		}
		
	}
	
	/**
	 * dao 多条件查询商品信息   sql语句的拼写 sql="selece *from products where 1=1 and  "
	 * @param pid
	 * @param category
	 * @param pname
	 * @param minprice
	 * @param maxprice
	 * @return
	 */
	public List<Product> findbywhere(String pid, String category, String pname,
			String minprice, String maxprice) {
		// TODO Auto-generated method stub
		//QueryRunner runner=new QueryRunner(MyJdbcUtils.getDataSource());
		//String sql="select * from products where 1=1 and pid=? and ";
		//真实的sql语句:select *from products where pid=? and categpry=? and pname= ? and minprice>? and maxprice <?
		//还有 万一 条件没被勾选就不需要这个判断条件
		StringBuffer sb=new StringBuffer("select * from products where 1=1 ");
		List<String> list=new ArrayList<String>();
		if(pid!=null&&!pid.trim().isEmpty()){
			sb.append(" and pid like ?");
			list.add("%"+pid+"%");
		}
		if(category!=null&&!category.trim().isEmpty()){
			sb.append(" and category=?");
			list.add(category);
		}
		if(pname!=null&&!pname.trim().isEmpty()){
			sb.append(" and pname=?");
			list.add(pname);
		}
		if(minprice!=null&&!minprice.trim().isEmpty()){
			sb.append(" and price>?");
			list.add(minprice);
		}
		if(maxprice!=null&&!maxprice.trim().isEmpty()){
			sb.append(" and price<?");
			list.add(maxprice);
		}
		String sql=sb.toString();
		System.out.println(sql);
		
		
		QueryRunner runner=new QueryRunner(MyJdbcUtils.getDataSource());
		
		try {
					
			
			List<Product> plist=runner.query(sql, new BeanListHandler<Product>(Product.class),list.toArray());
			System.out.println(plist.size());
			for(Product p:plist){
				System.out.println(p);
			}
			return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("多条件查询异常");
		}
	}
	/**
	 * 业务层:通过数据库获取其他三个参数   即totalPage/totalCount/beanList
	 * 思路:总记录数totalCount:::sql select count(*) from products
	 * totalPage=?
	 * beanList<>
	 * @param category 
	 * @param pageCode
	 * @param pageSize
	 * @return
	 */
	/*
	public PageBean findbypage(int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		PageBean<Product> page=new PageBean<Product>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		//查询总记录数/每页的记录数据/计算总页数(这个不用管吧)
		String tolsql="select count(*) from products";
		String pagesql="select * from products limit ?,?";
		QueryRunner runner=new QueryRunner(MyJdbcUtils.getDataSource());
		try {
			long total =(Long) runner.query(tolsql,new ScalarHandler());
			List<Product> beanList=runner.query(pagesql, new BeanListHandler<Product>(Product.class),(pageCode-1)*pageSize,pageSize );
			int totalCount=(int)(total);
			
			page.setBeanList(beanList);
			page.setTotalCount(totalCount);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}
	/**
	 * 分页查询第二版
	 /*
	public PageBean findbypage(String category,int pageCode, int pageSize) {
			PageBean<Product> page=new PageBean<Product>();
			page.setPageCode(pageCode);
			page.setPageSize(pageSize);
			//查询总记录数
			QueryRunner runner=new QueryRunner(MyJdbcUtils.getDataSource());
			//sql="select count(*)from products where category=?"
			try {
				long totals=(Long) runner.query("select count(*)from products where category=?", new ScalarHandler());
				int totalCount=(int)totals;
				List<Product> beanList=(List<Product>) runner.query("select * from products where catefory=? limit ?,?", new BeanListHandler<Product>(Product.class));
				page.setTotalCount(totalCount);
				page.setBeanList(beanList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw  new RuntimeException(e);
			}
			
		return page;
	}
	*/
	public PageBean findbypage(String category, int pageCode, int pageSize) {
		QueryRunner runner=new QueryRunner(MyJdbcUtils.getDataSource());
		PageBean<Product> page=new PageBean<Product>();
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		String consql=null;
		String lisql=null;
		List<Object> list1=new ArrayList<Object>();
		//查询总记录数的sql
		//选则的是所有商品的查询
		if(category==null){
	         consql="select count(*) from products ";
	
		     lisql="select * from products limit ?,?";}
		else{
			 consql="select count(*) from products where category=?";
			 lisql="select * from products where category =? limit ?,?";
			 list1.add(category);
		}
		///执行语句
		try {
			long spagecount=(Long) runner.query(consql, new ScalarHandler(),list1.toArray());
			int totalCount=(int)spagecount;
			list1.add((pageCode-1)*pageSize);
			list1.add(pageSize);
			List<Product> list=runner.query(lisql,new BeanListHandler<Product>(Product.class),list1.toArray());
			page.setBeanList(list);
			page.setTotalCount(totalCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}
	
}