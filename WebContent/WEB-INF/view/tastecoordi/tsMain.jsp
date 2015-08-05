
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	/* CoordinationDao coordinationDao = new MyBatisCoordinationDao();
	List<Coordination> list = coordinationDao.getCoordinations();
	request.setAttribute("list", list);  */
%>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>>tsMAIN</title>
<link href="../resource/css/reset.css" type="text/css" rel="stylesheet" />
<link href="../resource/css/layout.css" type="text/css" rel="stylesheet" />
</head>
<body>

<body>
	<div id="top">
		<!-- <div class="content-wrapper"> -->
		<h1 class="Hidden">top</h1>
		<!-- </div> -->
	</div>

	<aside id="aside">
		<div class="content-wrapper">
			<h1 class="Hidden">전체메뉴</h1>
			<nav>
				<h1 class="Hidden">메뉴</h1>
				<ul>
					<li><a href=""><img src="../resource/image/css/mypage-icon.png"
							alt="Mypage"></a></li>
					<li><a href=""><img src="../resource/image/css/login-icon.png"
							alt="Login"></a></li>
					<li><a href=""><img src="../resource/image/css/coordi-icon.png"
							alt="Coordi"></a></li>
					<li><a href=""><img src="../resource/image/css/search-icon.png"
							alt="Search"></a></li>


					<!-- <form>

						<fieldset> -->
					<!-- 			<legend>검색정보</legend>
							<h3>스타일검색</h3>
							<label>스타일</label> <select>
								<option value=cj>캐쥬얼</option>
								<option value=dd>댄디</option>
								<option value=ro>로맨틱</option>
								<option value=cl>클래식</option>
								<option value=bo>보이쉬</option>
								<option value=hh>힙합</option>
								<option value=ss>섹시</option>
								<option value=vv>빈티지</option>
								<option value=of>오피스</option>
							</select>
							<h3>아이템검색1</h3>
							<label>카테고리</label> <select>
								<option value=top>상의</option>
								<option value=bot>하의</option>
								<option value=out>아우터</option>
								<option value=dre>원피스</option>
								<option value=sho>신발</option>
								<option value=acc>잡화</option>
							</select> <label>색상필드</label><select>
								<option value=red>빨강</option>
								<option value=org>주황</option>
								<option value=yel>노랑</option>
								<option value=grn>초록</option>
								<option value=blu>파랑</option>
								<option value=nav>남색</option>
								<option value=pur>보라</option>
								<option value=blc>검정</option>
								<option value=gry>회색</option>
								<option value=pik>분홍</option>
								<option value=beg>베이지</option>
								<option value=brw>갈색</option>
								<option value=wht>흰색</option>
							</select>

							<h3>아이템검색2</h3>
							<label>카테고리</label> <select>
								<option value=top>상의</option>
								<option value=bot>하의</option>
								<option value=out>아우터</option>
								<option value=dre>원피스</option>
								<option value=sho>신발</option>
								<option value=acc>잡화</option>
							</select> <label>색상필드</label><select>
								<option value=red>빨강</option>
								<option value=org>주황</option>
								<option value=yel>노랑</option>
								<option value=grn>초록</option>
								<option value=blu>파랑</option>
								<option value=nav>남색</option>
								<option value=pur>보라</option>
								<option value=blc>검정</option>
								<option value=gry>회색</option>
								<option value=pik>분홍</option>
								<option value=beg>베이지</option>
								<option value=brw>갈색</option>
								<option value=wht>흰색</option>
							</select>

							<h3>아이템검색3</h3>
							<label>카테고리</label> <select>
								<option value=top>상의</option>
								<option value=bot>하의</option>
								<option value=out>아우터</option>
								<option value=dre>원피스</option>
								<option value=sho>신발</option>
								<option value=acc>잡화</option>
							</select> <label>색상필드</label><select>
								<option value=red>빨강</option>
								<option value=org>주황</option>
								<option value=yel>노랑</option>
								<option value=grn>초록</option>
								<option value=blu>파랑</option>
								<option value=nav>남색</option>
								<option value=pur>보라</option>
								<option value=blc>검정</option>
								<option value=gry>회색</option>
								<option value=pik>분홍</option>
								<option value=beg>베이지</option>
								<option value=brw>갈색</option>
								<option value=wht>흰색</option>
							</select>

						</fieldset> -->
					<li><a href=""><img
							src="../resource/image/css/company-icon.png" alt="Company"></a></li>
					<li><a href=""><img src="../resource/image/css/q&a-icon.png"alt="Q&A"></a></li>
				</ul>
			</nav>
		</div>
	</aside>



	<header id="header">
		<div class="content-wrapper">
			<h1 class="Hidden">로고</h1>
			<nav>
				<h1>
					<img src="../resource/image/css/logo.png" alt="TASTES COORDI">
				</h1>
			</nav>
		</div>
	</header>

<div class="fix"></div>

	<main id="main">
	<div class="content-wrapper clearfix">
		<section>
			<h1 class="Hidden">메인메뉴</h1>


			<section>
				<h3 class="Hidden">배너창</h3>
				<h1>
					<img src="../resource/image/css/bn.JPG" alt="배너">
				</h1>
			</section>

		</section>

		<section>
			<h1>코디목록</h1>
			<c:forEach var="n" items="${list}">
		
				<ul>
					<li><img src="../resource/image/css/codi1.JPG" alt="코디이미지">${n.img}</li>
					<li>${n.img}</li>
					<li><img src="../resource/image/css/pro.JPG" alt="프로필이미지"></li>
					<li>${n.mid}</li>
					<li><img src="../resource/image/css/view.JPG" alt="뷰이미지"></li>
					<li>${n.hit}</li>
					<li><img src="../resource/image/css/like.JPG" alt="코디이미지"></li>
					<li>${n.likeCnt}</li>
					<li><img src="../resource/image/css/nt.JPG" alt="코디이미지"></li>
					<li>${n.cmtCnt}</li>
				</ul>
			</c:forEach>

		</section>

		<nav>
			<h1>페이지목록</h1>
			<ul>
				<li><a href="">1</a></li>
				<li><a href="">2</a></li>
				<li><a href="">3</a></li>
			</ul>
		</nav>
	</div>
	</main>


	<footer id="footer">
		<div class="content-wrapper">
			<section>
				<h1>저작권정보</h1>
				<p>FreeStyle Copyrightⓒ2015</p>
			</section>
		</div>
	</footer>
</body>
</html>