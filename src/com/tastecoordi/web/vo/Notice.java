package com.tastecoordi.web.vo;

import java.util.Date;
import java.util.List;



public class Notice {

	private int number;
	private String content;
	private Date date;
	private String link;
	private String image;
	private String mid;

	
	public List<NoticeFile> files;
	
		
	public List<NoticeFile> getFiles() {
		return files;
	}

	public void setFiles(List<NoticeFile> files) {
		this.files = files;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

}
