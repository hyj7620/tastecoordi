<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- JSTL 날짜변환 -->
    
    
    
<!--  ---------------------------------------------------------------------------   --> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TSNotice</title>
<link href="../resource/css/reset.css" type="text/css" rel="stylesheet"/>
<link href="../resource/css/layout.css" type="text/css" rel="stylesheet"/>
</head>

<div id = "top"></div>

<body id = "body">

   <header id="header">

      <h1>
         <img src="../resource/image/css/logo.png" alt="TASTES COORDI">
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

   <aside id= "aside">

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
               <li><a href="NoticeReg">공지등록</a></li>
               <li><a href="Notice">공지목록</a></li>
            </ul>
         </ul>
      </nav>

   </aside>


   <main id="main">
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
                     <td><input type = "checkbox" value = "선택"/> ${n.number}</td>
                     <td><a href="NoticeDetail?n=${n.number}">${n.content}</a></td>
                     
                     <td><fmt:formatDate value="${n.date}" pattern="yyyy-MM-dd"/></td>                     
                     <td>${n.link}</td>
                     <td>${n.image}</td>
                     <td>${n.mid}</td>
                     <td>수정 삭제</td>
                     
                      </tr>
               </c:forEach>
            </tbody>
         </table>
      </section>
      
   
  
   </main>


</body>
</html>