package com.nwpu.util;

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
					if(obj instanceof Statement) {
						((ResultSet)obj).close();
					}
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
