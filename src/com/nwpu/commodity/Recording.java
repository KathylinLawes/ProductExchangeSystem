package com.nwpu.commodity;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：Recording.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件完成的主要功能是实现商品的上架操作
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
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class Recording
 */
@WebServlet("/Recording")
public class Recording extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recording() {
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
		request.setCharacterEncoding("utf-8");  
		String cid=request.getParameter("cid");
		String sid=request.getParameter("sid");
		String stel=request.getParameter("stel");
		String btel=request.getParameter("btel");
		String baddress=request.getParameter("baddress");
		String sschool=request.getParameter("ssschool");
		HttpSession session=request.getSession();
		String bid=(String)session.getAttribute("bid");
		
		Connection conn=null;
		PreparedStatement pstm=null;
		conn=SqlCon.getConn();
		String sql="insert into orders(bid,btel,baddress,sid,stel,saddress,cid) values (?,?,?,?,?,?,?)";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setObject(1, bid);
			pstm.setObject(2, btel);
			pstm.setObject(3, baddress);
			pstm.setObject(4, sid);
			pstm.setObject(5, stel);
			pstm.setObject(6, sschool);
			pstm.setObject(7, cid);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*		
		System.out.println(cid);
		System.out.println(id);
		System.out.println(stel);
		System.out.println(btel);
		System.out.println(baddress);
		System.out.println(bid);
*/		
		response.sendRedirect("shop/shopping.jsp");		
		
	}

}
