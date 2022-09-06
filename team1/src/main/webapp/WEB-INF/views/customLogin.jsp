<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="./menu.jsp"/>
	<div id="container">
		<section id="login">
			<h2 class="main">로그인</h2>
			
			<h3 class="error"><c:out value="${error }" /> </h3>
			<form action="/login" method="post">
				<table class="tbl_login">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인">
						</td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
			</form>
			
		</section>
	</div>
	<jsp:include page="./footer.jsp" />
</body>
</html>