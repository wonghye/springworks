<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 보기</title>
<link rel="stylesheet" href="/resources/css/style.css">
<style>
#container{background-image: linear-gradient(to bottom, #f9e7f9, #ffe8ef, #ffede5, #fff4e2, #f7fbe7);}
</style>
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../menu.jsp"/>
   <div id="container">
      <section id="list">
         <h2>${board.title}</h2>
         <form action="/board/updateBoard" method="post">
			<!-- 수정 시에 기본키 속성이 반드시 필요함  --> 
			<input type="hidden" name="bno" value="${board.bno}">
			<!-- 수정, 삭제시에 페이지 번호 유지(안하면 무조건 1페이지로 이동) -->
			<input type="hidden" name="pageNum" value="${cri.pageNum}">
			<input type="hidden" name="amount" value="${cri.amount}">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <table class="tbl_view">
               <tr>
                  <td>제목</td>
                  <td><div style="float:left; width:400px;"><input type="text" name="title" value="${board.title}" ></div><div style="float:right; width:200px;"><fmt:formatDate value="${board.regDate}"
                     pattern="yyyy-MM-dd hh:mm:ss"/></div></td>
               </tr>
               <tr>
                  <td>작성자</td>
                  <td><input type="text" name="writer" value="${board.writer}"></td>
               </tr>
               <tr>
                  <td>내용</td>
                  <td style="padding:5px">
                     <textarea name="content" cols="50" rows="10"><c:out value="${board.content}"/></textarea>
                  </td>
               </tr>
               <%-- <tr>
                  <td>등록일</td>
                  <td class="time"><fmt:formatDate value="${board.regDate}"
                     pattern="yyyy-MM-dd hh:mm:ss"/>
                  </td>
               </tr> --%>
               <tr>
                  <td>조회수</td>
                  <td><input type="text" name="cnt" value="${board.cnt}"></td>
               </tr>               
               <!-- <tr>
                  <td colspan="2">
                  <button type="button">재밌어요</button> </td>
               </tr>    -->            
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
                     <a href="/board/boardList"><input type="button" value="목록"></a>
                  </td>                                                      
               </tr>
            </table>
         </form>
      </section>
      <!-- 페이지 처리 전송 폼 -->
         <form action="/board/boardList" method="get" id="actionForm">            
            <input type="hidden" name="bno" value="${board.bno}">
            <input type="hidden" name="pageNum" value="${cri.pageNum}">
            <input type="hidden" name="amount" value="${cri.amount}">
         </form>
   </div>
<script type="text/javascript">
   $(document).ready(function(){ //제이쿼리 환경
      let actionForm = $("#actionForm");
         
      $(".lBtn").click(function(e){
         e.preventDefault();
         actionForm.submit();
      })   
   
   });
</script>

</body>
</html>