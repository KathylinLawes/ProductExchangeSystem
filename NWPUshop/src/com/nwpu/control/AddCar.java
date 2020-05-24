package com.nwpu.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class AddCar
 */
@WebServlet("/AddCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCar() {
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
		String ccid=request.getParameter("commodityid");
		String buyerid=request.getParameter("buyerid");
		int cid=0;
		int id=0;
//		String cname=null;
//		float price=0;
//		int cnumbers=0;
//		String picture=null;
//		String cdescribe=null;
//		int remark=0;
		String bid=null;
		//System.out.println(id);
		Connection conn=null;
		PreparedStatement pstm=null;
		conn=SqlCon.getConn();
		String sql="select * from commodity where cid="+ccid;
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
			cid=rs.getInt(1);
			id=rs.getInt(2);
		//	cname=rs.getString(3);
		//	price=rs.getFloat(4);
		//	cnumbers=rs.getInt(5);
		//	picture=rs.getString(6);
		//	cdescribe=rs.getString(7);
		//	remark=rs.getInt(8);
			bid=buyerid;
//			System.out.println(cid);
//			System.out.println(cname);
//			System.out.println(price);
//			System.out.println(cnumbers);
//			System.out.println(cdescribe);
//			System.out.println(remark);
//			System.out.println(bid);
//			System.out.println(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String sql1="insert into shoppingcart(cid,sid,bid) values(?,?,?)";
		try {
			pstm=conn.prepareStatement(sql1);
			pstm.setObject(1, cid);
			pstm.setObject(2, id);
			pstm.setObject(3, bid);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("shop/commodity.jsp?cid="+cid);
		
	}

}
