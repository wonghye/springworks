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
			<img src="/resources/images/tra.jpg" alt="석양" id="pic">
			<!-- <h4>
				<a href="/customLogin">로그인</a> &nbsp;&nbsp;
				<a href="/member/signup">회원가입</a> &nbsp;&nbsp;
				<a href="/board/boardList">게시판</a>&nbsp;&nbsp;
			</h4> -->
		</section>
		
	</div>
	<jsp:include page="./footer.jsp" />
	<script type="text/javascript">
		//메인 이미지 슬라이드 효과
		let picture = ["/resources/images/tra.jpg", "/resources/images/activity.jpg"];
		let idx = 0;
		
		slideShow(); //함수 호출
		
		function slideShow() {
			document.getElementById("pic").src = picture[idx];
			idx++;
			if(idx == picture.length)
				idx = 0;
			setTimeout(slideShow, 2000);	//2초 간격, 콜백 함수 (괄호 생략)
		}
	</script>
</body>
</html>