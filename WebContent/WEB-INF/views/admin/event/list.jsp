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
</head>
<body>

    <!--사이드바에 들어갈 내용들-->
	<c:import url="/WEB-INF/views/admin/include/navi.jsp"/>


<section>
    <div class="main">
        <div class="goods">
            <div>
              <p><b class="nam1">기타 - </b><span class="nam2">이벤트/공지사항게시판 리스트</span></p>
                    <table>
                      	<thead>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성날짜</th>
                                <th>조회수</th>
                            </tr>
                          </thead>
						<c:forEach var='event' items="${eventList }">
							<tbody>
                            <tr>
                                <td>${event.board_index}</td>
                                <td>
	                                <a href="${root }admin/event/modify?board_index=${event.board_index}&page=${page}">
	                                	<b>[${event.board_type }]</b>${event.title}
	                                </a>
                              	</td>
                                <td>${event.position}</td>
                                <td>${event.reg_date}</td>
                                <td>${event.board_hits}</td>
                            </tr>	
                          	</tbody>
						</c:forEach>
                    </table>
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
						href="${root }admin/event/list?page=${pageBean.prevPage}"
						class="page-link">이전</a></li>
				</c:otherwise>
			</c:choose>


			<c:forEach var='idx' begin="${pageBean.min }" end='${pageBean.max }'>
				<c:choose>
					<c:when test="${idx == pageBean.currentPage }">
						<li class="page-item active"><a
							href="${root }admin/event/list?page=${idx}"
							class="page-link">${idx }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a
							href="${root }admin/event/list?page=${idx}"
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
						href="${root }admin/event/list?page=${pageBean.nextPage}"
						class="page-link">다음</a></li>
				</c:otherwise>
			</c:choose>

		</ul>
	</div>
	
</section>
</body>
</html>