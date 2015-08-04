package com.tastecoordi.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tastecoordi.web.dao.NoticeDao;
import com.tastecoordi.web.dao.mybatis.MyBatisNoticeDao;
import com.tastecoordi.web.vo.Notice;


@WebServlet("/notice/NoticeDetail")
public class NoticeDetailController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		NoticeDao noticedao = new MyBatisNoticeDao();
		String number = request.getParameter("n"); // n포함한 넘버값(문자열) 가져오기
		
		Notice notice = noticedao.getNotice(number);
		
		request.setAttribute("n", notice);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/Notice/NoticeDetail.jsp");
		dispatcher.forward(request, response);
	}
}

