package com.nwpu.login;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：loginServlent.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件完成的主要功能是实现登录的功能
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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nwpu.util.SqlCon;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
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
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		HttpSession session=request.getSession();
		
		PrintWriter out=response.getWriter();
		
		Connection conn=null;
		conn=SqlCon.getConn();
		String sql="select * from buyer where btel="+user+"";  //这个地方是不是要添加用户不存在
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				if(rs.getString(3).equals(pass)){
					session.setAttribute("bid",rs.getString(1));
					session.setAttribute("bonlinename",rs.getString(4));
					response.sendRedirect("shop/buyercenter.jsp");
				}else {
					response.sendRedirect("shop/login.html");
				}
			}else {
				response.sendRedirect("shop/login.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
