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
    <title>공지사항이벤트</title>
        <script type="text/javascript" src="../js/jsmobilemenu.js"></script>
    <script type="text/javascript" src="../js/searchbox.js"></script>
    <link href="../css/header.css" type="text/css" rel="stylesheet" />
    <link href="../css/main.css" type="text/css" rel="stylesheet" />
    <link href="../css/footer.css" type="text/css" rel="stylesheet" />
    <link href="../css/공지사항이벤트.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <!-- 헤더 -->
	<c:import url="/WEB-INF/views/include/sub_header.jsp"/>

    
    <!-- 메인 -->
    <section class="section">
            
            <div class="board_list">

                <h1>공지사항/이벤트 게시판</h1>
                    <table>
                        <!-- 행 길이 조정 -->
                        <colgroup>
                            <col width="5%">
                            <col width="50%">
                            <col width="10%">
                            <col width="10%">
                            <col width="5%">
                        </colgroup>

                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>제목</td>
                                <td>작성자</td>
                                <td>작성날짜</td>
                                <td>조회수</td>
                            </tr>
                        </thead>
                        
                        <c:forEach var="event" items="${eventList }">
	                        <tbody>
	                            <tr>
	                                <td>${event.board_index}</td>
	                                <td><a href="${root }event/detail?board_index=${event.board_index}&page=${page}"><b>[${event.board_type }]</b>${event.title}</a></td>
	                                <td>${event.position}</td>
	                                <td>${event.reg_date}</td>
	                                <td>${event.board_hits}</td>
	                            </tr>
	                        </tbody>
                        </c:forEach>
                        
                    </table>

                  
                    
            </div>
        </div>

    
    </section>
	
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
						href="${root }event/list?page=${pageBean.prevPage}"
						class="page-link">이전</a></li>
				</c:otherwise>
			</c:choose>


			<c:forEach var='idx' begin="${pageBean.min }" end='${pageBean.max }'>
				<c:choose>
					<c:when test="${idx == pageBean.currentPage }">
						<li class="page-item active"><a
							href="${root }event/list?page=${idx}"
							class="page-link">${idx }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a
							href="${root }event/list?page=${idx}"
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
						href="${root }event/list?page=${pageBean.nextPage}"
						class="page-link">다음</a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>
	

	<!-- 하단 -->
    <c:import url="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>

