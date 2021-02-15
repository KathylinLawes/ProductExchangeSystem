package com.nwpu.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * Servlet implementation class a_loginServlet
 */
@WebServlet("/a_loginServlet")
public class a_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public a_loginServlet() {
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
		String adminuser=request.getParameter("username");
		String adminpass=request.getParameter("password");
		//System.out.println(user);
		HttpSession session=request.getSession();
		
		PrintWriter out=response.getWriter();
		
		Connection conn=null;
		conn=SqlCon.getConn();
		String sql="select * from admin where username='"+adminuser+"'";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				System.out.println(rs.getString(2));
				if(rs.getString(3).equals(adminpass)){
					
					session.setAttribute("admin",rs.getString(2));
					response.sendRedirect("shop/admincenter.jsp");
				}else {
					response.sendRedirect("shop/a_login.html");
				}
			}else {
				response.sendRedirect("shop/a_login.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
