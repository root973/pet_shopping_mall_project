<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 찾기</title>
    <script type="text/javascript" src="../js/jsmobilemenu.js"></script>
    <script type="text/javascript" src="../js/searchbox.js"></script>
    <link href="../css/header.css" type="text/css" rel="stylesheet" />
    <link href="../css/main.css" type="text/css" rel="stylesheet" />
    <link href="../css/footer.css" type="text/css" rel="stylesheet" />
    <link href="../css/삭제.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <!-- 헤더 -->
	<c:import url="/WEB-INF/views/include/sub_header.jsp"/>


    <section>
        <div  class="delete_main">
       <div>
           <span class="delete_title">탈퇴</span>
       </div>
       <div class="delete_title1">
           <span >정말 탈퇴하시겠습니까?</span>
       </div>
       <form action="${root}member/delete_pro" method="post">
           	<input type="submit" class="delete_btn" value="예">
           	<input type="button" class="delete_btn" onclick="history.go(-1)" value="아니요">
       </form>
           	
  
    </div>
    </section>
	<!-- 하단 -->
    <c:import url="/WEB-INF/views/include/footer.jsp"/>
</body>