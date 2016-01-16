package com.itheima.utils;

import java.util.UUID;

/**
 * 生成唯一的字符串
 * UUID
 * @author Administrator
 */
public class MyUUIDUtils {
	
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}
	
	/**
	 * 生成唯一的字符串
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}

}
