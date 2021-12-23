<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>

<title>트렌디한 애견쇼핑몰, 트렌독!</title>
<link href="../css/join.css" rel="stylesheet" type="text/css" />
<link href="../css/header.css" type="text/css" rel="stylesheet" />
<link href="../css/footer.css" type="text/css" rel="stylesheet" />
<link href="../css/main.css" type="text/css" rel="stylesheet" />
<link href="../css/modify.css" type="text/css" rel="stylesheet" />
</head>
<script>
	function checkUserIdExist(){
		
		var member_id = $("#member_id").val()
		
		if(member_id.length == 0){
			alert('아이디를 입력해주세요')
			return
		}
		
		$.ajax({
			url : '${root}member/checkUserIdExist/' + member_id,
			type : 'get',
			dataType : 'text',
			success : function(result){
				if(result.trim() == 'true'){
					alert('사용할 수 있는 아이디입니다')
					$("#idExist").val('true')
				} else {
					alert('사용할 수 없는 아이디 입니다')
					$("#idExist").val('false')
				}
			}
		})
	}
	
	function resetUserIdExist(){
		$("#idExist").val('false')
	}
</script>
<body>

	<c:import url="/WEB-INF/views/include/sub_header.jsp" />
	
	<section class="section">
	<div class="joinform">
		<form:form action="${root }member/join_pro" method='post'
			modelAttribute="joinUserBean">
			<form:hidden path="idExist" />
			
			<div class="join_1">
				<form:label path="name" 
				style="width: 20%; height: 40%;" class="join_id">
				이름
				</form:label>
				<br>
				<form:input path="name"
				style="width: 200px; height: 20px;"/>
				<br>
				<form:errors path="name" style='color:red' /><br>
			</div>
			
			<div class="join_2">
				<form:label path="member_id"
				style="width: 20%; height: 40%;" class="join_id">
				아이디
				</form:label>
				<br>
				<form:input path="member_id"
					onkeypress="resetUserIdExist()" style="width: 200px; height: 20px;"/>
				<button type="button" class="id_check"
					onclick='checkUserIdExist()'>중복확인</button>
				<br>
				<form:errors path="member_id" style='color:red' /><br>
				</div>
			
			<div class="join_3">
				<form:label path="pass"
				style="width: 20%; height: 40%;" class="join_id">
				비밀번호
				</form:label>
				<br>
				<form:input type="password" path="pass"
				style="width: 200px; height: 20px;"/>
				<br>
				<form:errors path='pass' style='color:red' /><br>
			</div>
			
			<div class="join_4">
				<form:label path="pass2"
				style="width: 20%; height: 40%;" class="join_id">
				비밀번호 확인
				</form:label>
				<br>
				<form:input type="password" path="pass2"
				style="width: 200px; height: 20px;" />
				<br>
				<form:errors path='pass2' style='color:red' /><br>
			</div>
			
			<div class="join_5">
			<form:label path="email"
			style="width: 20%; height: 40%;" class="join_id">이메일</form:label>
			<br>
			<form:input type="email" path="email"
			style="width: 200px; height: 20px;"/>
			<br>
			<form:errors path="email" style="color: red;" /><br>
			</div>
			
			<div class="join_6">
			<form:label path="phone"
			style="width: 20%; height: 40%;" class="join_id">전화번호</form:label>
			<br>
			<form:input type="text" path="phone" placeholder="*ex) 010-0000-0000"
			style="width: 200px; height: 20px;"/>
			<br>
			<form:errors path="phone" style="color: red;" /><br>
			</div>

			
			<div class="join_7">
			<form:label path="birth"
			style="width: 20%; height: 40%;" class="join_id">생년월일</form:label>
			<br>
			<form:input type="text" path="birth" placeholder="*ex) 2000-01-01"
			style="width: 200px; height: 20px;"/>
			<br>
			<form:errors path="birth" style="color: red;" /><br>
			</div>
			
			<div class="join_8">
				<div class="join_id">
						주소
				</div>
			<form:input type="text" id="sample6_postcode" path="zip_code" name="zipcode" placeholder="우편번호" style="width: 200px; height: 20px;" readonly="true"/>
            <!-- form 안에 버튼이 있으면 default가 submit이기 때문에 type="button"으로 주어야한다.-->
            <button type="button" onclick="sample6_execDaumPostcode()" id="postbtn" class="addr_search"><span>우편번호</span><i class="fas fa-chevron-right"></i></button><br>
            <form:input type="text" id="sample6_address" path="address" name="city" placeholder="주소" style="width: 200px; height: 20px;" readonly="true"/>기본주소<br>
			<form:input type="text" id="sample6_detailAddress" path="address_detail" name="street" placeholder="상세주소" style="width: 200px; height: 20px;"/>나머지주소<br>
			<br>
			</div>
			
			<div class="join_9">
			<form:button class='join_btn'>회원가입</form:button>
			</div>

		</form:form>
		
	</div>
	</section>

	<c:import url="/WEB-INF/views/include/footer.jsp" />


    <!--우편번호 api-->
    <script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				console.log(data.zonecode);
				console.table(data);
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_detailAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_detailAddress").value = '';
                }


                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
    </script>


</body>
</html>








