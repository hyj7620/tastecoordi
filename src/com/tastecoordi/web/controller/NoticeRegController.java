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

		if (request.getMethod().equals("POST"))// ����Ʈ ��û�̶�� ��ü ����(���� �빮�ڷ�)
		{
			// ���� ���
			Part part = request.getPart("file");
			ServletContext application = request.getServletContext();

			// ���� ��μ���(������, �����)
			String url = "/notice/upload"; // �������� url
			String path = application.getRealPath(url); // Ȩ������ url�� �����ּҷ� ��ȯ
			String temp = part.getSubmittedFileName();
			String fname = temp.substring(temp.lastIndexOf("\\") + 1);
			String fpath = path + "\\" + fname; // ���ڿ� ���ϱ�
			response.getWriter().println(fpath);

			// ���� ���
			InputStream ins = part.getInputStream(); // �Է¹ޱ�
			OutputStream outs = new FileOutputStream(fpath); // ����ϱ�

			byte[] ��� = new byte[1024];
			int len = 0;

			while ((len = ins.read(���, 0, 1024)) >= 0)
				outs.write(���, 0, len);

			outs.flush();
			outs.close();
			ins.close();
			// -----------------------------------------------------------------

			String contnent = request.getParameter("contnent");
			String link = request.getParameter("link");
			String file = request.getParameter("file");

			Notice notice = new Notice();
			NoticeFile noticeFile = new NoticeFile(); // ���� ��ü ����

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
