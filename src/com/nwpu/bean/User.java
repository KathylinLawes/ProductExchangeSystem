package com.nwpu.bean;

/**
 * Copyright (c) 2020,�����������
  * �ļ����ƣ�User.java
  * �ļ���ʶ�����У԰���ֽ���ϵͳ���˵����
  * ժ         Ҫ�����ļ����û���Ϣ���ඨ�壬�ڲ��������û���Ϣ��get�Լ�set����
 * 
  * ��ǰ�汾��1.2
  * ���ߣ���֮��
  * ���ʱ�䣺2020.6.11
 * 
  * ȡ���汾��1.1
  * ԭ���ߣ���֮��
  * ������ڣ�2020.6.4
 */

public class User{
	int bid;
    String brealname;
	String buserpwd;
	String bonlinename;
	String bschool;
	String bsex;
	String btel;
	String bemail;
	public User(int bid, String brealname, String buserpwd, String bonlinename, String bschool, String bsex,
			String btel, String bemail) {
		super();
		this.bid = bid;
		this.brealname = brealname;
		this.buserpwd = buserpwd;
		this.bonlinename = bonlinename;
		this.bschool = bschool;
		this.bsex = bsex;
		this.btel = btel;
		this.bemail = bemail;
	}
	/**
	  * �������ܣ�bid���Ե�get����
	  * �����������
	  * ���������bid��ֵ
	  * ����ֵ������bid��ֵ
	  * ֮������get�����뵱ǰ�������ƣ����ٽ���һһ����
	 */
	public int getBid() {
		return bid;
	}
	/**
	  * �������ܣ�bid���Ե�set����
	  * ��������� bid
	  * �����������
	  * ����ֵ����
	  * ֮�����е�set�����뵱ǰ�������ƣ����ٽ���һһ����
	 */
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBrealname() {
		return brealname;
	}
	public void setBrealname(String brealname) {
		this.brealname = brealname;
	}
	public String getBuserpwd() {
		return buserpwd;
	}
	public void setBuserpwd(String buserpwd) {
		this.buserpwd = buserpwd;
	}
	public String getBonlinename() {
		return bonlinename;
	}
	public void setBonlinename(String bonlinename) {
		this.bonlinename = bonlinename;
	}
	public String getBschool() {
		return bschool;
	}
	public void setBschool(String bschool) {
		this.bschool = bschool;
	}
	public String getBsex() {
		return bsex;
	}
	public void setBsex(String bsex) {
		this.bsex = bsex;
	}
	public String getBtel() {
		return btel;
	}
	public void setBtel(String btel) {
		this.btel = btel;
	}
	public String getBemail() {
		return bemail;
	}
	public void setBemail(String bemail) {
		this.bemail = bemail;
	}
}

