package com.nwpu.control;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nwpu.bean.User;
import com.nwpu.util.SqlCon;
import com.nwpu.dao.managerforgetpasswordDao;
/**
 * 这一个类中包含了所有的和忘记密码相关的操作
 * @author ASUS
 *
 */
@WebServlet("/sendemail")
public class sendemailservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	 static int length=6;
	 static public StringBuffer creat()
	 {
		 Random random=new Random();
	     StringBuffer code=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       code.append(str.charAt(number));
	     }
		return code;
	 }
	 static StringBuffer code1=creat();
	 String code2 = new String(code1);

	 String email1;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		managerforgetpasswordDao forget=new managerforgetpasswordDao();
		System.out.println("success");
		boolean cansend=forget.cansend(email);
		if(cansend)
		{
			try {
				forget.sendcode(code2, email);
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("shop/forget_password2.jsp");
			email1=email;
		}
		else
		{
			resp.sendRedirect("shop/forget_password.jsp?error=yes");
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=email1;
		//System.out.println(email);
		String code=req.getParameter("code");
		User manager = new User(0, code, code, code, code, code, code, code);
		try {
			Connection c = SqlCon.getConn();
			String sql = "select * from buyer where bemail='"+email+"' ";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				manager.setBuserpwd(rs.getString("bpassword"));
			}
			SqlCon.close(c, ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String password=manager.getBuserpwd();
		managerforgetpasswordDao forget=new managerforgetpasswordDao();
		if(code.equals(code2))
		{
			try {
				forget.sendpassword(email,password);
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("shop/forget_password3.jsp");
		}
		else{
			resp.sendRedirect("shop/forget_password.jsp?error=no");
		}
	}
}
