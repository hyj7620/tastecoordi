package com.tastecoordi.web.dao.mybatis;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.tastecoordi.web.dao.FollowDao;
import com.tastecoordi.web.dao.mybatis.SqlNewlecSessionFactory;
import com.tastecoordi.web.vo.Follow;

public class MyBatisFollowDao implements FollowDao {

	SqlSessionFactory factory = new SqlNewlecSessionFactory()
			.getSqlSessionFactory();


/*	@Override
	public int removeFollow(Follow f) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return 0;
	}*/

	@Override
	public int getfollow(Follow f) throws ClassNotFoundException, SQLException {
		
		return 0;
	}

	@Override
	public int removeFollow(String Mid) throws ClassNotFoundException,
			SQLException {
		SqlSession session = factory.openSession();

		int result = 0;
		try { // rollback½Ã try catch ¾²±â
			result = session.delete(
					"com.tastecoordi.web.dao.FollowDao.removeFollow",
					Mid);

			session.commit();
		} finally {
			session.rollback();
			session.close();

		}

		return result;
	}

	@Override
	public int addFollow(Follow f) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();

		int result = 0;

		try {
			result = session.insert(
					"com.tastecoordi.web.dao.FollowDao.addFollow", f);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}

		return result;
	}

	@Override
	public int removeFollow(Follow f) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return 0;
	}



}