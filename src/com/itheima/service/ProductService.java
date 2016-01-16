package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.daomain.PageBean;
import com.itheima.daomain.Product;
import com.itheima.excepiton.MyException;
import com.itheima.utils.MyUUIDUtils;

public class ProductService {
	/**
	 * 业务层 添加
	 * 处理product的数据给主键和urlm赋值
	 * @param p
	 * @throws MyException 
	 * @throws SQLException 
	 */
	public void add(Product p) throws SQLException, MyException {
		// TODO Auto-generated method stub
		p.setPid(MyUUIDUtils.getUUID());
		p.setImgurl(null);
		ProductDao dao=new ProductDao();
		dao.add(p);
	}

	public List<Product> findall() throws SQLException {
		// TODO Auto-generated method stub
		ProductDao dao=new ProductDao();
		
		return dao.findAll();
	}
/**
 * 业务层 查找 
 * @param pid
 * @return
 * @throws MyException 
 */
	public Product findById(String pid) throws MyException {
		// TODO Auto-generated method stub
		ProductDao dao=new ProductDao();
		
		return dao.findById(pid);
	}

public void update(Product p) throws MyException {
	// TODO Auto-generated method stub
	ProductDao dao=new ProductDao();
	dao.update(p);
}
	/**
	 * 业务层多条件查找方法
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
	ProductDao dao=new ProductDao();
	
	return dao.findbywhere(pid,category,pname,minprice,maxprice);
}
	/**
	 * 业务层分页操作
	 * @param pageCode
	 * @param pageSize
	 * @return
	 */
	/*
	public PageBean findbypage(int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		ProductDao dao=new ProductDao();
		return dao.findbypage(pageCode,pageSize);
	}
	public PageBean findbypage(String category,int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		ProductDao dao=new ProductDao();
		return dao.findbypage(category,pageCode,pageSize);
	}
*/
		/**
		 * 分页查询
		 * @param category 
		 * @param pageCode
		 * @param pageSize
		 * @return 
		 */
				
	public PageBean findbypage(String category, int pageCode, int pageSize) {
		// TODO Auto-generated method stub
		ProductDao dao=new ProductDao();
		 return dao.findbypage(category,pageCode,pageSize);
	}
}










