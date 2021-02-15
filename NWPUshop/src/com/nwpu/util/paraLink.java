package com.nwpu.util;

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
