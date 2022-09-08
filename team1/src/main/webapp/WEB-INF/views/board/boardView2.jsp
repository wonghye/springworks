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
</head>
<body>
   <div id="container">
      <section id="list">
         <h2>글 상세 보기</h2>
         <form action="/board/updateBoard2" method="post">
         <input type="hidden" name="bno" value="${board2.bno }">
            <table class="tbl_view">
               <tr>
                  <td>제목</td>
                  <td><input type="text" name="title" value="${board2.title}"></td>
               </tr>
               <tr>
                  <td>작성자</td>
                  <td><input type="text" name="writer" value="${board2.writer}"></td>
               </tr>
               <tr>
                  <td>내용</td>
                  <td>
                     <textarea name="content" cols="50" rows="10"><c:out value="${board2.content}"/></textarea>
                  </td>
               </tr>
               <tr>
                  <td>등록일</td>
                  <td class="time"><fmt:formatDate value="${board2.regDate}"
                     pattern="yyyy-MM-dd hh:mm:ss"/>
                  </td>
               </tr>
               <tr>
                  <td>조회수</td>
                  <td><input type="text" name="cnt" value="${board2.cnt}"></td>
               </tr>               
               <tr>
                  <td colspan="2">
                  <button type="button">재밌어요</button> </td>
               </tr>               
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
   </div>
</body>
</html>