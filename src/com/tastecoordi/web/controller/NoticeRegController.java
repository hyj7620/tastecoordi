package com.tastecoordi.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.tastecoordi.web.dao.NoticeDao;
import com.tastecoordi.web.dao.NoticeFileDao;
import com.tastecoordi.web.dao.mybatis.MyBatisNoticeDao;
import com.tastecoordi.web.dao.mybatis.MyBatisNoticeFileDao;
import com.tastecoordi.web.vo.Notice;
import com.tastecoordi.web.vo.NoticeFile;

@WebServlet("/notice/noticeReg")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class NoticeRegController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getMethod().equals("POST"))// 포스트 요청이라면 객체 생성(조건 대문자로)
		{
			// 파일 등록
			Part part = request.getPart("file");
			ServletContext application = request.getServletContext();

			// 서버 경로설정(절대경로, 상대경로)
			String url = "/notice/upload"; // 웹페이지 url
			String path = application.getRealPath(url); // 홈페이지 url을 물리주소로 변환
			String temp = part.getSubmittedFileName();
			String fname = temp.substring(temp.lastIndexOf("\\") + 1);
			String fpath = path + "\\" + fname; // 문자열 더하기
			response.getWriter().println(fpath);

			// 파일 등록
			InputStream ins = part.getInputStream(); // 입력받기
			OutputStream outs = new FileOutputStream(fpath); // 출력하기

			byte[] 대야 = new byte[1024];
			int len = 0;

			while ((len = ins.read(대야, 0, 1024)) >= 0)
				outs.write(대야, 0, len);

			outs.flush();
			outs.close();
			ins.close();
			// -----------------------------------------------------------------

			String contnent = request.getParameter("contnent");
			String link = request.getParameter("link");
			String file = request.getParameter("file");

			Notice notice = new Notice();
			NoticeFile noticeFile = new NoticeFile(); // 파일 객체 생성

			notice.setContent(contnent);
			notice.setLink(link);
			// notice.setMid(mid);

			response.getWriter().println("<br/>" + contnent);
			NoticeDao noticedao = new MyBatisNoticeDao();
			noticedao.addNotice(notice);

			NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();
			noticeFile.setMid(fname);
			
			//noticeFile.setNoticeNumber(noticedao.getLastNumber);
			noticeFileDao.addNoticeFile(noticeFile);

			response.sendRedirect("Notice.jsp");

		}
		else {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/view/Notice/NoticeReg.jsp");
			dispatcher.forward(request, response);
		}
	
	}
}
