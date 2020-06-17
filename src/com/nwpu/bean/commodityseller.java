package com.nwpu.bean;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：commodityseller.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件是卖家商品的定义，内部包含了各种卖家商品的get以及set方法，它继承了commodity的一切属性和方法
 * 
  * 当前版本：1.2
  * 作者：杨之正
  * 完成时间：2020.6.11
 * 
  * 取代版本：1.1
  * 原作者：杨之正
  * 完成日期：2020.6.4
 */

public class commodityseller extends commodity {
	private String sonlinename;
	private int srank;
	private String sschool;
	public commodityseller(int cid, int sid, String cname, float price, String picture, String describe, String type,
			int remark, String sonlinename, int srank, String sschool) {
		super(cid, sid, cname, price, picture, describe, type, remark);
		this.sonlinename = sonlinename;
		this.srank = srank;
		this.sschool = sschool;
	}
	/**
	  * 函数介绍：sonlinename属性的get方法
	  * 输入参数：无
	  * 输出参数：sonlinename的值
	  * 返回值：返回sonlinename的值
	  * 之后所有get方法与当前方法类似，不再进行一一罗列
	 */
	public String getSonlinename() {
		return sonlinename;
	}
	/**
	  * 函数介绍：sonlinename属性的set方法
	  * 输入参数：sonlinename
	  * 输出参数：无
	  * 返回值：无
	  * 之后所有的set方法与当前方法类似，不再进行一一罗列
	 */
	public void setSonlinename(String sonlinename) {
		this.sonlinename = sonlinename;
	}
	public int getSrank() {
		return srank;
	}
	public void setSrank(int srank) {
		this.srank = srank;
	}
	public String getSschool() {
		return sschool;
	}
	public void setSschool(String sschool) {
		this.sschool = sschool;
	}
	
	
}
