<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재밌는게 딱! 좋아!</title>
<style>
/* @font-face {
    font-family: 'SBAggroB';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroB.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
*{font-family: 'SBAggroB';}  */

 @font-face {
    font-family: 'GOSEONGGEUMGANGNURI';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/GOSEONGGEUMGANGNURI.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
*{font-family: 'GOSEONGGEUMGANGNURI';} 
   .dung {
position: absolute;
z-index: 99;
width: 80px;
height: 80px;
background: url("../resources/images/smile.png") no-repeat center / contain;
animation: dung 100s infinite linear;
}
@keyframes dung {
0% {top:15%; left:80%;}
25% {top:25%; left:0;}
50% {top:50%; left:80%;}
75% {top:75%; left:0;}
100% {top:99%; left:80%;}
}
#container{background-image: linear-gradient(to bottom, #f9e7f9, #ffe8ef, #ffede5, #fff4e2, #f7fbe7);}
.multiple-box-shadows {
  box-shadow: -5px -5px 30px 5px #FFB3B3, 5px 5px 30px 5px #FFDBA4;
}
</style>
</head>
<body>
   <jsp:include page="../menu.jsp"/>
   <div id="container">
      <section id="list">
         <h2 class="main">유머 게시판</h2>
         <p class="dung">
         <table class="tbl_list multiple-box-shadows">
            <tr>
               <th>번호</th><th>제목</th><th>작성자</th><th>등록일</th><th>조회수</th><th>좋아요</th>
            </tr>
            <c:forEach items="${boardList}" var="board">
            <tr>
               <td><c:out value="${board.bno}" /></td>
               <td><a href="/board/boardView?bno=<c:out value='${board.bno}'/>"><c:out value="${board.title}" /></a> </td>
               <td><c:out value="${board.writer}" /></td>
               <td><fmt:formatDate value="${board.regDate}" 
                       pattern="yyyy-MM-dd hh:mm:ss" /></td>
               <td><c:out value="${board.cnt}" /></td>
               <td><%-- <c:out value="${board.hit }" /> --%></td>
            </tr>
            </c:forEach>
         </table>
         <div style="margin-top: 10px;">
            <!-- 이전 버튼 -->
            <c:if test="${startPage > 1 }">
               <a href="/boardList.do?pageNum=<c:out value='${startPage-1 }' />">이전 </a> 
            </c:if>   
            <c:if test="${startPage <= 1 }">
               <a href="/boardList.do?pageNum=<c:out value='${startPage }' />">이전 </a> 
            </c:if>   
            <c:forEach var="i" begin="1" end="${endPage }">
               <!--  현재 페이지와 페이지 번호가 같으면 굵게 표시  -->
               <c:if test="${currentPage eq i }">
                  <a href="/boardList.do?pageNum=<c:out value='${i }' />"><b><c:out value="${i }" /></b> </a> 
               </c:if> 
               <c:if test="${currentPage ne i }"> <!-- ne = not eq -->
               <a href="/boardList.do?pageNum=<c:out value='${i }' />"><c:out value="${i }" /></a> 
               </c:if>
            </c:forEach>
               <!-- 다음 버튼  -->
               <c:if test="${endPage > startPage }" >
                  <a href="/boardList.do?pageNum=<c:out value='${startPage +1 }' />">다음 </a> 
               </c:if>
               <c:if test="${endPage <= startPage }" >
                  <a href="/boardList.do?pageNum=<c:out value='${startPage }' />">다음 </a> 
               </c:if>
         </div>
         <div class="btn_box">
                 <a href="/board/insertBoard"><button type="button" class="btn-hover color-10">작성하기</button></a>
         </div>
      </section>
   </div>
   <link rel="stylesheet" href="/resources/css/style.css">
   <jsp:include page="../footer.jsp" />
   
</body>
</html>