<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<!-- <link rel="stylesheet" href="/resources/css/style.css"> -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/319f0bada6.js" crossorigin="anonymous"></script>
<style>
.NavBox ul{width:100%; margin:0 auto; height:100%}
.NavBox li{width:180px; float:left; padding:10px 0px; margin:0px; text-align:center; list-style: none;}
.NavBox a{color:white; text-decoration:none;}
.menutopbox{height:90px; margin:0px;}
@media (min-width: 0px) and (max-width: 1024px) {
.NavBox li{float:left; width:100%; height:20px; margin-bottom:20px;}
.NavBox ul{width:100%; margin:0 auto; height:100%}
.menutopbox{height:250px;}
}
</style>
</head>
<body>
<div class="collapse NavBox" id="navbarToggleExternalContent">
  <div class="bg-dark p-4 menutopbox">
  <security:authorize access="isAnonymous()">
      <ul>  
         <li><a href ="/">Home</a></li>
         <li><a href ="/customLogin">로그인</a></li>
         <li><a href ="/member/signup">회원가입</a></li>
         <li><a href="/board/boardList">재미</a></li>         
         <li><a href="/board/boardList2">공포</a></li>         
    </ul>
    <!-- <h6><a href ="/">Home</a></h6>
    <h6><a href ="/customLogin">로그인</a></h6>
    <h6><a href ="/member/signup">회원가입</a></h6>
    <h6><a href ="/member/memberList">회원목록</a></h6>
    <h6><a href="/board/boardList">재미</a></h6>
    <h6><a href="/board/boardList2">공포</a></h6> -->
    </security:authorize>
    <security:authentication property="principal" var="pinfo"/>
    <security:authorize access="isAuthenticated()">
    <%-- <h6><a href ="/">Home</a></h6>
    <h6><a href ="/customLogout"><c:out value="${pinfo.username }" />(님)로그아웃</a></h6>
    <h6><a href ='/member/memberView?userid=<c:out value="${pinfo.username }" />'>내 정보</a></h6>
    <h6><a href ="/member/memberList">회원목록</a></h6>
    <h6><a href="/board/boardList">재미</a></h6>
    <h6><a href="/board/boardList2">공포</a></h6> --%>
    <ul>
         <li><a href ="/">Home</a></li>
         <li><a href ="/customLogout"><c:out value="${pinfo.username }" />(님)로그아웃</a></li>
         <li><a href ="/member/memberList">회원목록</a></li>
         <li><a href="/board/boardList">재미</a></li>
         <li><a href="/board/boardList2">공포</a></li>   
         <li><a href ='/member/memberView?userid=<c:out value="${pinfo.username }" />'>내 정보</a></li>
      </ul>
    </security:authorize>
  </div>
</div>
<nav class="navbar navbar-dark bg-dark" style="width:100%; margin:1px 0px 0px 0px">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  </div>
</nav>

<!-- 기존 메뉴바 -->
  <%--  <nav>
   <security:authorize access="isAnonymous()">
      <ul>  
         <li><a href ="/">Home</a></li>
         <li><a href ="/customLogin">로그인</a></li>
         <li><a href ="/member/signup">회원가입</a></li>
         <!-- <li><a href ="/member/memberList">회원목록</a></li> -->
         <li><a href="/board/boardList">재미</a></li>         
         <li><a href="/board/boardList2">공포</a></li>         
      </ul>
   </security:authorize>
   
   <security:authentication property="principal" var="pinfo"/>
   
   <security:authorize access="isAuthenticated()">
      <ul>
         <li><a href ="/">Home</a></li>
         <li><a href ="/customLogout"><c:out value="${pinfo.username }" />(님)로그아웃</a></li>
         <li><a href ="/member/memberList">회원목록</a></li>
         <li><a href="/board/boardList">재미</a></li>
         <li><a href="/board/boardList2">공포</a></li>   
         <li><a href ='/member/memberView?userid=<c:out value="${pinfo.username }" />'>내 정보</a></li>
      </ul>
   </security:authorize>
   </nav> --%>
</body>
</html>