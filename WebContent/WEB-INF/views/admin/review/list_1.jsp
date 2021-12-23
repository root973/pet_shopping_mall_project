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
</head>
<body>
    
	<!--사이드바에 들어갈 내용들-->
	<c:import url="/WEB-INF/views/admin/include/navi.jsp"/>


  <section>
    <div class="main">

      <div class="goods">
		<p><b class="nam1">리뷰/문의 - </b><span class="nam2">관리자 상품 리뷰 확인</span></p>
		<div style="margin-bottom: 1%;">
        상품분별
        <select>
          <option value="">의류</option>
          <option value="">강아지용품</option>
          <option value="">위생용품</option>
          <option value="">실외용품</option>
          <option value="">실내용품</option>
        </select>



        상품명 <input type="text" value="">
        <input type="submit" class="tab_btn_1" value="검색">
        </div>


        <div class="table">

          <div class="Questions">
            <table class="Questions_list">

              <thead>
                <tr>

                  <th>글번호</th>
                  <th>상품명</th>
                  <th>작성자</th>
                  <th></th>

                </tr>
              </thead>
              <tbody>
              <c:forEach var="review" items="${reviewlist }">
              	               <tr>
                  <!--글번호 불러올곳-->
                  <td>${review.r_num }</td>
                  <td>
                    <a href="#" class="title_a">${review.goods_code }</a>
                  </td>
                  <!--제목 불러올곳-->
                  <td>
                    <a href="#" class="title_a">${review.content }</a>
                  </td>
                  <!--작성자 불러올곳-->
                  <td>${review.member_id }</td>

                  <td>
                    <input type="button" class="tab_btn_1" value="답글">
                    <input type="button" class="tab_btn_1" value="삭제">
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