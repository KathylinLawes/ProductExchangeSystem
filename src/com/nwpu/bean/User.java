package com.nwpu.bean;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：User.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件是用户信息的类定义，内部包含了用户信息的get以及set方法
 * 
  * 当前版本：1.2
  * 作者：杨之正
  * 完成时间：2020.6.11
 * 
  * 取代版本：1.1
  * 原作者：杨之正
  * 完成日期：2020.6.4
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
	  * 函数介绍：bid属性的get方法
	  * 输入参数：无
	  * 输出参数：bid的值
	  * 返回值：返回bid的值
	  * 之后所有get方法与当前方法类似，不再进行一一罗列
	 */
	public int getBid() {
		return bid;
	}
	/**
	  * 函数介绍：bid属性的set方法
	  * 输入参数： bid
	  * 输出参数：无
	  * 返回值：无
	  * 之后所有的set方法与当前方法类似，不再进行一一罗列
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

