package com.nwpu.bean;

/**
 * Copyright (c) 2020,�����������
  * �ļ����ƣ�shoppingcart.java
  * �ļ���ʶ�����У԰���ֽ���ϵͳ���˵����
  * ժ         Ҫ�����ļ��ǹ��ﳵ���ඨ�壬�ڲ������˹��ﳵ��Ϣ��get�Լ�set����
 * 
  * ��ǰ�汾��1.2
  * ���ߣ���֮��
  * ���ʱ�䣺2020.6.11
 * 
  * ȡ���汾��1.1
  * ԭ���ߣ���֮��
  * ������ڣ�2020.6.4
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
	  * �������ܣ�carid���Ե�get����
	  * �����������
	  * ���������carid��ֵ
	  * ����ֵ������carid��ֵ
	  * ֮������get�����뵱ǰ�������ƣ����ٽ���һһ����
	 */
	public int getCarid() {
		return carid;
	}
	/**
	  * �������ܣ�carid���Ե�set����
	  * ��������� carid
	  * �����������
	  * ����ֵ����
	  * ֮�����е�set�����뵱ǰ�������ƣ����ٽ���һһ����
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
