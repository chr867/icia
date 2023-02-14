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
	
	<c:if test="${empty sessionScope.id}">
		<h3>비로그인 상태</h3>		
	</c:if>
	
	<c:if test="${!empty sessionScope.id}">
		<h3>로그인 상태</h3>		
		<a></a> <!-- 로그아웃 링크 -->
	</c:if>
	
	<c:if test="${id=='admin'}">
		<h3>관리자 로그인 상태</h3>		
	</c:if>
	
	<c:if test="${id!='admin'}">
		<h3>일반 유저 로그인 상태</h3>		
	</c:if>

	<c:choose>
		<c:when test="${id=='admin'}">
			<h3>관리자 로그인 상태</h3>				
		</c:when>
		
		<c:when test="${id!='admin'}">
			<h3>일반 유저 로그인 상태</h3>		
		</c:when>
	</c:choose>
	
	<c:set var="data" value="관리자">	</c:set>
	<b><c:out value="${data}"></c:out> </b>
<hr>

<div id="result">
	
</div>	
	<script type="text/javascript">
//	console.log('${mList}')
	console.log(${mListJson})
 	$(function(){
		let mList=${mListJson} //json 문자열 -->js객체 변환
		let tbList='<table border="1">'
		for(let id of mList){
			tbList+='<tr>';
			tbList+='<td><a href="memberinfo?id='+id+'">'+id+'</a></td>';
			tbList+='<td><a href="memberdelete?id='+id+'">삭제</a></td>';
			tbList+='</tr>';
		}
		tbList+='</table>';
		$("#result").append(tbList);
		//$('<a href="https://www.naver.com" target="_blank" >네이버</a>').appendTo('body')
		let $aElem=$('<a>')
		$aElem.attr('href', "https://www.naver.com").html('NAVER')
		.appendTo('body')
		
		console.log('${id}') //String 
		console.log(${id!=null}) //true(bool)
		console.log('${id!=null}')//true(String)
		console.log('empty',${empty id})
		console.log(${!empty id})
		//if(${id!=null}){
		if(${!empty id}){
			alert("로그인 상태")
		}else{
			alert('비로그인 상태')
		}
	})
		
	</script>
</body>
</html>