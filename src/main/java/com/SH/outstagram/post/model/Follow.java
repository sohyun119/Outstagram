package com.SH.outstagram.post.model;

import java.util.Date;

public class Follow {
	
	private int id;
	private int thisId;
	private String thisName;
	private int userId;
	private String userName;
	private Date creaetedAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getThisId() {
		return thisId;
	}
	public void setThisId(int thisId) {
		this.thisId = thisId;
	}
	public String getThisName() {
		return thisName;
	}
	public void setThisName(String thisName) {
		this.thisName = thisName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreaetedAt() {
		return creaetedAt;
	}
	public void setCreaetedAt(Date creaetedAt) {
		this.creaetedAt = creaetedAt;
	}
	
	

}
