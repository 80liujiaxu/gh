package com.example.demo.dto;

public class Wy {

	
	private Integer yid;
	
	private String yname;
	
	private Double price;
	

	public Integer getYid() {
		return yid;
	}

	public void setYid(Integer yid) {
		this.yid = yid;
	}

	public String getYname() {
		return yname;
	}

	public void setYname(String yname) {
		this.yname = yname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Wy [yid=" + yid + ", yname=" + yname + ", price=" + price + "]";
	}
	
	

}
