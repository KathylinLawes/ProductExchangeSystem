package com.nwpu.commodity;

/**
 * Copyright (c) 2020,�����������
  * �ļ����ƣ�CommodityDown.java
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
	  * �������ܣ������ݿ���ȡ����Ӧ�����ݲ�����չʾ
	  * ���������HttpServletRequest request, HttpServletResponse response
	  * �����������
	  * ����ֵ������ҳ�Ͽ��Կ�����ص���Ϣ
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a=request.getParameter("data");
		//System.out.println(a);
		char[] b=a.toCharArray();       //����ȡ�����ַ���ת�����ַ�����
		String c="";
		for(int i=0;i<b.length;i++) {
			if(b[i]=='['||b[i]==']'||b[i]=='\"') {     //ȥ��[ ] \ 
				
			}else {
				c+=b[i];
			}
		}
		String[] f=c.split(",");                //���ַ����ö��ŷָ���
		
		int[] arrint=new int[f.length];
		for(int l=0;l<f.length;l++) {      
			arrint[l]=Integer.parseInt(f[l]);
		}
		Connection conn=null;            //���ݿ�����
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
		   allcommodity.add("���óɹ�");
		
		JSONArray jsonarray=JSONArray.fromObject(allcommodity);
		
		response.getWriter().println(jsonarray);
		
		//
		
	}

}
