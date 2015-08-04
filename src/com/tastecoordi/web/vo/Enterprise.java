package com.tastecoordi.web.vo;

import java.util.Date;

public class Enterprise {
	private String MID;
	private String Link;
	private String PhoneNumber;
	private Date AllowDay;
	private Date RequestDate;

	
	
	public String getMID() {
		return MID;
	}
	public void setMID(String mID) {
		MID = mID;
	}
	public Date getRequestDate() {
		return RequestDate;
	}
	public void setRequestDate(Date requestDate) {
		RequestDate = requestDate;
	}
	public Date getAllowDay() {
		return AllowDay;
	}
	public void setAllowDay(Date allowDay) {
		AllowDay = allowDay;
	}

	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}


}