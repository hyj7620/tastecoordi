
<%@page import="com.tastecoordi.web.vo.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.tastecoordi.web.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.tastecoordi.web.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%
	NoticeDao noticedao = new MyBatisNoticeDao();
	List<Notice> list = noticedao.getNotices();	 /* list 지역변수 */
	
	request.setAttribute("list",list);	/* 저장소에 넣어줘야. */
%>   
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>

<section>
				<!--  for문 대신 JSTL 적용. 3번 반복 -->
				<h1>${i}공지사항 목록</h1>
			
			<table>
				<thead>
					<tr>
						<!-- <th>공지선택</th> -->
						<th>공지번호</th>
						<th>공지 내용</th>
						
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="n" items ="${list}" > 	<!--  for문 대신 JSTL 적용. list 개수만큼-->
				
					<tr>
						<%-- <td>${n.code}</td> --%>
						<td>${n.number}</td>
						<td><a href="Notice.jsp?c=${n.number}">${n.content}
						</a></td>
						
						<td>${n.mid}</td>
						<td>${n.date}</td>
						
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</section>

</body>
</html>