package com.nwpu.control;

/**
 * Copyright (c) 2020,�����������
  * �ļ����ƣ�CheckName.java
  * �ļ���ʶ�����У԰���ֽ���ϵͳ���˵����
  * ժ         Ҫ�����ļ���ɵ���Ҫ������ʵ�����Ƶļ��
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nwpu.util.SqlCon;

/**
 * Servlet implementation class CheckName
 */
@WebServlet("/CheckName")
public class CheckName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckName() {
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
		String tel=request.getParameter("tel");
		boolean flag=true;
		Connection conn=null;
		conn=SqlCon.getConn();
		String sql="select btel from buyer";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString(1).equals(tel)) {
					flag=false;
					break;
				}
			}
			String jsonString="{\"flag\":"+flag+"}";
			
			response.getWriter().print(jsonString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
