<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>


<!DOCTYPE html>
<html lang="en">
  <script src="https://kit.fontawesome.com/115203431c.js" crossorigin="anonymous"></script>
<head>
<link href="../../css/관리자메인.css" type="text/css" rel="stylesheet" />
<link href="../../css/관리자사이드.css" type="text/css" rel="stylesheet" />
<link href="../../css/관리자상품리뷰확인.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>     
	
<script>
function del_check(member_id){

	var answer = confirm("해당 계정을 정말 삭제하시겠습니까?");
	if(answer){
		 location.href="${root }admin/client_mem/delete_pro?member_id="+member_id;
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
            location.href = "${root}admin/client_mem/src_del?keyword="+ui.item.label;
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
	<c:import url="/WEB-INF/views/admin/include/navi.jsp"/>

<section>
    <div class="main">
        <div class="goods">
        
         <p><b class="nam1">회원관리 - </b><span class="nam2">회원탈퇴</span></p>
            <div>
           
               회원아이디 <input id="searchbox" placeholder="아이디입력">
            

                    <!--회원 리스트-->
                    
                    <div>
                        <form style="margin-top:1%">
                            <table>
                                <th>아이디</th><th>이름</th><th>전화번호</th><th>이메일</th><th>생년월일</th><th>보유포인트</th>
                                <c:forEach var="member" items="${memberList}">
                                <tr>
                                	<td>${member.member_id }</td>
                                    <td>${member.name }</td>
                                    <td>${member.phone }</td>
                                    <td>${member.email }</td>
                                    <td>${member.birth }</td>
                                    <td>${member.point }P</td>
                                    <td><input type="button" class="tab_btn_1" value="탈퇴" onclick="del_check('${member.member_id}')"></td>
                                </tr>
                                </c:forEach>
                                
                            </table>
                        </form>
                    </div>
            </div>
        </div>
    </div>

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
						href="${root }admin/client_mem/list_del?page=${pageBean.prevPage}"
						class="page-link">이전</a></li>
				</c:otherwise>
			</c:choose>


			<c:forEach var='idx' begin="${pageBean.min }" end='${pageBean.max }'>
				<c:choose>
					<c:when test="${idx == pageBean.currentPage }">
						<li class="page-item active"><a
							href="${root }admin/client_mem/list_del?page=${idx}"
							class="page-link">${idx }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a
							href="${root }admin/client_mem/list_del?page=${idx}"
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
						href="${root }admin/client_mem/list_del?page=${pageBean.nextPage}"
						class="page-link">다음</a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>

</section>
</body>
</html>