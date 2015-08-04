package com.tastecoordi.web.dao;

import java.util.Date;
import java.util.List;

import com.tastecoordi.web.vo.Jjims;

public interface JjimsDao {
	public List<Jjims> getJjims(
			String mid,
			String clothesCode,
			Date regDate);
	
	public int addJjims(Jjims j);
	public int removeJjims(String mid);
}
