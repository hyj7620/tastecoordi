
<%@page import="com.tastecoordi.web.vo.Coordination"%>
<%@page import="com.tastecoordi.web.dao.mybatis.MyBatisCoordinationDao"%>
<%@page import="com.tastecoordi.web.dao.CoordinationDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	CoordinationDao coordinationdao = new MyBatisCoordinationDao();
	String code = request.getParameter("c");
	Coordination coordination=coordinationdao.getCodi(code);

%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

		<h1>메뉴</h1>

		<ul>
			<!-- 	<li><a href="마이페이지 주소"><img src="../마이페이지 버튼 이미지 주소"
					alt="마이페이지 버튼">Mypage</a></li>
			<li><a href="메인페이지 주소"><img src="../로그아웃 버튼 이미지 주소"
					alt="로그아웃 버튼">Log Out</a></li>
			<li><a href="코디페이지 주소"><img src="../코디 버튼 이미지 주소"
					alt="코디페이지 버튼">Coordi</a></li>
			<li><a href="검색창 주소"><img src="../검색 버튼 이미지 주소"
					alt="검색버튼 버튼">Search</a></li>
			<li><a href="Q&A 주소"><img src="../Q&A 버튼 주소"
					alt="Q&A 버튼">Q&A</a></li>
			<li><a href="회사소개 주소"><img src="../회사소개 버튼 주소"
					alt="회사소개 버튼">company</a></li> -->

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
				BlueSky01
				<!-- 코디명 불러와야 함 ${c.title}-->
				<footer>created by ssh0101</footer> <!-- 멤버아이디 불러와야 함. ${c.mid} -->
			</section>

			<article>
				<h1>설명</h1>
				설명 :
				<p>시원해보이는 데이트룩</p>	<!-- 코디 등록시 입력한거 불러와야 함. -->

				<form>
					<h1>댓글</h1>
					<legend>
						<label>댓글</label> 
						
						<input type="text" /> <input type="submit"
							vaule="입력" />
						
					</legend>
				</form>
				<section>
					<h1>댓글 목록</h1>
					<table>
						<thead>
							<tr>
								<th>작성자</th>
								<th>댓글내용</th>
								<th>날짜</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${n.mid}</td>
								<td>${n.content}</td>
								<td>${n.regdate}</td>
							</tr>
						</tbody>
					</table>

				</section>

			</article>

			<nav>
				<h1>프로필 사진, 좋아요</h1>
				<ul>
					<li><a href=""><img src="" alt="프로필 사진"></a></li>
					<li><a href=""><img src="" alt="팔로우 이미지"></a></li>
					<li><a href=""><img src="" alt="좋아요 이미지"></a></li>
				</ul>
			</nav>
		</section>

		<nav>
			<h1>Overview</h1>	<!-- 이미지 리스트로 출력 가로 5개, 줄바꿈. css로-->
			<ul>
				<li><a href=""><img src="" alt="이미지1"></a></li>
				<li><a href=""><img src="" alt="이미지2"></a></li>
				<li><a href=""><img src="" alt="이미지3"></a></li>
				<li><a href=""><img src="" alt="이미지4"></a></li>
				<li><a href=""><img src="" alt="이미지5"></a></li>
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