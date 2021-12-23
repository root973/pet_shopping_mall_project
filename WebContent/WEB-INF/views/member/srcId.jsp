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
        <div  class="id_main">
       <div>
           <span class="id_title">아이디 찾기</span>
       </div>
       <div class="id_title1">
           <span >아이디는 가입시 입력하신 이메일을 통해 찾을 수 있습니다.</span>
       </div>
       
       <form action="${root }member/srcId_pro" method="post">
       		<div>
           		<input type="text" class="id_text" name="cli_name" placeholder="이름">
       		</div>
       		<div>
           		<input type="email" class="id_text" name="cli_email" placeholder="이메일">
       		</div>
       		<div>
           		<input type="submit" class="id_btn" value="다음">
       		</div>
       </form>
 

    </div>
    </section>


	<!-- 하단 -->
    <c:import url="/WEB-INF/views/include/footer.jsp"/>


</body>
</html>

