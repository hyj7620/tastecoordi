package com.tastecoordi.web.dao.mybatis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.tastecoordi.web.dao.JjimsDao;
import com.tastecoordi.web.vo.Jjims;

public class MybatisJjimsDao implements JjimsDao{

	SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();
	@Override
	public List<Jjims> getJjims(String mid, String clothesCode, Date regDate) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		params.put("mid", mid);
		params.put("clothesCode", clothesCode);
		params.put("regDate", regDate);
		
		SqlSession session = factory.openSession();
		//Member m = session.selectOne("com.freestyle.java.dao.mybatis...", uid);
		//MemberDao dao = session.getMapper(MemberDao.class);
		//return dao.getMembers(page, field, query, startDate, endDate);
		
		List<Jjims> list = session.selectList("getJjims", params);
		session.close();
		return list;
	}

	@Override
	public int addJjims(Jjims j) {
		SqlSession session = factory.openSession();
		/*MemberDao dao = session.getMapper(MemberDao.class);
		session.close();
		return dao.addMember(m);*/
		int result=0;
		try{
		result = session.insert("com.tastecoordi.web.dao.JjimsDao.addJjims",j);
		session.commit();
		}
		finally{
		session.rollback();
		session.close();
		}
		return result;
	}

	@Override
	public int removeJjims(String mid) {
		SqlSession session = factory.openSession();
		/*MemberDao dao = session.getMapper(MemberDao.class);
		session.close();
		return dao.removeMember(m);*/
		int result=0;
		try{
		result = session.delete("com.tastecoordi.web.dao.JjimsDao.removeJjims", mid);
		session.commit();
		}
		finally{
		session.rollback();
		session.close();
		}
		return result;
	}

}
