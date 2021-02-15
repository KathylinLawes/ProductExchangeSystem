package com.nwpu.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nwpu.util.SqlCon;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/s_loginServlet")
public class s_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s_loginServlet() {
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
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		HttpSession session=request.getSession();
		
		PrintWriter out=response.getWriter();
		
		Connection conn=null;
		conn=SqlCon.getConn();
		String sql="select * from seller where stel="+user+"";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				if(rs.getString(3).equals(pass)){
					session.setAttribute("sellerid",rs.getString(1));
					session.setAttribute("selleronlinename",rs.getString(4));
					response.sendRedirect("shop/Sellercenter.jsp");
				}else {
					response.sendRedirect("shop/s_login.html");
				}
			}else {
				response.sendRedirect("shop/s_login.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
