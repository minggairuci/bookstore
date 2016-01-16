package com.itheima.daomain;

public class CartItem {
	private Product product;
	private int buyNum;
	//private Double subTotal;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getbuyNum() {
		return buyNum;
	}

	public void setbuyNum(int buyNum) {
		this.buyNum = buyNum;
	}

	public Double getSubtotal() {
		return product.getPrice()*buyNum;
	}

	
	
}
