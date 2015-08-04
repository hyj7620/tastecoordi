
<%@page import="com.tastecoordi.web.dao.NoticeDao"%>
<%@page import="com.tastecoordi.web.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.tastecoordi.web.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	if (request.getMethod().equals("POST"))//포스트 요청이라면 객체 생성(조건 대문자로)
	{
		String contnent = request.getParameter("contnent");
		String link = request.getParameter("link"); 
		String file = request.getParameter("file");

		Notice notice = new Notice();
		notice.setContent(contnent);
				
		
		NoticeDao noticedao = new MyBatisNoticeDao();
		noticedao.addNotice(notice);
	
		
		response.sendRedirect("Notice.jsp");
		
	}
%>
    
    
    
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<section>
	<h1>공지사항 내용 ${header["host"]}</h1>

		<!-- 공지사항 내용 입력 폼 -->
			<form method="post">
				<fieldset>
					<legend>공지사항 정보</legend>
					<dl>
						<dt>제목</dt>
						<dd>
							<input name = "content"/></dd>
						<dt>링크</dt>
						<dd>
						<input name = "link"/></dd>
						</dd>
						<dt>이미지</dt>
						<dd>
							<input name = "file" type="file"  value="찾아보기"/>
						</dd>
					</dl>
					<div>
						<input  type="submit" value="등록">
					</div>
				</fieldset>
			</form>
		</section>
</body>
</html>