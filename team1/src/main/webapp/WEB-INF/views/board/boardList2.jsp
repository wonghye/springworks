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
</head>
<body>
   <jsp:include page="../menu.jsp"/>
   <div id="container">
      <section id="list">
         <h2 class="main">호러 게시판</h2>
         <table class="tbl_list">
            <tr>
               <th>번호</th><th>제목</th><th>작성자</th><th>등록일</th><th>조회수</th><th>좋아요</th>
            </tr>
            <c:forEach items="${boardList2}" var="board2">
            <tr>
               <td><c:out value="${board2.bno}" /></td>
               <td><a href="/board/boardView2?bno=<c:out value='${board2.bno}'/>"><c:out value="${board2.title}" /></a> </td>
               <td><c:out value="${board2.writer}" /></td>
               <td><fmt:formatDate value="${board2.regDate}" 
                       pattern="yyyy-MM-dd hh:mm:ss" /></td>
               <td><c:out value="${board2.cnt}" /></td>
               <td><%-- <c:out value="${board.hit }" /> --%></td>
            </tr>
            </c:forEach>
         </table>
         <div style="margin-top: 10px;">
            <!-- 이전 버튼 -->
            <c:if test="${startPage > 1 }">
               <a href="/boardList2.do?pageNum=<c:out value='${startPage-1 }' />">이전 </a> 
            </c:if>   
            <c:if test="${startPage <= 1 }">
               <a href="/boardList2.do?pageNum=<c:out value='${startPage }' />">이전 </a> 
            </c:if>   
            <c:forEach var="i" begin="1" end="${endPage }">
               <!--  현재 페이지와 페이지 번호가 같으면 굵게 표시  -->
               <c:if test="${currentPage eq i }">
                  <a href="/boardList2.do?pageNum=<c:out value='${i }' />"><b><c:out value="${i }" /></b> </a> 
               </c:if> 
               <c:if test="${currentPage ne i }"> <!-- ne = not eq -->
               <a href="/boardList2.do?pageNum=<c:out value='${i }' />"><c:out value="${i }" /></a> 
               </c:if>
            </c:forEach>
               <!-- 다음 버튼  -->
               <c:if test="${endPage > startPage }" >
                  <a href="/boardList2.do?pageNum=<c:out value='${startPage +1 }' />">다음 </a> 
               </c:if>
               <c:if test="${endPage <= startPage }" >
                  <a href="/boardList2.do?pageNum=<c:out value='${startPage }' />">다음 </a> 
               </c:if>
         </div>
         <div class="btn_box">
            <a href="/board/insertBoard2"><button type="button">작성하기</button></a>
         </div>
      </section>
   </div>
   <jsp:include page="../footer.jsp" />
</body>
</html>