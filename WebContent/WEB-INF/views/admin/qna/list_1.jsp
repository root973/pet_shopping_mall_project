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
		
		<p><b class="nam1">상품관리 - </b><span class="nam2">관리자 상품 문의</span></p>
        <div style="margin-bottom: 1%;">
        
        회원명 <input type="text" value="">
        <input type="submit" class="tab_btn_1" value="검색">
        </div>

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
                  <td>
                    <a href="#" class="">${qna.q_content }</a>
                  </td>
                  <!--작성자 불러올곳-->
                  <td>${qna.member_id}</td>
                  <td>${qna.reg_date}</td>
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