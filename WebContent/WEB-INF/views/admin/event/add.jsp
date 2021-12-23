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
<link href="../../css/관리자게시글작성.css" type="text/css" rel="stylesheet" />
</head>

<body>

	<!--사이드바에 들어갈 내용들-->
	<c:import url="/WEB-INF/views/admin/include/navi.jsp" />


	<section>
		<div class="main">
			<div class="goods">
				<div>
					<p>
						<b class="nam1">기타 - </b><span class="nam2">이벤트/공지사항게시판 작성</span>
					</p>

					<!--이벤트/공지사항게시판 글 작성-->
					<form action="${root }admin/event/add_pro" method="post" enctype="multipart/form-data">
						<table>
							<tr>
								<th>제목</th>
								<td><input type="text" name="title" size="60"></td>
							</tr>

							<tr>
								<th>글종류</th>
								<td>
									<select name="board_type">
											<option value="공지사항">공지사항</option>
											<option value="이벤트">이벤트</option>
									</select>
								</td>
							</tr>


							<tr>
								<th>상세내용</th>
								<td><textarea rows="10" cols="60" name="content" size="60"></textarea></td>
							</tr>


							<tr>
								<th>이미지첨부</th>
								<td><input type="file" name="event_img_url"
									multiple="multiple"></td>
							</tr>

							<tr>
								<td colspan="2"><input type="submit" value="글등록" class="tab_btn_1"> 
								<input type="reset" value="재작성" class="tab_btn_1"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>

</html>