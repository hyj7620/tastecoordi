
<%@page import="com.tastecoordi.web.vo.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.tastecoordi.web.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.tastecoordi.web.dao.NoticeDao"%>


<% /* if (request.getMethod().equals("POST"))//포스트 요청이라면 객체 생성(조건 대문자로)
	{
		String content = request.getParameter("content"); //사용자가 입력한 title
		String link = request.getParameter("link");
		String file = request.getParameter("file");
	

		Notice notice = new Notice();
		notice.setContent(content);
		//notice.setMid(mid);
		notice.setLink(link);

		NoticeDao noticedao = new MyBatisNoticeDao();
		noticedao.addNotice(notice);

		response.sendRedirect("Notice.jsp");

	} */%>







<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	/*  NoticeDao noticeDao = new MyBatisNoticeDao();
	 List<Notice> list = noticeDao.getNotices();

	 request.setAttribute("list", list); */
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TSMAIN</title>
</head>
<body>

	<header>

		<h1>
			<img src="../images/logo.png" alt="TASTES COORDI">
		</h1>
		<section>
			<h1>로고</h1>
			<section>
				<h1>상태폼</h1>
				<form>
					<fieldset>
						<legend>관리자모드</legend>
						<label>관리자모드</label><input type="submit" value="관리자모드" /> <label>로그인</label><input
							type="submit" value="로그아웃" />
					</fieldset>
				</form>
			</section>
		</section>
	</header>

	<aside>

		<h1>관리자메뉴</h1>
		<nav>
			<ul>
				<h1>회원</h1>
				<li><a href="">회원관리</a></li>
			</ul>
		</nav>

		<nav>
			<ul>
				<h1>업체</h1>
				<li><a href="">업체관리</a></li>
				<ul>
					<li><a href="">업체등록</a></li>
					<li><a href="">업체목록</a></li>
				</ul>
			</ul>
		</nav>
		<nav>
			<ul>
				<h1>상품</h1>
				<li><a href="">상품관리</a></li>
				<ul>
					<li><a href="">상품목록</a></li>
				</ul>
			</ul>
		</nav>
		<nav>
			<ul>
				<h1>공지</h1>
				<li><a href="">공지관리</a></li>
				<ul>
					<li><a href="noticeReg">공지등록</a></li>
					<li><a href="notice">공지목록</a></li>
				</ul>
			</ul>
		</nav>

	</aside>


	<main>
	<section>
		<h1>공지사항 내용</h1>

		<!-- 공지사항 내용 입력 폼 -->
		<form method="post">
			<fieldset>
				<legend>공지사항 정보</legend>
				<dl>
					<dt>제목</dt>
					<dd>
						<input name="content" />
					</dd>
					<dt>링크</dt>
					<dd>
						<input name="link" />
					</dd>
					</dd>
					<dt>이미지</dt>
					<dd>
						<input name="file" type="file" value="찾아보기" />
					</dd>
				</dl>
				<div>
					<input type="submit" value="등록">
					<a href = "Notice.jsp">취소</a>
				</div>
			</fieldset>
		</form>
	</section>

	</main>


</body>
</html>