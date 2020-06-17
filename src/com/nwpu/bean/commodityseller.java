package com.nwpu.bean;

/**
 * Copyright (c) 2020,�����������
  * �ļ����ƣ�commodityseller.java
  * �ļ���ʶ�����У԰���ֽ���ϵͳ���˵����
  * ժ         Ҫ�����ļ���������Ʒ�Ķ��壬�ڲ������˸���������Ʒ��get�Լ�set���������̳���commodity��һ�����Ժͷ���
 * 
  * ��ǰ�汾��1.2
  * ���ߣ���֮��
  * ���ʱ�䣺2020.6.11
 * 
  * ȡ���汾��1.1
  * ԭ���ߣ���֮��
  * ������ڣ�2020.6.4
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
	  * �������ܣ�sonlinename���Ե�get����
	  * �����������
	  * ���������sonlinename��ֵ
	  * ����ֵ������sonlinename��ֵ
	  * ֮������get�����뵱ǰ�������ƣ����ٽ���һһ����
	 */
	public String getSonlinename() {
		return sonlinename;
	}
	/**
	  * �������ܣ�sonlinename���Ե�set����
	  * ���������sonlinename
	  * �����������
	  * ����ֵ����
	  * ֮�����е�set�����뵱ǰ�������ƣ����ٽ���һһ����
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
