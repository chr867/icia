<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"
	integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
	crossorigin="anonymous"></script>
</head>
<body>
	<h1>boardList.jsp</h1>

	<table>
		<tr bgcolor="skyblue" height="30">
			<th width="100">번호</th>
			<th width="100">제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="100">조회수</th>
		</tr>
		<c:forEach var="board" items="${bList}">
			<tr height="25">
				<td align="center">${board.b_num}</td>
				<!-- href="#" 페이지 맨위로 이동뒤 이벤트 발생
				     href="#;" 페이지 현재위치에서 이벤트 발생 -->
				<td align="center"><a href="#" data-bs-toggle="modal"
					data-bs-target="#myModal" onclick="articleView(${board.b_num})">
						${board.b_title}</a></td>
				<td align="center">${board.b_id}</td>
				<td align="center">${board.b_date}</td>
				<td align="center">${board.b_views}</td>
			</tr>
		</c:forEach>
	</table>

	<!--  로그아웃 버튼 -->
	<c:if test="${!empty id}">
		<div align="right">
			<form id="logoutFrm" action="/member/logout" method="post">
				<a href="javascript:logout()">logout</a>
			</form>
		</div>
	</c:if>

	<script type="text/javascript">
logout=()=>{ //로그아웃 submit
	$('#logoutFrm').submit();
}

</script>
</body>
</html>