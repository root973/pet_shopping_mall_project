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
    <script type="text/javascript" src="../js/jsmobilemenu.js"></script>
    <script type="text/javascript" src="../js/searchbox.js"></script>
    <link href="../css/header.css" type="text/css" rel="stylesheet" />
    <link href="../css/main_1.css" type="text/css" rel="stylesheet" />
    <link href="../css/footer.css" type="text/css" rel="stylesheet" />
    <link href="../css/이벤트공지사항상세페이지.css" type="text/css" rel="stylesheet" />
</head>

<body>
    <!-- 헤더 -->
	<c:import url="/WEB-INF/views/include/sub_header.jsp"/>


    <section>

        <div class="board_main">
            <div class="board_head">
                <p>
                <a href="${root }event/list?page=${page}"><span>공지사항 / 이벤트 ></span></a>
                <h1>${event.title }</h1>
                </p>
            </div>

            <div class="board_name">
                <span><b>${event.position}</b></span>
                <span>${event.admin_id}</span>

                <div>
                    <span>${event.reg_date }</span>
                    <span>조회</span>
                    <span>${event.board_hits }</span>
                </div>
            </div>

            <div class="board_section">
            
            <c:if test='${img_url!="no" }'>
            	<c:forEach var="img" items="${img_url }">
            		<img src="../${img }">
            		<br>
            	</c:forEach>
            </c:if>
            	
                <span>${event.content }</span>
            </div>

            <div class="board_button">
                <a href="${root }event/list?page=${page}"> <input type="button" class="board_button_list" value="목록"> </a>
            </div>
        </div>


    </section>

    <!-- 하단 -->
    <c:import url="/WEB-INF/views/include/footer.jsp"/>
</body>

</html>