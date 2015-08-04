package com.tastecoordi.web.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.tastecoordi.web.dao.MemberDao;
import com.tastecoordi.web.dao.mybatis.SqlNewlecSessionFactory;
import com.tastecoordi.web.vo.Member;

public class MyBatisMemberDao implements MemberDao {
	
	SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();

	@Override
	public int addMember(Member m) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		
		int result = 0;
		
		try{
			result = session.insert("com.tastecoordi.web.dao.MemberDao.addMember", m);
			session.commit();
		}
		finally{
			session.rollback();
			session.close();
		}
		
		return result;
	}
	
	/*public List<Member> getMembers( String field, String query) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("field", field);
		params.put("query", query);

		
		SqlSession session = factory.openSession();
		List<Member> list = session.selectList("getMembers", params);
		session.close();
		
		return list;
		
	}*/

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		
		SqlSession session = factory.openSession(); // 여러가지 DAO가 담긴 보따리에서 내가 원하는 DAO를 꺼내오는 것
	
		Member m = session.selectOne("com.tastecoordi.web.dao.MemberDao.getMember", id);
					
		session.close();
		return m;
	}

	@Override
	public int removeMember(String id) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		
		int result = 0;
		
		try{
			result = session.delete("com.tastecoordi.web.dao.MemberDao.removeMember", id);
			session.commit();
		}
		finally{
			session.rollback();
			session.close();
		}
		
		return result;
	}

	@Override
	public List<Member> getMembers(int page, String field, String query,
			String startDate, String endDate) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("field", field);
		params.put("query", query);
		params.put("startDate",startDate);
		params.put("endDate", endDate);
		
		SqlSession session = factory.openSession();
		List<Member> list = session.selectList("getMembers", params);
		session.close();
		
		return list;
		
	}

	@Override
	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		return getMembers(1,"name","","2015-04-09","2015-07-10");
	}

}
