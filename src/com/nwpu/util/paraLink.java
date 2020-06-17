package com.nwpu.util;

/**
 * Copyright (c) 2020,�����������
  * �ļ����ƣ�paraLink.java
  * �ļ���ʶ�����У԰���ֽ���ϵͳ���˵����
  * ժ         Ҫ�����ļ���ɵ���Ҫ������������ݿ������
 * 
  * ��ǰ�汾��1.2
  * ���ߣ���֮��
  * ���ʱ�䣺2020.6.11
 * 
  * ȡ���汾��1.1
  * ԭ���ߣ���֮��
  * ������ڣ�2020.6.4
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
