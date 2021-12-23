<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>

<!DOCTYPE html>
<html lang="en">
<script src="https://kit.fontawesome.com/115203431c.js" crossorigin="anonymous"></script>


<head>
	<link href="../css/관리자메인.css" type="text/css" rel="stylesheet" />
    <link href="../css/관리자사이드.css" type="text/css" rel="stylesheet" />
</head>

<body>
	
	<!--사이드바에 들어갈 내용들-->
	<c:import url="/WEB-INF/views/admin/include/navi.jsp"/>

    <section class="section">
        <!-- 1번째 화면 최근 리뷰 -->
        <div class="review_list">
            <div>
                <div><b>최근 리뷰 리스트</b></div>
                <div><a href="${root}admin/review/list">더보기</a></div>
            </div>
            <div>
                <table>
                    
                    <thead>
                        <tr>
                            <th class="aa">상품코드</th>
                            <th>내용</th>
                            <th class="bb">고객아이디</th>
                        </tr>
                    </thead>
                    <c:forEach var="review" items="${reviewList}">
                    	<tbody>
	                        <tr>
	                            <td>${review.goods_code }</td>
	                            <td>${review.content }</td>
	                            <td>${review.member_id }</td>
	                        </tr>
                    	</tbody>
                    </c:forEach>
                </table>
            </div>
        </div>
        <!-- 2번째 화면 최근 문의 -->
        <div class="question_list">
            <div>
                <div><b>최근 문의 리스트</b></div>
                <div><a href="${root}admin/qna/list">더보기</a></div>
            </div>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th class="aa">상품코드</th>
                            <th>내용</th>
                            <th class="bb">고객아이디</th>
                        </tr>
                    </thead>
                    <c:forEach var="qna" items="${qnaList}">
                    	<tbody>
	                        <tr>
	                            <td>${qna.goods_code }</td>
	                            <td>${qna.q_content }</td>
	                            <td>${qna.member_id }</td>
	                        </tr>
                    	</tbody>
                    </c:forEach>
                </table>
            </div>
        </div>

        <!-- 3번째 화면 최근 주문 목록 -->
        <div class="order_list">
            <div>
                <div><b>최근 주문 목록 리스트</b></div>
                <div><a href="${root}admin/order/list">더보기</a></div>
            </div>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>구매자</th>
                            <th>상품정보</th>
                            <th>결제금액</th>
                            <th>상태</th>
                        </tr>
                    </thead>
                    <c:forEach var="order" items="${orderList}">
                    	<tbody>
	                        <tr>
	                            <td>${order.name }</td>
	                            <td>${order.goods_name }</td>
	                            <td>${order.total_price }</td>
	                            <td>${order.order_status }</td>
	                        </tr>
                    	</tbody>
                    </c:forEach>
                </table>
            </div>
        </div>
        <!-- 4번째 화면 제품 판매 순위 -->
        <!-- 순위는 1~5위까지만 나오게끔-->
        <div class="bestseller_list">
            <div>
                <div><b>제품 판매 순위 리스트</b></div>
            </div>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>순위</th>
                            <th>상품명</th>
                            <th>분류</th>
                            <th>가격</th>
                        </tr>
                    </thead>
                    <c:forEach var="goods" items="${goodsList}" varStatus="idx">
                    	<tbody>
	                        <tr>
	                            <td><b>${idx.index+1}</b></td>
	                            <td>${goods.goods_name }</td>
	                            <td>${goods.category_small }</td>
	                            <td>${goods.price }원</td>

	                        </tr>
                    	</tbody>
                    </c:forEach>
                </table>
            </div>
        </div>



    </section>

</body>

</html>