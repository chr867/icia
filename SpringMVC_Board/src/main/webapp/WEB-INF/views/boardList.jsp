<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:if test="${!empty id}">
<div align="right">
	<form id="logoutFrm" action="/member/logout" method="post">
		<a href="javascript:logout()"> </a>
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