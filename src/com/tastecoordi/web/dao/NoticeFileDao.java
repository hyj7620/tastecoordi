package com.tastecoordi.web.dao;

import java.util.List;

import com.tastecoordi.web.vo.NoticeFile;

public interface NoticeFileDao {

	//public NoticeFile getNoticeFile(String code);

	public int addNoticeFile(NoticeFile noticefile);
	
	public List<NoticeFile> getNoticeFileOfNotice(String code);
}
