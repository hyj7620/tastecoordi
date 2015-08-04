package com.tastecoordi.web.dao.mybatis;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.tastecoordi.web.dao.LikeDao;
import com.tastecoordi.web.vo.Like;

public class MyBatisLikeDao implements LikeDao {

	SqlSessionFactory factory = new SqlNewlecSessionFactory()
			.getSqlSessionFactory();

	@Override
	public int addLike(Like m) {
		SqlSession session = factory.openSession();

		int result = 0;

		try {
			result = session.insert("com.tastecoordi.web.dao.LikeDao.addLike",
					m);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}

		return result;
	}

	@Override
	public int removeLike(String uid) {

		SqlSession session = factory.openSession();
		int result = 0;

		try {
			result = session.delete(
					"com.tastecoordi.web.dao.LikeDao.removeLike ", uid);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}

		return result;

	}

	@Override
	public Like getLike(String uid) {
		SqlSession session = factory.openSession();

		Like m = session.selectOne("com.tastecoordi.web.dao.LikeDao.getLike",
				uid);

		session.close();

		return m;
	}

}
