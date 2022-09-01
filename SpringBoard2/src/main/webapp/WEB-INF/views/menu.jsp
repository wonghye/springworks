<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<nav>
	<security:authorize access="isAnonymous()">
		<ul>  
			<li><a href ="/">Home</a></li>
			<li><a href ="/member/signup">회원가입</a></li>
			<li><a href ="/customLogin">로그인</a></li>
			<li><a href ="/member/memberList">회원목록</a></li>
			<li><a href="/board/boardList">게시판</a></li>			
		</ul>
	</security:authorize>
	<security:authorize access="isAuthenticated()">
		<ul>
			<li><a href ="/">Home</a></li>
			<li><a href ="member/memberView">나의 정보</a></li>
			<li><a href ="/customLogout">로그아웃</a></li>
			<li><a href ="/member/memberList">회원목록</a></li>
			<li><a href="/board/boardList">게시판</a></li>
		</ul>
	</security:authorize>
	</nav>
</body>
</html>