package com.nwpu.bean;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：commodity.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件是商品的类定义，内部包含了各种商品的get以及set方法
 * 
  * 当前版本：1.2
  * 作者：杨之正
  * 完成时间：2020.6.11
 * 
  * 取代版本：1.1
  * 原作者：杨之正
  * 完成日期：2020.6.4
 */

public class commodity {
	private int cid;         //商品id
	private int sid;         //卖家id
	private String cname;    //商品名称
	private float price;     //商品价格
	private String picture;  //商品图片位置
	private String describe; //商品描述
	private String type;     //商品类型
	private int remark;      //商品标记  
	public commodity(int cid, int sid, String cname, float price, String picture, String describe, String type,
			int remark) {
		super();
		this.cid = cid;
		this.sid = sid;
		this.cname = cname;
		this.price = price;
		this.picture = picture;
		this.describe = describe;
		this.type = type;
		this.remark = remark;
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
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRemark() {
		return remark;
	}
	public void setRemark(int remark) {
		this.remark = remark;
	}
	
	
}
