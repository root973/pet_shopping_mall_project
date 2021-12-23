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
    <title>카테고리</title>
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


	<!--메인  -->
    <section class="section">
		
		<div style="margin: 2%;"></div>
    	<div class="newarrivals">
        <div class="newarrivals_caption">
            검색결과
        </div>
    </div>
		
		<div class="newarrivals">

			<div class="newarrivals_carousel">
				<div class="w_carousel_mdpick">
					<div class="mdpick_caption">추천상품</div>
					<div class="mdpick_img">
						<a href="${root }goods/detail?goods_code=${goods.goods_code}">
							<img src="../${goods.thumbnail_img_url }" alt="추천상품">
						</a>
					</div>
					<div class="mdpick_name">
						<a href="${root }goods/detail?goods_code=${goods.goods_code}">${goods.goods_name }</a>
					</div>
					<div class="mdpick_info">${goods.info }</div>
					<div class="mdpick_price">
						<b>₩${goods.price }</b>
					</div>
				</div>
			</div>

		</div>

		<%-- <div style="margin: 2%;"></div>
    <div class="newarrivals">
        <div class="newarrivals_caption">
            WEEKLY BEST
        </div>
    </div>
    <div class="newarrivals">
        <div class="newarrivals_container">
            <div class="newarrivals_menu">
                <ul>
	                <li><a href="${root }goods/sub_list?big_ctg=${big_ctg }&small_ctg=all">전체</a></li>
	                <c:forEach var="s_ctg" items="${small_ctg }">
	                	<li><a href="${root }goods/sub_list?big_ctg=${big_ctg }&small_ctg=${s_ctg.ctg_small_eng}&page=1">${s_ctg.ctg_small_ko}</a></li>
	                </c:forEach>
                </ul>   
            </div>            
        </div>
    </div>
	
	<c:forEach var="goods_list" items="${list}" varStatus="i">
	
		<c:forEach var="goods" items="${goods_list}" varStatus="j">
			<c:if test="${j.index==0 }">
				<div class="categories">${small_ctg[i.index].ctg_small_ko }<input type="button" value="더보기 >" id="more"  onclick="location.href='${root }goods/sub_list?big_ctg=${goods.category_big }&small_ctg=${goods.category_small }&page=1&option=none'"></div>
				<div class="newarrivals">
			</c:if>
				<div class="newarrivals_carousel">
		            <div class="w_carousel_mdpick">
		                <div class="mdpick_caption">추천상품</div>
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
		  	<c:if test="${j.index==3 }">
		  		</div>
		  	</c:if>
		</c:forEach>
	</c:forEach> --%>

    </section>
    <!-- 하단 -->
    <c:import url="/WEB-INF/views/include/footer.jsp"/>
    
    
</body>
</html>