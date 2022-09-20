<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무서운게 딱! 좋아!</title>
<link rel="stylesheet" href="/resources/css/style.css">
<style type="text/css">
.multiple-box-shadows {
  box-shadow: -5px -5px 30px 5px black, 5px 5px 30px 5px blue;
}
.dung {position: absolute; z-index: 99; width: 80px; height: 80px;
	   background: url("../resources/images/ghost1.png") no-repeat center / contain;
	   animation: dung 100s infinite linear;}
	   
@keyframes dung 
{ 0% {top:10%; left:80%;}
25% {top:25%; left:0;}
50% {top:50%; left:80%;}
75% {top:75%; left:0;}
100% {top:99%; left:80%;}
}
@font-face {
    font-family: 'SangSangRock';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/SangSangRockOTF.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
*{font-family: 'SangSangRock';}
#container{background-image: linear-gradient(to bottom, #d32929, #a42027, #761a21, #4b1418, #230a0a);}
.tbl_list td{color:#eee;}
</style>
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
</head>
<body>
   <jsp:include page="../menu.jsp"/>
   <div id="container">
      <section id="list">
         <h2 class="main" style="color:#eee"><strong>호러 게시판</strong></h2>
         <p class="dung"></p>
         <table class="tbl_list multiple-box-shadows">
            <tr>
               <th>번호</th><th>제목</th><th>작성자</th><th>등록일</th><th>조회수</th>
            </tr>
            <c:forEach items="${boardList2}" var="board2">
            <tr>
               <td><c:out value="${board2.bno}" /></td>
               <td><a style="color:#eee" href="/board/boardView2?bno=<c:out value='${board2.bno}'/>"><c:out value="${board2.title}" /></a> </td>
               <td><c:out value="${board2.writer}" /></td>
               <td><fmt:formatDate value="${board2.regDate}" 
                       pattern="yyyy-MM-dd hh:mm:ss" /></td>
               <td><c:out value="${board2.cnt}" /></td>
            </tr>
            </c:forEach>
         </table>
         <!-- pagination(페이징) -->
			<div>
				<ul class="paging">
				<!-- 이전(Previous) 메뉴 -->
				<c:if test="${pageMaker.prev}">
					<li class="page-l">
						<a href="${pageMaker.startPage - 1 }">이전</a>
					</li>
				</c:if>
				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" 
				           var="num">
				    <!-- 현재 페이지 활성화 -->
				    <c:if test="${pageMaker.cri.pageNum eq num}">
					<li class="page-l">
						<b><a href="${num}" style="color: white">
							<c:out value="${num}" /></a>
						</b>
					</li>
					</c:if>
				    <c:if test="${pageMaker.cri.pageNum ne num}">
					<li class="page-l">
						<a href="${num}"><c:out value="${num}" /></a>
					</li>
					</c:if>
				</c:forEach>
				<!-- 다음(Next) 메뉴 -->
				<c:if test="${pageMaker.next}">
					<li class="page-l">
						<a href="${pageMaker.endPage + 1 }">다음</a>
					</li>
				</c:if>
				</ul>
			</div>
			<!-- 페이지 처리 전송 폼 -->
			<form action="/board/boardList2" method="get" id="actionForm">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
				<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
			</form>
         <div class="btn_box">
            <a href="/board/insertBoard2"><button type="button" class="btn-hover color-8">작성하기</button></a>
         </div>
      </section>
   <link rel="stylesheet" href="/resources/css/style.css">
   </div>
    <jsp:include page="../footer.jsp" />
    <script type="text/javascript">
	$(document).ready(function(){ //제이쿼리 환경
		let actionForm = $("#actionForm");
		//페이지 이동
		$(".page-l a").on("click", function(e){
			e.preventDefault(); //기본 동작 제한(링크 걸리지 않음)
			let targetPage = $(this).attr("href"); //클릭한 페이지
			console.log(targetPage);
			
			actionForm.find("input[name='pageNum']").val(targetPage);
			actionForm.submit();
		});
		
		//상세 페이지로 전송
		$(".move").on("click", function(e){
			e.preventDefault();
			
			let targetBno = $(this).attr("href");
			console.log(targetBno);
			
			actionForm.append("<input type='hidden' name='bno' value='" + targetBno + "'>");
			actionForm.attr("action", "/board/boardView2");
			actionForm.submit();
		});
	});
</script>
</body>
</html>