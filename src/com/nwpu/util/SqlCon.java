package com.nwpu.util;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：SqlCon.java
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

import java.sql.*;

public class SqlCon {
	static {
		try {
			Class.forName(paraLink.Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(paraLink.URL,paraLink.USER,paraLink.PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Object...objects) {
		if(objects!=null&&objects.length>0) {
			try {
				for(Object obj:objects) {
					if(obj instanceof Connection) {
						((Connection)obj).close();
					}
					if(obj instanceof Statement) {
						((Statement)obj).close();
					}
//					if(obj instanceof Statement) {
//						((ResultSet)obj).close();
//					}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(getConn());
	}
	
}
