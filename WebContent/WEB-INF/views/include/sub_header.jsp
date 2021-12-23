<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />

<!-- 헤더 -->
<header class="header">
	<!-- 사이드메뉴 -->
	<div class="header_divide1">
		<img src="../icon/메뉴아이콘.png" class="mobile-menu">

		<div class="menuwrap">
			<!-- "메뉴목록 표시" -->
			<div></div>
			<ul class="category_list">
				<li class=""><a href="${root }" class="link_sub_item"><img
						src="../icon/홈아이콘.png"> HOME</a></li>
				<li class=""><a href="${root }goods/main_list?big_ctg=cloth" class="link_sub_item"><img
						src="../icon/의류아이콘.png">의류</a></li>
				<li class=""><a href="${root }goods/main_list?big_ctg=cosmetic" class="link_sub_item"><img
						src="../icon/강아지용품아이콘.png">강아지용품</a></li>
				<li class=""><a href="${root }goods/main_list?big_ctg=food" class="link_sub_item"><img
						src="../icon/밥그릇아이콘.png">사료/간식</a></li>
				<li class=""><a href="${root }goods/main_list?big_ctg=hygiene_item" class="link_sub_item"><img
						src="../icon/화장지아이콘.png">위생용품</a></li>
				<li class=""><a href="${root }goods/main_list?big_ctg=home_item" class="link_sub_item"><img
						src="../icon/카펫아이콘.png">실내용품</a></li>
				<li class=""><a href="${root }goods/main_list?big_ctg=outdoor_item" class="link_sub_item"><img
						src="../icon/실외용품아이콘.png">실외용품</a></li>
				<li class=""><a href="${root }event/list" class="link_sub_item"><img
						src="../icon/확성기아이콘.png">공지사항/이벤트</a></li>
			</ul>
		</div>
	</div>
	<div class="header_divide2">
		<div class="logo">
			<a href="${root }"><img src="../icon/TRENDOG 로고.png" id="logo"></a>
		</div>
	</div>
	<div class="header_divide3">
		<!-- 헤더오른쪽 -->
		<div class="r-menu">
			<c:choose>
				<c:when test="${loginBean.memberLogin == true}">
				<div class="modify">
						<a href="${root}member/mypage" style="cursor: pointer;">Mypage</a>
					</div>
					<div class="modify">
						<a href="${root}member/modify_cer" style="cursor: pointer;">Modify</a>
					</div>
					<div class="logout">
						<a href="${root}member/logout" style="cursor: pointer;">Logout</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="joinus">
						<a href="${root }member/join" style="cursor: pointer;">Join Us</a>
					</div>
					<div class="login">
						<a href="${root }member/login" style="cursor: pointer;">Log In</a>
					</div>
				</c:otherwise>
			</c:choose>
			<div>
				<a href="${root }cart/list?member_id=${loginBean.member_id}"> <img
					src="../icon/장바구니아이콘.png" id="carticon">
				</a>
			</div>
			<div>
				<img src="../icon/돋보기아이콘.png" id="searchicon" onclick="search()">
				<!-- <input type="button" id="searchbt" value="검색" onclick="src_btn()"> -->
        		<input id="searchbox" placeholder="검색어입력">
			</div>
		</div>
	</div>
</header>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>     
<script>
      $(function() {    //화면 다 뜨면 시작
        $("#searchbox").autocomplete({
            source : function( request, response ) {
                 $.ajax({
                        type: 'get',
                        url: '${root}goods/keyword',
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
                location.href = "${root}goods/search?keyword="+ui.item.label;
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
            position: { my : "right top", at: "right bottom" },    //잘 모르겠음
            close : function(event){    //자동완성창 닫아질때 호출
                console.log(event);
            }
        });
        
    });
      
	function src_btn(){
		var item = document.getElementById("searchbox").value;
		location.href = "${root}goods/search?keyword="+item;
	}

</script>
