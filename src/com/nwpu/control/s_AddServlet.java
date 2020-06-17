package com.nwpu.control;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：s_AddServlet.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件完成的主要功能是实现卖家的添加
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
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nwpu.util.SqlCon;

/**
 * Servlet implementation class s_AddServlet
 */
@WebServlet("/s_AddServlet")
public class s_AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s_AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	  * 函数介绍：从数据库中取得相应的数据并进行展示
	  * 输入参数：HttpServletRequest request, HttpServletResponse response
	  * 输出参数：无
	  * 返回值：在网页上可以看到相关的信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		设置输入的编码格式为utf-8
		request.setCharacterEncoding("utf-8");  
//		给浏览器的标示，该字体为text/html
		response.setContentType("text/html;charset:utf-8");  
		HttpSession session=request.getSession();
		String realname=request.getParameter("realname");
		String userpwd=request.getParameter("userpwd");
		String onlinename=request.getParameter("onlinename");
		String school=request.getParameter("school");
		String sex=request.getParameter("sex");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		String studentid=request.getParameter("studentid");
		
		System.out.println(realname);
		System.out.println(userpwd);
		System.out.println(onlinename);
		System.out.println(school);
		System.out.println(sex);
		System.out.println(tel);
		System.out.println(email);
		System.out.println(studentid);
	
		Connection conn=null;
		PreparedStatement pstm=null;
		conn=SqlCon.getConn();
		
		String sql="insert into seller(stel,spassword,sonlinename,sschool,srealname,sstudentid,ssex,semail) values(?,?,?,?,?,?,?,?)";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setObject(1, tel);
			pstm.setObject(2, userpwd);
			pstm.setObject(3, onlinename);
			pstm.setObject(4, school);
			pstm.setObject(5, realname);
			pstm.setObject(6, studentid);
			pstm.setObject(7, sex);
			pstm.setObject(8, email);
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//	SqlCon.close(pstm,conn);
			session.setAttribute("selleronlinename",onlinename);
			response.sendRedirect("shop/index.html");   //这个地方最好修改一下
		}
		
	}

}