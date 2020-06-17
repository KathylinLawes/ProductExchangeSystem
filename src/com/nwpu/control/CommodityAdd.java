package com.nwpu.control;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：CommodityAdd.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件完成的主要功能是实现商品的添加
 * 
  * 当前版本：1.2
  * 作者：杨之正
  * 完成时间：2020.6.11
 * 
  * 取代版本：1.1
  * 原作者：杨之正
  * 完成日期：2020.6.4
 */

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.nwpu.img.IMGControl;
import com.nwpu.util.SqlCon;

/**
 * Servlet implementation class CommodityAdd
 */
@WebServlet("/CommodityAdd")
@MultipartConfig

public class CommodityAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityAdd() {
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
	 * @throws ServletException 
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	  * 函数介绍：从数据库中取得相应的数据并进行展示
	  * 输入参数：HttpServletRequest request, HttpServletResponse response
	  * 输出参数：无
	  * 返回值：在网页上可以看到相关的信息
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		response.setContentType("text/html;charset=utf8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Collection<Part>parts=request.getParts();
		String servicepath=this.getServletContext().getRealPath("upload");
		String picturepath=IMGControl.getImg(parts, servicepath);  //将图片拷贝到指定位置,并返回文件位置
		String cname=request.getParameter("cname");
		String cdescribe=request.getParameter("cdescribe");
		String type=request.getParameter("type");
		String price=request.getParameter("cprice");
		float cprice=Float.parseFloat(price);
		HttpSession session=request.getSession();
		String sellerid=(String)session.getAttribute("sellerid");
		System.out.println(sellerid);
		int sid=Integer.parseInt(sellerid);
		Connection conn=null;
		PreparedStatement pstm=null;
		conn=SqlCon.getConn();
		System.out.println(sid+cname+cprice+picturepath+cdescribe+type);
		String sql="insert into commodity(sid,cname,price,picture,cdescribe,type)values(?,?,?,?,?,?)";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setObject(1, sid);
			pstm.setObject(2, cname);
			pstm.setObject(3, cprice);
			pstm.setObject(4, picturepath);
			pstm.setObject(5, cdescribe);
			pstm.setObject(6, type);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//	SqlCon.close(pstm,conn);
			response.sendRedirect("shop/SellerAdd.jsp");
		}
	/*	
		System.out.println(id);
		System.out.println(picturepath);
		System.out.println(cname);
		System.out.println(cdescribe);
		System.out.println(cprice);
		System.out.println(cnumbers);
		
		*/
	}

}
