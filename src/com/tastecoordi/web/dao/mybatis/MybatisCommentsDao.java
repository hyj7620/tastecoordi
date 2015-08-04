package com.tastecoordi.web.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tastecoordi.web.dao.ClothesDao;
import com.tastecoordi.web.dao.CommentsDao;
import com.tastecoordi.web.vo.Comments;
import com.tastecoordi.web.vo.Enterprise;

public class MybatisCommentsDao implements CommentsDao{

	@Autowired
	SqlSession session;
	//SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();
	
	@Override
	public List<Comments> getComments() {
		
		//SqlSession session = factory.openSession();
		CommentsDao dao = session.getMapper(CommentsDao.class);
		
		return getComments(1, "code", "");
		
		
	}

	@Override
	public List<Comments> getComments(int page) {
		
		//SqlSession session = factory.openSession();
		CommentsDao dao = session.getMapper(CommentsDao.class);
		
		return getComments(page, "code", "");
	}
	
	@Override
	public List<Comments> getComments(int page, String field, String query) {
		
		HashMap<String, Object>params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("field", field);
		params.put("query", query);

		//SqlSession session = factory.openSession();
		List<Comments> list = session.selectList("getComments", params);
		
		//session.close();
		
		return list;
	}
	

	@Override
	public int addComments(Comments c) {
		//SqlSession session = factory.openSession();
		/*MemberDao dao = session.getMapper(MemberDao.class);
		session.close();
		return dao.addMember(m);*/
		int result=0;
		try{
		result = session.insert("com.tastecoordi.web.dao.CommentsDao.addComments",c);
		session.commit();
		}
		finally{
		session.rollback();
		session.close();
		}
		return result;
	}

	@Override
	public int removeComments(String code) {
		//SqlSession session = factory.openSession();
		/*MemberDao dao = session.getMapper(MemberDao.class);
		session.close();
		return dao.removeMember(m);*/
		int result=0;
		try{
		result = session.delete("com.tastecoordi.web.dao.CommentsDao.removeComments", code);
		session.commit();
		}
		finally{
		session.rollback();
		session.close();
		}
		return result;
	}

	

}
