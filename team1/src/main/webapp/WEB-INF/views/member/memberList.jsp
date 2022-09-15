<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" href="/resources/css/font.css">
<link rel="stylesheet" href="/resources/css/style.css">
<style type="text/css">
/* #container{background-color: black;} */
.multiple-box-shadows {
 /*  box-shadow: -5px -5px 25px 3px b, 5px 5px 30px 5px blue; */
 box-shadow: 0 0 15px  green;
}
</style>
</head>
<body>
   <jsp:include page="../menu.jsp" />
   <div id="container">
      <section id="list">
         <div class="title">
            <!-- <h2 style="color: white;">회원 목록</h2> -->
            <h2 >회원 목록</h2>
         </div>
            <table class="tbl_list multiple-box-shadows">
               <thead>
                  <tr>
                     <th>번호</th>
                     <th>아이디</th>
                     <!-- <th>비밀번호</th> -->
                     <th>이름</th>
                     <th>가입일</th>
                     <th>이메일</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${memberList}" var="member" varStatus="status">
                   <tr>
                      <td><c:out value="${status.count}"/></td>
                      <td><a style="color:black" href="/member/memberView?userid=<c:out value="${member.userid}" />"><c:out value="${member.userid}" /></a></td>
                      <%-- <td><c:out value="${member.userpw}" /></td> --%>
                      <td><c:out value="${member.username}" /></td>
                      <td><fmt:formatDate value="${member.regdate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                      <td><c:out value="${member.email}" /></td>
                   </tr>
                   </c:forEach>
                  </tbody>
            </table>
      </section>
   </div>
   <jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>