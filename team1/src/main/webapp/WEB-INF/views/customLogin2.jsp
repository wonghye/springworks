<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<jsp:include page="./menu.jsp" />
	<div id="container">
		<section id="login">
			<h2>로그인</h2>
			<%-- <c:if test="${error == 1}">
				<p class="error">
					<c:out value="아이디나 비밀번호를 확인해 주세요." />
				</p>
			</c:if> --%>
			
			<h3 style="color:red"><c:out value="${error}"/></h3>
			
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
							<input type="reset" value="취소">
						</td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
			</form>
		
		</section>
	</div>
</body>
</html>