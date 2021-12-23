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
	<link href="../../css/관리자상품리뷰확인.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>     
	
<script>
function update(order_num, ship_id, invoice_id){
	var answer = confirm("해당 배송정보를 업데이트하시겠습니까?");
	if(answer){
		var order_status = document.getElementById(ship_id).value;
		var invoice_number = document.getElementById(invoice_id).value;
		location.href="${root }admin/order/modify_pro?order_num="+order_num+"&order_status="+order_status+"&invoice_number="+invoice_number;
	}else{
	   	return false;
	}
}


$(function() {    //화면 다 뜨면 시작
    $("#searchbox").autocomplete({
        source : function( request, response ) {
             $.ajax({
                    type: 'get',
                    url: '${root}admin/member/keyword',
                    dataType: "json",
                    //data: {"param":"param"},
                    success: function(data) {
                        //서버에서 json 데이터 response 후 목록에 추가
                        response($.ui.autocomplete.filter(data, request.term));
                    }
               });
            },    // source 는 자동 완성 대상
        select : function(event, ui) {    //아이템 선택시
            console.log(ui.item.label);    
            location.href = "${root}admin/order/search?keyword="+ui.item.label;
        },
        focus : function(event, ui) {    //포커스 가면
            return false;//한글 에러 잡기용도로 사용됨
        },
        minLength: 1,// 최소 글자수
        autoFocus: true, //첫번째 항목 자동 포커스 기본값 false
        classes: {    //잘 모르겠음
            "ui-autocomplete": "highlight"
        },
        delay: 100,    //검색창에 글자 써지고 나서 autocomplete 창 뜰 때 까지 딜레이 시간(ms)
        disabled: false, //자동완성 기능 끄기
        position: { my : "right top", at: "right bottom" },
        close : function(event){    //자동완성창 닫아질때 호출
            console.log(event);
        }
    });
    
});
</script>
</head>

<body>

	<!--사이드바에 들어갈 내용들-->
	<c:import url="/WEB-INF/views/admin/include/navi.jsp" />


	<section>
		<div class="main">
			<div class="goods">
				<p><b class="nam1">주문관리 - </b><span class="nam2">주문목록</span></p>


				<!--구매자 검색-->
				회원아이디 <input id="searchbox" placeholder="아이디입력">
			

				<!--상품 리스트 및 배송정보-->
				<div>
					<form>
						<table style="margin-top:1%;">
							<th>아이디</th>
							<th>구매자</th>
							<th>상품정보</th>
							<th>판매가</th>
							<th>수량</th>
							<th>주문일자</th>
							<th>상태</th>
							<th>송장번호</th>
							<th>총 결제금액</th>

							<c:forEach var="order" items="${orderlist}" varStatus="idx">
								<tr>
									<td>${order.member_id }</td>
									<td>${order.name }</td>
									<td>${order.goods_name }</td>
									<td>${order.total_price }</td>
									<td>${order.ea}</td>
									<td>${order.order_date }</td>
									<td><select name="shipping_select" id="ship_${idx.index }">
											<option value="준비중" <c:if test='${order.order_status=="준비중" }'>selected</c:if>>준비중</option>
											<option value="배송중" <c:if test='${order.order_status=="배송중" }'>selected</c:if>>배송중</option>
											<option value="배송완료" <c:if test='${order.order_status=="배송완료" }'>selected</c:if>>배송완료</option>
											<option value="주문취소" <c:if test='${order.order_status=="주문취소" }'>selected</c:if>>주문취소</option>
											<option value="교환" <c:if test='${order.order_status=="교환" }'>selected</c:if>>교환</option>
											<option value="반품" <c:if test='${order.order_status=="반품" }'>selected</c:if>>반품</option>
									</select></td>
									<td><input type="text" class="shipping_num" id="invoice_${idx.index }"
										placeholder="송장번호 입력" value="${order.invoice_number}"></td>
									<td>${order.total_price}</td>
									<td><input type="button" value="수정" class="tab_btn_1" onclick="update('${order.order_num}', 'ship_${idx.index }', 'invoice_${idx.index }')"></td>
								</tr>
							</c:forEach>
						</table>
					</form>
				</div>
			</div>
		</div>

		<!-- order페이지 이동파트 -->
		<div class="page">
			<ul class="pagination justify-content-center">
				<c:choose>
					<c:when test="${pageBean.prevPage <= 0 }">
						<li class="page-item disabled"><a href="#" class="page-link">이전</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a
							href="${root }admin/order/list?page=${pageBean.prevPage}"
							class="page-link">이전</a></li>
					</c:otherwise>
				</c:choose>


				<c:forEach var='idx' begin="${pageBean.min }" end='${pageBean.max }'>
					<c:choose>
						<c:when test="${idx == pageBean.currentPage }">
							<li class="page-item active"><a
								href="${root }admin/order/list?page=${idx}" class="page-link">${idx }</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a
								href="${root }admin/order/list?page=${idx}" class="page-link">${idx }</a></li>
						</c:otherwise>
					</c:choose>

				</c:forEach>

				<c:choose>
					<c:when test="${pageBean.max >= pageBean.pageCnt }">
						<li class="page-item disabled"><a href="#" class="page-link">다음</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a
							href="${root }admin/order/list?page=${pageBean.nextPage}"
							class="page-link">다음</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>

	</section>
</body>
</html>