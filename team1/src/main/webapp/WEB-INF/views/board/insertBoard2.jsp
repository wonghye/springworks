<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script type="text/javascript">
	function checkForm() {
		let form = document.newWrite;
		let title = form.title.value;
		let writer = form.writer.value;
		let content = form.content.value;
		
		if(title == ""){
			alert("제목을 입력해주세요");
			form.title.focus();
			return false;
		}
		if(content == ""){
			alert("내용을 입력해주세요");
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
			<h2 class="main">글쓰기</h2>
			<form action="/board/insertBoard?${_csrf.parameterName }=${_csrf.token }" 
			method="post" enctype="multipart/form-data" 
			onsubmit="return checkForm()" name="newWrite">
				<table class="tbl_reg">
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" placeholder="Title"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text"  name="writer" value='<security:authentication property="principal.username"/>'
							readonly="readonly"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<textarea name="content" placeholder="Content" cols="50" rows="10"></textarea>
						</td>
					</tr>
					<tr>
						<td>업로드</td>
						<td>
							<input type="file" name="uploadFile">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록" >
							<a href="/board/boardList"><input type="button" value="목록"></a>
						</td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
			</form>
		</section>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>