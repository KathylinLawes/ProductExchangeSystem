package com.nwpu.control;

/**
 * Copyright (c) 2020,�����������
  * �ļ����ƣ�CommodityAdd.java
  * �ļ���ʶ�����У԰���ֽ���ϵͳ���˵����
  * ժ         Ҫ�����ļ���ɵ���Ҫ������ʵ����Ʒ�����
 * 
  * ��ǰ�汾��1.2
  * ���ߣ���֮��
  * ���ʱ�䣺2020.6.11
 * 
  * ȡ���汾��1.1
  * ԭ���ߣ���֮��
  * ������ڣ�2020.6.4
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
	  * �������ܣ������ݿ���ȡ����Ӧ�����ݲ�����չʾ
	  * ���������HttpServletRequest request, HttpServletResponse response
	  * �����������
	  * ����ֵ������ҳ�Ͽ��Կ�����ص���Ϣ
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		response.setContentType("text/html;charset=utf8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Collection<Part>parts=request.getParts();
		String servicepath=this.getServletContext().getRealPath("upload");
		String picturepath=IMGControl.getImg(parts, servicepath);  //��ͼƬ������ָ��λ��,�������ļ�λ��
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
