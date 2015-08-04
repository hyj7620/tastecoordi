
<%@page import="com.tastecoordi.web.vo.Notice"%>
<%@page import="com.tastecoordi.web.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.tastecoordi.web.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	NoticeDao noticedao = new MyBatisNoticeDao();
	String code = request.getParameter("c"); //c포함한 코드값(문자열) 가져오기
	Notice n = noticedao.getNotice(code);
	request.setAttribute("n", n);
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<article>
	<h1>공지사항 내용 ${header["host"]}</h1>


	<dl>
		<dt>제목</dt>
		<dd>${n.title}</dd>
		<dt>작성일</dt>
		<dd>${n.regdate}</dd>
		<dt>작성자</dt>
		<dd>${n.writer}</dd>
		<dt>조회수</dt>
		<dd>${n.hit}</dd>
		<dt>첨부파일</dt>
		<dd></dd>
		<dt>내용</dt>
		<dd>${n.content}</dd>
	</dl>
	</article>

	<nav>
	<h1>버튼 목록</h1>
	<p>
		<a href="NoticeDetail.jsp">목록</a>
	</p>
	</nav>

</body>
</html>