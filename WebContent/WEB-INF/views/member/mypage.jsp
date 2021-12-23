<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="../js/jsmobilemenu.js"></script>
<script type="text/javascript" src="../js/searchbox.js"></script>
<script type="text/javascript" src="../js/장바구니.js"></script>
<title>트렌독_로그인</title>
<link href="../css/mypage.css" type="text/css" rel="stylesheet" />
<link href="../css/header.css" type="text/css" rel="stylesheet" />
<link href="../css/footer.css" type="text/css" rel="stylesheet" />
<link href="../css/main.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<c:import url="/WEB-INF/views/include/sub_header.jsp" />

	<section class="section">

		<div class="menuselection">

			<div class="menu_a">
				<label><input type="radio" name="clientmenu" id="menu_a">구매목록관리</label>
			</div>
			<div class="menu_b">
				<label><input type="radio" name="clientmenu" id="menu_b">리뷰,문의</label>
			</div>
		</div>


		<!-- 여기서부터 주문목록-->

		<div class="order_list" id="form_2">
			<div>
				<h1>내 주문목록</h1>
			</div>
			<div class="title">
				<div class="buy_date">주문날짜</div>
				<div class="item">상품명</div>
				<div class="count">수량</div>
				<div class="shipping">배송비</div>
				<div class="state">상태</div>
				<div class="invonumber">송장번호</div>
				<div class="sum">합계</div>
			</div>

			<c:forEach var="myorderlist" items="${myorderlist}">
				<div class="item_list">
					<div class="buy_date">${myorderlist.order_date}</div>

					<div class="item">
						<div class="listinfo">
							<a
								href="${root }goods/detail?goods_code=${myorderlist.goods_code}">
								${myorderlist.goods_name} </a>
						</div>
					</div>

					<div class="count">
						<span id='result1'>${myorderlist.ea}</span>
					</div>

					<div class="shipping">3,000</div>

					<div class="state">${myorderlist.order_status}</div>

					<c:choose>
						<c:when test="${!empty myorderlist.invoice_number}">
							<div class="invonumber">${myorderlist.invoice_number}</div>
						</c:when>
						<c:otherwise>
							<div class="invonumber">배송 준비중입니다.</div>
						</c:otherwise>
					</c:choose>

					<div class="sum">${myorderlist.total_price}원</div>

				</div>
			</c:forEach>
		</div>

		<!-- "리뷰 후기" -->

		<div class="review_question">
			<div>

				<div>
					<h1>내가 올린 리뷰</h1>
				</div>
				<div class="rq_list">
					<div class="rq_data">등록 날짜</div>
					<div class="rq_info">상품정보</div>
					<div class="rq_review">리뷰</div>
					<div class="rq_question">답글</div>
				</div>

				<c:forEach var="reviewmap" items="${myreviewmap}">
					<div class="list_title">
						<div class="rq_data">${reviewmap.key.reg_date}</div>
						<div class="rq_info">
							<a href="${root}goods/detail?goods_code=${reviewmap.key.goods_code}">
							${reviewmap.value }
							</a>
						</div>
						<div class="rq_review">${reviewmap.key.content}</div>
						<c:choose>
							<c:when test="${!empty reviewmap.key.content_reply }">
								<div class="rq_question">${reviewmap.key.content_reply}</div>
							</c:when>
							<c:otherwise>
								<div class="rq_question">답글이 없습니다.</div>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
			</div>
			<div>
				<div>
					<h1>내가 올린 질문</h1>
				</div>
				<div class="rq_list">
					<div class="rq_data">날짜</div>
					<div class="rq_info">상품정보</div>
					<div class="rq_review">문의</div>
					<div class="rq_question">답변</div>
				</div>
				<c:forEach var="qnamap" items="${myqnamap }">
					<div class="list_title">
						<div class="rq_data">${qnamap.key.reg_date}</div>
						<div class="rq_info">
						<a href="${root}goods/detail?goods_code=${qnamap.key.goods_code}">
						${qnamap.value }
						</a>
						</div>
						<div class="rq_review">
							${qnamap.key.q_content}
						</div>
						<c:choose>
							<c:when test="${!empty qnamap.key.a_content }">
								<div class="rq_question">${qnamap.key.a_content}</div>
							</c:when>
							<c:otherwise>
								<div class="rq_question">답변이 없습니다.</div>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
			</div>
		</div>



	</section>
	<c:import url="/WEB-INF/views/include/footer.jsp" />
</body>
<script>
	function count1(type) {
		// 결과를 표시할 element
		const resultElement = document.getElementById('result1');

		// 현재 화면에 표시된 값
		let number = resultElement.innerText;

		// 더하기/빼기
		if (type === 'plus') {
			number = parseInt(number) + 1;
		} else if (type === 'minus' && parseInt(number) >= 1) {
			number = parseInt(number) - 1;
		}

		// 결과 출력
		resultElement.innerText = number;
	}
</script>
<script>
	function count2(type) {
		// 결과를 표시할 element
		const resultElement = document.getElementById('result2');

		// 현재 화면에 표시된 값
		let number = resultElement.innerText;

		// 더하기/빼기
		if (type === 'plus') {
			number = parseInt(number) + 1;
		} else if (type === 'minus' && parseInt(number) >= 1) {
			number = parseInt(number) - 1;
		}

		// 결과 출력
		resultElement.innerText = number;
	}

	var a = document.getElementById("menu_a");
	var a1 = document.getElementsByClassName("order_list")[0];
	var b = document.getElementById("menu_b");
	var b1 = document.getElementsByClassName("review_question")[0];

	a.addEventListener("click", function() {
		a1.style = " display: block;";
		b1.style = " display: none";
	});
	b.addEventListener("click", function() {
		a1.style = " display: none";
		b1.style = " display: block";

	});
</script>

</html>