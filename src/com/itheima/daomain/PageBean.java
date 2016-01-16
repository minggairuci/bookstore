package com.itheima.daomain;

import java.util.List;

public class PageBean<T> {
	/**
	 * 五龙珠即pagebean的五个属性
	 * 当前页 pageCode 从客户端可以获取
	 * 每页记录数:pageSize  可以设置
	 *  总页数:totalPage 这个应该根据总记录数/每页记录数
	 *  页面显示数据beanList   数据库查询
	 *  总记录数:totalCount  数据库查询
	 * 	 */
	private int pageCode;
	private int pageSize;
	private int totalPage;
	private List<T> beanList;
	private  int totalCount;
	private String url;
	
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PageBean [pageCode=" + pageCode + ", pageSize=" + pageSize
				+ ", totalPage=" + totalPage + ", beanList=" + beanList
				+ ", totalCount=" + totalCount + "]";
	}
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		if(totalCount%pageSize==0){
			return totalCount/pageSize;
		}else{
			return totalCount/pageSize+1;
		}
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList (List<T> beanList) {
		this.beanList = beanList;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
