package com.docto.shared;

import java.io.Serializable;

public class Everegistbeans implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegmobile() {
		return regmobile;
	}
	public void setRegmobile(String regmobile) {
		this.regmobile = regmobile;
	}
	public String email;
	public String address;
	public String regmobile;
	public String eventname;
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String date;
	

}
