package com.two.body;

import java.io.Serializable;

public class Comments implements Serializable {
	private String ID=null;
	private String No=null;
	private String content=null;
	private java.sql.Date time=null;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.sql.Date getTime() {
		return time;
	}
	public void setTime(java.sql.Date time) {
		this.time = time;
	}
	
	

}
