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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script type="text/javascript" src="../js/jsmobilemenu.js"></script>
<script type="text/javascript" src="../js/searchbox.js"></script>
<title>트렌독_유저 개인정보 수정</title>
<link href="../css/header.css" type="text/css" rel="stylesheet" />
<link href="../css/footer.css" type="text/css" rel="stylesheet" />
<link href="../css/main.css" type="text/css" rel="stylesheet" />
<link href="../css/modify.css" type="text/css" rel="stylesheet" />
</head>
<script>
	
</script>
<body>

	<c:import url="/WEB-INF/views/include/sub_header.jsp" />

	<section class="section">
		<form:form action="${root }member/modify_pro" method='post'
			modelAttribute="modifyUserBean">

			<div class="client_modify">
				<div class="dividebox">
					<div class="memberinfo_list">
						<form:label path="member_id">아이디 </form:label>
					</div>
					<div>
						<form:input path="member_id" id="readonlyinput" readonly="true"/>
					</div>
				</div>
				
				<div class="dividebox">
					<div class="memberinfo_list">
						<form:label path="pass">비밀번호</form:label>
					</div>
					<div>
						<form:input type="password" path="pass" class='password' />
					</div>
					<div>
						<form:errors path='pass' id="errormessage" style='color:red' />
					</div>
				</div>
				<div class="dividebox">
					<div class="memberinfo_list">
						<form:label path="pass2">비밀번호 확인</form:label>
					</div>
					<div>
						<form:input type="password" path="pass2" class='password' />
					</div>
					<br>
					<div>
						<form:errors path='pass2' id="errormessage" style='color:red' />
					</div>
				</div>
				
				<div class="dividebox">
					<div class="memberinfo_list">
						<form:label path="name">이름</form:label>
					</div>
					<div>
						<form:input path="name" id="readonlyinput" readonly="true"/>
					</div>
				</div>
				<div class="dividebox">
					<div class="memberinfo_list">
						<form:label path="birth">생년월일</form:label>
					</div>
					<div>
						<form:input path="birth" id="readonlyinput" readonly="true" />
					</div>
				</div>
				
				<div class="dividebox">
					<div class="memberinfo_list">
						<form:label path="phone" >전화번호</form:label>
					</div>
					<div>
						<form:input path="phone" id="readonlyinput" class="phone_number" readonly="true" />
					</div>
				</div>
				
				<div class="dividebox">
					<div class="memberinfo_list">
						<form:label path="email">이메일</form:label>
					</div>
					<div>
						<form:input type="email" path="email" class='email' />
					</div>
					<div>
						<form:errors path="email" id="errormessage" style="color: red;" />
					</div>
				</div>
				
				<div class="dividebox">
					<div class="memberinfo_list">주소</div>
					<div>
						<form:input type="text" id="sample6_postcode" path="zip_code"
							name="zipcode" class="post_number" placeholder="우편번호"
							readonly="true" />
					</div>
					<!-- form 안에 버튼이 있으면 default가 submit이기 때문에 type="button"으로 주어야한다.-->
					<div>
						<button type="button" onclick="sample6_execDaumPostcode()"
							id="postbtn" class="search">우편번호<i class="fas fa-chevron-right"></i>
						</button>
					</div>
				</div>

				<div class="dividebox">
					<div class="memberinfo_list">기본주소</div>
					<div>
						<form:input type="text" id="sample6_address" path="address"
							name="city" placeholder="주소" class='address' readonly="true" />
					</div>
				</div>

				<div class="dividebox">
					<div class="memberinfo_list">나머지주소</div>
					<div>
						<form:input type="text" id="sample6_detailAddress"
							path="address_detail" name="street" placeholder="상세주소"
							class='address' />
					</div>
				</div>

				<div class="dividebox">
					<div class="memberinfo_list">
						<form:label path="point">포인트</form:label>
					</div>
					<div>
						<form:input path="point" id="readonlyinput" class='address' readonly="true" />
					</div>
				</div>

				<div class="buttonbox" style="justify-content: center">
					<form:button class="modify_com">수정</form:button>
					<form:button type="button" class="cancel"
						onclick="location.href='${root}member/delete'">탈퇴</form:button>
				</div>

			</div>

		</form:form>






	</section>

	<c:import url="/WEB-INF/views/include/footer.jsp" />

	<!--우편번호 api-->
	<script type="text/javascript"
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function sample6_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
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
							if (data.userSelectedType === 'R') {
								// 법정동명이 있을 경우 추가한다. (법정리는 제외)
								// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
								if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								// 건물명이 있고, 공동주택일 경우 추가한다.
								if (data.buildingName !== ''
										&& data.apartment === 'Y') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
								if (extraAddr !== '') {
									extraAddr = ' (' + extraAddr + ')';
								}
								// 조합된 참고항목을 해당 필드에 넣는다.
								document
										.getElementById("sample6_detailAddress").value = extraAddr;

							} else {
								document
										.getElementById("sample6_detailAddress").value = '';
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('sample6_postcode').value = data.zonecode;
							document.getElementById("sample6_address").value = addr;
							// 커서를 상세주소 필드로 이동한다.
							document.getElementById("sample6_detailAddress")
									.focus();
						}
					}).open();
		}
	</script>

</body>
</html>








