package com.tastecoordi.web.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tastecoordi.web.dao.NoticeDao;
import com.tastecoordi.web.vo.Notice;

public class MyBatisNoticeDao implements NoticeDao {

	// 세션팩토리 변수로 빼줘서 선언.
	@Autowired
	private SqlSession session;

	/*
	 * @Autowired public void setSession(SqlSession session) { this.session =
	 * session; }
	 */

	@Override
	public int addNotice(Notice n) {
		// SqlSession session = factory.openSession();

		int result = 0;

		try {
			NoticeDao dao = session.getMapper(NoticeDao.class);
			result = dao.addNotice(n);
			
			/*result = session.insert(
					"com.tastecoordi.web.dao.NoticeDao.addNotice", n);*/
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}

		return result;
	}

	// 공지사항 조회
	@Override
	public List<Notice> getNotices(int page, String field, String query,
			String startDate, String endDate) {

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("field", field);
		params.put("query", query);
		params.put("startDate", startDate);
		params.put("endDate", endDate);

		// SqlSession session = factory.openSession();
		List<Notice> list = session.selectList("getNotices", params);
		//session.close();

		return list;
	}

	@Override
	public List<Notice> getNotices() {
		// TODO Auto-generated method stub
		return getNotices(1, "number", "", "2015-04-18", "2015-08-28");
	}

	@Override
	public Notice getNotice(String number) {
		// SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		return dao.getNotice(number);
	}

	@Override
	public int removeNotice(String number) {
		// TODO Auto-generated method stub
		// SqlSession session = factory.openSession();

		int result = 0;

		try {
			result = session.delete(
					"com.tastecoordi.web.dao.NoticeDao.removeNotice", number);
			session.commit();
		} finally {
			session.rollback();
			session.close();
		}

		return result;
	}

	@Override
	public int getLastNumber() {
		
		NoticeDao dao = session.getMapper(NoticeDao.class);
		return dao.getLastNumber();
	}

}
