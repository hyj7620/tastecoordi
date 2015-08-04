package com.tastecoordi.web.dao;

import java.util.List;

import com.tastecoordi.web.vo.Notice;

public interface NoticeDao {

	/*public int addNotice(Notice n);

	public List<Notice> getNotices(int page, String field, String query);
	public List<Notice> getNotice(int page);
	public List<Notice> getNotices();

	public Notice getNotice(String number);
	public String getLastNumber();

	
	
	public int removeNotice(String number);*/

	// select update delete
	

	public List<Notice> getNotices(int page, String field, String query,
			String startDate, String endDate);
	public List<Notice> getNotices();
	
	public Notice getNotice(String number);
	
	public int addNotice(Notice n);
	public int removeNotice(String number);
	public int getLastNumber();	//15.07.27 Ãß°¡
}