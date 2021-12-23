<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="../js/jsmobilemenu.js"></script>
<script type="text/javascript" src="../js/searchbox.js"></script>
<title>트렌독_로그인</title>
<link href="../css/login.css" type="text/css" rel="stylesheet" />
<link href="../css/header.css" type="text/css" rel="stylesheet" />
<link href="../css/footer.css" type="text/css" rel="stylesheet" />
<link href="../css/main.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<c:import url="/WEB-INF/views/include/sub_header.jsp" />

	<section class="section">
		<div class="loginform">

			<div class="log_1">
				<div class="log_1_in"></div>

			</div>
			<c:if test="${fail == true }">
				<div class="alert alert-danger">
					<h3>로그인 실패</h3>
					<p>아이디 비밀번호를 확인해주세요</p>
				</div>
			</c:if>
			<form:form action="${root }member/login_pro" method='post'
				modelAttribute="tempLoginUserBean" class="im">
				<div class="log_2_in">
					<form:input path="member_id" class='id' placeholder="Username" 
					style="width: 300px;height: 40px;  margin-bottom: 25px; font-size: 18px;"/>
					<form:errors path='member_id' style='color:red' />

					<form:password path="pass" class='pw' placeholder="Password" 
					style="width: 300px;height: 40px; font-size: 18px;"/>
					<form:errors path='pass' style='color:red' />
				</div>

				<div class="idsearch">
					<span style="margin-right: 10px;">
						<a href="${root }member/srcId" class="srcId_href" 
						style="text-decoration: none;">아이디 찾기</a>
						<a href="${root }member/srcPass" class="srcPass_href" 
						style="text-decoration: none;">비밀번호 찾기</a>
					</span>
					
				</div>
				<div class="log_3">
					<div class="log_3_in">
						<form:button class='loginbtn'
						style="width: 300px; height: 40px; border-radius: 5px; font-size: 18px; margin-bottom: 15px;  cursor: pointer;">
						로그인
						</form:button>
						<input type="button" onclick="location.href='${root}member/join'" value="회원가입" class="joinbtn"
						style="width: 300px; height: 40px; border-radius: 5px; font-size: 18px;  cursor: pointer;" >
					</div>
				</div>
			</form:form>

		</div>
	</section>

	<c:import url="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>








    