package com.nwpu.control;

/**
 * Copyright (c) 2020,�����������
  * �ļ����ƣ�AddServlet.java
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

import java.io.IOException;
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
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	  * �������ܣ������ݿ���ȡ����Ӧ�����ݲ�����չʾ
	  * ���������HttpServletRequest request, HttpServletResponse response
	  * �����������
	  * ����ֵ������ҳ�Ͽ��Կ�����ص���Ϣ
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	��������ı����ʽΪutf-8
		request.setCharacterEncoding("utf-8");  
//		��������ı�ʾ��������Ϊtext/html
		response.setContentType("text/html;charset:utf-8");  
		HttpSession session=request.getSession();
		String realname=request.getParameter("realname");
		String userpwd=request.getParameter("userpwd");
		String onlinename=request.getParameter("onlinename");
		String school=request.getParameter("school");
		String sex=request.getParameter("sex");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		System.out.println(realname);
		System.out.println(userpwd);
		System.out.println(onlinename);
		System.out.println(school);
		System.out.println(sex);
		System.out.println(tel);
		System.out.println(email);
		Connection conn=null;
		PreparedStatement pstm=null;
		conn=SqlCon.getConn();
		String sql="insert into buyer(brealname,bpassword,bonlinename,bschool,bsex,btel,bemail) values(?,?,?,?,?,?,?)";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setObject(1, realname);
			pstm.setObject(2, userpwd);
			pstm.setObject(3, onlinename);
			pstm.setObject(4, school);
			pstm.setObject(5, sex);
			pstm.setObject(6, tel);
			pstm.setObject(7, email);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//	SqlCon.close(pstm,conn);
			session.setAttribute("onlinename",onlinename);
			response.sendRedirect("shop/index.html");
		}
		
		
	}

}
