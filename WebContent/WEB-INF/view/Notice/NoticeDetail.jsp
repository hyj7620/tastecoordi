
<%@page import="com.tastecoordi.web.vo.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.tastecoordi.web.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.tastecoordi.web.dao.NoticeDao"%>
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
<title>TSNoticeDetail</title>
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
					<li><a href="">공지등록</a></li>
					<li><a href="">공지목록</a></li>
				</ul>
			</ul>
		</nav>

	</aside>


	<main>
	<section>

		<h1>공지사항 목록</h1>
		<dl>
			<dt>내용</dt>
			<dd>${n.content}</dd>
		</dl>
		<dl>
			<dt>작성일</dt>
			<dd>${n.date}</dd>
		</dl>
		<dl>
			<dt>작성자</dt>
			<dd>${n.mid}</dd>
		</dl>
		<dl>
			<dt>링크</dt>
			<dd>${n.link}</dd>
		</dl>
		<dl>
			<dt>이미지</dt>
			<dd>${n.image}</dd>
		</dl>


	</section>

	</main>


</body>
</html>