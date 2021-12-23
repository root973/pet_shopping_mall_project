<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />

<!DOCTYPE html>
<html lang="en">
<script src="https://kit.fontawesome.com/115203431c.js"
	crossorigin="anonymous"></script>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="../js/jsmobilemenu.js"></script>
<script type="text/javascript" src="../js/searchbox.js"></script>
<link href="../css/header.css" type="text/css" rel="stylesheet" />
<link href="../css/main.css" type="text/css" rel="stylesheet" />
<link href="../css/리뷰문의작성.css" type="text/css" rel="stylesheet" />
<link href="../css/상세페이지.css" type="text/css" rel="stylesheet" />
<link href="../css/상세페이지2.css" type="text/css" rel="stylesheet" />
<link href="../css/footer.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<!-- 헤더 -->
	<c:import url="/WEB-INF/views/include/sub_header.jsp" />


	<section>
		<!-- 상품이미지, 상품옵션선택 -->
		<div class="sangdan">
			<!-- 상품이미지나올곳 -->
			<div class="left_menu">
				<img src="../${goods.thumbnail_img_url }"
					style="width: 100%; height: 100%;">
			</div>

			<!-- 상품 옵션선택 수량넣을곳 -->
			<form action="${root }cart/add_pro_cart" method="post">
				<input type="hidden" value="${loginBean.member_id }" name="member_id"> 
				<input type="hidden" value="${goods.goods_code }" name="goods_code"> 
				<input type="hidden" value="${goods.goods_name}" name="goods_name">
				<input type="hidden" value="${goods.thumbnail_img_url}" name="img_url"> 
				<input type="hidden" value="${goods.price}" name="price">
				<!-- 상품 옵션선택 수량넣을곳 -->
				<div class="right_menu">
					<!-- 상품명,수량나올곳 -->
					<div class="r_menu1">
						<div class="product_name">${goods.goods_name }</div>
						<div class="size_option">
							사이즈 옵션 <select name="option_1">
								<c:forEach var="option_1" items="${option_1 }">
									<option value="${option_1 }">${option_1 }</option>
								</c:forEach>
							</select> <select name="option_2">
								<c:forEach var="option_2" items="${option_2 }">
									<option value="${option_2 }">${option_2 }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<!-- 판매가,배송비나올곳 -->
					<div class="r_menu2">

						<div class="r_menu2_1">
							<div>판매가</div>
							<div id="ris">${goods.price}</div>
						</div>

						<div class="r_menu2_1">
							<div>배송방법</div>
							<div>국내배송</div>
						</div>

						<div class="r_menu2_1">
							<div>배송비</div>
							<div>3000원</div>
						</div>
						<c:if test="${loginBean.memberLogin==true }">
							<div class="r_menu2_1">
								<div>수량</div>
								<div class="cut">
									<input type="button" value="-" onclick="minus()"> 
									<input type="text" value="1" name="ea" id="con1" readonly="readonly"> 
									<input type="button" value="+" onclick="plus()">
							</div>
						</div>
						</c:if>


					</div>
					<c:if test="${loginBean.memberLogin==true }">
											<!-- 버튼클릭시 수량,가격나올곳 -->
						<div class="r_menu3">
							<div class="r_menu3_1">총액</div>
							<div class="r_menu3_2">
							<input type="text" value="${goods.price }" id="pr1" readonly="readonly">
							<div class="r_menu4_1">원</div>
						</div>
						</div>
						<div class="r_menu3">
							<input type="submit" value="구매하기"> 
							<input type="button" value="장바구니담기" onclick="return submit2(this.form);">
						</div>
					</c:if>

				</div>
			</form>
		</div>






		<!--중간에 상세정보,문의하기,리뷰,환불내용 다있써브러~-->
		<div class="contentbox" id="a1">

			<div class="tab_btn">
				<div class="tab_sub" style="background-color: #333;">
					<a href="#" style="color: #f3f3f3;">상품상세정보</a>
				</div>
				<div class="tab_sub">
					<a href="#a2">상품구매안내</a>
				</div>
				<div class="tab_sub">
					<a href="#a3">상품사용후기</a>
				</div>
				<div class="tab_sub">
					<a href="#a4">상품Q&A</a>
				</div>
			</div>

			<!-- 상품상세정보창 -->
			<c:forEach var="detail_img_url" items="${detail_img_url}">
				<div class="tab_info">
					<img src="../${detail_img_url }" style="width: 100%;">
				</div>
			</c:forEach>



			<div class="tab_guide" id="a2">
				<!-- 탭버튼 -->
				<div class="tab_btn">
					<div class="tab_sub">
						<a href="#a1">상품상세정보</a>
					</div>
					<div class="tab_sub" style="background-color: #333;">
						<a href="#" style="color: #f9f9f9;">상품구매안내</a>
					</div>
					<div class="tab_sub">
						<a href="#a3">상품사용후기</a>
					</div>
					<div class="tab_sub">
						<a href="#a4">상품Q&A</a>
					</div>
				</div>


				<!-- 구매안내창 -->
				<div class="tab_guide_1">
					<div class="tab_guide_1_1">
						<div>
							<span style="margin-right: 10px;"> <i
								class="far fa-credit-card"></i></span> <span>상품결제정보</span>
						</div>
					</div>

					<div class="tab_guide_1_2">
						<div>
							<span style="font-size: 14px;"><b>[제품 출시일]</b></span> <br>
							<p style="font-size: 14px; color: gray;">- 보고펫 제주담은 덴탈츄 3종
								(돼지/광어/닭):21년 11월 15일</p>
							<br>
							<p style="font-size: 14px; color: gray;">고액 결제의 경우 안전을 위해
								카드사에서 확인전화를 드릴 수도 있습니다. 확인과정에서 도난 카드의 사용이나 타인 명의의 주문등 정상적인 주문이
								아니라고 판단될 경우 임의로 주문 을 보류 또는 취소할 수 있습니다.</p>
							<br>
							<p style="font-size: 14px; color: gray;">
								무통장 임금은 상품 구매 대금은 PC뱅킹, 인터넷 뱅킹, 텔레뱅킹 혹은 가까운 은행에서 직접 입금하시면 됩니다. <br>주문시
								입력한 입금자명과 실제입금자의 성명이 반드시 일치하여야 하며, 7일 이내로 입금을 하셔야 하며 입금되지 않은 주문은
								자동취소 됩니다.
							</p>
						</div>
					</div>
				</div>

				<div class="tab_guide_2">
					<div class="tab_guide_2_1">
						<div>
							<span style="margin-right: 10px;"><i
								class="fas fa-box-open"></i></span><span>배송정보</span>
						</div>
					</div>
					<div class="tab_guide_2_2">
						<div>
							<p style="font-size: 14px; color: gray;">
								배송 방법: <span>택배</span>
							</p>
							<p style="font-size: 14px; color: gray;">
								배송 지역: <span>3000원</span>
							</p>
							<p style="font-size: 14px; color: gray;">
								배송 기간: <span>1일 ~ 3일</span>
							</p>
							<p style="font-size: 14px; color: gray;">
								배송 안내: <span>-산간벽지나 도서지방은 별도의 추가금액을 집ㄹ하셔야 하는 경우가 있습니다.</span><br>
								고객님꼐서 주문하신 상품은 입금 확인후 배송해 드립니다. 다만, 상품종류에 따라서 상품의 배송이 다소 지연될 수
								있습니다.
							</p>
						</div>
					</div>
				</div>

				<div class="tab_guide_3">
					<div class="tab_guide_3_1">
						<div>
							<span style="margin-right: 10px;"><i
								class="fas fa-exchange-alt"></i></span><span>교환 및 반품정보</span>
						</div>
					</div>
					<div class="tab_guide_3_2">
						<div>
							<span><b><p>교환 및 반품이 가능한 경우</p></b></span>
							<p style="font-size: 14px; color: gray;">-상품을 공급 받으신 날로부터
								7일이내 단, 가전제품의 경우 포장을 개봉하였거나 포장이 훼손되어 강품가치가 상실된 경우에는 교환/반품이
								불가능합니다.</p>
							<p style="font-size: 14px; color: gray;">-공급받으신 상품 및 용역의 내용이
								표시.광고 내용과 다르거나 다르게 이행된 경우에는 공급받은 날로부터 3월이내, 그 사실을 알게 된 날로부터
								30일이내</p>
							<span><b><p>교환 및 반품이 불가능한 경우</p></b></span>
							<p style="font-size: 14px; color: gray;">-포장을 개봉하였거나 포장이 훼손되어
								상품가치가 상실된 경우</p>
							<p style="font-size: 14px; color: gray;">-복제가 가능한 상품등의 포장을
								훼손한 경우</p>
							<p style="font-size: 14px; color: gray;">-시간의 경과에 의하여 재판매가
								곤란할 정도로 상품등의 가치가 현저히 감소한 경우</p>
							<p style="font-size: 14px; color: gray;">-고객님의 사용 또는 일부 소비에
								의하여 상품의 가치가 현저히 감소한경우 단, 화장품등의 경우 사용제품을 제공한 경우에 한 합니다.</p>
						</div>
					</div>
				</div>

			</div>



			<div class="tab_review" id="a3">
				<!--(상품리뷰)컨텐츠내용-->

				<div class="tab_btn">
					<div class="tab_sub">
						<a href="#a1">상품상세정보</a>
					</div>
					<div class="tab_sub">
						<a href="#a2">상품구매안내</a>
					</div>
					<div class="tab_sub" style="background-color: #333;">
						<a href="#a3" style="color: #f9f9f9;">상품사용후기</a>
					</div>
					<div class="tab_sub">
						<a href="#a4">상품Q&A</a>
					</div>
				</div>

				<div>
					<h2 class="review" style="left: 45%;">상품 리뷰</h2>
				</div>
				
				<!-- 리뷰 가져오기 -->
				<div class="question_list" id="review_list"></div>

				<c:forEach var="reviewList" items="${reviewList}" varStatus="reviewIdx">
					<div class="accordion">
						<!--상품리스트-->
						<input type="radio" name="gg" id="answer${reviewIdx.index+1}">
						<label for="answer${reviewIdx.index+1}" id="answer${reviewIdx.index+1}">${reviewList.content}</label>
						<c:choose>
							<c:when test="${reviewList.content_reply==null }">
							</c:when>
							<c:otherwise>
								<div>
									<p>re.${reviewList.content_reply}</p>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<!--리뷰창 끝-->
				</c:forEach>

				<!-- 리뷰페이지 이동파트 -->
				<div class="page">
					<ul class="pagination justify-content-center">
						<c:choose>
							<c:when test="${pageBean_r.prevPage <= 0 }">
								<li class="page-item disabled"><a href="#" class="page-link">이전</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a
									href="${root }goods/detail?goods_code=${goods.goods_code}&page_r=${pageBean_r.prevPage}&page_q=1&#review_list"
									class="page-link">이전</a></li>
							</c:otherwise>
						</c:choose>
			
			
						<c:forEach var='idx' begin="${pageBean_r.min }" end='${pageBean_r.max }'>
							<c:choose>
								<c:when test="${idx == pageBean_r.currentPage }">
									<li class="page-item active"><a
										href="${root }goods/detail?goods_code=${goods.goods_code}&page_r=${idx}&page_q=1&#review_list"
										class="page-link">${idx }</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a
										href="${root }goods/detail?goods_code=${goods.goods_code}&page_r=${idx}&page_q=1&#review_list"
										class="page-link">${idx }</a></li>
								</c:otherwise>
							</c:choose>
			
						</c:forEach>
			
						<c:choose>
							<c:when test="${pageBean_r.max >= pageBean_r.pageCnt }">
								<li class="page-item disabled"><a href="#" class="page-link">다음</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a
									href="${root }goods/detail?goods_code=${goods.goods_code}&page_r=${pageBean_r.nextPage}&page_q=1&#review_list"
									class="page-link">다음</a></li>
							</c:otherwise>
						</c:choose>
			
					</ul>
				</div>
				
				<!-- 리뷰입력 -->
				<c:if test="${loginBean.memberLogin==true}">
					<form action="${root }goods/reg_review" method="post">
						<input type="hidden" value="${goods.goods_code }"
							name="goods_code"> <input type="hidden"
							value="${loginBean.member_id }" name="r_member_id">


						<div class="review_main"></div>
						<div class="review_main"></div>
						<div class="review_con">
							<textarea cols="106" rows="5" placeholder="상품평 입력(최대 300자)"
								name="r_content" onkeyup="fn_checkByte(this)"></textarea>
							<sup>(<span id="nowByte">0</span>/300자)
							</sup>
						</div>

						<div class="review_btn">
							<span> <input type="submit" class="review_btn1" value="등록">
								<input type="reset" class="review_btn1" value="취소">
							</span>
						</div>
					</form>
				</c:if>
			</div>


			<div class="tab_qa" id="a4">

				<div class="tab_btn">
					<div class="tab_sub">
						<a href="#a1">상품상세정보</a>
					</div>
					<div class="tab_sub">
						<a href="#a2">상품구매안내</a>
					</div>
					<div class="tab_sub">
						<a href="#a3">상품사용후기</a>
					</div>
					<div class="tab_sub" style="background-color: #333;">
						<a href="#" style="color: #f9f9f9;">상품Q&A</a>
					</div>
				</div>
				<div>
					<h2 class="review" style="left: 45%;">상품Q&A</h2>
				</div>
				
				<div class="question_list" id="question_list">
					<div class="question_list_1">
						<!--상품리스트-->
					</div>
					<c:forEach var="qnaList" items="${qnaList}" varStatus="qnaIdx">
						<div class="accordion">
							<!--상품리스트-->
							<input type="radio" name="gg" id="reply0${qnaIdx.index+1}">
							<label for="reply0${qnaIdx.index+1}">Q.${qnaList.q_content}</label>
							<c:choose>
								<c:when test="${qnaList.a_content==null }">
									<div>
										<p>아직 답변하지 않은 질문입니다.</p>
									</div>
								</c:when>
								<c:otherwise>
									<div>
										<p>A.${qnaList.a_content}</p>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</c:forEach>
					<!--상품리스트끝-->
			
			<!-- qna페이지 이동파트 -->
					<div class="page">
						<ul class="pagination justify-content-center">
							<c:choose>
								<c:when test="${pageBean_q.prevPage <= 0 }">
									<li class="page-item disabled"><a href="#" class="page-link">이전</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a
										href="${root }goods/detail?goods_code=${goods.goods_code}&page_r=1&page_q=${pageBean_q.prevPage}&#question_list"
										class="page-link">이전</a></li>
								</c:otherwise>
							</c:choose>
				
				
							<c:forEach var='idx' begin="${pageBean_q.min }" end='${pageBean_q.max }'>
								<c:choose>
									<c:when test="${idx == pageBean_q.currentPage }">
										<li class="page-item active"><a
											href="${root }goods/detail?goods_code=${goods.goods_code}&page_r=1&page_q=${idx}&#question_list"
											class="page-link">${idx }</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a
											href="${root }goods/detail?goods_code=${goods.goods_code}&page_r=1&page_q=${idx}&#question_list"
											class="page-link">${idx }</a></li>
									</c:otherwise>
								</c:choose>
				
							</c:forEach>
				
							<c:choose>
								<c:when test="${pageBean_q.max >= pageBean_q.pageCnt }">
									<li class="page-item disabled"><a href="#" class="page-link">다음</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a
										href="${root }goods/detail?goods_code=${goods.goods_code}&page_r=1&page_q=${pageBean_q.nextPage}&#question_list"
										class="page-link">다음</a></li>
								</c:otherwise>
							</c:choose>
				
						</ul>
					</div>		
			
					
					
				<!-- 상품문의 작성 -->
				<c:if test="${loginBean.memberLogin==true}">
					<form action="${root }goods/reg_qna" method="post">
						<input type="hidden" value="${goods.goods_code }"
							name="goods_code"> <input type="hidden"
							value="${loginBean.member_id }" name="q_member_id">

						<div class="review_main"></div>
						<div class="review_con">
							<textarea cols="106" rows="5" placeholder="질문 입력(최대 300자)"
								name="q_content" onkeyup="fn_checkByte2(this)"></textarea>
							<sup>(<span id="nowByte2">0</span>/300자)
							</sup>
						</div>
						<div class="review_btn">
							<span> <input type="submit" class="review_btn1" value="등록">
								<input type="reset" class="review_btn1" value="취소">
							</span>
						</div>
					</form>
				</c:if>

					

				</div>
			</div>
		</div>
		<!-- 콘텐츠박스  -->


	</section>
	
	

	<!-- 하단 -->
	<c:import url="/WEB-INF/views/include/footer.jsp" />
	<script>
		var a;
		var b;
		a = parseInt(con1.value);
		b = parseInt(pr1.value);
		var c = document.getElementById("ris");
		twe = parseInt(c.innerText);

		function plus() {
			if (a < 99) {
				con1.value = ++a;
				pr1.value = parseInt(pr1.value) + twe;
				sumpr.value = parseInt(sumpr.value) + twe;
			}
		}

		function minus() {
			if (a > 1) {
				con1.value = --a;
				pr1.value = parseInt(pr1.value) - twe;
				sumpr.value = parseInt(sumpr.value) - twe;
			}
		}

		function submit2(frm) {
			frm.action = "${root}cart/add_pro";
			frm.submit();
			return true;
		}

		function fn_checkByte(obj) {
			const maxlength = 300; //최대 300자
			const text_val = obj.value; //입력한 문자
			const text_len = text_val.length; //입력한 문자수

			let totallength = 0;
			for (let i = 0; i < text_len; i++) {
				totallength++;
			}

			if (totallength > maxlength) {
				alert('최대 300자까지만 입력가능합니다.');
				document.getElementById("nowByte").innerText = totallength;
				document.getElementById("nowByte").style.color = "red";
			} else {
				document.getElementById("nowByte").innerText = totallength;
				document.getElementById("nowByte").style.color = "green";
			}
		}
		function fn_checkByte2(obj) {
			const maxlength = 300; //최대 300자
			const text_val = obj.value; //입력한 문자
			const text_len = text_val.length; //입력한 문자수

			let totallength = 0;
			for (let i = 0; i < text_len; i++) {
				totallength++;
			}

			if (totallength > maxlength) {
				alert('최대 300자까지만 입력가능합니다.');
				document.getElementById("nowByte2").innerText = totallength;
				document.getElementById("nowByte2").style.color = "red";
			} else {
				document.getElementById("nowByte2").innerText = totallength;
				document.getElementById("nowByte2").style.color = "green";
			}
		}
	</script>
</body>

</html>