<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<jsp:include page="./menu.jsp"/>
	<div id="container">
		<section id="main">
			<div class="main">
				<h2>메인 페이지입니다.</h2>
			</div>
			<img src="/resources/images/activity.jpg" alt="행글라이더">
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