package com.itheima.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.daomain.Cart;
import com.itheima.daomain.CartItem;
import com.itheima.daomain.Product;
import com.itheima.excepiton.MyException;
import com.itheima.service.ProductService;

public class CartServlet extends BaseServlet {

	public void addtocart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MyException {
			/**
			 * 通过pid获取购物车--购物项---商品分析 购物车中有 多个购物项和合计  合计为所有小计的和;
			 * 即map<String,CartItem>   购物项中有商品信息(product) 小计 数量*价格
			 * 获取了但是有错误 搁置
			 */
		String pid=request.getParameter("pid");
		ProductService ps=new ProductService();
		
			Product p=ps.findById(pid);
			CartItem cartItem=new CartItem();
			cartItem.setbuyNum(1);
			cartItem.setProduct(p);
			//购物项 准备好数据, 向购物车里添加购物项
			Cart cart=this.addCart(request);
			//Map<String,Cart> map=new HashMap<String,Cart>();
			cart.addCart(cartItem);
			//System.out.println(cart==null);
			response.sendRedirect(request.getContextPath()+"/cart.jsp");
		//	response.sendRedirect(request.getContextPath()+"/cart.jsp");
		} 
			

	public Cart addCart(HttpServletRequest request){
		HttpSession session=request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		if(cart==null){
			cart=new Cart();
			request.getSession().setAttribute("cart",cart);
		}
		return cart;
		
	}	public void remove(HttpServletRequest request, HttpServletResponse response) throws MyException, IOException{
			//通过jsp传递获取pid
		   	String pid=request.getParameter("pid");
	    	//从session中获取购物车
		   HttpSession session= request.getSession();
		   Cart cart=(Cart) session.getAttribute("cart");
		   //pid key,cartItem是value .通过map集合通过key删除value
		   cart.getMap().remove(pid);
		   //转发回购物页面
		   response.sendRedirect(request.getContextPath()+"/cart.jsp");
		    
	}public void addCount(HttpServletRequest request, HttpServletResponse response) throws IOException{
	 	//通过jsp 接收 参数 pid/count
		System.out.println("zhixingle me ");
		
		String pid=request.getParameter("pid");
	 	String scount=request.getParameter("count");
	 	//从session中获取购物车
	 	int count =Integer.parseInt(scount);
	 	  HttpSession session= request.getSession();
	      Cart cart=(Cart) session.getAttribute("cart");
	  
	    CartItem cartItem=cart.getMap().get(pid);	 
	    if(count>cartItem.getProduct().getPnum()){
	    	 response.sendRedirect(request.getContextPath()+"/cart.jsp");
	    	 return;
	    }else{
	    cartItem.setbuyNum(count);
	     //不需要:一直在session中放着呢
	   //  request.getSession().setAttribute("cart",cart);
	     response.sendRedirect(request.getContextPath()+"/cart.jsp");
	    }
	}public void cutCount(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String pid=request.getParameter("pid");
	 	String scount=request.getParameter("count");
	    int count =Integer.parseInt(scount);
	    HttpSession session=request.getSession();
	    Cart cart=(Cart) session.getAttribute("cart");
	    CartItem cartItem=cart.getMap().get(pid);
	    if(count==0){
	    	//response.sendRedirect(request.getContextPath()+"cart?method=remove&pid="+pid);
	    	cart.getMap().remove(pid);
	    	 response.sendRedirect(request.getContextPath()+"/cart.jsp");
	    }else{
	    	cartItem.setbuyNum(count);
	    	 response.sendRedirect(request.getContextPath()+"/cart.jsp");
	    }
	    
		
	}
}
