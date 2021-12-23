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

				<!--구매자 검색-->
				회원아이디 <input id="searchbox" placeholder="아이디입력">
			

				<div class="table">

					<div class="Questions">
						<table class="Questions_list">

							<thead>
								<tr>

									<th>글번호</th>
									<th>질문</th>
									<th>작성자</th>
									<th>작성 일자</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="qna" items="${qnalist }">
									<tr>
										<!--글번호 불러올곳-->
										<td>${qna.q_num }</td>
										<!--제목 불러올곳-->
										<td><a href="#" class="">${qna.q_content }</a></td>
										<!--작성자 불러올곳-->
										<td>${qna.member_id}</td>
										<td>${qna.reg_date}</td>
										<td>
											<input type="button" value="답글" onclick="location.href='${root}admin/qna/answer?q_num=${qna.q_num}'">
                    						<input type="button" value="삭제" onclick="del_qna('${qna.q_num}')">
										</td>

									</tr>
								</c:forEach>

							</tbody>
						</table>

					</div>

				</div>

			</div>

	</section>

</body>

</html>