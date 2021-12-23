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
    <title>트렌디한 애견쇼핑몰, 트렌독!</title>
    <script type="text/javascript" src="../js/장바구니.js"></script>
    <script type="text/javascript" src="../js/jsmobilemenu.js"></script>
    <script type="text/javascript" src="../js/searchbox.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
     
    <link href="../css/header.css" type="text/css" rel="stylesheet" />
    <link href="../css/main.css" type="text/css" rel="stylesheet" />
    <link href="../css/footer.css" type="text/css" rel="stylesheet" />
    <link href="../css/장바구니.css" type="text/css" rel="stylesheet" />
    
</head>
<body>

    <!-- 헤더 -->
	<c:import url="/WEB-INF/views/include/sub_header.jsp"/>

    <!-- 메인 -->
    <section class="section">
        
        <form name="orderform" id="orderform" method="post" class="orderform" action="${root }order/order_form">
        <input type="hidden" id="idx_check" name="idx_check">
        <input type="hidden" value="${loginBean.member_id }" name="member_id">
        
         
            <div class="basketdiv" id="basket">
            <!-- 주문상단 -->
                <div class="rowhead">
                    <div class="subdiv">
                        <div class="check"><input type="checkbox" name='selectall' value='selectall' onclick='selectAll(this)' checked></div>
                        <div class="img">이미지</div>
                        <div class="pname">상품명</div>
                        <div class="option1">옵션1</div>
                        <div class="option2">옵션2</div>
                        <div class="basketprice">가격</div>
                        <div class="num">수량</div>
                        <div class="sum">합계</div>

                    </div>
                </div>
				<c:forEach	var="cart" items="${cart_list }" varStatus="i">
					<div class="rowdata">
	                    <div class="subdiv">
	                        <div class="check"><input type="checkbox" name="buy" value="${cart.cart_idx }" checked="" onclick="javascript: basket.checkItem(); checkSelectAll(this);"></div>
	                        <div class="img"><img src="../${cart.img_url }" width="60"></div>
	                        <div class="pname">${cart.goods_name }</div>
	                        <div class="option1">${cart.option1}</div>
	                        <div class="option2">${cart.option2}</div>
	                        <div class="basketprice"><input type="hidden" name="p_price" id="p_price1" class="p_price" value="${cart.price }">${cart.price }원</div>
	                        <div class="num">
	                            <div class="updown">
	                                <input type="button" class="down" value="-" onclick="javascript:basket.changePNum(${i.index+1 });">
	                                <input type="text" name="p_num${i.index+1 }" id="p_num${i.index+1 }" size="2" maxlength="2" class="p_num" value="${cart.ea }" onkeyup="javascript:basket.changePNum(1);">
	                                <input type="button" class="up" value="+" onclick="javascript:basket.changePNum(${i.index+1 });">
	                                
	                            </div>
	                        </div>
	                        <div class="sum">${cart.total}</div>
	                    </div>
	                </div>
				</c:forEach>
                
            
    
            <div class="delete_button">
                <!-- <input type="button" value="선택상품삭제" href="javascript:void(0)" class="abutton" onclick="javascript:basket.delCheckedItem();">
                <input type="button" value="전체삭제" href="javascript:void(0)" class="abutton" onclick="javascript:basket.delAllItem();"> -->
            	<input type="button" value="선택상품삭제" class="abutton" onclick="return delete_checked(this.form)">
                <input type="button" value="전체삭제" class="abutton" onclick="return delete_all(this.form)">
            </div>
            

            <!-- 상품갯수 초기값 넣어주세요 명균띠 -->
            <div class="total">
                <div class="count_all" id="sum_p_num">상품갯수: ${total_cnt }개</div>
            </div>
            <div class="total">
                <div class="price_all" id="sum_p_price">합계금액: ${total_price }원</div>
            </div>
        </div>
		</form>

            <!-- "장바구니 기능 버튼" -->
        
            <div class="basket_button">
        
                <input type="button" value="쇼핑계속하기" onclick="return go_home(this.form)">
                <input type="button" value="바로구매" onclick="return order_form(this.form)">
        
            </div>
    	
    </section>

    <!-- 하단 -->
    <c:import url="/WEB-INF/views/include/footer.jsp"/>
<script>

window.onbeforeunload = function(event){
	
	var obj_length = document.getElementsByName("buy").length;
	var cart_idx = "";
	var ea = "";
	var total = "";
	  	
	for (var i=0; i<obj_length; i++) {
   	 	if(i==0){
   	 		cart_idx += document.getElementsByName("buy")[i].value;
   	 		ea += document.getElementsByClassName("p_num")[i].value;
   	 		total += document.getElementsByClassName("sum")[i+1].innerText;
        }else{
        	cart_idx += ","+document.getElementsByName("buy")[i].value;
   	 		ea += ","+document.getElementsByClassName("p_num")[i].value;
   	 		total += ","+document.getElementsByClassName("sum")[i+1].innerText;
        }
    }
	console.log(cart_idx+ea);
	
	if(!obj_length==0){
		$.ajax({
			url : '${root}cart/updateCartEa',
			type : 'post',
			data : {
				idx_list : cart_idx,
				ea_list : ea,
				total_list : total
			},
			success : function(result){
				console.log("저장!");
			}
		})
	}
	  	
	
	
}



function delete_checked(frm){
		
	var obj_length = document.getElementsByName("buy").length;

	if(obj_length!=0){
		var answer = confirm("선택한 제품을 정말 삭제하시겠습니까?");
	 	if(answer){
	 		
	   	  	var result = "";
	   	 	
	        for (var i=0; i<obj_length; i++) {
	            if (document.getElementsByName("buy")[i].checked == true) {
	                if(result === ""){
	                	result += document.getElementsByName("buy")[i].value;
	                }else{
	                	result += ","+document.getElementsByName("buy")[i].value;
	                }
	            }
	        }
	        document.getElementById("idx_check").value = result;
		 		
		 	frm.action="${root}cart/delete_checked";
			frm.submit();
			return true;
	 	}else{
		 	return false;
	 	}
	}else{
		alert("장바구니가 비어있습니다.")
		return false;
	}
}


function delete_all(frm){
	
	var obj_length = document.getElementsByName("buy").length;
	
	if(obj_length!=0){
		var answer = confirm("모든 제품을 정말 삭제하시겠습니까?");
		if(answer){
		 	frm.action="${root}cart/delete_all";
			frm.submit();
			return true;
		}else{
			return false;
		}
	}else{
		alert("장바구니가 비어있습니다.")
		return false;
	}
}

function go_home(){
	location.href = "${root}/main";
	return true;
}

function order_form(){
	
	var obj_length = document.getElementsByName("buy").length;
	var result = "";
	 	
    for (var i=0; i<obj_length; i++) {
        if (document.getElementsByName("buy")[i].checked == true) {
            if(result === ""){
            	result += document.getElementsByName("buy")[i].value;
            }else{
            	result += ","+document.getElementsByName("buy")[i].value;
            }
        }
    }
    document.getElementById("idx_check").value = result;
	if(obj_length!=0 && result!=""){
		location.href = "${root}order/order_form?member_id=${loginBean.member_id}&cart_list="+result;
	 	return true;
	}else if(obj_length==0){
		alert("장바구니가 비어있습니다");
		return false;
	}else if(result==""){
		alert("선택하신 제품이 없습니다");
		return false;
	}
 	
}


</script>
</body>
</html>