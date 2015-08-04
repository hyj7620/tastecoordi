package com.tastecoordi.web.dao;

import java.util.List;

import com.tastecoordi.web.vo.Coordination;

public interface CoordinationDao {
	public int addCodi(Coordination codi);

	public int delCodi(String code);

	public List<Coordination> getCodis(); // 모두출력

	public List<Coordination> getCodis(int page, String field, String query);
	
	public Coordination getCodi(String code);
}
