

<%@page import="com.tastecoordi.web.vo.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.tastecoordi.web.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.tastecoordi.web.dao.NoticeDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- JSTL 날짜변환 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
/* 	NoticeDao noticedao = new MyBatisNoticeDao(); */
	/* List<Notice> list = noticedao.getNotices(page, field, query, startDate, endDate); */	 /* list 지역변수 */
	/* request.setAttribute("list",list);	 *//* 저장소에 넣어줘야. */
%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
               <li><a href="">공지등록</a></li>
               <li><a href="">공지목록</a></li>
            </ul>
         </ul>
      </nav>

   </aside>


   <main>
   <section>
      <h1>메인메뉴</h1>


    <!--   <section id="lecture-search-form">
         <h1>상태폼</h1>
         <form>
            <fieldset>
               <legend>
                  <a href="">회원검색</a>
               </legend>
               <label>회원검색</label> <select>
                  <option>ID</option>
                  <option>이메일</option>
                  <option>닉네임</option>
               </select> <label>회원정보검색</label> <input type="text" /> <input type="submit"
                  value="검색" />
            </fieldset>
         </form>
      </section> -->


      <section>
         <h1>공지사항 목록</h1>
         <table>
            <thead>
               <tr>
                  <th>공지번호</th>
                  <th>내용</th>
                  <th>날짜</th>
                  <th>링크</th>
                  <th>이미지</th>
                  <th>아이디</th>
                  <th>관리<th>
               </tr>
            </thead>
            <tbody>

               <c:forEach var="n" items="${list}">
                  <tr>
                     <td>${n.number}</td>
                     <td>${n.content}</td>
                     <td>${n.regDate}</td>
                     <td>${n.link}</td>
                     <td>${n.image}</td>
                     <td>${n.mid}</td>
                     <td>수정 삭제</td>
                     
                      </tr>
               </c:forEach>
            </tbody>
         </table>
      </section>

      <nav>
         <h1>페이지목록</h1>
         <ul>
            <li><a href="">1</a></li>
            <li><a href="">2</a></li>
            <li><a href="">3</a></li>
         </ul>
      </nav>
   </section>


   </main>


</body>
</html>