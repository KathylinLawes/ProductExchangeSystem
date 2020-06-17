package com.nwpu.commodity;

/**
 * Copyright (c) 2020,�����������
  * �ļ����ƣ�downCommoditymanage.java
  * �ļ���ʶ�����У԰���ֽ���ϵͳ���˵����
  * ժ         Ҫ�����ļ���ɵ���Ҫ������ʵ����Ʒ���¼ܲ���
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
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nwpu.bean.commodity;
import com.nwpu.util.SqlCon;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class Commoditymanage
 */
@WebServlet("/downCommoditymanage")
public class downCommoditymanage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public downCommoditymanage() {
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
	  * �������ܣ������ݿ���ȡ����Ӧ�����ݲ�����չʾ
	  * ���������HttpServletRequest request, HttpServletResponse response
	  * �����������
	  * ����ֵ������ҳ�Ͽ��Կ�����ص���Ϣ
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sellerid=request.getParameter("id");
		
		ArrayList<commodity> allcommodity=new ArrayList<commodity>();
		Connection conn=null;
		conn=SqlCon.getConn();
		String sql="select * from commodity where sid="+sellerid+" and remark=0";
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
				String type=rs.getString(7);
				int remark=rs.getInt(8);
				commodity commodity=new commodity(cid,sid,cname,price,picture,cdescribe,type,remark);
				allcommodity.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8"); 
		JSONArray jsonarray=JSONArray.fromObject(allcommodity);
		//System.out.println(jsonarray);
		response.getWriter().println(jsonarray);
	}
	

}
