package com.nwpu.bean;

public class User{
	int bid;
    String brealname;
	String buserpwd;
	String bonlinename;
	String bschool;
	String bsex;
	String btel;
	String bemail;
	public User(int bid, String brealname, String buserpwd, String bonlinename, String bschool, String bsex,
			String btel, String bemail) {
		super();
		this.bid = bid;
		this.brealname = brealname;
		this.buserpwd = buserpwd;
		this.bonlinename = bonlinename;
		this.bschool = bschool;
		this.bsex = bsex;
		this.btel = btel;
		this.bemail = bemail;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBrealname() {
		return brealname;
	}
	public void setBrealname(String brealname) {
		this.brealname = brealname;
	}
	public String getBuserpwd() {
		return buserpwd;
	}
	public void setBuserpwd(String buserpwd) {
		this.buserpwd = buserpwd;
	}
	public String getBonlinename() {
		return bonlinename;
	}
	public void setBonlinename(String bonlinename) {
		this.bonlinename = bonlinename;
	}
	public String getBschool() {
		return bschool;
	}
	public void setBschool(String bschool) {
		this.bschool = bschool;
	}
	public String getBsex() {
		return bsex;
	}
	public void setBsex(String bsex) {
		this.bsex = bsex;
	}
	public String getBtel() {
		return btel;
	}
	public void setBtel(String btel) {
		this.btel = btel;
	}
	public String getBemail() {
		return bemail;
	}
	public void setBemail(String bemail) {
		this.bemail = bemail;
	}
}

