package com.tastecoordi.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tastecoordi.web.dao.NoticeDao;
import com.tastecoordi.web.dao.mybatis.MyBatisNoticeDao;
import com.tastecoordi.web.vo.Notice;

@WebServlet("/tastecoordi/notice")
public class NoticeController extends HttpServlet {
	
		
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		NoticeDao noticedao = new MyBatisNoticeDao();
		List<Notice> list = noticedao.getNotices();
		//List<Notice> list = noticedao.getNotices();
		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/tastecoordi/notice.jsp");
		dispatcher.forward(request, response);
	}

}
