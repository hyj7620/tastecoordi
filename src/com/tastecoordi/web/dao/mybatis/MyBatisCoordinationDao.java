package com.tastecoordi.web.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tastecoordi.web.dao.CoordinationDao;
import com.tastecoordi.web.vo.Coordination;
import com.tastecoordi.web.vo.Enterprise;

public class MyBatisCoordinationDao implements CoordinationDao {
	
	@Autowired
	SqlSession session;
	//SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();

	@Override
	public int addCodi(Coordination codi) {
		// TODO Auto-generated method stub
		//SqlSession session = factory.openSession();

		int result = 0;

		try {
			result = session.insert(
					"com.tastecoordi.web.dao.Coordination.addCodi", codi);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}

		return result;
	}

	@Override
	public int delCodi(String code) {

		//SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = session.delete(
					"com.tastecoordi.web.dao.Coordination.delCodi", code);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	@Override
	public List<Coordination> getCodis() {
		//SqlSession session = factory.openSession();
		CoordinationDao dao = session.getMapper(CoordinationDao.class);

		return dao.getCodis(1, "title", "");
	}

	@Override
	public List<Coordination> getCodis(int page, String field, String query) {
		
		HashMap<String, Object>params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("field", field);
		params.put("query", query);

		//SqlSession session = factory.openSession();
		List<Coordination> list = session.selectList("getCoordination",params);
		
		session.close();
		
		return list;
	}

	@Override
	public Coordination getCodi(String code) {
		//SqlSession session = factory.openSession();
		CoordinationDao dao = session.getMapper(CoordinationDao.class);
		return dao.getCodi(code);
	}

}
