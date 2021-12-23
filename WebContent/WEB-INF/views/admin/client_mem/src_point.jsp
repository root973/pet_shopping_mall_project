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
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>     
	
<script>
	function update_p(member_id, p_id){
		var answer = confirm("해당 계정의 포인트를 업데이트하시겠습니까?");
		if(answer){
			var point = document.getElementById(p_id).value;
			location.href="${root }admin/client_mem/modify_point?member_id="+member_id+"&point="+point;
		}else{
		   	return false;
		}
	}
	
	function reset_p(member_id){
		var answer = confirm("해당 계정의 포인트를 초기화(0)하시겠습니까?");
		if(answer){
			location.href="${root }admin/client_mem/reset_point?member_id="+member_id;
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
                location.href = "${root}admin/client_mem/src_point?keyword="+ui.item.label;
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
        
            <div>
               회원아이디 <input id="searchbox" placeholder="아이디입력">

                    <!--회원 리스트-->
                  <p><b>회원관리 - </b><span>포인트수정</span></p>

                    <div>
                        <form>
                            <table>
                                <th>아이디</th><th>이름</th><th>전화번호</th><th>이메일</th><th>생년월일</th><th>포인트수정</th><th>잔여포인트</th>
                                <tr>
                                	<td>${member.member_id }</td>
                                    <td>${member.name }</td>
                                    <td>${member.phone }</td>
                                    <td>${member.email }</td>
                                    <td>${member.birth }</td>
                                    <td><input id="point_1" type="text" size="5" placeholder="포인트수정"></td>
                                    <td>현재포인트: ${member.point }P</td>
                                    <td colspan="2">
                                    	<input type="button" value="수정" onclick="update_p('${member.member_id}', 'point_1')">
                                    	<input type="button" value="초기화" onclick="reset_p('${member.member_id}')">
                                  	</td>
                                </tr>
                                
                            </table>
                        </form>
                    </div>
            </div>
        </div>
    </div>

    
</section>
</body>
</html>