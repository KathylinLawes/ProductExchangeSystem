package com.nwpu.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nwpu.util.SqlCon;
import com.nwpu.bean.commodity;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class AllCommodity
 */
@WebServlet("/AllCommodity")
public class AllCommodity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllCommodity() {
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
		ArrayList<commodity> allcommodity=new ArrayList<commodity>();
		Connection conn=null;
		conn=SqlCon.getConn();
		String sql="select * from commodity where remark=1";
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				int cid=rs.getInt(1);
				int id=rs.getInt(2);
				String cname=rs.getString(3);
				float price=rs.getFloat(4);
				String picture=rs.getString(5);
				String cdescribe=rs.getString(6);
				String type=rs.getString(7);
				int remark =rs.getInt(8);
				commodity commodity=new commodity(cid,id,cname,price,picture,cdescribe,type,remark);
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
