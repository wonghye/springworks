<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 보기 - 공포</title>
<link rel="stylesheet" href="/resources/css/font.css">
<link rel="stylesheet" href="/resources/css/style.css">
<style type="text/css">
#container{background-image: linear-gradient(to bottom, #d32929, #a42027, #761a21, #4b1418, #230a0a);}
</style>
</head>
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<body>
<jsp:include page="../menu.jsp"/>
   <div id="container">
      <section id="list">
         <h2 style="color: white;">${board2.title}</h2>
         <form action="/board/updateBoard2" method="post">
			<!-- 수정 시에 기본키 속성이 반드시 필요함  --> 
			<input type="hidden" name="bno" value="${board2.bno}">
			<!-- 수정, 삭제시에 페이지 번호 유지(안하면 무조건 1페이지로 이동) -->
			<input type="hidden" name="pageNum" value="${cri.pageNum}">
			<input type="hidden" name="amount" value="${cri.amount}">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <table class="tbl_view">
               <tr>
                  <td>제목</td>
                  <td><div style="float:left; width:400px;"><input type="text" name="title" value="${board2.title}" ></div><div style="float:right; width:200px;"><fmt:formatDate value="${board2.regDate}"
                     pattern="yyyy-MM-dd hh:mm:ss"/></div></td>
               </tr>
               <tr>
                  <td>작성자</td>
                  <td><input type="text" name="writer" value="${board2.writer}"></td>
               </tr>
               <tr>
                  <td>내용</td>
                  <td style="padding:5px">
                     <textarea name="content" cols="50" rows="10"><c:out value="${board2.content}"/></textarea>
                  </td>
               </tr>
               <%-- <tr>
                  <td>등록일</td>
                  <td class="time"><fmt:formatDate value="${board2.regDate}"
                     pattern="yyyy-MM-dd hh:mm:ss"/>
                  </td>
               </tr> --%>
               <tr>
                  <td>조회수</td>
                  <td><input type="text" name="cnt" value="${board2.cnt}"></td>
               </tr>               
               <!-- <tr>
                  <td colspan="2">
                  <button type="button">재밌어요</button> </td>
               </tr>    -->            
               <tr>
                  <td colspan="2">
                  <security:authentication property="principal" var="pinfo"/>
                  <security:authorize access="isAuthenticated()">
                  <c:if test="${pinfo.username eq board2.writer }">
                     <input type="submit" value="수정">
                     <a href="/board/deleteBoard2?bno=<c:out value="${board2.bno}"/>" onclick="return confirm('해당 게시글을 삭제하시겠습니가?')">
                     <input type="button" value="삭제"></a>
                  </c:if>   
                  </security:authorize>   
                     <a href="/board/boardList2"><input type="button" value="목록"></a>
                  </td>                                                      
               </tr>
            </table>
         </form>
      </section>
      <!-- 페이지 처리 전송 폼 -->
         <form action="/board/boardList2" method="get" id="actionForm">            
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
   </div>
   <jsp:include page="../footer.jsp" />
</body>
</html>