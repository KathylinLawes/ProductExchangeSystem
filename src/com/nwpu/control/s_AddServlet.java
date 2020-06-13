package com.nwpu.control;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nwpu.util.SqlCon;

/**
 * Servlet implementation class s_AddServlet
 */
@WebServlet("/s_AddServlet")
public class s_AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s_AddServlet() {
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
//		设置输入的编码格式为utf-8
		request.setCharacterEncoding("utf-8");  
//		给浏览器的标示，该字体为text/html
		response.setContentType("text/html;charset:utf-8");  
		HttpSession session=request.getSession();
		String realname=request.getParameter("realname");
		String userpwd=request.getParameter("userpwd");
		String onlinename=request.getParameter("onlinename");
		String school=request.getParameter("school");
		String sex=request.getParameter("sex");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		String studentid=request.getParameter("studentid");
		
		System.out.println(realname);
		System.out.println(userpwd);
		System.out.println(onlinename);
		System.out.println(school);
		System.out.println(sex);
		System.out.println(tel);
		System.out.println(email);
		System.out.println(studentid);
	
		Connection conn=null;
		PreparedStatement pstm=null;
		conn=SqlCon.getConn();
		
		String sql="insert into seller(stel,spassword,sonlinename,sschool,srealname,sstudentid,ssex,semail) values(?,?,?,?,?,?,?,?)";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setObject(1, tel);
			pstm.setObject(2, userpwd);
			pstm.setObject(3, onlinename);
			pstm.setObject(4, school);
			pstm.setObject(5, realname);
			pstm.setObject(6, studentid);
			pstm.setObject(7, sex);
			pstm.setObject(8, email);
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//	SqlCon.close(pstm,conn);
			session.setAttribute("selleronlinename",onlinename);
			response.sendRedirect("shop/index.html");   //这个地方最好修改一下
		}
		
	}

}