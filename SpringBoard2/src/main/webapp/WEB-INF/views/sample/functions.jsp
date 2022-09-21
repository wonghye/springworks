<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl - functions 태그 실습 </title>
</head>
<body>
	<h2>jstl - functions 태그 실습 </h2>
	<c:set var="text" value="${fn:split('hello, java Spring FrameWork',' ')}" />
	<!-- split (문자열,구분기호) : 구분기호로 문자열을 분리해서 배열로 반환 -->
	<!--{hello,java Spring FrameWork}  -->
	<c:out value="${text[2]}" /><br>
	<c:out value="${fn:split('hello, java Spring FrameWork',' ')[2]}" />
	<p>문자열의 개수 : ${fn:length(text)}</p>
	<p>
		<c:forEach begin="0" end="${fn:length(text)}" var="i">
			<c:out value="${text[i] }" /><br>
		</c:forEach>
	</p>
</body>
</html>