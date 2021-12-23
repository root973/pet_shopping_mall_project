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
<link href="../../css/관리자상품등록.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<!--사이드바에 들어갈 내용들-->
	<c:import url="/WEB-INF/views/admin/include/navi.jsp" />

	<section>
		<div class="main">
			<div class="main_form">

			<p>
				<b class="nam1">상품관리 - </b><span class="nam2">상품 등록</span>
			</p>
			
			<form action="${root }admin/goods/modify_pro" method="post" enctype="multipart/form-data">
			<input type="hidden" name="goods_code" value="${goods.goods_code }">
			
			<div id="category">
				<input type="hidden" name="category_big" value="${goods.category_big }"> 
				<input type="hidden"name="category_small" value="${goods.category_small }"> 
				<input type="button" value="카테고리 수정" onclick="modify_ctg()">
			</div>

			<p>
			<div>
				<label class="form-label"><b>옵션1</b></label>
				<div>옵션입력시 반드시 구분자로 '|'를 사용해주세요!</div>
				<span><input type="text" name="option_1"
					value="${goods.option_1}"></span>
			</div>

			<div>
				<label class="form-label"><b>옵션2</b> </label>
				<div>옵션입력시 반드시 구분자로 '|'를 사용해주세요!</div>
				<span><input type="text" name="option_2"
					value="${goods.option_2}"></span>
			</div>
			</p>


			<div>
				<div>
					<b>상품명 :</b>
				</div>
				<div>
					<input type="text" name="goods_name" value="${goods.goods_name}">
				</div>
				<div>
					<b>판매가격 :</b>
				</div>
				<div>
					<input type="text" name="price" value="${goods.price}">
				</div>
			</div>

			<div>
				<h3>상품(대표)이미지</h3>

				<input type="file"name="thumbnail_img_url"> 
				
				<h3>상품(상세)이미지</h3>

				<input type="file" name="detail_img_url" multiple="multiple">
			</div>

			<div class="goods_info">

				<h3>상품상세내용</h3>

				<textarea cols="30" rows="5" name="info">${goods.info}</textarea>
			</div>


			<div class="goods_price">

				<input type="submit" class="item_btn2" value="등록">
				<input type="button" class="item_btn2"  value="제품삭제" onclick="del_check()">
			</div>
		</form>
		</div>
		<br>
		</div>
	</section>

	<script>
		function on(e) {
			var value = e.value;
			var r = document.getElementById("sub");
			r.innerHTML = "";

			if (value == "cloth") {
				r.innerHTML = "<label class='form-label'>소카테고리</label> <select name='category_small'>"
						+ "<option value='outer'>아우터</option>"
						+ "<option value='shirts'>셔츠</option>"
						+ "<option value='knit'>니트</option>"
						+ "<option value='raincoat'>레인코트</option>"
						+ "<option  value='shoes'>신발</option>"
						+ "<option value='accessories'>악세사리</option>"
						+ "</select>";
			} else if (value == "cosmetic") {
				r.innerHTML = "<label class='form-label'>소카테고리</label> <select name='category_small'>"
						+ "<option value='toy'>장난감</option>"
						+ "<option value='comb'>빗</option>"
						+ "<option value='fence'>울타리</option>"
						+ "<option value='dry'>드라이</option>" + "</select>";
			} else if (value == "food") {
				r.innerHTML = "<label class='form-label'>소카테고리</label> <select name='category_small'>"
						+ "<option value='dry_food'>건식사료</option>"
						+ "<option value='wet_food'>습식사료</option>"
						+ "<option value='gum'>개껌</option>"
						+ "<option value='treat'>트릿</option>" + "</select>";
			} else if (value == "hygiene_item") {
				r.innerHTML = "<label class='form-label'>소카테고리</label> <select name='category_small'>"
						+ "<option value='shit_pad'>배변패드</option>"
						+ "<option value='cleanser'>세정제</option>"
						+ "<option value='fragnance'>방향제</option>"
						+ "</select>";
			} else if (value == "outdoor_item") {
				r.innerHTML = "<label class='form-label'>소카테고리</label> <select name='category_small'>"
						+ "<option value='lead'>하네스,목줄,리드줄</option>"
						+ "<option value='toilet_bag'>배변봉투</option>"
						+ "<option value='stroller'>유모차</option>"
						+ "<option value='external_chip'>외장칩</option>"
						+ "</select>";
			} else if (value == "home_item") {
				r.innerHTML = "<label class='form-label'>소카테고리</label> <select name='category_small'>"
						+ "<option value='mat'>매트</option>"
						+ "<option value='bowl'>밥그릇</option>"
						+ "<option value='cushion'>방석</option>"
						+ "<option value='cage'>케이지</option>" + "</select>";
			}
		}

		function modify_ctg() {
			var ctg = document.getElementById("category");

			ctg.innerHTML = "<div>"
					+ "<label class='form-label'><b>대카테고리</b></label>"
					+ "<select name='category_big' id='secter' onchange='on(this)'>"
					+ "<option value='cloth'>의류</option>"
					+ "<option value='cosmetic'>강아지용품</option>"
					+ "<option value='food'>간식사료</option>"
					+ "<option value='home_item'>실내용품</option>"
					+ "<option value='outdoor_item'>실외용품</option>"
					+ "<option value='hygiene_item'>위생용품</option>"
					+ "</select>" + "</div>" + "<div id='sub'>"
					+ "<label class='form-label'><b>소카테고리</b></label>"
					+ "<select name='category_small'>"
					+ "<option value='outer'>아우터</option>"
					+ "<option value='shirts'>셔츠</option>"
					+ "<option value='knit'>니트</option>"
					+ "<option value='raincoat'>레인코트</option>"
					+ "<option value='shoes'>신발</option>"
					+ "<option value='accessories'>악세사리</option>" + "</select>"
					+ "</div>";
		}
		
		function del_check(){
	    	 var answer = confirm("해당 제품을 정말 삭제하시겠습니까?");
	    	 if(answer){
	    		 location.href="${root }admin/goods/delete_pro?goods_code=${goods.goods_code}";
	    	 }else{
	    		 return false;
	    	 }
	     }
	</script>

</body>
</html>