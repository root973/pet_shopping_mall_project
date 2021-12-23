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
    <title>트렌디한 애견쇼핑몰, 트렌독!</title>
    <script type="text/javascript" src="js/searchbox.js"></script>
    <script type="text/javascript" src="js/jsmobilemenu.js"></script>
    <link href="css/main.css" type="text/css" rel="stylesheet" />
    <link href="css/header.css" type="text/css" rel="stylesheet" />
    <link href="css/footer.css" type="text/css" rel="stylesheet" />
    <link href="css/category.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<!-- 헤더 -->
	<c:import url="/WEB-INF/views/include/header.jsp"/>
    
    
    <!-- 메인 -->
    
    <section class="section">       
        <!-- 이벤트페이지 -->
        
        <div class="carousel_container main_top">
            <input type="radio" id="radio1" name="radio" checked>
            <input type="radio" id="radio2" name="radio">
            <input type="radio" id="radio3" name="radio">
            <input type="radio" id="radio4" name="radio">

            <!--서버로부터 main_carousel 배열 받기 -->
            <a href="#" class="first_img"><img src="./image/이벤트페이지1.png" alt="이벤트1"></a>
            <a href="#"><img src="./image/이벤트페이지2.png" alt="이벤트2"></a>
            <a href="#"><img src="./image/이벤트페이지3.png" alt="이벤트3"></a>
            <a href="#"><img src="./image/이벤트페이지4.png" alt="이벤트4"></a>
            

            <div class="manualbtns">
                <label for="radio1" class="manualbtn"></label>
                <label for="radio2" class="manualbtn"></label>
                <label for="radio3" class="manualbtn"></label>
                <label for="radio4" class="manualbtn"></label>
            </div>
            
        </div>

        <!-- 상품페이지 -->

        <div class="newarrivals">
            <div class="newarrivals_caption">
                NEW ARRIVALS
            </div>
        </div>

        <!-- 의류 -->
        <div class="categories">의류 <input type="button" value="더보기 >" id="more" onclick="location.href='${root }goods/main_list?big_ctg=cloth'"></div>
        <div class="newarrivals">
        	<c:forEach var="goods" items="${cloth_list }">
	        	<div class="newarrivals_carousel">
	                <div class="w_carousel_mdpick">
	                    <div class="mdpick_caption">신상품</div>
	                    <div class="mdpick_img">
	                        <a href="${root }goods/detail?goods_code=${goods.goods_code}">
	                            <img src="${goods.thumbnail_img_url }" alt="추천상품">
	                        </a>
	                    </div>
	                    <div class="mdpick_name"><a href="${root }goods/detail?goods_code=${goods.goods_code}">${goods.goods_name }</a></div>
	                    <div class="mdpick_info">${goods.info }</div>
	                    <div class="mdpick_price"><b>₩${goods.price }</b></div>
	                </div>
	            </div>
        	</c:forEach>
        </div>
            

        <!-- 강아지용품 -->
        <div class="categories">강아지용품<input type="button" value="더보기 >" id="more" onclick="location.href='${root }goods/main_list?big_ctg=cosmetic'"></div>
        <div class="newarrivals">
        	<c:forEach var="goods" items="${cosmetic_list }">
	        	<div class="newarrivals_carousel">
	                <div class="w_carousel_mdpick">
	                    <div class="mdpick_caption">신상품</div>
	                    <div class="mdpick_img">
	                        <a href="${root }goods/detail?goods_code=${goods.goods_code}">
	                            <img src="${goods.thumbnail_img_url }" alt="추천상품">
	                        </a>
	                    </div>
	                    <div class="mdpick_name"><a href="${root }goods/detail?goods_code=${goods.goods_code}">${goods.goods_name }</a></div>
	                    <div class="mdpick_info">${goods.info }</div>
	                    <div class="mdpick_price"><b>₩${goods.price }</b></div>
	                </div>
	            </div>
        	</c:forEach>
        </div>

        <!-- 사료/간식 -->
        <div class="categories">사료/간식 <input type="button" value="더보기 >" id="more" onclick="location.href='${root }goods/main_list?big_ctg=food'"></div>
        <div class="newarrivals">
        	<c:forEach var="goods" items="${food_list }">
	        	<div class="newarrivals_carousel">
	                <div class="w_carousel_mdpick">
	                    <div class="mdpick_caption">신상품</div>
	                    <div class="mdpick_img">
	                        <a href="${root }goods/detail?goods_code=${goods.goods_code}">
	                            <img src="${goods.thumbnail_img_url }" alt="추천상품">
	                        </a>
	                    </div>
	                    <div class="mdpick_name"><a href="${root }goods/detail?goods_code=${goods.goods_code}">${goods.goods_name }</a></div>
	                    <div class="mdpick_info">${goods.info }</div>
	                    <div class="mdpick_price"><b>₩${goods.price }</b></div>
	                </div>
	            </div>
        	</c:forEach>
        </div>

        <!-- 위생용품 -->
        <div class="categories">위생용품 <input type="button" value="더보기 >" id="more" onclick="location.href='${root }goods/main_list?big_ctg=hygiene_item'"></div>
        <div class="newarrivals">
        	<c:forEach var="goods" items="${hygiene_item_list }">
	        	<div class="newarrivals_carousel">
	                <div class="w_carousel_mdpick">
	                    <div class="mdpick_caption">신상품</div>
	                    <div class="mdpick_img">
	                        <a href="${root }goods/detail?goods_code=${goods.goods_code}">
	                            <img src="${goods.thumbnail_img_url }" alt="추천상품">
	                        </a>
	                    </div>
	                    <div class="mdpick_name"><a href="${root }goods/detail?goods_code=${goods.goods_code}">${goods.goods_name }</a></div>
	                    <div class="mdpick_info">${goods.info }</div>
	                    <div class="mdpick_price"><b>₩${goods.price }</b></div>
	                </div>
	            </div>
        	</c:forEach>
        </div>

        <!-- 실내용품 -->
        <div class="categories">실내용품 <input type="button" value="더보기 >" id="more" onclick="location.href='${root }goods/main_list?big_ctg=home_item'"></div>
        <div class="newarrivals">
        	<c:forEach var="goods" items="${home_item_list }">
	        	<div class="newarrivals_carousel">
	                <div class="w_carousel_mdpick">
	                    <div class="mdpick_caption">신상품</div>
	                    <div class="mdpick_img">
	                        <a href="${root }goods/detail?goods_code=${goods.goods_code}">
	                            <img src="${goods.thumbnail_img_url }" alt="추천상품">
	                        </a>
	                    </div>
	                    <div class="mdpick_name"><a href="${root }goods/detail?goods_code=${goods.goods_code}">${goods.goods_name }</a></div>
	                    <div class="mdpick_info">${goods.info }</div>
	                    <div class="mdpick_price"><b>₩${goods.price }</b></div>
	                </div>
	            </div>
        	</c:forEach>
        </div>

        <!-- 실외용품 -->
        <div class="categories">실외용품 <input type="button" value="더보기 >" id="more" onclick="location.href='${root }goods/main_list?big_ctg=outdoor_item'"></div>
        <div class="newarrivals">
        	<c:forEach var="goods" items="${outdoor_item_list }">
	        	<div class="newarrivals_carousel">
	                <div class="w_carousel_mdpick">
	                    <div class="mdpick_caption">신상품</div>
	                    <div class="mdpick_img">
	                        <a href="${root }goods/detail?goods_code=${goods.goods_code}">
	                            <img src="${goods.thumbnail_img_url }" alt="추천상품">
	                        </a>
	                    </div>
	                    <div class="mdpick_name"><a href="${root }goods/detail?goods_code=${goods.goods_code}">${goods.goods_name }</a></div>
	                    <div class="mdpick_info">${goods.info }</div>
	                    <div class="mdpick_price"><b>₩${goods.price }</b></div>
	                </div>
	            </div>
        	</c:forEach>
        </div>
        <!--newarrivals end-->



    </section>

    <!-- 하단 -->
    <c:import url="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>





    