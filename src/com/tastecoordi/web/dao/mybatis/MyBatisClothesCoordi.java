package com.tastecoordi.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tastecoordi.web.dao.ClothesCoordiDao;
import com.tastecoordi.web.vo.ClothesCoordi;

public class MyBatisClothesCoordi implements ClothesCoordiDao {

	//SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();
	@Autowired
	SqlSession session;

	@Override
	public int addCC(ClothesCoordi Codi) {
		// TODO Auto-generated method stub
		//SqlSession session = factory.openSession();

		int result = 0;

		try {
			result = session.insert(
					"com.tastecoordi.web.dao.ClothesCoordi.addCC", Codi);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}

		return result;
	}

	@Override
	public int delCC(String code) {
		// TODO Auto-generated method stub
		//SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = session.delete(
					"com.tastecoordi.web.dao.Coordination.delCC", code);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}
		return result;
	}

	@Override
	public List<ClothesCoordi> getCCs(String code) {
		//SqlSession session = factory.openSession();
		ClothesCoordiDao dao = session.getMapper(ClothesCoordiDao.class);

		return dao.getCCs(code);
	}

}
