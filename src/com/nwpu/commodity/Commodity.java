package com.nwpu.commodity;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：Commodity.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件完成的主要功能是完成商品信息的获取与存储
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

import com.nwpu.bean.commodityseller;
import com.nwpu.util.SqlCon;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class Commodity
 */
@WebServlet("/Commodity")
public class Commodity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commodity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	  * 函数介绍：从数据库中得到相关的信息并进行存储
	  * 输入参数：HttpServletRequest request, HttpServletResponse response
	  * 输出参数：无
	  * 返回值：在网页上可以看到相关的信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition=request.getParameter("cid");
		//System.out.println(cid);
		//request.setAttribute("cid", cid);
		ArrayList<commodityseller> allcommodity=new ArrayList<commodityseller>();
		Connection conn=null;
		conn=SqlCon.getConn();
		//String sql="select * from commodity where cid ="+condition+"";
		String sql="select cid,commodity.sid,cname,price,picture,cdescribe,type,remark,sonlinename,srank,sschool  from seller,commodity where cid="+condition+" and commodity.sid=seller.sid ";
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
				String type = rs.getString(7);
				String remark1 = rs.getString(8);
				int remark=Integer.parseInt(remark1);
				String selleronlinename=rs.getString(9);
				int sellerrank=rs.getInt(10);
				String sellerschool=rs.getString(11);
				commodityseller commodity=new commodityseller(cid,sid,cname,price,picture,cdescribe,type,remark,selleronlinename,sellerrank,sellerschool);
				allcommodity.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8"); 
		JSONArray jsonarray=JSONArray.fromObject(allcommodity);
		
		response.getWriter().println(jsonarray);
	}

}
