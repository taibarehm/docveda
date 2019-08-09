package com.docto.shared;

import java.io.Serializable;

public class Csumm implements Serializable {
	
	

	private static final long serialVersionUID = 1L;
	public int Id;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getLodata() {
		return lodata;
	}
	public void setLodata(String lodata) {
		this.lodata = lodata;
	}
	public String getSumm() {
		return summ;
	}
	public void setSumm(String summ) {
		this.summ = summ;
	}
	public String heading;
	public String lodata;
	public String summ;

}
