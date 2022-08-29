<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="container">
		<section id="login">
			<h2>�α���</h2>
			<c:if test="${error ==1 }">
				<p class="error">
					<c:out value="���̵� ��й�ȣ�� Ȯ�����ּ���! " />
				</p>
			</c:if>
			<form action="/login" method="post">
				<table class="tbl_login">
					<tr>
						<td>���̵�</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>��й�ȣ</td>
						<td><input type="password" name="passwd"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="�α���">
							<input type="reset" value="���">
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
</body>
</html>