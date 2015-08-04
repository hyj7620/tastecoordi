package com.tastecoordi.web.dao;

import java.util.List;

import com.tastecoordi.web.vo.ClothesCoordi;

public interface ClothesCoordiDao {
	public int addCC(ClothesCoordi cCodi);

	public int delCC(String code);

	public List<ClothesCoordi> getCCs(String code);

}
