package com.nwpu.commodity;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：orderadd.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件完成的主要功能是实现订单的添加
 * 
  * 当前版本：1.2
  * 作者：杨之正
  * 完成时间：2020.6.16
 * 
  * 取代版本：1.1
  * 原作者：杨之正
  * 完成日期：2020.6.4
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nwpu.bean.order;
import com.nwpu.bean.shoppingcart;
import com.nwpu.util.SqlCon;

import net.sf.json.JSONArray;


/**
 * Servlet implementation class orderadd
 */
@WebServlet("/orderadd")
public class orderadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderadd() {
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
		String condition=request.getParameter("carid");
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("bid");
		//System.out.println(condition);
		ArrayList<shoppingcart> order=new ArrayList<shoppingcart>();
		Connection conn=null;
		conn=SqlCon.getConn();
		
		//System.out.println(user);
		String sql="select carid,commodity.cid,commodity.sid,cname,price,type,picture,cdescribe,remark,seller.sonlinename,seller.sschool,buyer.bonlinename,seller.stel from shoppingcart,commodity,seller,buyer where shoppingcart.bid=buyer.bid and shoppingcart.sid=seller.sid and shoppingcart.cid=commodity.cid and carid="+condition;
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				int carid=rs.getInt(1);
				int cid=rs.getInt(2);
				int sid=rs.getInt(3);
				String cname=rs.getString(4);
				float price=rs.getFloat(5);
				String type=rs.getString(6);
				String picture=rs.getString(7);
				String cdescribe=rs.getString(8);
				int remark=rs.getInt(9);
				String sonlinename=rs.getString(10);
				String sschool=rs.getString(11);
				String bonlinename=rs.getString(12);
				String stel=rs.getString(13);
				
				shoppingcart commodity=new shoppingcart(cid,sid,cname,price,picture,cdescribe,type,remark,carid,user,sonlinename,bonlinename,sschool,stel);
				order.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8"); 
		JSONArray jsonarray=JSONArray.fromObject(order);
		//System.out.println(jsonarray);
		response.getWriter().println(jsonarray);
		
	}

}
