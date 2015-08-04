
<%@page import="com.tastecoordi.web.vo.Comments"%>
<%@page import="java.util.List"%>
<%@page import="com.tastecoordi.web.dao.mybatis.MybatisCommentsDao"%>
<%@page import="com.tastecoordi.web.dao.CommentsDao"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	/* CommentsDao commentsDao = new MybatisCommentsDao();
	List<Comments> list = commentsDao.getComments();
	request.setAttribute("list", list); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	<header id="header 로고만.">
		<h1>
			<a href="메인페이지 링크주소"><img src="../ 로고 이미지 주소"
				alt="tastes coordi 로고"></a>
		</h1>
	</header>

	<aside>

		<h1>메인메뉴</h1>

		<ul>

			<li><a href="">Mypage</a></li>
			<li><a href="">Log Out</a></li>
			<li><a href="">Coordi</a></li>
			<li><a href="">Serch</a></li>
			<li><a href="">Q&A</a></li>
			<li><a href="">company</a></li>
		</ul>

	</aside>

	<section>

		<main>

		<h1>코디 상세페이지</h1>


		<section>
			<h1>코디 이미지</h1>
			<img src="" alt="코디 이미지">
		</section>

		<!-- 코디 상세페이지 우측 칸 -->
		<section>
			<h1>코디설명</h1>
			<section>
				<h1>코디 저작정보</h1>
				
				${codi.title} created by ${codi.mid}<br>
				


				<%-- <c:forEach var="d" items="${codilist}">
					${d.title} created by ${d.mid}<br>  <!-- 코디네이션의 제목? 코드?, 아이디 -->
				</c:forEach> --%>
			</section>

			<section>
				<h1>설명</h1>
				설명 :
				<p>
					<%-- ${d.title} --%>
				</p>
				<!-- 코디네이션의 타이틀. 코디 룸 등록시 입력한거 불러와야 함. -->


				<!-- 코디 댓글 입력 폼 -->
				<form>
					<fieldset>
						<legend>댓글</legend>
						<dl>
							<dd>
								<textarea cols="50" rows="5" name="content"></textarea>
							</dd>
						</dl>
						<div>
							<input type="submit" value="입력">
						</div>
					</fieldset>
				</form>



				<section>
					<h1>댓글 목록</h1>
					<table>
						<thead>

							<tr>
								<th>코드</th>
								<th>작성자</th>
								<th>코디코드</th>
								<th>날짜</th>
								<th>내용</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="n" items="${list}">
								<tr>
									<td>${n.code}</td>
									<td>${n.mid}</td>
									<td><a href="CoordiDetailPage?c=${n.codiCode}">${n.codiCode}</td>
									<td>${n.regDate}</td>
									<td>${n.content}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</section>

			</section>


			<nav>
				<h1>프로필 사진, 좋아요</h1>
				<ul>
					<li><a href=""><img src="" alt="프로필 사진"></a></li>
					<li><a href=""><img src="" alt="팔로우 이미지"></a></li>
					<li><a href=""
						onclick="javascript:window.open('LikePop.html','popup','scrollbars=no, resizable=no, width=300,height=200')";returnfalse">
							<img src="" alt="좋아요 이미지">
					</a></li>
					<!-- 좋아요 팝업창, 마이페이지로 이동 -->
				</ul>
			</nav>
		</section>

		<nav>
			<h1>Overview</h1>
			<!-- 이미지 리스트로 출력 가로 5개, 줄바꿈. css로-->
			<ul>
				<li><a href=""><img src="" alt="이미지1"></a></li>
				<li><a href=""><img src="" alt="이미지2"></a></li>
				
			<c:forEach var="co" items="${codilist}">
				<%-- <li>${n.code}</li> --%>
				<li>${co.img}</li>
				
				
			</c:forEach>
				
			</ul>
		</nav>


		<nav>
			<h1>해당 코디에 사용된 아이템</h1>
			<!-- 이미지 리스트로 출력 가로 5개, 줄바꿈. css로-->
			<ul>
				<li><a href=""><img src="" alt="이미지1"></a></li>
				<li><a href=""><img src="" alt="이미지2"></a></li>
				
				
			<c:forEach var="cl" items="${clotheslist}">
				<li>${cl.clothesCode}</li>
				<%-- <li>${cl.image}</li> --%>
			</c:forEach>	
				
			</ul>
		</nav>


		</main>
	</section>

	<footer>
		<section>
			<h1>저작권 정보</h1>
			<p>FreeStyle Copyrightⓒ2015</p>
		</section>
	</footer>


</body>
</html>