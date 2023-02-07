<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
<h3>memberInfo.jsp - 일반회원 정보</h3>

<script type="text/javascript">
	let mList=${mb}
	console.log(mList)
	for (let value in mList) {
		$('<p>').html(value+': '+mList[value]).appendTo('body')
		console.log(mList[value])
	}
</script>
${mb}
</body>
</html>