package com.docto.shared;

import java.io.Serializable;

public class News implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String Heading;
	String Upload;
	String Desc;
	
	public String getHeading() {
		return Heading;
	}
	public void setHeading(String heading) {
		Heading = heading;
	}
	public String getUpload() {
		return Upload;
	}
	public void setUpload(String upload) {
		this.Upload = upload;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		this.Desc = desc;
	}


}
