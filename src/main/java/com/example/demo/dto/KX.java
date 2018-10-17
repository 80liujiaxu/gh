package com.example.demo.dto;

import java.util.List;

public class KX {

	
	private Integer kid;
	
	private String kname;
	
	private List<Wy> wy;
	
	

	public List<Wy> getWy() {
		return wy;
	}

	public void setWy(List<Wy> wy) {
		this.wy = wy;
	}

	public Integer getKid() {
		return kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	@Override
	public String toString() {
		return "KX [kid=" + kid + ", kname=" + kname + ", wy=" + wy + "]";
	}

	
	
}
