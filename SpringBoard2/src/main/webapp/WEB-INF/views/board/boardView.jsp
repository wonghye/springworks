<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~</title>
<link rel="stylesheet" href="/resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
</head>
<body>
	<div id="container">
		<section id="view">
			<h2>글 상세 보기</h2>
			<form action="/board/updateBoard" method="post">
			<!-- 수정 시 기본키 필요함  -->
			<input type="hidden" name="bno" value="${board.bno }">
			<!-- 수정 , 삭제시 페이지로 돌아감 -->
			<input type="hidden" name="pageNum" value="${cri.pageNum }">
			<input type="hidden" name="amount" value="${cri.amount }">
			<input type="hidden" name="type" value="${cri.type}">
			<input type="hidden" name="keyword" value="${cri.keyword}">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<!-- 토큰  -->
				<table class="tbl_view">
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" value="${board.title}"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer" value="${board.writer}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<textarea name="content" cols="50" rows="10"><c:out value="${board.content}"/></textarea>
						</td>
					</tr>
					<tr>
						<td>등록일</td>
						<td class="time"><fmt:formatDate value="${board.updateDate}" 
					              pattern="yyyy-MM-dd HH:mm:ss" />
		              	</td>
					</tr>
					<tr>
						<td>조회수</td>
						<td><input type="text" name="cnt" value="${board.cnt}"></td>
					</tr>					
					<tr>
						<td colspan="2">
						<security:authentication property="principal" var="pinfo"/>
						<security:authorize access="isAuthenticated()">
						<c:if test="${pinfo.username eq board.writer }">
							<input type="submit" value="수정">
							<a href="/board/deleteBoard?bno=<c:out value="${board.bno}"/>" onclick="return confirm('해당 게시글을 삭제하시겠습니가?')">
							<input type="button" value="삭제"></a>
						</c:if>	
						</security:authorize>	
							<a href="/board/boardList"><input type="button" value="목록" class="listBtn"></a>
						</td>                                                      
					</tr>
				</table>
			</form>
			<!-- 댓글 영역 -->
			<div class="comment">
				<h4>댓글</h4>
				<ol class="replyList">
					<c:forEach items="${replyList}" var="list">
						<li>
							<p class="replyer">작성자: <c:out value="${list.replyer}" />&nbsp;&nbsp;
							   (작성일: <fmt:formatDate value="${list.updateDate}" 
							   				pattern="yyyy-MM-dd HH:mm:ss" /> )
							</p>
							<p class="content"><c:out value="${list.reply }" /></p>  
							<c:if test="${pinfo.username eq list.replyer}">
							<p>
								<button type="button" class="replyUpdateBtn" data-rno="${list.rno}">수정</button>
								<button type="button" class="replyDeleteBtn" data-rno="${list.rno}">삭제</button>
							</p>
							</c:if> 
						</li>
					</c:forEach>
				</ol>
				<!-- 댓글 등록폼 -->
				<form action="" method="post" id="replyForm" class="reply">
					<input type="hidden" name="bno" value="${board.bno }">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<ul>
						<li>
							<label>작성자</label>
							<input type="text" name="replyer" id="replyer" 
							value="<security:authentication property="principal.username"/>">
							
						</li>
						<li>
							<textarea rows="4" cols="60" name="reply" id="reply"></textarea>
							<button type="button" class="replyBtn">댓글 등록</button>
						</li>
					</ul>
				
				</form>
			</div>
			
		</section>
		<!-- 페이지 처리 전송 폼 -->
			<form action="/board/boardList" method="get" id="actionForm">
				<input type="hidden" name="bno" value="${board.bno }">
				<input type="hidden" name="pageNum" value="${cri.pageNum }">
				<input type="hidden" name="amount" value="${cri.amount }">
				<input type="hidden" name="type" value="${pageMaker.cri.type }">
				<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
			</form>
	</div>
	<jsp:include page="../footer.jsp" />
<script type="text/javascript">
	$(document).ready(function(e){  // 제이쿼리 환경
		//목록 버튼 이벤트 
		let actionForm = $("#actionForm");
		
		$(".listBtn").click(function(e){
			e.preventDefault();  // 기본 동작 막아줌
			actionForm.submit();
		});
		
		//댓글 등록 이벤트 처리
		let replyForm = $("#replyForm");
		$(".replyBtn").click(function (e){
			e.preventDefault(); 	//기본 동작 제한(링크 등)
			console.log("test~");
			
			replyForm.attr("action", "/board/reply");
			replyForm.submit();
		});
		
		//댓글 삭제 페이지 요청
		$(".replyDeleteBtn").click(function(e){
			e.preventDefault(); //링크 안되도록 함
			console.log("click....");
			
			let rno = $(this).attr("data-rno"); //삭제 버튼
			
			location.href = "/board/replyDelete?bno=${board.bno}"
						+ "&rno=" + rno;
		}); //click 닫기
			
		//댓글 수정 페이지 요청
		$(".replyUpdateBtn").click(function(e){
			e.preventDefault(); //링크 안되도록 함
			console.log("click....");
			
			let rno = $(this).attr("data-rno"); //수정 버튼
			
			location.href = "/board/replyUpdate?bno=${board.bno}"
						+ "&rno=" + rno;
		}); //click 닫기
		
		
	});
</script>		
</body>
</html>