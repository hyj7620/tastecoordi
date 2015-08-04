package com.tastecoordi.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tastecoordi.web.dao.ClothesCoordiDao;
import com.tastecoordi.web.dao.ClothesDao;
import com.tastecoordi.web.dao.CommentsDao;
import com.tastecoordi.web.dao.CoordinationDao;
import com.tastecoordi.web.vo.ClothesCoordi;
import com.tastecoordi.web.vo.Comments;
import com.tastecoordi.web.vo.Coordination;


@Controller
@RequestMapping("/CoordiDetailPage/*")
public class CoordiDetailController extends HttpServlet {

	private CoordinationDao coordinationDao;
	private CommentsDao commentsDao;
	private ClothesDao clothesDao;
	private ClothesCoordiDao clothesCoordiDao;
	

	
	@Autowired
	public void setClothesCoordiDao(ClothesCoordiDao clothesCoordiDao) {
		this.clothesCoordiDao = clothesCoordiDao;
	}

	@Autowired
	public void setCoordinationDao(CoordinationDao coordinationDao) {
		this.coordinationDao = coordinationDao;
	}
	
	@Autowired
	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}
	
	@Autowired
	public void setClothesDao(ClothesDao clothesDao) {
		this.clothesDao = clothesDao;
	}
	
	@RequestMapping("CoordiDetailPage")
	public String coordinationDetail(Model model, String c){
		
		List<Comments> list = commentsDao.getComments();
		model.addAttribute("list", list);
		
		
		
		model.addAttribute("codi", coordinationDao.getCodi(c));
		//코디 하나에 대한 정보
		
		/*String code = request.getParameter("c");	//코디 룸페이지에서 c 넘겨줘야.(notice.jsp 100번째 줄 참고)
		Coordination codi = coordinationDao.getCodi(code);
		model.addAttribute("codi", codi);*/
	
		//코디 리스트
				
				List<Coordination> codilist = coordinationDao.getCodis();
				model.addAttribute("codilist", codilist);
		
		//코디에 사용된 아이템 리스트
			
			/*List<Clothes> clotheslist = clothesDao.getClothes();
			model.addAttribute("clotheslist", clotheslist);*/
		List<ClothesCoordi>	clotheslist = clothesCoordiDao.getCCs(c);
		model.addAttribute("clotheslist", clotheslist);		
	

		return "/WEB-INF/view/CoordiDetailPage/CoordiDetailPage.jsp";
		
		
	}
	

	
	
/*	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CommentsDao commentsDao = new MybatisCommentsDao();
		List<Comments> list = commentsDao.getComments();
		request.setAttribute("list", list);
		
		
		
		
		//코디 하나에 대한 정보
		CoordinationDao coordinationDao = new MyBatisCoordinationDao();
		String code = request.getParameter("c");	//코디 룸페이지에서 c 넘겨줘야.(notice.jsp 100번째 줄 참고)
		Coordination codi = coordinationDao.getCodi(code);
		request.setAttribute("codi", codi);
		
		//코디 리스트
				CoordinationDao coordinationDao = new MyBatisCoordinationDao();
				List<Coordination> codilist = coordinationDao.getCodis();
				request.setAttribute("codilist", codilist);
		
		//코디에 사용된 아이템 리스트
			ClothesDao clothesDao = new MyBatisClothesDao();
			List<Clothes> clotheslist = clothesDao.getClothes();
			request.setAttribute("clotheslist", clotheslist);
				
		

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/CoordiDetailPage/CoordiDetailPage.jsp");
		dispatcher.forward(request, response);

	}*/
}
