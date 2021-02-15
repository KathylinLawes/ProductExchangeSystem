package com.nwpu.commodity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nwpu.util.SqlCon;

/**
 * Servlet implementation class Recording
 */
@WebServlet("/Recording")
public class Recording extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recording() {
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
		request.setCharacterEncoding("utf-8");  
		String cid=request.getParameter("cid");
		String sid=request.getParameter("sid");
		String stel=request.getParameter("stel");
		String btel=request.getParameter("btel");
		String baddress=request.getParameter("baddress");
		String sschool=request.getParameter("ssschool");
		HttpSession session=request.getSession();
		String bid=(String)session.getAttribute("bid");
		
		Connection conn=null;
		PreparedStatement pstm=null;
		conn=SqlCon.getConn();
		String sql="insert into orders(bid,btel,baddress,sid,stel,saddress,cid) values (?,?,?,?,?,?,?)";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setObject(1, bid);
			pstm.setObject(2, btel);
			pstm.setObject(3, baddress);
			pstm.setObject(4, sid);
			pstm.setObject(5, stel);
			pstm.setObject(6, sschool);
			pstm.setObject(7, cid);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*		
		System.out.println(cid);
		System.out.println(id);
		System.out.println(stel);
		System.out.println(btel);
		System.out.println(baddress);
		System.out.println(bid);
*/		
		response.sendRedirect("shop/shopping.jsp");		
		
	}

}
