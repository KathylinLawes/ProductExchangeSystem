package com.nwpu.commodity;

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

import com.nwpu.bean.order;
import com.nwpu.util.SqlCon;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class b_Orders
 */
@WebServlet("/b_Orders")
public class b_Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public b_Orders() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String condition=request.getParameter("bid");
		System.out.println(condition);
		Connection conn=null;
		conn=SqlCon.getConn();
		ArrayList<order> orders=new ArrayList<order>();
		//System.out.println(user);
		String sql="select orderid,commodity.cid,commodity.sid,cname,price,type,picture,cdescribe,remark,seller.sonlinename,seller.sschool,buyer.bonlinename,seller.stel,orders.baddress,orders.bid,orders.btel,orders.saddress from orders,commodity,seller,buyer where orders.sid=seller.sid and orders.bid=buyer.bid and orders.cid=commodity.cid and orders.bid="+condition;
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				int orderid=rs.getInt(1);
				int cid=rs.getInt(2);
				int sid=rs.getInt(3);
				String cname=rs.getString(4);
				float price=rs.getFloat(5);
				String type=rs.getString(6);
				String picture=rs.getString(7);
				String cdescribe=rs.getString(8);
				int remark=rs.getInt(9);
				String sonlinename=rs.getString(10);
				String sschool=rs.getString(11);
				String bonlinename=rs.getString(12);
				String stel=rs.getString(13);
				String baddress=rs.getString(14);
				String bid=rs.getString(15);
				String btel=rs.getString(16);
				String saddress=rs.getString(17);
				order commodity=new order(cid,sid,cname,price,picture,cdescribe,type,remark,orderid,bid,btel,baddress,stel,saddress,bonlinename,sonlinename);
				orders.add(commodity);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.setContentType("text/html;charset=UTF-8"); 
		JSONArray jsonarray=JSONArray.fromObject(orders);
		//System.out.println(jsonarray);
		response.getWriter().println(jsonarray);
		
	}

}
