<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>


<!DOCTYPE html>
<html lang="en">
  <script src="https://kit.fontawesome.com/115203431c.js" crossorigin="anonymous"></script>
<head>
    <link href="../../css/관리자사이드.css" type="text/css" rel="stylesheet" />
    <link href="../../css/관리자메인.css" type="text/css" rel="stylesheet" />
</head>
<body>

    <!--사이드바에 들어갈 내용들-->
	<c:import url="/WEB-INF/views/admin/include/navi.jsp"/>



    <section>
        <div class="main">
            <div class="goods">
                <div>
                    <p><b class="nam1">관리자 - </b><span class="nam2">관리자 게시판</span></p>
                    <table>
                        <thead>
                            <tr>

                                <th class="">아이디</th>
                                <th class="">이름</th>
                                <th class="">직책</th>

                            </tr>
                        </thead>
						<c:forEach var="admin" items="${admin_list }">
							<tbody>
	                            <tr>
	                                <td class=""><a href="${root }admin/admin_mem/modify?admin_id=${admin.admin_id}">${admin.admin_id }</a></td>
	                                <td class="">${admin.name }</td>
	                                <td class="">${admin.position }</td>
	                            </tr>
	                        </tbody>
						</c:forEach>
                        

                    </table>

                </div>
            </div>
        </div>
    </section>
</body>