package com.nwpu.bean;

/**
 * Copyright (c) 2020,�����������
  * �ļ����ƣ�Seller.java
  * �ļ���ʶ�����У԰���ֽ���ϵͳ���˵����
  * ժ         Ҫ�����ļ���������Ϣ���ඨ�壬�ڲ�������������Ϣ��get�Լ�set����
 * 
  * ��ǰ�汾��1.2
  * ���ߣ���֮��
  * ���ʱ�䣺2020.6.11
 * 
  * ȡ���汾��1.1
  * ԭ���ߣ���֮��
  * ������ڣ�2020.6.4
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
	  * �������ܣ�cid���Ե�get����
	  * �����������
	  * ���������cid��ֵ
	  * ����ֵ������cid��ֵ
	  * ֮������get�����뵱ǰ�������ƣ����ٽ���һһ����
	 */
	public int getCid() {
		return cid;
	}
	/**
	  * �������ܣ�cid���Ե�set����
	  * ��������� cid
	  * �����������
	  * ����ֵ����
	  * ֮�����е�set�����뵱ǰ�������ƣ����ٽ���һһ����
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
