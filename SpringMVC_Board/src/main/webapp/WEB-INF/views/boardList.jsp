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
<script type="text/javascript">
	function logout() {
		$('#logoutFrm').submit();
	}
</script>
</head>
<body>
	<h1>boardList.jsp --게시판 목록</h1>
	<c:if test="${!empty id}">
		<div align="right">
			<form id="logoutFrm" action="/member/logout" method="post">
				<a href="javascript:logout()">로그아웃</a>

			</form>
		</div>
	</c:if>
	
	<table id="one_table">
		<tr height="30">
			<td width="80" bgcolor="pink" align="center">ID</td>
			<td>${member.m_id}</td>
		</tr>
		<tr height="30">
			<td width="80" bgcolor="pink" align="center">NAME</td>
			<td>${member.m_name}</td>
		</tr>
		<tr height="30">
			<td width="80" bgcolor="pink" align="center">GNAME</td>
			<td>${member.m_grade}</td>
		</tr>
		<tr height="30">
			<td width="80" bgcolor="pink" align="center">POINT</td>
			<td>${member.m_point}</td>
		</tr>
	</table>
	
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
</body>
</html>