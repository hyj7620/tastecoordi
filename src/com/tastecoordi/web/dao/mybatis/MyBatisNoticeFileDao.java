package com.tastecoordi.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.tastecoordi.web.dao.NoticeFileDao;
import com.tastecoordi.web.vo.NoticeFile;

public class MyBatisNoticeFileDao implements NoticeFileDao {

	/*SqlSessionFactory factory = new SqlNewlecSessionFactory()
			.getSqlSessionFactory();*/

	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	

	/*@Override
	public NoticeFile getNoticeFile(String code) {
		//SqlSession session = factory.openSession();
		NoticeFileDao dao = session.getMapper(NoticeFileDao.class);
		
		return dao.getNoticeFile(code);
	}*/
	
	@Override
	public List<NoticeFile> getNoticeFileOfNotice(String code) {
		
		NoticeFileDao dao = session.getMapper(NoticeFileDao.class);
		List<NoticeFile> list = dao.getNoticeFileOfNotice(code);
		session.close();
		return list;
	}
	
	

	//공지사항 파일 추가
	@Override
	public int addNoticeFile(NoticeFile noticefile) {
		//SqlSession session = factory.openSession();
		int result = 0;
		try {
			NoticeFileDao dao = session.getMapper(NoticeFileDao.class);
			result = dao.addNoticeFile(noticefile);
			session.commit();
		} finally {
			session.rollback();
			session.commit();
		}
		return result;
	}


	
}
