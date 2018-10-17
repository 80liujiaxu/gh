package com.example.demo.dto;

import java.util.List;

public class Xq {

	
	private Integer hid;
	
	private String bname;
	
	private int sex;
	
	private Integer status;
	
	private String g_date;
	
	private String g_time;
	
	private Wy wy;
	
	private KX kx;
	
	private String dh;


	public Integer getHid() {
		return hid;
	}


	public void setHid(Integer hid) {
		this.hid = hid;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getG_date() {
		return g_date;
	}


	public void setG_date(String g_date) {
		this.g_date = g_date;
	}


	public String getG_time() {
		return g_time;
	}


	public void setG_time(String g_time) {
		this.g_time = g_time;
	}


	public KX getKx() {
		return kx;
	}


	public void setKx(KX kx) {
		this.kx = kx;
	}


	public Wy getWy() {
		return wy;
	}


	public void setWy(Wy wy) {
		this.wy = wy;
	}


	
	public String getDh() {
		return dh;
	}


	public void setDh(String dh) {
		this.dh = dh;
	}


	@Override
	public String toString() {
		return "Xq [hid=" + hid + ", bname=" + bname + ", sex=" + sex + ", status=" + status + ", g_date=" + g_date
				+ ", g_time=" + g_time + ", wy=" + wy + ", kx=" + kx + "]";
	}


	
	


	
	
	
	
	
	
	
}
