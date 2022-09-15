<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유머 - 글 작성하기</title>
<link rel="stylesheet" href="/resources/css/font.css">
<link rel="stylesheet" href="/resources/css/style.css">
<style type="text/css">
#container{background-image: linear-gradient(to bottom, #f9e7f9, #ffe8ef, #ffede5, #fff4e2, #f7fbe7);}
.multiple-box-shadows {
  box-shadow: -5px -5px 30px 5px #FFB3B3, 5px 5px 30px 5px #FFDBA4;
}
</style>
<script type="text/javascript">
	function checkForm(){
		//alert("글쓰기");
		let form = document.newWrite;  //폼 이름
		let title = form.title.value;  //제목 입력값
		let content = form.content.value; //내용 입력값
		
		if(title == ""){
			alert("제목을 입력해주세요.");
			form.title.focus();
			return false;
		}
		if(content == ""){
			alert("내용을 입력해주세요.");
			form.content.focus();
			return false;
		}	
	}
</script>
</head>
<body>
<jsp:include page="../menu.jsp"/>
	<div id="container">
		<section id="list">
			<h2>글쓰기</h2>
			<form action="/board/insertBoard" method="post" 
				  onsubmit="return checkForm()" name="newWrite">
				<table class="tbl_reg multiple-box-shadows">
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" placeholder="Title"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer" readonly="readonly"
						      value='<security:authentication property="principal.username"/>'></td> 
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<textarea name="content" cols="50" rows="10"
							          placeholder="Content"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록">
							<a href="/board/boardList"><input type="button" value="목록"></a>
						</td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</section>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>