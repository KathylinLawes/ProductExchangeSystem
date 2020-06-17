package com.nwpu.bean;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：Seller.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件是卖家信息的类定义，内部包含了卖家信息的get以及set方法
 * 
  * 当前版本：1.2
  * 作者：杨之正
  * 完成时间：2020.6.11
 * 
  * 取代版本：1.1
  * 原作者：杨之正
  * 完成日期：2020.6.4
 */

public class Seller {
	private int cid;
	private int id;
	private String cname;
	private float price;
	private int cnumbers;
	private String picture;
	private String cdescribe;
	private String selleronlinename;
	private int sellerrank;
	private String sellerschool;
	
	public Seller(int cid,int id, String cname, float price, int cnumbers, String picture, String cdescribe,String selleronlinename,int sellerrank,String sellerschool) {
		super();
		this.cid=cid;
		this.id = id;
		this.cname = cname;
		this.price = price;
		this.cnumbers = cnumbers;
		this.picture = picture;
		this.cdescribe = cdescribe;
		this.selleronlinename=selleronlinename;
		this.sellerrank=sellerrank;
		this.sellerschool=sellerschool;
	}
	/**
	  * 函数介绍：cid属性的get方法
	  * 输入参数：无
	  * 输出参数：cid的值
	  * 返回值：返回cid的值
	  * 之后所有get方法与当前方法类似，不再进行一一罗列
	 */
	public int getCid() {
		return cid;
	}
	/**
	  * 函数介绍：cid属性的set方法
	  * 输入参数： cid
	  * 输出参数：无
	  * 返回值：无
	  * 之后所有的set方法与当前方法类似，不再进行一一罗列
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCnumbers() {
		return cnumbers;
	}
	public void setCnumbers(int cnumbers) {
		this.cnumbers = cnumbers;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getCdescribe() {
		return cdescribe;
	}
	public void setCdescribe(String cdescribe) {
		this.cdescribe = cdescribe;
	}


	public String getSelleronlinename() {
		return selleronlinename;
	}


	public void setSelleronlinename(String selleronlinename) {
		this.selleronlinename = selleronlinename;
	}


	public int getSellerrank() {
		return sellerrank;
	}


	public void setSellerrank(int sellerrank) {
		this.sellerrank = sellerrank;
	}


	public String getSellerschool() {
		return sellerschool;
	}


	public void setSellerschool(String sellerschool) {
		this.sellerschool = sellerschool;
	}
	
	
}
