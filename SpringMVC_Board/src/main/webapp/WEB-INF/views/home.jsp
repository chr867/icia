<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Home</title>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="https://code.jquery.com/jquery-3.6.3.js" 
integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
crossorigin="anonymous"></script>
	
</head>

<body>
<h1>Home.jsp-로그인 페이지</h1>
<h3>${msg}</h3>
	<form action="/member/access" name="logFrm" method="post">
		<table border="1">
			<tr>
				<td colspan="2" align="center" bgcolor="skyblue">로그인</td>
			</tr>
			<tr>
				<td><input type="text" name="m_id"></td>
				<td rowspan="2"><button>로그인</button>
			</tr>
			<tr>
				<td><input type="password" name="m_pw"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" bgcolor="skyblue">com.board.icia</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="/member/join">회원가입</a></td>
			</tr>
		</table>
	</form>
	
<script type="text/javascript">
	let check=${check}
	console.log(check)
	if(check==1){
		Swal.fire({
			icon:'success',
			title:'회원가입 성공',
			text:'로그인 해 주세요'
		})
	}else if(check==2){
		Swal.fire({
			icon:'error',
			title:'로그인 실패',
			text:'아이디 또는 비번 오류'
		})
	}
</script>

</body>
</html>
