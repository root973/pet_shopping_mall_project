<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/"/>
<script>
	alert('선택된 제품이 삭제되었습니다')
	location.href="${root}/cart/list?member_id=${loginBean.member_id}";
</script>