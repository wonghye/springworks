<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<jsp:include page="../menu.jsp"/>
	<div id="container">
		<section id="list">
			<h2 class="main">회원 목록</h2>
				<table class="tbl_list">
					<thead>
						<tr>
							<th>번호</th>
							<th>아이디</th>
							<th>이 름</th>
							<th>가입일</th>
							<th>권한1</th>
							<!-- <th>권한2</th> -->
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${memberList }" var="member" varStatus="status">
						<tr>
							<td><c:out value="${status.count }" /> </td>  <!-- 목록 번호순 만들기  -->
							<td><a href="/member/memberView?userid=<c:out value="${member.userid }" />"> <c:out value="${member.userid }" /></a></td>						
							<%-- <td><c:out value="${member.userpw }" /> </td> --%>						
							<td><c:out value="${member.username }" /> </td>						
							<td><fmt:formatDate value="${member.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<%-- <td><c:out value="${member.authList.get(0) }" /> </td>	 --%>				
							<%--<td><c:out value="${fn:split(member.authList.get(0),'=')[2]}" /> </td>--%>
							<!-- fn:replace(문자열, '이전문자','대체할문자') -->	
							<td><c:out value="${fn:replace(fn:split(member.authList.get(0),'=')[2], ')', '')}" /> </td>						
						</tr>
					</c:forEach>	
					</tbody>
					
				</table>
		</section>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>