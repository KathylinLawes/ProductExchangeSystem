package com.nwpu.bean;

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
	public String getSonlinename() {
		return sonlinename;
	}
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
