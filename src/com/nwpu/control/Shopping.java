package com.nwpu.control;


/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：Shopping.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件完成的主要功能是实现购物的功能
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

import com.nwpu.bean.shoppingcart;
import com.nwpu.util.SqlCon;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class Shopping
 */
@WebServlet("/Shopping")
public class Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shopping() {
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
		ArrayList<shoppingcart> allcommodity=new ArrayList<shoppingcart>();
		Connection conn=null;
		conn=SqlCon.getConn();
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("bid");
		//System.out.println(user);
		String sql="select commodity.cid,commodity.sid,commodity.cname,commodity.price,picture,cdescribe,remark,type,carid from shoppingcart,commodity WHERE shoppingcart.cid=commodity.cid and shoppingcart.bid="+user+" and commodity.remark=1";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				int cid=rs.getInt(1);
				int sid=rs.getInt(2);
				String cname=rs.getString(3);
				float price=rs.getFloat(4);
			
				String picture=rs.getString(5);
				String cdescribe=rs.getString(6);
				int remark=rs.getInt(7);
				String type=rs.getString(8);
				int carid=rs.getInt(9);
				String a="123";
				shoppingcart commodity=new shoppingcart(cid,sid,cname,price,picture,cdescribe,type,remark,carid,user,a,a,a,a);
				allcommodity.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		//System.out.println(allcommodity);
	  /*request.setAttribute("allcommodity",allcommodity);
		request.getRequestDispatcher("shop/display.jsp").forward(request, response);
		*/
		response.setContentType("text/html;charset=UTF-8"); 
		JSONArray jsonarray=JSONArray.fromObject(allcommodity);
		//System.out.println(jsonarray);
		response.getWriter().println(jsonarray);
	}

}


