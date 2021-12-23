<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html lang="en">
<script src="https://kit.fontawesome.com/115203431c.js"
	crossorigin="anonymous"></script>

<head>
<link href="../../css/관리자메인.css" type="text/css" rel="stylesheet" />
<link href="../../css/관리자사이드.css" type="text/css" rel="stylesheet" />
<link href="../../css/관리자리뷰답글.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<!--사이드바에 들어갈 내용들-->
	<c:import url="/WEB-INF/views/admin/include/navi.jsp" />

	<section>
		<div class="main">
			<div class="goods">

				<div class="">
					<p>
						<b class="nam1">리뷰/문의 - </b><span class="nam2">관리자 리뷰 답글 작성</span>
					</p>
					<table class="">
						<tbody>
							<tr>
								<th class="">작성일</th>
								<td class="">${qna.reg_date }</td>
							</tr>
							<tr>
								<th class="">상품코드</th>
								<td class="">${qna.goods_code }</td>
							</tr>
							<tr>
								<th class="">고객아이디</th>
								<td class="">${qna.member_id}</td>
							</tr>
							<tr>
								<th class="">리뷰내용</th>
								<td class="">${qna.q_content }</td>
							</tr>
						</tbody>
					</table>
					<!-- 답글 내용 -->
					<form action="${root }admin/qna/answer_pro" method="post">
						<input type="hidden" name="q_num" value="${qna.q_num}">
						<div class="">
							<div>답글달기</div>
							<textarea cols="150%" rows="10" placeholder="내용을입력하시오"
								style="border: 1px solid #ccc;" name="a_content"></textarea>
	
						</div>
						<div class="tab_btn">
							<input type="submit" class="tab_btn_1" value="작성">
						</div>
					</form>
				</div>

			</div>
		</div>
	</section>

</body>

</html>