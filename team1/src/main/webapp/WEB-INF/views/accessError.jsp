<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error 처리 </title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<jsp:include page="./menu.jsp"/>
	<div id="container">
		<section id="error">
			<h1 class="main">Access Denied Page</h1>
			
			<h2><c:out value="${msg }" /> </h2>
		</section>
	</div>
	<jsp:include page="./footer.jsp" />
</body>
</html>