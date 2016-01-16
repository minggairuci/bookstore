package com.itheima.daomain;

public class User {
	 /*`uid` VARCHAR(100),
	  `username` VARCHAR(20) ,
	  `password` VARCHAR(20) ,
	  `gender` VARCHAR(10) ,
	  `email` VARCHAR(50) ,
	  `telephone` VARCHAR(20) ,
	  `introduce` VARCHAR(100),
	  `activeCode` VARCHAR(50) ,
	  `state` INT(11) ,
	  `role` VARCHAR(10) DEFAULT '普通用户',
	  `registTime` TIMESTAMP ,
	  PRIMARY KEY (`uid`)*/
	private String uid;
	private String username;
	private String password;
	private String gender;
	private String eamil;
	private String telephone;
	private String introduce;
	private String activeCode;
	private int state;
	private String role;
	private String registTime;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	
	
	
	
	
}
