package com.tastecoordi.web.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlNewlecSessionFactory extends HttpServlet {
	
	//프로그램이 실행될때마다 딱 한번 호출되는 static 생성자. instance가 만들어질때마다 호출되는 instance 생성자 
	
	
	public static SqlSessionFactory ssf;
	
	@Override
	public void init() throws ServletException {
		String resource = "com/tastecoordi/web/dao/mybatis/configuration.xml";
		InputStream inputStream = null;

		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ssf = new SqlSessionFactoryBuilder().build(inputStream);

	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		return ssf;
	}
	



}
