<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html lang="en">
<script src="https://kit.fontawesome.com/115203431c.js" crossorigin="anonymous"></script>

<head>
    <link href="../css/관리자로그인.css" type="text/css" rel="stylesheet" />
</head>

<body>

	<section>
		<div class="main">

			<div class="admin_login">

				<div class="login_title">관리자 페이지 로그인 후 입장 가능</div>
				
				<form:form action="${root }admin/login_pro" method="post"
					modelAttribute="tempLoginUserBean" class="login_form">
					<div>
						<form:input path="admin_id" type="text" placeholder="아이디 입력" class="id"/><br>
						<form:errors path="admin_id" style='color:red' />
					</div>

					<div>
						<form:input path="pass" type="password" placeholder="패스워드 입력" class="pw"/><br>
						<form:errors path="pass" style='color:red' />
					</div>

					<div>
						<form:button class="login_btn" >로그인</form:button>
					</div>
				</form:form>
				<c:if test="${fail == true }">
					<div class="alert alert-danger">
						<h3>로그인 실패</h3>
						<p>아이디 비밀번호를 확인해주세요</p>
					</div>
				</c:if>
			</div>

		</div>
	</section>

</body>

</html>