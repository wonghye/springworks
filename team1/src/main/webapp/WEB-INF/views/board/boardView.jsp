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
<style type="text/css">
#container{background-image: linear-gradient(to bottom, #f9e7f9, #ffe8ef, #ffede5, #fff4e2, #f7fbe7);}
tbody{width:; background: fff;}
</style>
</head>
<body>
<jsp:include page="../menu.jsp"/>
   <div id="container">
   	<div id="bg">
      <section id="list">
         <h2>${board.title}</h2>
         <form action="/board/updateBoard" method="post">
         <input type="hidden" name="bno" value="${board.bno }">
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
      </div>
   </div>
   <jsp:include page="../footer.jsp" />
</body>
</html>