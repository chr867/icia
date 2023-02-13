<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>joinFrm.jsp</h1>
	${msg}
	<form name="joinFrm" action="memberjoin" method="post">
	아이디:<input type="text" name="id">	<br> 
	비번:<input type="password" name="pw"> <br> 
	이름:<input type="text" name="name">	<br> 
	성별:<input type="radio" name="gender" value="남자">남자
	<input type="radio" name="gender" value="여자">여자	<br>
	<button type="button" onclick="formCheck()">회원가입</button>
	<button type="reset">취소</button>
	</form>
	
	<script type="text/javascript">
		function formCheck(){
			let frm=document.joinFrm;
			let len=frm.length-4;
			for (let i=0;i<len;i++){
				if(frm[i].value==''){
					alert(frm[i].name+"을 입력하세요!")
					frm[i].focus();
					return false;
				}
			}
			frm.submit();
		}
	</script>
</body>
</html>