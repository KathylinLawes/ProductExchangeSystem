package com.nwpu.bean;

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
	public int getCid() {
		return cid;
	}
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
