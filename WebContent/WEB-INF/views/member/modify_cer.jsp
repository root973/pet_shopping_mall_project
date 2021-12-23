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
    <title>인증</title>
    <script type="text/javascript" src="../js/jsmobilemenu.js"></script>
    <script type="text/javascript" src="../js/searchbox.js"></script>
    <link href="../css/header.css" type="text/css" rel="stylesheet" />
    <link href="../css/main.css" type="text/css" rel="stylesheet" />
    <link href="../css/footer.css" type="text/css" rel="stylesheet" />
    <link href="../css/인증.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <!-- 헤더 -->
	<c:import url="/WEB-INF/views/include/sub_header.jsp" />


    <section>
        <div  class="certify_main">
       <div>
           <span class="certify_title">계정 인증</span>
       </div>
       <div class="certify_title1">
           <span >비밀번호를 다시 한번 입력해주세요.</span>
       </div>
       
       <form action="${root}member/modify_cer_pro" method="post">
       		<div>
           		<input type="password" class="certify_text" name="cli_pass" placeholder="비밀번호">
       		</div>
       		<div>
           		<input type="submit" class="certify_btn" value="다음">
       		</div>
       </form>
    </div>
    </section>


	<!-- 하단 -->
    <c:import url="/WEB-INF/views/include/footer.jsp"/>


</body>