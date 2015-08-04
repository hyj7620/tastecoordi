package com.tastecoordi.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.tastecoordi.web.vo.Clothes;

public interface ClothesDao {

	public int addClothes(Clothes c) throws ClassNotFoundException,
			SQLException;

	public List<Clothes> getClothes(int page, String field, String query,
			String startDate, String endDate);

	public int removeClothes(String mid) throws ClassNotFoundException,
			SQLException;

	public Clothes getCloth(String mid) throws ClassNotFoundException,
			SQLException;

	public List<Clothes> getClothes();

}
