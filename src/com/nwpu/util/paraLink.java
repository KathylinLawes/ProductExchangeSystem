package com.nwpu.util;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：paraLink.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件完成的主要功能是完成数据库的连接
 * 
  * 当前版本：1.2
  * 作者：杨之正
  * 完成时间：2020.6.11
 * 
  * 取代版本：1.1
  * 原作者：杨之正
  * 完成日期：2020.6.4
 */

import java.util.*;
import java.io.*;

public class paraLink {
	private static Properties p=new Properties();
	static {
		InputStream is=paraLink.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			
			p.load(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static final String Driver=p.getProperty("driver");
	public static final String URL=p.getProperty("url");
	public static final String USER=p.getProperty("user");
	public static final String PASSWORD=p.getProperty("password");
	
}
