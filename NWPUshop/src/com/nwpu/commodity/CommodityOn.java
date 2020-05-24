package com.nwpu.commodity;

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
@WebServlet("/CommodityOn")
public class CommodityOn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommodityOn() {
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
			//System.out.println(arrint[l]);
		}
		Connection conn=null;            //数据库连接
		conn=SqlCon.getConn();
		String sql = "Update commodity set remark=1 where cid=?";
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
