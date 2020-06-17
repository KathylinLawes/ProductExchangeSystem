package com.nwpu.control;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：sendmailservlet.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件完成的主要功能是实现邮件的发送
 * 
  * 当前版本：1.2
  * 作者：杨之正
  * 完成时间：2020.6.11
 * 
  * 取代版本：1.1
  * 原作者：杨之正
  * 完成日期：2020.6.4
 */

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nwpu.bean.User;
import com.nwpu.util.SqlCon;
import com.nwpu.dao.managerforgetpasswordDao;
/**
 * 这一个类中包含了所有的和忘记密码相关的操作
 * @author ASUS
 *
 */
@WebServlet("/sendemail")
public class sendemailservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	 static int length=6;
	 static public StringBuffer creat()
	 {
		 Random random=new Random();
	     StringBuffer code=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       code.append(str.charAt(number));
	     }
		return code;
	 }
	 static StringBuffer code1=creat();
	 String code2 = new String(code1);

	 String email1;
	 
	 /**
	  * 函数介绍：从数据库中取得相应的数据并进行展示
	  * 输入参数：HttpServletRequest request, HttpServletResponse response
	  * 输出参数：无
	  * 返回值：在网页上可以看到相关的信息
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		managerforgetpasswordDao forget=new managerforgetpasswordDao();
		System.out.println("success");
		boolean cansend=forget.cansend(email);
		if(cansend)
		{
			try {
				forget.sendcode(code2, email);
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("shop/forget_password2.jsp");
			email1=email;
		}
		else
		{
			resp.sendRedirect("shop/forget_password.jsp?error=yes");
		}
	}
	
	/**
	  * 函数介绍：从数据库中取得相应的数据并进行展示
	  * 输入参数：HttpServletRequest request, HttpServletResponse response
	  * 输出参数：无
	  * 返回值：在网页上可以看到相关的信息
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=email1;
		//System.out.println(email);
		String code=req.getParameter("code");
		User manager = new User(0, code, code, code, code, code, code, code);
		try {
			Connection c = SqlCon.getConn();
			String sql = "select * from buyer where bemail='"+email+"' ";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				manager.setBuserpwd(rs.getString("bpassword"));
			}
			SqlCon.close(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String password=manager.getBuserpwd();
		managerforgetpasswordDao forget=new managerforgetpasswordDao();
		if(code.equals(code2))
		{
			try {
				forget.sendpassword(email,password);
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("shop/forget_password3.jsp");
		}
		else{
			resp.sendRedirect("shop/forget_password.jsp?error=no");
		}
	}
}
