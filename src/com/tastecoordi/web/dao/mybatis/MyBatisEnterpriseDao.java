package com.tastecoordi.web.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.tastecoordi.web.dao.EnterpriseDao;
import com.tastecoordi.web.vo.Enterprise;



public class MyBatisEnterpriseDao implements EnterpriseDao {
	
	SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();

	
	@Override
	public int addEnterprise(Enterprise m) {
		SqlSession session = factory.openSession();
		int result = 0;
		
		try{
			result = session.insert("com.tastecoordi.web.dao.EnterpriseDao.addEnterprise ", m);
			session.commit();
		}
		finally{
			session.rollback();
			session.close();
		}
		
		return result;
	}

	@Override
	public int removeEnterprise(String uid) {
		SqlSession session = factory.openSession();
		int result = 0;
		
		try{
			result = session.delete("com.tastecoordi.web.dao.EnterpriseDao.removeEnterprise ", uid);
			session.commit();
		}
		finally{
			session.rollback();
			session.close();
		}
		
		return result;
	}

	@Override
	public Enterprise getEnterprise(String uid) {
		SqlSession session = factory.openSession();
		
	Enterprise m = session.selectOne("com.tastecoordi.web.dao.EnterpriseDao.getEnterprise",uid);
	
	   session.close();
			
	   return m;
	}

	@Override
	public List<Enterprise> getEnterprises(int page, String field, String query) {
		// TODO Auto-generated method stub

		HashMap<String, Object>params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("field", field);
		params.put("query", query);

		SqlSession session = factory.openSession();
		List<Enterprise> list = session.selectList("getEnterprise",params);
		
		session.close();
		
		return list;
	}

}
