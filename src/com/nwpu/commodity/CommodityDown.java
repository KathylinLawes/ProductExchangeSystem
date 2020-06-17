package com.nwpu.commodity;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：CommodityDown.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件完成的主要功能是实现商品的下架操作
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
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nwpu.util.SqlCon;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CommodityDown
 */
@WebServlet("/CommodityDown")
public class CommodityDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityDown() {
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
		String a=request.getParameter("data");
		//System.out.println(a);
		char[] b=a.toCharArray();       //将获取到的字符串转化成字符数组
		String c="";
		for(int i=0;i<b.length;i++) {
			if(b[i]=='['||b[i]==']'||b[i]=='\"') {     //去掉[ ] \ 
				
			}else {
				c+=b[i];
			}
		}
		String[] f=c.split(",");                //将字符串用逗号分隔开
		
		int[] arrint=new int[f.length];
		for(int l=0;l<f.length;l++) {      
			arrint[l]=Integer.parseInt(f[l]);
		}
		Connection conn=null;            //数据库连接
		conn=SqlCon.getConn();
		String sql = "Update commodity set remark=0 where cid=?";
		PreparedStatement pstm=null;
		try {
			pstm=conn.prepareStatement(sql);
			for(int i=0;i<arrint.length;i++) {
			pstm.setObject(1, arrint[i]);	
			pstm.addBatch();	
			}
			pstm.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String>allcommodity=new ArrayList<String>();
		   allcommodity.add("调用成功");
		
		JSONArray jsonarray=JSONArray.fromObject(allcommodity);
		
		response.getWriter().println(jsonarray);
		
		//
		
	}

}
