package com.itheima.daomain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<String,CartItem> map=new HashMap<String,CartItem>();
	
	//private double total;
	public double getTotal() {
		double t=0;
		for(String key:map.keySet()){
			t=t+map.get(key).getSubtotal();
		}
		return t;
	}
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	
	public void addCart(CartItem cartItem){
		String pid=cartItem.getProduct().getPid();
		if(map.containsKey(pid)){
			CartItem hisItem=map.get(pid);
			hisItem.setbuyNum(cartItem.getbuyNum()+hisItem.getbuyNum());
			
		}else{
			map.put(pid,cartItem);
		}
		
	}

}


