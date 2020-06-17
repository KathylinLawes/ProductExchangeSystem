package com.nwpu.bean;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：shoppingcart.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件是购物车的类定义，内部包含了购物车信息的get以及set方法
 * 
  * 当前版本：1.2
  * 作者：杨之正
  * 完成时间：2020.6.11
 * 
  * 取代版本：1.1
  * 原作者：杨之正
  * 完成日期：2020.6.4
 */

public class shoppingcart extends commodity {
	private int carid;
	private String bid;
	private String sonlinename;
	private String bonlinename;
	private String sschool;
	private String stel;
	public shoppingcart(int cid, int sid, String cname, float price, String picture, String describe, String type,
			int remark, int carid, String bid,String sonlinename,String bonlinename,String sschool,String stel) {
		super(cid, sid, cname, price, picture, describe, type, remark);
		this.carid = carid;
		this.bid = bid;
		this.sonlinename=sonlinename;
		this.bonlinename=bonlinename;
		this.sschool=sschool;
		this.stel=stel;
	}
	/**
	  * 函数介绍：carid属性的get方法
	  * 输入参数：无
	  * 输出参数：carid的值
	  * 返回值：返回carid的值
	  * 之后所有get方法与当前方法类似，不再进行一一罗列
	 */
	public int getCarid() {
		return carid;
	}
	/**
	  * 函数介绍：carid属性的set方法
	  * 输入参数： carid
	  * 输出参数：无
	  * 返回值：无
	  * 之后所有的set方法与当前方法类似，不再进行一一罗列
	 */
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getSonlinename() {
		return sonlinename;
	}
	public void setSonlinename(String sonlinename) {
		this.sonlinename = sonlinename;
	}
	public String getBonlinename() {
		return bonlinename;
	}
	public void setBonlinename(String bonlinename) {
		this.bonlinename = bonlinename;
	}
	public String getSschool() {
		return sschool;
	}
	public void setSschool(String sschool) {
		this.sschool = sschool;
	}
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
	}
	
}
