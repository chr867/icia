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
<h3>memberList.jsp - 일반회원 목록</h3>
${msg}
<%-- ${mList} --%>
<!-- jstl: 간편하지만, 가독성이 떨어짐. -->
	<table border="1">
		<c:forEach var="id" items="${mList}">
			<tr>
				<td> <a href="memberinfo?id=${id}">${id}</a></td>
				<td> <a href="memberdelete?id=${id}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
<hr>
<div id="result">
	
</div>	
	<script type="text/javascript">
//	console.log('${mList}')
	console.log(${mListJson})
 	$(function(){
		let mList=${mListJson}
		let tbList='<table border="1">'
		for(let id of mList){
			tbList+='<tr>';
			tbList+='<td><a href="memberinfo?id='+id+'">'+id+'</a></td>';
			tbList+='<td><a href="memberdelete?id='+id+'">삭제</a></td>';
			tbList+='</tr>';
		}
		tbList+='</table>';
		$("#result").append(tbList);
	})
	
	</script>
</body>
</html>