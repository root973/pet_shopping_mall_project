<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var='root' value="${pageContext.request.contextPath }/" />


<!DOCTYPE html>
<html lang="en">
<script src="https://kit.fontawesome.com/115203431c.js"
	crossorigin="anonymous"></script>
<head>
<link href="../../css/관리자메인.css" type="text/css" rel="stylesheet" />
<link href="../../css/관리자사이드.css" type="text/css" rel="stylesheet" />
<link href="../../css/관리자게시글작성.css" type="text/css" rel="stylesheet" />
</head>

<body>

	<!--사이드바에 들어갈 내용들-->
	<c:import url="/WEB-INF/views/admin/include/navi.jsp" />


	<section>
		<div class="main">
			<div class="goods">
				<div>
					<p>
						<b>기타 - </b><span>이벤트/공지사항게시판 작성</span>
					</p>

					<!--이벤트/공지사항게시판 글 작성-->
					<form action="${root }admin/event/modify_pro" method="post" enctype="multipart/form-data">
					<input type="hidden" name="board_index" value="${event.board_index}">
		
						<table>
							<tr>
								<th>제목</th>
								<td><input type="text" name="title" size="60" value="${event.title }"></td>
							</tr>

							<tr>
								<th>글종류</th>
								<td id="category">
									<input type="hidden"name="board_type" value="${event.board_type}"> 
									<input type="button" value="글종류 수정" onclick="modify_ctg()">
								</td>
							</tr>


							<tr>
								<th>상세내용</th>
								<td><textarea rows="10" cols="60" name="content" size="60">${event.content }</textarea></td>
							</tr>


							<tr>
								<th>이미지첨부</th>
								<td><input type="file" name="event_img_url"
									multiple="multiple"></td>
							</tr>

							<tr>
								<td colspan="2"><input type="submit" value="글수정"></td>
							</tr>
						</table>
					</form>
					
					<br>
					<input type="button"  value="이벤트삭제" onclick="del_check()">
					
				</div>
			</div>
		</div>
	</section>
	<script>
     
     function del_check(){
    	 var answer = confirm("이벤트를 정말 삭제하시겠습니까?");
    	 if(answer){
    		 location.href="${root }admin/event/delete_pro?board_index=${event.board_index}";
    	 }else{
    		 return false;
    	 }
     }
     
     function modify_ctg() {
		var ctg = document.getElementById("category");
		
		ctg.innerHTML = "<select name='board_type'>"+
						"<option value='공지사항'>공지사항</option>"+
						"<option value='이벤트'>이벤트</option>"+
						"</select>";
			
     }
     
     
    </script>
</body>

</html>