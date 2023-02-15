<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
<h1>main.jsp</h1>
<h3>${id}님 ${msg}</h3>
<%-- 영역속성객체:${msg}
request 객체:${param.msg} --%>
${check}

<c:if test="${!empty id}">
<div align="right">
	<form id="logoutFrm" action="/member/logout" method="post">
		<a href="javascript:logout()">logout</a>
	</form>
</div>
</c:if>

<script type="text/javascript">
logout=()=>{
	$('#logoutFrm').submit();
}
</script>
</body>
</html>