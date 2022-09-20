<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정</title>
<link rel="stylesheet" href="/resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
</head>
<body>
	<div id="container">
		<section id="reply_update">
			<div class="title">
				<h2>댓글 수정</h2>
			</div>
			<form action="/board/replyUpdate" method="post" id="updateForm"
			      class="updateForm">
			  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			  <input type="hidden" name="bno" value="${selectReply.bno}">
			  <input type="hidden" name="rno" value="${selectReply.rno}">
			  <ul>
			  	<li>
			  		<label>댓글 내용</label>
			  		<textarea rows="4" cols="50"
			  		   name="reply"><c:out value="${selectReply.reply}"/></textarea>
			  	</li>
			  </ul>
			  <div>
		  		<button type="submit" class="updateBtn">저장</button>
		  		<button type="button" class="cancelBtn">취소</button>
		  	  </div>
			</form>
		</section>
	</div>
<script>
	$(document).ready(function(){
		let updateForm = $("#updateForm");
		
		$(".cancelBtn").click(function(e){
			e.preventDefault();
			
			updateForm.attr("action", "/board/boardView?bno=${selectReply.bno}");
			updateForm.attr("method", "get");
			updateForm.submit();
		});
	});
</script>
</body>
</html>