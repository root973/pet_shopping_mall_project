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
	function del_qna(q_num){
		var answer = confirm("해당 문의글을 삭제하시겠습니까?");
		if(answer){
			location.href="${root }admin/qna/delete_pro?q_num="+q_num;
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
	            location.href = "${root}admin/qna/search?keyword="+ui.item.label;
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
				
				<p><b class="nam1">리뷰/문의 - </b><span class="nam2">관리자 상품 문의 확인</span>
				<div style="margin-bottom:10px">
				<!--구매자 검색-->
				회원아이디 <input id="searchbox" placeholder="아이디입력">
				</div>

				<div class="table">

					<div class="Questions">
						<table class="Questions_list">

							<thead>
								<tr>

									<th class="aa">글번호</th>
									<th class="bb">상품코드</th>
									<th>질문</th>
									<th class="cc">작성자</th>
									<th class="dd"></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="qna" items="${qnalist }">
									<tr>
										<!--글번호 불러올곳-->
										<td class="aa">${qna.q_num }</td>
										<!--제목 불러올곳-->
										<td class="bb">
										${qna.goods_code}
										</td>
										<td>
										${qna.q_content }
										</td>
										<!--작성자 불러올곳-->
										<td class="cc">${qna.member_id}</td>
										<td class="dd">
											<input type="button" value="답글" class="tab_btn_1" onclick="location.href='${root}admin/qna/answer?q_num=${qna.q_num}'">
                    						<input type="button" value="삭제" class="tab_btn_1" onclick="del_qna('${qna.q_num}')" style="margin-top:5%">
										</td>

									</tr>
								</c:forEach>

							</tbody>
						</table>

					</div>

				</div>

			</div>

			<!-- qna페이지 이동파트 -->
			<div class="page">
				<ul class="pagination justify-content-center">
					<c:choose>
						<c:when test="${pageBean.prevPage <= 0 }">
							<li class="page-item disabled"><a href="#" class="page-link">이전</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a
								href="${root }admin/qna/list?page=${pageBean.prevPage}"
								class="page-link">이전</a></li>
						</c:otherwise>
					</c:choose>


					<c:forEach var='idx' begin="${pageBean.min }"
						end='${pageBean.max }'>
						<c:choose>
							<c:when test="${idx == pageBean.currentPage }">
								<li class="page-item active"><a
									href="${root }admin/qna/list?page=${idx}" class="page-link">${idx }</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a
									href="${root }admin/qna/list?page=${idx}" class="page-link">${idx }</a></li>
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
								href="${root }admin/qna/list?page=${pageBean.nextPage}"
								class="page-link">다음</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
	</section>

</body>

</html>