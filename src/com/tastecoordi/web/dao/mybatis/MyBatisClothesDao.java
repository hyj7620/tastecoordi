package com.tastecoordi.web.dao.mybatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tastecoordi.web.dao.ClothesDao;
import com.tastecoordi.web.dao.CoordinationDao;
import com.tastecoordi.web.vo.Clothes;

public class MyBatisClothesDao implements ClothesDao {

	// 세션팩토리 변수로 빼줘서 선언.
	@Autowired
	private SqlSession session;
//------------------------------------
	
	@Override
	public int addClothes(Clothes c) throws ClassNotFoundException, SQLException {

		//SqlSession session = factory.openSession();
		int result = 0;

		try {
			ClothesDao dao=session.getMapper(ClothesDao.class);
			result = dao.addClothes(c);
			/*result = session.insert(
					"com.tastecoordi.web.dao.ClothesDao.addClothes", c);*/
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}

		return result;
	}

	

	@Override
	public int removeClothes(String code) throws ClassNotFoundException,
			SQLException {
		int result = 0;
		//SqlSession session = factory.openSession();

		try {
			result = session.delete(
					"com.tastecoordi.web.dao.ClothesDao.removeClothes", code);
			session.commit();
		} finally {
			session.rollback();
			session.close();

		}
		return result;
	}

	
	
	//의류 목록 조회
	@Override
	public List<Clothes> getClothes(int page, String field, String query,
			String startDate, String endDate) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("field", field);
		params.put("query", query);
		params.put("startDate", startDate);
		params.put("endDate", endDate);

		//SqlSession session = factory.openSession();
		List<Clothes> list = session.selectList("getClothes", params);
		//session.close();
		return list;
	}
	
	@Override
	public Clothes getCloth(String mid) throws ClassNotFoundException,
			SQLException {
		//SqlSession session = factory.openSession();
		Clothes c = session.selectOne(
				"com.tastecoordi.web.dao.ClothesDao.getCloth", mid);
		session.close();

		return c;
	}

	@Override
	public List<Clothes> getClothes() {
		//SqlSession session = factory.openSession();
		

		return getClothes(1, "CODE", "","2015-04-19","2015-08-28");
	
	}
	

}
