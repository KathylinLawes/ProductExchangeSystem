package com.nwpu.bean;

/**
 * Copyright (c) 2020,�����������
  * �ļ����ƣ�order.java
  * �ļ���ʶ�����У԰���ֽ���ϵͳ���˵����
  * ժ         Ҫ�����ļ��Ƕ������ඨ�壬�ڲ������˸�����Ʒ��get�Լ�set����
 * 
  * ��ǰ�汾��1.2
  * ���ߣ���֮��
  * ���ʱ�䣺2020.6.11
 * 
  * ȡ���汾��1.1
  * ԭ���ߣ���֮��
  * ������ڣ�2020.6.4
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
	  * �������ܣ�orderid���Ե�get����
	  * �����������
	  * ���������orderid��ֵ
	  * ����ֵ������orderid��ֵ
	  * ֮������get�����뵱ǰ�������ƣ����ٽ���һһ����
	 */
	public int getOrderid() {
		return orderid;
	}
	/**
	  * �������ܣ�orderid���Ե�set����
	  * ��������� orderid
	  * �����������
	  * ����ֵ����
	  * ֮�����е�set�����뵱ǰ�������ƣ����ٽ���һһ����
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
