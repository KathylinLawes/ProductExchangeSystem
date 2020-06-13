package com.nwpu.bean;

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
	public int getOrderid() {
		return orderid;
	}
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
