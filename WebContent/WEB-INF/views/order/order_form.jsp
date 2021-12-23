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
    <title>결제하기</title>
    <script type="text/javascript" src="../js/jsmobilemenu.js"></script>
    <script type="text/javascript" src="../js/searchbox.js"></script>
    <link href="../css/header.css" type="text/css" rel="stylesheet" />
    <link href="../css/main.css" type="text/css" rel="stylesheet" />
    <link href="../css/footer.css" type="text/css" rel="stylesheet" />
    <link href="../css/결제페이지.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <!-- 헤더 -->
	<c:import url="/WEB-INF/views/include/sub_header.jsp"/>
	
	<section class="section">
	<form action="${root }order/order_ver" method='post'>
	<!-- 가져올 cart_list -->
	<input type="hidden" value="${loginBean.member_id }" name="member_id">
	<input type="hidden" value="${cart_list }" name="cart_list">
    <!-- 메인 -->
        <div class="paytitle">
            결제하기
        </div>
        <div class="listbox">
        <div class="list_title">결제할 상품 목록</div>
            <div class="paylist">
                <div class="item_name">제품명</div>
                <div class="item_option1">옵션1</div>
                <div class="item_option1">옵션2</div>
                <div class="item_ea">수량</div>
                <div class="item_cost">가격</div>
            </div>
        <c:forEach var="cart" items="${pet_cart }" varStatus="i">
            <div class="paylist2">
                <div class="item_name">${cart.goods_name }</div>
                <div class="item_option1">${cart.option1}</div>
                <div class="item_option1">${cart.option2}</div>
                <div class="item_ea">${cart.ea }</div>
                <div class="item_cost">${cart.total }</div>
            </div>
        </c:forEach>
        </div>
        <!-- 배송지 추가 -->
        <div class="address_input"> 
        	
            <div class="list_title">
                받으실 주소
            </div>
            <div class="address_info">
            	<div class="post_title">받으실 분</div>
            	<input type="text" placeholder="우편번호" class="post_number" name="name" value="${loginBean.name }">
            </div>
            <div class="address_info">
                <div class="post_title">주소</div>
                <input type="text" placeholder="우편번호" class="post_number" id='sample6_postcode' name="zip_code" value="${loginBean.zip_code }">
                <!-- form 안에 버튼이 있으면 default가 submit이기 때문에 type="button"으로 주어야한다.-->
                <input type="button" value="주소찾기" class="search"  onclick="sample6_execDaumPostcode()" id="postbtn">
            </div>
            <div class="address_info">
                <div class="post_title">기본주소</div>
                <input type="text" placeholder="주소" class="address" id="sample6_address" name="address" value="${loginBean.address }">
            </div>
            <div class="address_info">
                <div class="post_title">상세주소</div>
                <input type="text" placeholder="상세주소" class="address" name="address_detail" id='sample6_detailAddress' value="${loginBean.address_detail }">
            </div>
            
        </div>
        
        <div class="list_title">
               기타 요청사항
        </div>
            
        <div class="clientMemo">
        	<textarea rows="10" cols="150" name="memo" placeholder="기타 요청사항(250자 이내)" style="border:1px solid #ccc;"></textarea>
        </div>
		
		<div class="pay">
            <input type="submit" class="payment" value="결제하기"> 
            <input type="button" class="cancel" value="취소">
        </div>
        
		<!-- 결제수단 -->
		
        <!-- <div class="paywhat">
            <div class="list_title">결제수단</div>
            <label><input type="radio" name="payoption">카드결제</label>
            <label><input type="radio" name="payoption">무통장입금</label>
        </div> -->
        

       
	</form>
	
 </section>
    



    <!-- 하단 -->
    <c:import url="/WEB-INF/views/include/footer.jsp"/>

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

