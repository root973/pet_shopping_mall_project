<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>서브 카테고리</title>
    <script type="text/javascript" src="../js/jsmobilemenu.js"></script>
    <script type="text/javascript" src="../js/searchbox.js"></script>
    <link href="../css/header.css" type="text/css" rel="stylesheet" />
    <link href="../css/main.css" type="text/css" rel="stylesheet" />
    <link href="../css/footer.css" type="text/css" rel="stylesheet" />
    <link href="../css/category.css" type="text/css" rel="stylesheet" />
</head>
<body>
    
	<!-- 헤더 -->
	<c:import url="/WEB-INF/views/include/sub_header.jsp"/>

    <section class="section"> 

    <div style="margin: 2%;">　</div>
    <div class="newarrivals">
        <div class="newarrivals_caption">
            WEEKLY BEST
        </div>
    </div>
    <div class="newarrivals">
        <div class="newarrivals_container">
            <div class="newarrivals_menu">
                <ul>
	                <li><a href="${root }goods/sub_list?big_ctg=${big_ctg }&small_ctg=all&page=1&option=none">전체</a></li>
	                <c:forEach var="s_ctg" items="${s_ctg }">
	                	<li><a href="${root }goods/sub_list?big_ctg=${big_ctg }&small_ctg=${s_ctg.ctg_small_eng}&page=1&option=none">${s_ctg.ctg_small_ko}</a></li>
	                </c:forEach>
                </ul>  
            </div>            
        </div>
    </div>

    <div class="classify">
        <input type="button" class="classify_recommend" value="최신순" onclick="location.href='${root }goods/sub_list?big_ctg=${big_ctg }&small_ctg=${small_ctg }&page=1&option=goods_code'">
        <input type="button" class="classify_recently" value="구매 많은순" onclick="location.href='${root }goods/sub_list?big_ctg=${big_ctg }&small_ctg=${small_ctg }&page=1&option=purchase_number'">
        <input type="button" class="classify_price" value="가격순" onclick="location.href='${root }goods/sub_list?big_ctg=${big_ctg }&small_ctg=${small_ctg }&page=1&option=price'">
        <input type="button" class="classify_ddabong" value="좋아요순" onclick="location.href='${root }goods/sub_list?big_ctg=${big_ctg }&small_ctg=${small_ctg }&page=1&option=like_number'">
    </div>
	
	<c:forEach var="goods" items="${goods_list}" varStatus="i">
			<c:if test="${i.index==0 }">
				<div class="categories">${s_ctg_ko }</div>
			</c:if>
			<c:if test="${i.index%4==0}" var="result">
				<div class="newarrivals">
			</c:if>
				
				<div class="newarrivals_carousel">
		            <div class="w_carousel_mdpick">
		                <div class="mdpick_caption"></div>
		                <div class="mdpick_img">
		                    <a href="${root }goods/detail?goods_code=${goods.goods_code}">
		                        <img src="../${goods.thumbnail_img_url }" alt="추천상품">
		                    </a>
		                </div>
		                <div class="mdpick_name">
		                	<a href="${root }goods/detail?goods_code=${goods.goods_code}">${goods.goods_name }</a>
		                </div>
		                <div class="mdpick_info">${goods.info }</div>
		                <div class="mdpick_price"><b>₩${goods.price }</b></div>
		            </div>
		        </div>
		  	<c:if test="${(i.index+1)%4==0}">
		  		</div>
		  	</c:if>
		</c:forEach>

   	<!-- 페이지 이동파트 -->
	<div class="page">
		<ul class="pagination justify-content-center">
			<c:choose>
				<c:when test="${pageBean.prevPage <= 0 }">
					<li class="page-item disabled"><a href="#" class="page-link">이전</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a
						href="${root }goods/sub_list?big_ctg=${big_ctg}&small_ctg=${small_ctg}&page=${pageBean.prevPage}&option=${option}"
						class="page-link">이전</a></li>
				</c:otherwise>
			</c:choose>


			<c:forEach var='idx' begin="${pageBean.min }" end='${pageBean.max }'>
				<c:choose>
					<c:when test="${idx == pageBean.currentPage }">
						<li class="page-item active"><a
							href="${root }goods/sub_list?big_ctg=${big_ctg}&small_ctg=${small_ctg}&page=${idx}&option=${option}"
							class="page-link">${idx }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a
							href="${root }goods/sub_list?big_ctg=${big_ctg}&small_ctg=${small_ctg}&page=${idx}&option=${option}"
							class="page-link">${idx }</a></li>
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
						href="${root }goods/sub_list?big_ctg=${big_ctg}&small_ctg=${small_ctg}&page=${pageBean.nextPage}&option=${option}"
						class="page-link">다음</a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>

    </section>
    
 
    
    <!-- 하단 -->
    <c:import url="/WEB-INF/views/include/footer.jsp"/>
    
</body>
</html>