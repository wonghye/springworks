<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.user.login.title" /></title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
   <jsp:include page="./menu.jsp" />
   <div id="container" style="height:1200px;">
      <section id="login">
         <div class="title">
            <h2 style="font-size:55px;"><spring:message code="message.user.login.title" /></h2>
         </div>
         <p class="lang">
             <a href="customLogin?lang=ko">
               <spring:message code="message.user.login.language.ko" /> | 
            </a> 
            <a href="customLogin?lang=en">
               <spring:message code="message.user.login.language.en" />
            </a>
         </p>
         <h3 class="error"><c:out value="${error}" /></h3>
         <form action="/login" method="post">
            <table class="tbl_login">
               <tr>
                  <td colspan="2" class="login_name" ><spring:message code="message.user.login.id" /></td>
               </tr>
               <tr>
                  <td colspan="2"><input class="login_box" type="text" name="username" placeholder="ID"></td>
               </tr>
               <tr>
                  <td colspan="2" class="login_name"><spring:message code="message.user.login.password" /></td>
               </tr>
               <tr>
                  <td colspan="2"><input class="login_box" type="password" name="password" placeholder="PASSWORD"></td>
               </tr>
               <tr>
               	  <td colspan="2"><div class="cbox_wrapper">
                    <label for="keep-login"><spring:message code="message.user.login.keepLogin" /></label>
                    <input type="checkbox" class="cbox keep-login" id="keep-login" name="keep-login" 
                    value="keep-login">
                  </div></td>
               </tr>
               <tr>
                  <td colspan="2">
                     <input class="login_btn" type="submit" value="<spring:message code="message.user.login.loginBtn" />">
                  </td>
               </tr>
               <tr>
                  <td colspan="2">
                     <a id="register" href ="/member/signup"><div id="register_box"><spring:message code="message.user.login.signUp" /></div></a>
                  </td>
               </tr>
               <tr>
               	<td colspan="2">
               	<a href="https://www.naver.com"><img width="70%" src="https://user.ruliweb.com/assets/img/sns/btn_login_naver.png" alt="NAVER 아이디로 로그인"></a>
               	</td>
               </tr>
               <tr>
               	<td colspan="2">
               	<a href="https://www.kakaocorp.com/page/"><img width="70%" src="https://user.ruliweb.com/assets/img/sns/btn_login_kakao.png" alt="NAVER 아이디로 로그인"></a>
               	</td>
               </tr>
               <tr>
               	<td colspan="2">
               	<a href="https://www.google.com"><img width="70%" src="https://user.ruliweb.com/assets/img/sns/btn_login_google.png" alt="NAVER 아이디로 로그인"></a>
               	</td>
               </tr>
               <tr>
               	<td colspan="2">
               	<a href="https://www.apple.com/kr"><img width="70%" src="https://user.ruliweb.com/assets/img/sns/btn_login_apple.png" alt="NAVER 아이디로 로그인"></a>
               	</td>
               </tr>
            </table>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
         </form>
      </section>
   </div>
   <jsp:include page="./footer.jsp" />
</body>
</html>