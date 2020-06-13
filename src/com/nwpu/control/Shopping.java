package com.nwpu.control;

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
import javax.servlet.http.HttpSession;

import com.nwpu.bean.shoppingcart;
import com.nwpu.util.SqlCon;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class Shopping
 */
@WebServlet("/Shopping")
public class Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shopping() {
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
		ArrayList<shoppingcart> allcommodity=new ArrayList<shoppingcart>();
		Connection conn=null;
		conn=SqlCon.getConn();
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("bid");
		//System.out.println(user);
		String sql="select commodity.cid,commodity.sid,commodity.cname,commodity.price,picture,cdescribe,remark,type,carid from shoppingcart,commodity WHERE shoppingcart.cid=commodity.cid and shoppingcart.bid="+user+" and commodity.remark=1";
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
				int remark=rs.getInt(7);
				String type=rs.getString(8);
				int carid=rs.getInt(9);
				String a="123";
				shoppingcart commodity=new shoppingcart(cid,sid,cname,price,picture,cdescribe,type,remark,carid,user,a,a,a,a);
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


