<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>


<!DOCTYPE html>
<html lang="en">
  <script src="https://kit.fontawesome.com/115203431c.js" crossorigin="anonymous"></script>
<head>
	<link href="../../css/관리자메인.css" type="text/css" rel="stylesheet" />
    <link href="../../css/관리자사이드.css" type="text/css" rel="stylesheet" />
    <link href="../../css/관리자등록.css" type="text/css" rel="stylesheet" />
</head>
<script>
	window.onload = function(){
		var pos = document.getElementById("position");
		
		for(var i=0; i<pos.length; i++){
			if(pos[i].value=='${admin.position}'){
				pos[i].selected = true;
			}
		}
	}
	
	function del_check(){
		if('${admin.admin_id}'!='root'){
			var answer = confirm("해당 계정을 정말 삭제하시겠습니까?");
		   	 if(answer){
		   		 location.href="${root }admin/admin_mem/delete_pro?admin_id=${admin.admin_id}";
		   	 }else{
		   		 return false;
		   	 }
		}else{
			alert("root계정은 삭제가 불가능합니다");
		}
	   	 
    }
</script>
<body>
  
  	<!--사이드바에 들어갈 내용들-->
	<c:import url="/WEB-INF/views/admin/include/navi.jsp"/>

<section>
		<div class="main">

				<form action="${root}admin/admin_mem/modify_pro" class="joinform" method="post">

					<p>
						<b class="nam1">관리자 - </b><span class="nam2">관리자 정보수정/삭제</span>
					</p>
					<br> <input type="hidden" name="admin_id"
						value="${admin.admin_id }">
					<!-- 아이디 -->

					<div class="join_1">
						<div class="join_id" style="width: 10%;">
							<div>아이디</div>
						</div>
						<div style="width: 200px; height: 20px; display: inline-block;">${admin.admin_id }</div>
					</div>

					<!-- 비밀번호 / 확인 -->
					<div class="join_2">
						<div class="join_id" style="width: 10%;">
							<div>비밀번호</div>
						</div>
						<input name="pass" type="password"
							style="width: 200px; height: 20px;" placeholder="비밀번호 입력"
							value="${admin.pass }" />
					</div>
					<br>

					<div class="join_3">
						<div class="join_id" style="width: 10%;">
							<div>비밀번호 확인</div>
						</div>
						<input name="pass2" type="password"
							style="width: 200px; height: 20px;" placeholder="비밀번호 입력 확인"
							value="${admin.pass }" />
					</div>
					<br>
					<!-- 이름 -->
					<div class="join_4">
						<div class="join_id" style="width: 10%;">
							<div>이름</div>
						</div>
						<input name="name" type="text" style="width: 200px; height: 20px;"
							placeholder="이름 입력" value="${admin.name}" />
					</div>
					<br>
					<!-- 직책 -->

					<div class="join_5">
						<div class="join_id" style="width: 10%;">
							<div>직책</div>
						</div>
						<select name="position">
							<option value='관리자'>관리자</option>
							<option value='부관리자'>부관리자</option>
						</select>
					</div>
					<br>

					<!-- 수정/삭제 버튼 -->
					<div class="join_7">
						<input type="submit" class="join_btn" value="수정"> <input
							type="button" class="join_btn" value="삭제" onclick="del_check()">
					</div>

				</form>


		</div>
	</section>

</body>

</html>