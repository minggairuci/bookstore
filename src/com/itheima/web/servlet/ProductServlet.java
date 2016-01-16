package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.daomain.PageBean;
import com.itheima.daomain.Product;
import com.itheima.excepiton.MyException;
import com.itheima.service.ProductService;

public class ProductServlet extends BaseServlet {
/**
 * 添加商品
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */
	public void addproduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,String[]> map=request.getParameterMap();
		Product p=new Product();
		try {
			BeanUtils.populate(p, map);
			ProductService ps=new ProductService();
			ps.add(p);
			response.sendRedirect(request.getContextPath()+"/addproduct?method=findAll");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/admin/products/add.jsp").forward(request, response);
		} 
		
		
	}
	/**
	 * 显示所有商品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws MyException 
	 */
	
	public void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MyException {
			ProductService ps=new ProductService();
			try {
				List<Product> pList=ps.findall();
				
				request.setAttribute("pList", pList);
				request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new MyException("显示所有商品异常");
			}
			
	
	}
	/**
	 * 修改商品信息,先查后改.根据获取的id值在编辑页面中显示商品的所有信息
	 * @param request
	 * @param response
	 * @throws MyException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	public void intiUpdate(HttpServletRequest request, HttpServletResponse response) throws MyException, ServletException, IOException{
			String pid=request.getParameter("pid");
			//t通过pid去数据库查找该商品
			ProductService ps=new ProductService();
			Product p=ps.findById(pid);
			System.out.println(p);
			request.setAttribute("p",p);
			//request.getRequestDispatcher("/admin/products/edit.jsp").forward(request,response);
			request.getRequestDispatcher("/admin/products/edit.jsp").forward(request,response);
	}
	public void updateproduct(HttpServletRequest request, HttpServletResponse response) {

		
		//修改数据更新到数据库
		
		Map<String,String[]> map=request.getParameterMap();
		Product p=new Product();
		try {
			BeanUtils.populate(p, map);
			ProductService ps=new ProductService();
			ps.update(p);
			response.sendRedirect(request.getContextPath()+"/addproduct?method=findAll");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	/**多条件查询商品,动态的显示到商品列表中
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
		public void findbywhere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			System.out.println("到了吗");
			String pid=request.getParameter("pid");
			String category=request.getParameter("category");
			String pname=request.getParameter("pname");
			String minprice=request.getParameter("minprice");
			String maxprice=request.getParameter("maxprice");
			ProductService ps=new ProductService();
			//Product p=new Product();
			List<Product> pList=ps.findbywhere(pid,category,pname,minprice,maxprice);
			
		 
				//System.out.println(plist.size());
			
			//System.out.println(plist.toString());
			request.setAttribute("pList", pList);
			//System.out.println(plist.toString());
			
		//  request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
			
		}
		/**
		 * 五龙珠 servlet层可以获取2颗 pageCode pageSize传入service层
		 * @param request
		 * @param response
		 * @throws IOException 
		 * @throws ServletException 
		 */
	/*	public void findbypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			int pageCode=this.getpageCode(request);
			int pageSize=4;
			ProductService ps=new ProductService();
			PageBean<Product> pagebean=ps.findbypage(pageCode,pageSize);
			request.setAttribute("pagebean", pagebean);
			request.getRequestDispatcher("/product_list.jsp").forward(request,response);
			
		}
		public int getpageCode(HttpServletRequest request){
			String pc=request.getParameter("pc");
			if(pc==null){
				return 1;
			}else{
				return Integer.parseInt(pc);
			}
		}
		*/
		public void findinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
				String pid=request.getParameter("pid");
				ProductService ps=new ProductService();
				try {
					Product p=ps.findById(pid);
					request.setAttribute("p",p);
					request.getRequestDispatcher("/product_info.jsp").forward(request,response);
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("yochangle ");
				}
				
		}
		/*
		public void findByPage2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			//获取类别根据类别来查询并分页显示/还是分页多了个条件
			String category=request.getParameter("category");
			//分页查询
			if(category==null){
				return;
			}
			int pageCode=this.getpageCode(request);
			int pageSize=4;
			ProductService ps=new ProductService();
			PageBean<Product> pagebean=ps.findbypage(category,pageCode,pageSize);
			request.setAttribute("pagebean", pagebean);
			request.getRequestDispatcher("/product_list.jsp").forward(request,response);
			
		}
		*/
		/**
		 * 重写写一个分页的方法, 因为在写条件分页查询的时候乱乱的感觉没有思路
		 * 
		 */
	/* public void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	int pageCode=this.getCode(request);
		 	int pageSize=4;
		 	ProductService ps=new ProductService();
		 	PageBean pagebean=ps.findbypage(pageCode, pageSize);
		 	request.setAttribute("pagebean", pagebean);
		 	request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		 	

	 }*/
	 public int getCode(HttpServletRequest request){
		 String pc=request.getParameter("pc");
		 if(pc==null){
			 return 1;
		 }else{
			 return Integer.parseInt(pc);
			 
		 }
	 }
	 public void findByPage2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 	//获取类别的参数
		 String category=request.getParameter("category");
		 if(category!=null){
			 category=new String(category.getBytes("ISO8859-1"),"utf-8");
			 
		 }
		 
		 int pageCode=this.getCode(request); 
	
		 	int pageSize=4;
		 	ProductService ps=new ProductService();
		 	PageBean pagebean=ps.findbypage(category,pageCode, pageSize);
		 	pagebean.setUrl(this.getUrl(request));
		 	request.setAttribute("pagebean", pagebean);
		 	request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	 }
	 public String getUrl(HttpServletRequest request){
		 /*分页查询需要的条件
		  * http://localhost:8080/book/
		  * http://localhost:8080/book/addproduct?method=findByPage2&category=%E5%8A%B1%E5%BF%97
		  *///获取路径 后跟pc=2;会累加
		String path1=request.getRequestURI();
		String path2=request.getQueryString();
		String url=path1+"?"+path2;
		if(url.contains("pc=")){
			int index=url.lastIndexOf("pc=");
			url=url.substring(0,index);
		}
		 return url;
	 }

}












