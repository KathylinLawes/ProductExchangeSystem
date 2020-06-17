package com.nwpu.dao;

/**
 * Copyright (c) 2020,�����������
  * �ļ����ƣ�manageforgetpasswordDao.java
  * �ļ���ʶ�����У԰���ֽ���ϵͳ���˵����
  * ժ         Ҫ�����ļ���ɵ���Ҫ������ʵ�����������һЩ�в���
 * 
  * ��ǰ�汾��1.2
  * ���ߣ���֮��
  * ���ʱ�䣺2020.6.11
 * 
  * ȡ���汾��1.1
  * ԭ���ߣ���֮��
  * ������ڣ�2020.6.4
 */

import java.security.GeneralSecurityException;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.jsptags.navigation.pager.parser.ParseException;
import com.nwpu.util.SqlCon;
import com.sun.mail.util.MailSSLSocketFactory;


public class managerforgetpasswordDao{
	public boolean cansend(String email) {
		boolean returnValue = false;
		String sql = "SELECT * from buyer";
		try {
			Connection conn =SqlCon.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String useremailInDB = rs.getString("bemail");
				if (useremailInDB.equals(email)) {
					returnValue = true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return returnValue;
	}
	/**
	  * �������ܣ������ݿ���ȡ����Ӧ�����ݲ�����չʾ
	  * ���������HttpServletRequest request, HttpServletResponse response
	  * �����������
	  * ����ֵ������ҳ�Ͽ��Կ�����ص���Ϣ
	 */
	public void sendcode(String code,String email) throws GeneralSecurityException  // ������֤��
	{
		// �ռ��˵�������
        String to = email;
        // �����˵�������
        String from = "302949125@qq.com";
        // ָ�������ʼ�������Ϊ smtp.qq.com
        String host = "smtp.qq.com";  //QQ �ʼ�������
        // ��ȡϵͳ����
        Properties properties = System.getProperties();
        // �����ʼ�������
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // ��ȡĬ��session����
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("302949125@qq.com", "bmrmsjwypcyubjdg"); //�������ʼ��û���������
            }
        });
        try{
            // ����Ĭ�ϵ� MimeMessage ����
            MimeMessage message = new MimeMessage(session);
            // Set From: ͷ��ͷ�ֶ�
            message.setFrom(new InternetAddress(from));
            // Set To: ͷ��ͷ�ֶ�
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: ͷ��ͷ�ֶ�
            message.setSubject("ͼ�����ϵͳ-�һ�����");
            // ������Ϣ��
            message.setText("�����֤��Ϊ:\n"+code);
            // ������Ϣ
            Transport.send(message);
            System.out.println("Sent message successfully");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
	
	/**
	  * �������ܣ������ݿ���ȡ����Ӧ�����ݲ�����չʾ
	  * ���������HttpServletRequest request, HttpServletResponse response
	  * �����������
	  * ����ֵ������ҳ�Ͽ��Կ�����ص���Ϣ
	 */
	public void sendpassword(String email,String password) throws GeneralSecurityException
	{
		// �ռ��˵�������
        String to = email;
        // �����˵�������
        String from = "302949125@qq.com";
        // ָ�������ʼ�������Ϊ smtp.qq.com
        String host = "smtp.qq.com";  //QQ �ʼ�������
        // ��ȡϵͳ����
        Properties properties = System.getProperties();
        // �����ʼ�������
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // ��ȡĬ��session����
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("302949125@qq.com", "bmrmsjwypcyubjdg"); //�������ʼ��û���������
            }
        });
        try{
            // ����Ĭ�ϵ� MimeMessage ����
            MimeMessage message = new MimeMessage(session);
            // Set From: ͷ��ͷ�ֶ�
            message.setFrom(new InternetAddress(from));
            // Set To: ͷ��ͷ�ֶ�
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: ͷ��ͷ�ֶ�
            message.setSubject("ͼ�����ϵͳ-�һ�����");
            // ������Ϣ��
            message.setText("�������Ϊ:\n"+password);
            // ������Ϣ
            Transport.send(message);
            System.out.println("Sent message successfully");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
	public void senddeadline(String email,String title,String borrowdate,String deadlinedate) throws GeneralSecurityException, java.text.ParseException, ParseException
	{
		//��Sting����dateת��Ϊdate���Ͳ���Ҫ������ʱ��
		java.util.Date borrow=null;
		java.util.Date deadline=null;
		java.util.Date now=null;
		       Calendar cal=Calendar.getInstance();
		       java.util.Date currentdate=cal.getTime();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String current=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentdate);
				borrow=format.parse(borrowdate);
				deadline=format.parse(deadlinedate);
				now=format.parse(current);   
				long between1=(deadline.getTime()-borrow.getTime())/1000;
				long between2=(now.getTime()-borrow.getTime())/1000;
				long period=between1/(24*3600);
				long today=between2/(24*3600);
				System.out.println(email);
				
				String to = email;
	        // �����˵�������
	        String from = "302949125@qq.com";
	        // ָ�������ʼ�������Ϊ smtp.qq.com
	        String host = "smtp.qq.com";  //QQ �ʼ�������
	        // ��ȡϵͳ����
	        Properties properties = System.getProperties();
	        // �����ʼ�������
	        properties.setProperty("mail.smtp.host", host);
	        properties.put("mail.smtp.auth", "true");
	        MailSSLSocketFactory sf = new MailSSLSocketFactory();
	        sf.setTrustAllHosts(true);
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.ssl.socketFactory", sf);
	        // ��ȡĬ��session����
	        Session session = Session.getDefaultInstance(properties,new Authenticator(){
	            public PasswordAuthentication getPasswordAuthentication()
	            {
	                return new PasswordAuthentication("302949125@qq.com", "bmrmsjwypcyubjdg"); //�������ʼ��û���������
	            }
	        });
	        try{
	            // ����Ĭ�ϵ� MimeMessage ����
	            MimeMessage message = new MimeMessage(session);
	            // Set From: ͷ��ͷ�ֶ�
	            message.setFrom(new InternetAddress(from));
	            // Set To: ͷ��ͷ�ֶ�
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            // Set Subject: ͷ��ͷ�ֶ�
	            message.setSubject("Borrow Book warning!");
	            System.out.println(period-today);
	            if((period-today)<=1&&(period-today)>=0)
	            {
	            // ������Ϣ��
	            message.setText("This email is come from Librarian.\n"+"You borrowed a book named:"+title+",at "+borrowdate+".\nyou need return this book at today!");
	            Transport.send(message);
	            }
	            if((period-today)<0)
	            {
	            	 // ������Ϣ��
		            message.setText("This email is come from  Librarian."+"You borrowed a "+title+",at "+borrowdate+".this book is out of date");
		            Transport.send(message);
	            }
	            // ������Ϣ
	           
	            System.out.println("Sent message successfully....from runoob.com");
	        }catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
	}
	
	public void onekeytosenddeadlineemail() throws GeneralSecurityException, java.text.ParseException, ParseException
	{
		String sql = "select reader.reader_email,booklisttable.title,borrow.borrow_date,borrow.deadline_date,borrow.return_date from reader,booklisttable,borrow where reader.reader_phone=borrow.reader_phone and borrow.book_isbn=booklisttable.id ";
		try {
			Connection conn =SqlCon.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String email = rs.getString("reader.reader_email");
				String title=rs.getString("booklisttable.title");
				String borrowdate=rs.getString("borrow.borrow_date");
				String deadlinedate=rs.getString("borrow.deadline_date");
				String returndate=rs.getString("borrow.return_date");
				if(returndate==null)
				{
					System.out.println("1");
					senddeadline(email,title,borrowdate,deadlinedate);
				}
				
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void onekeytosendpubnishemail() throws GeneralSecurityException
	{
		String sql="select reader.reader_email,punish.punish_price,punish.punish_reason,punish.punish_result,booklisttable.title from reader,punish,booklisttable where reader.reader_phone=punish.reader_phone and punish.book_id=booklisttable.id";
		try {
			Connection conn =SqlCon.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String email = rs.getString("reader.reader_email");
				String price=rs.getString("punish.punish_price");
				String reason=rs.getString("punish.punish_reason");
				String result=rs.getString("punish.punish_result");
				String title=rs.getString("booklisttable.title");
				if(result.equals("0"))
				{
				sendpunish(email,price,reason,result,title);
				}
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void sendpunish(String email,String price,String reason,String result,String title) throws GeneralSecurityException
	{
		 // �ռ��˵�������
        String to = email;

        // �����˵�������
        String from = "302949125@qq.com";

        // ָ�������ʼ�������Ϊ smtp.qq.com
        String host = "smtp.qq.com";  //QQ �ʼ�������

        // ��ȡϵͳ����
        Properties properties = System.getProperties();

        // �����ʼ�������
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // ��ȡĬ��session����
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("302949125@qq.com", "bmrmsjwypcyubjdg"); //�������ʼ��û���������
            }
        });
        try{
            // ����Ĭ�ϵ� MimeMessage ����
            MimeMessage message = new MimeMessage(session);
            // Set From: ͷ��ͷ�ֶ�
            message.setFrom(new InternetAddress(from));
            // Set To: ͷ��ͷ�ֶ�
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: ͷ��ͷ�ֶ�
            message.setSubject("Punishment warning");
            // ������Ϣ��
            message.setText("This email come from librarian,and you have a punishment need to paid\n"+"You borrow a book named "+title+"because you "+ reason +"  it.\n"+"So,you need pay for "+price+"��!");
            // ������Ϣ
            Transport.send(message);
            System.out.println("Sent message successfully....from runoob.com");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
	}
	public void autotosendpunishment(String phone) throws GeneralSecurityException
	{
		System.out.println("123");
		String sql="select reader.reader_email,punish.punish_price,punish.punish_reason,punish.punish_result,booklisttable.title from reader,punish,booklisttable where reader.reader_phone=punish.reader_phone and punish.book_id=booklisttable.id and reader.reader_phone='"+phone+"'";
		try {
			Connection conn =SqlCon.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String email = rs.getString("reader.reader_email");
				String price=rs.getString("punish.punish_price");
				String reason=rs.getString("punish.punish_reason");
				String result=rs.getString("punish.punish_result");
				String title=rs.getString("booklisttable.title");
				if(result.equals("not paid"))
				{
				autosendpunish(email,price,reason,result,title,phone);
				}
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void autosendpunish(String email,String price,String reason,String result,String title,String phone) throws GeneralSecurityException
	{
		 // �ռ��˵�������
        String to = email;

        // �����˵�������
        String from = "302949125@qq.com";

        // ָ�������ʼ�������Ϊ smtp.qq.com
        String host = "smtp.qq.com";  //QQ �ʼ�������

        // ��ȡϵͳ����
        Properties properties = System.getProperties();

        // �����ʼ�������
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // ��ȡĬ��session����
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("302949125@qq.com", "bmrmsjwypcyubjdg"); //�������ʼ��û���������
            }
        });

        try{
            // ����Ĭ�ϵ� MimeMessage ����
            MimeMessage message = new MimeMessage(session);

            // Set From: ͷ��ͷ�ֶ�
            message.setFrom(new InternetAddress(from));

            // Set To: ͷ��ͷ�ֶ�
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: ͷ��ͷ�ֶ�
            message.setSubject("Punishment warning");

            // ������Ϣ��
            message.setText("Dear reader:"+phone+"\nThis email come from system,and you have a punishment need to paid\n"+"You borrow a book named "+title+"because you "+ reason +"  it.\n"+"So,you need pay for "+price+"��!");

            // ������Ϣ
            Transport.send(message);
            System.out.println("Sent message successfully....from runoob.com");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
	}
	
	public void autosenddeadline(String email,String title,String borrowdate,String deadlinedate,String phone) throws GeneralSecurityException, java.text.ParseException, ParseException
	{
		//��Sting����dateת��Ϊdate���Ͳ���Ҫ������ʱ��
		       java.util.Date borrow=null;
		       java.util.Date deadline=null;
		       java.util.Date now=null;
		       Calendar cal=Calendar.getInstance();
		       java.util.Date currentdate=cal.getTime();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String current=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentdate);
				borrow=format.parse(borrowdate);
				deadline=format.parse(deadlinedate);
				now=format.parse(current);   
				long between1=(deadline.getTime()-borrow.getTime())/1000;
				long between2=(now.getTime()-borrow.getTime())/1000;
				long period=between1/(24*3600);
				long today=between2/(24*3600);
				System.out.println(email);
				
		 String to = email;

	        // �����˵�������
	        String from = "302949125@qq.com";

	        // ָ�������ʼ�������Ϊ smtp.qq.com
	        String host = "smtp.qq.com";  //QQ �ʼ�������

	        // ��ȡϵͳ����
	        Properties properties = System.getProperties();

	        // �����ʼ�������
	        properties.setProperty("mail.smtp.host", host);

	        properties.put("mail.smtp.auth", "true");
	        MailSSLSocketFactory sf = new MailSSLSocketFactory();
	        sf.setTrustAllHosts(true);
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.ssl.socketFactory", sf);
	        // ��ȡĬ��session����
	        Session session = Session.getDefaultInstance(properties,new Authenticator(){
	            public PasswordAuthentication getPasswordAuthentication()
	            {
	                return new PasswordAuthentication("302949125@qq.com", "bmrmsjwypcyubjdg"); //�������ʼ��û���������
	            }
	        });

	        try{
	            // ����Ĭ�ϵ� MimeMessage ����
	            MimeMessage message = new MimeMessage(session);

	            // Set From: ͷ��ͷ�ֶ�
	            message.setFrom(new InternetAddress(from));

	            // Set To: ͷ��ͷ�ֶ�
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            // Set Subject: ͷ��ͷ�ֶ�
	            message.setSubject("Borrow Book warning!");
	            System.out.println(period-today);
	            if((period-today)<=1&&(period-today)>=0)
	            {
	            // ������Ϣ��
	            message.setText("This email is come from Librarian.\n"+"You borrowed a book named:"+title+",at "+borrowdate+".\nyou need return this book at today!");
	            Transport.send(message);
	            }
	            if((period-today)<0)
	            {
	            	 // ������Ϣ��
		            message.setText("Dear reader:"+phone+"\nThis email is come from Librarian."+"You borrowed a "+title+",at "+borrowdate+".this book is out of date");
		            Transport.send(message);
	            }
	            // ������Ϣ
	           
	            System.out.println("Sent message successfully....from runoob.com");
	        }catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
	}
	
	public void autotosenddeadlineemail(String phone) throws GeneralSecurityException, java.text.ParseException, ParseException
	{
		String sql = "select reader.reader_email,booklisttable.title,borrow.borrow_date,borrow.deadline_date,borrow.return_date from reader,booklisttable,borrow where reader.reader_phone=borrow.reader_phone and borrow.book_isbn=booklisttable.id and reader.reader_phone='"+phone+"'";
		try {
			Connection conn =SqlCon.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String email = rs.getString("reader.reader_email");
				String title=rs.getString("booklisttable.title");
				String borrowdate=rs.getString("borrow.borrow_date");
				String deadlinedate=rs.getString("borrow.deadline_date");
				String returndate=rs.getString("borrow.return_date");
				if(returndate==null)
				{
					System.out.println("1");
					autosenddeadline(email,title,borrowdate,deadlinedate,phone);
				}
				
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void sendreserveemail(String phone) throws java.text.ParseException, GeneralSecurityException
	{
		String sql ="select reserve.reserve_state ,booklisttable.id,reserve.reserve_id,reader.reader_email,booklisttable.title,reserve.reserve_date from reader,booklisttable,reserve where reader.reader_phone=reserve.reader_phone and booklisttable.id=reserve.book_id and reader.reader_phone='"+phone+"'";
		try {
			Connection conn =SqlCon.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String email = rs.getString("reader.reader_email");
				String title=rs.getString("booklisttable.title");
				String reservedate=rs.getString("reserve.reserve_date");
				String reserveid=rs.getString("reserve.reserve_id");
				String book_id=rs.getString("booklisttable.id");
				String reserve_state=rs.getString("reserve.reserve_state");
				java.util.Date now=null;
				java.util.Date reserve=null;
			     Calendar cal=Calendar.getInstance();
			    java.util.Date currentdate=cal.getTime();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String current=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentdate);
				now=format.parse(current); 
				reserve=format.parse(reservedate);
				long between1=(now.getTime()-reserve.getTime())/1000;
				long period=between1/60;
				if(period>120&&reserve_state.equals("reserved"))
				{
					autosendreserveemail(email,title,reservedate);
					upatereservestate(reserveid);
					upatebookstate(book_id);
					
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void autosendreserveemail(String email,String title,String reservedate) throws GeneralSecurityException
	{
		 // �ռ��˵�������
        String to = email;

        // �����˵�������
        String from = "302949125@qq.com";

        // ָ�������ʼ�������Ϊ smtp.qq.com
        String host = "smtp.qq.com";  //QQ �ʼ�������

        // ��ȡϵͳ����
        Properties properties = System.getProperties();

        // �����ʼ�������
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // ��ȡĬ��session����
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("302949125@qq.com", "bmrmsjwypcyubjdg"); //�������ʼ��û���������
            }
        });

        try{
            // ����Ĭ�ϵ� MimeMessage ����
            MimeMessage message = new MimeMessage(session);

            // Set From: ͷ��ͷ�ֶ�
            message.setFrom(new InternetAddress(from));

            // Set To: ͷ��ͷ�ֶ�
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: ͷ��ͷ�ֶ�
            message.setSubject("Reserve Warnning");

            // ������Ϣ��
            message.setText("This email is come from system.\n"+"You reserved a book :"+title+" at "+reservedate+".\n"+"Because library just can reserve 120 minute\nSo,this is reserve failed!");

            // ������Ϣ
            Transport.send(message);
            System.out.println("Sent message successfully....from runoob.com");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
		
	}
	public void upatereservestate(String reserve_id)
	{ 
		int reserve=Integer.parseInt(reserve_id);
		String reserved="not reserved";
		String sql1 ="upate reserve set reserve_state='"+reserved+"' where reserve_id='"+reserve+"'";
		try {
			Connection conn =SqlCon.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql1);
			while (rs.next()) {
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
}
	public void upatebookstate(String book_id)
	{ 
		int id=Integer.parseInt(book_id);
		
		String sql1 ="upate booklisttable set book_state='ready' where id='"+id+"'";
		try {
			Connection conn =SqlCon.getConn();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql1);
			while (rs.next()) {
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
}
}

	
