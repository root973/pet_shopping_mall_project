<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />

<!--사이드바에 들어갈 내용들-->
<nav>

	<div class="sidecon">

		<div class="admin">
			<input type="radio" name="jaekwon" id="side0"> <label
				for="side0"><i class="fas fa-home"></i><a href="${root}admin/main">HOME</a></label>

			<!--관리자-->
			<input type="radio" name="jaekwon" id="side1"> <label
				for="side1"><i class="far fa-user"></i><a>관리자</a></label>
			<div>
				<div class="submenu">
					<a href="${root}admin/admin_mem/add">관리자 등록</a>
				</div>
				<div class="submenu">
					<a href="${root}admin/admin_mem/list">관리자 수정/삭제</a>
				</div>
			</div>

			<!--회원관리-->
			<input type="radio" name="jaekwon" id="side2"> <label
				for="side2"><i class="far fa-user"></i><a>회원관리</a></label>
			<div>
				<div class="submenu">
					<a href="${root}admin/client_mem/list_del">회원탈퇴</a>
				</div>
				<div class="submenu">
					<a href="${root}admin/client_mem/list_point">포인트수정</a>
				</div>
			</div>

			<!--상품관리-->
			<input type="radio" name="jaekwon" id="side3"> <label
				for="side3"><i class="fas fa-tasks"></i><a>상품관리</a></label>
			<div>
				<div class="submenu">
					<a href="${root}admin/goods/add">상품 등록</a>
				</div>
				<div class="submenu">
					<a href="${root}admin/goods/list">상품 수정/삭제</a>
				</div>
			</div>

			<!--주문관리-->
			<input type="radio" name="jaekwon" id="side4"> <label
				for="side4"><i class="far fa-list-alt"></i><a>주문관리</a></label>
			<div>
				<div class="submenu">
					<a href="${root}admin/order/list">주문 목록</a>
				</div>
			</div>

			<!--리뷰,댓글-->
			<input type="radio" name="jaekwon" id="side5"> <label
				for="side5"><i class="far fa-comment"></i><a>리뷰/문의</a></label>
			<div class="sub">
				<div class="submenu">
					<a href="${root}admin/review/list">상품리뷰확인</a>
				</div>
				<div class="submenu">
					<a href="${root}admin/qna/list">상품문의확인</a>
				</div>
			</div>

			<!--기타-->
			<input type="radio" name="jaekwon" id="side6"> <label
				for="side6"><i class="far fa-calendar-alt"></i><a>기타</a></label>
			<div class="sub">
				<div class="submenu">
					<a href="${root}admin/event/list">공지사항/이벤트 리스트</a>
				</div>
				<div class="submenu">
					<a href="${root}admin/event/add">공지사항/이벤트 작성</a>
				</div>
			</div>
			<div class="booo">
				<input type="button" class="title_a" value="로그아웃" onclick="location.href='${root}admin/logout'">
			</div>
		</div>
	</div>
	
</nav>