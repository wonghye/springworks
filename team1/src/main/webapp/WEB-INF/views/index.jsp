<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~</title>
<link rel="stylesheet" href="/resources/css/style.css">
<style>
   .btns{margin:10px 0 10px;}
</style>
</head>
<body>
   <jsp:include page="./menu.jsp" />
   <div class="container text-center" id="container">
      <div class="row">
         <div class="col-sm-6 link-dark">
            <img src="/resources/images/ghost.jpg" style="width:100%; height: 700px; border-radius: 25px; margin-top:30px;" alt="귀신">
            <button type="button" onclick= "location.href ='/board/boardList2'" class="btns btn btn-danger btn-lg fa-solid fa-fade"> 입장 </button>
         </div>
         <div class="col-sm-6">
            <img src="/resources/images/bonobono.jpg" style="width:100%; height: 700px; border-radius: 25px; margin-top:30px;" alt="웃음"> 
            <button type="button" onclick= "location.href ='/board/boardList'" class="btns btn btn-info btn-lg fa-solid fa-fade"> 입장 </button>
         </div>
      </div>
   </div>
   <jsp:include page="./footer.jsp"></jsp:include>
</body>
</html>