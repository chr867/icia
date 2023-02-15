<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.3.js"
	integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="
	crossorigin="anonymous"></script>
</head>
<body>
<h3>boardContentsAjax.jsp --글 상세 & 댓글 리스트</h3>
<table>
		<tr height="30">
			<td width="100" bgcolor="lightgray" align="center">NUM</td>
			<td colspan="5">${board.b_num}</td>
		</tr>
		<tr height="30">
			<td bgcolor="lightgray" align="center">WRITER</td>
			<td width="150">${board.b_id}</td>
			<td bgcolor="lightgray" align="center">DATE</td>
			<td width="150">${board.b_date}</td>
			<td bgcolor="lightgray" align="center">VIEWS</td>
			<td width="150">${board.b_views}</td>
		</tr>
		<tr height="30">
			<td bgcolor="lightgray" align="center">TITLE</td>
			<td colspan="5">${board.b_title}</td>
		</tr>
		<tr height="30">
			<td bgcolor="lightgray" align="center">CONTENTS</td>
			<td colspan="5" ><textarea readonly rows="5" cols="40">${board.b_contents}</textarea></td>
		</tr>
	</table>

	<form name="rFrm" id="rFrm">
		<!-- 댓글 입력 -->
		<table>
			<tr>
				<td><textarea rows="3" cols="50" name="r_contents"
						id="r_contents"></textarea></td>
				<td><input type="button" value="댓글전송"
					onclick="replyInsert(${board.b_num})"
					style="width: 70px; height: 50px"></td>
			</tr>
		</table>
	</form>
	<!-- 댓글 출력 -->
	<table id="rTable">
		<c:forEach var="reply" items="${rList}">
			<tr height="25" align="center">
				<td width="100">${reply.r_id}</td>
				<td width="200">${reply.r_contents}</td>
				<td width="200">${reply.r_date}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>