package com.docto.shared;

import java.io.Serializable;

public class Summm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String search;
	public String heading;
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public  String getLodata() {
		return lodata;
	}
	public void setLodata(String lodata) {
		this.lodata = lodata;
	}
	public String getSumm() {
		return summ;
	}
	public  void setSumm(String summ) {
		this.summ = summ;
	}
	public String lodata;
	public String summ;

}
