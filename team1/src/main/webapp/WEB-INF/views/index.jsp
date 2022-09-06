<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="./menu.jsp"/>
	<div class="heavy-rain-gradient color-block mb-3 mx-auto rounded-circle z-depth-1-half">
		<section id="main">
			<div class="main">
				<h2>메인</h2>
			</div>
			
			<!-- <h4>
				<a href="/customLogin">로그인</a> &nbsp;&nbsp;
				<a href="/member/signup">회원가입</a> &nbsp;&nbsp;
				<a href="/board/boardList">게시판</a>&nbsp;&nbsp;
			</h4> -->
		</section>
		
	</div>
	<jsp:include page="./footer.jsp" />
</body>
</html>