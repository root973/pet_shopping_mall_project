<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>


<!DOCTYPE html>
<html lang="en">
  <script src="https://kit.fontawesome.com/115203431c.js" crossorigin="anonymous"></script>
<head>
	<link href="../../css/관리자수정삭제게시판.css" type="text/css" rel="stylesheet" />
    <link href="../../css/관리자사이드.css" type="text/css" rel="stylesheet" />
        <link href="../../css/관리자메인.css" type="text/css" rel="stylesheet" />
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
                location.href = "${root}admin/goods/search?keyword="+ui.item.label;
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
      
	function src_btn(){
		var item = document.getElementById("searchbox").value;
		location.href = "${root}goods/search?keyword="+item;
	}

</script>

</head>
<body>

    <!--사이드바에 들어갈 내용들-->
	<c:import url="/WEB-INF/views/admin/include/navi.jsp"/>

    <section>
        <div class="main">
        <p><b class="nam1">상품관리 - </b><span class="nam2">관리자 수정/삭제 게시판</span></p>
        	상품명 <input id="searchbox" placeholder="상품명입력">
        
            <div class="goods">
                <div>
                    
                    <table style="margin-top:1%">
                        <thead>
                            <tr>
								<th class="img1">이미지</th>
                                <th class="code1">제품코드</th>
                                <th class="name">제품명</th>
                                <th class="sum">제품가격</th>
							</tr>
                        </thead>
						
						<c:forEach var='goods' items="${goodsList }">
							<tbody>
								<tr>
									<td class="img1"><a href='${root }admin/goods/modify?goods_code=${goods.goods_code}&page=${page}'><img src="../../${goods.thumbnail_img_url}" height="100" width="100"></a></td>
									<td class="code1">${goods.goods_code}</td>
									<td class="name"><a href='${root }admin/goods/modify?goods_code=${goods.goods_code}&page=${page}'>${goods.goods_name}</a></td>
									<td class="sum">${goods.price }원</td>
								</tr>
							</tbody>
						</c:forEach>
						
                    </table>

                </div>
            </div>
        </div>
	
	<!-- 페이지 이동파트 -->
	<div class="page">
		<ul class="pagination justify-content-center" style="position: relative; left: -10%">
			<c:choose>
				<c:when test="${pageBean.prevPage <= 0 }">
					<li class="page-item disabled"><a href="#" class="page-link">이전</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a
						href="${root }admin/goods/list?page=${pageBean.prevPage}"
						class="page-link">이전</a></li>
				</c:otherwise>
			</c:choose>


			<c:forEach var='idx' begin="${pageBean.min }" end='${pageBean.max }'>
				<c:choose>
					<c:when test="${idx == pageBean.currentPage }">
						<li class="page-item active"><a
							href="${root }admin/goods/list?page=${idx}"
							class="page-link">${idx }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a
							href="${root }admin/goods/list?page=${idx}"
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
						href="${root }admin/goods/list?page=${pageBean.nextPage}"
						class="page-link">다음</a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>
	
	
    </section>
</body>

</html>