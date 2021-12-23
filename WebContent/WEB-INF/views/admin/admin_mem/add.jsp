<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>

<!DOCTYPE html>
<html lang="en">


<head>
	<script src="https://kit.fontawesome.com/115203431c.js" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	
	<link href="../../css/관리자메인.css" type="text/css" rel="stylesheet" />
    <link href="../../css/관리자사이드.css" type="text/css" rel="stylesheet" />
    <link href="../../css/관리자등록.css" type="text/css" rel="stylesheet" />
</head>
<script>
	function checkAdminIdExist(){
		
		var admin_id = $("#admin_id").val()
		
		if(admin_id.length == 0){
			alert('아이디를 입력해주세요')
			return
		}
		
		$.ajax({
			url : '${root}admin/checkAdminIdExist/' + admin_id,
			type : 'get',
			dataType : 'text',
			success : function(result){
				if(result.trim() == 'true'){
					alert('사용할 수 있는 아이디입니다')
					$("#idExist").val('true')
				} else {
					alert('사용할 수 없는 아이디 입니다')
					$("#idExist").val('false')
				}
			}
		})
	}
	
	function resetAdminidExist(){
		$("#idExist").val('false')
	}
</script>
<body>

    <!--사이드바에 들어갈 내용들-->
	<c:import url="/WEB-INF/views/admin/include/navi.jsp"/>

 <section>
		<div class="main">
			<div class="goods">

				<!-- 아이디 -->

				<form:form action="${root}admin/admin_mem/add_pro" class="joinform"
					method="post" modelAttribute="addAdminBean">
					<form:hidden path="idExist" />
					<p>
						<b class="nam1">관리자 - </b><span class="nam2">관리자 등록</span>
					</p>
					<br>
					<div class="join_1">
						<div class="join_id" style="width: 10%;">
							<form:label path="admin_id">아이디</form:label>
						</div>
						<form:input path="admin_id" style="width: 200px; height: 20px;"
							placeholder="아이디 입력" onkeypress="resetAdminidExist()" />
						<button type="button" class="id_check"
							onclick="checkAdminIdExist()">중복확인</button>
					</div>
					<br>
					<form:errors path="admin_id" style='color:red' />
					<br>

					<!-- 비밀번호 / 확인 -->
					<div class="join_2">
						<div class="join_id" style="width: 10%;">
							<form:label path="pass">비밀번호</form:label>
						</div>
						<form:input path="pass" type="password"
							style="width: 200px; height: 20px;" placeholder="비밀번호 입력" />
					</div>
					<br>

					<div class="join_3">
						<div class="join_id" style="width: 10%;">
							<form:label path="pass2">비밀번호 확인</form:label>
						</div>
						<form:input path="pass2" type="password"
							style="width: 200px; height: 20px;" placeholder="비밀번호 입력 확인" />
					</div>
					<br>

					<!-- 이름 -->
					<div class="join_4">
						<div class="join_id" style="width: 10%;">
							<form:label path="name">이름</form:label>
						</div>
						<form:input path="name" type="text"
							style="width: 200px; height: 20px;" placeholder="이름 입력" />
					</div>
					<br>

					<!-- 직책 -->
					<div class="join_5">
						<div class="join_id" style="width: 10%;">
							<form:label path="position">직책</form:label>
						</div>
						<form:select path="position">
							<form:option value='관리자'>관리자</form:option>
							<form:option value='부관리자'>부관리자</form:option>
						</form:select>
					</div>
					<br>


					<!-- 등록버튼 -->
					<div class="join_7">

						<form:button class="join_btn">등록</form:button>
					</div>

				</form:form>

			</div>
		</div>
	</section>

</body>

</html>