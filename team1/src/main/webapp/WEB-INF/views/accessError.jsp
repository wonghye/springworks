<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 - 관리자 전용 페이지</title>
<link rel="stylesheet" href="/resources/css/font.css">
<link rel="stylesheet" href="/resources/css/style.css">
<style type="text/css">
#container{background-image: radial-gradient(circle, #9bc1f9, #bccffa, #d7ddfc, #ededfd, #ffffff);}
</style>
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<div id="container">
		<section id="role">
			<h1>Access Denied Page</h1>
			<h2 class="msg"><c:out value="${msg}" /></h2>
		</section>
	</div>
	<jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>