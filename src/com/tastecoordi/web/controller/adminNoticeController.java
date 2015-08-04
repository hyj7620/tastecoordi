package com.tastecoordi.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.tastecoordi.web.dao.NoticeDao;
import com.tastecoordi.web.dao.NoticeFileDao;
import com.tastecoordi.web.vo.Notice;
import com.tastecoordi.web.vo.NoticeFile;

@Controller
@RequestMapping("/customer/*")
public class adminNoticeController {

	private NoticeDao noticeDao;
	private NoticeFileDao noticeFileDao;

	@Autowired
	public void setNoticeFileDao(NoticeFileDao noticeFileDao) {
		this.noticeFileDao = noticeFileDao;
	}

	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	// notice 불러오기
	@RequestMapping("notice")
	// 별표 대신 들어갈 것들
	public String notice(Model model) {
		// NoticeDao noticeDao = new MybatisNoticeDao();
		List<Notice> list = noticeDao.getNotices();

		model.addAttribute("list", list);

		return "/WEB-INF/view/tastecoordi/notice.jsp";
	}

	@RequestMapping("noticeDetail")
	public String noticeDetail(String c, Model model) {

		Notice n = noticeDao.getNotice(c);
		model.addAttribute("n", n);
		return "/WEB-INF/view/tastecoordi/noticeDetail.jsp";
	}

	
	
	//notice emdfhr
	
	@RequestMapping(value = "noticeReg", method = RequestMethod.GET)
	public String noticeReg() {
		return "/WEB-INF/view/tastecoordi/noticeReg.jsp";
	}

	@RequestMapping(value = "noticeReg", method = RequestMethod.POST)
	public String noticeReg(Notice n, MultipartFile file,
			HttpServletRequest request) throws IOException {

		noticeDao.addNotice(n);
		int lastNumber = noticeDao.getLastNumber();

		if (!file.isEmpty()) {
			ServletContext application = request.getServletContext();

			String url = "/resource/image/notice";
			String path = application.getRealPath(url);
			String temp = file.getOriginalFilename();
			String fname = temp.substring(temp.lastIndexOf("\\") + 1);
			String fpath = path+ "\\"+fname;
			
			InputStream ins = file.getInputStream();
			OutputStream outs = new FileOutputStream(fpath);
			
			byte[] 대야 = new byte[1024];
			int len = 0;

			while ((len = ins.read(대야, 0, 1024)) >= 0)
			outs.write(대야, 0, len);

			outs.flush();
			outs.close();
			ins.close();
			
			NoticeFile noticeFile = new NoticeFile();
			noticeFile.setCode(fname);
			noticeFile.setNoticeNumber(lastNumber);
			noticeFileDao.addNoticeFile(noticeFile);
			}
		return "redirect:notice";
	}

}
