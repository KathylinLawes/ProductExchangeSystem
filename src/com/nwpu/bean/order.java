package com.nwpu.bean;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：order.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件是订单的类定义，内部包含了各种商品的get以及set方法
 * 
  * 当前版本：1.2
  * 作者：杨之正
  * 完成时间：2020.6.11
 * 
  * 取代版本：1.1
  * 原作者：杨之正
  * 完成日期：2020.6.4
 */
public class order extends commodity {
	private int orderid;
	private String bid;
	private String btel;
	private String badress;
	private String stel;
	private String sadress;
	private String bonlinename;
	private String sonlinename;
	public order(int cid, int sid, String cname, float price, String picture, String describe, String type, int remark,
			int orderid, String bid, String btel, String badress, String stel, String sadress,String bonlinename,String sonlinename) {
		super(cid, sid, cname, price, picture, describe, type, remark);
		this.orderid = orderid;
		this.bid = bid;
		this.btel = btel;
		this.badress = badress;
		this.stel = stel;
		this.sadress = sadress;
		this.bonlinename=bonlinename;
		this.sonlinename = sonlinename;
	}
	/**
	  * 函数介绍：orderid属性的get方法
	  * 输入参数：无
	  * 输出参数：orderid的值
	  * 返回值：返回orderid的值
	  * 之后所有get方法与当前方法类似，不再进行一一罗列
	 */
	public int getOrderid() {
		return orderid;
	}
	/**
	  * 函数介绍：orderid属性的set方法
	  * 输入参数： orderid
	  * 输出参数：无
	  * 返回值：无
	  * 之后所有的set方法与当前方法类似，不再进行一一罗列
	 */
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBtel() {
		return btel;
	}
	public void setBtel(String btel) {
		this.btel = btel;
	}
	public String getBadress() {
		return badress;
	}
	public void setBadress(String badress) {
		this.badress = badress;
	}
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
	}
	public String getSadress() {
		return sadress;
	}
	public void setSadress(String sadress) {
		this.sadress = sadress;
	}
	public String getBonlinename() {
		return bonlinename;
	}
	public void setBonlinename(String bonlinename) {
		this.bonlinename = bonlinename;
	}
	public String getSonlinename() {
		return sonlinename;
	}
	public void setSonlinename(String sonlinename) {
		this.sonlinename = sonlinename;
	}
	
}
