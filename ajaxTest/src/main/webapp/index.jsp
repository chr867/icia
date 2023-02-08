<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<h1>index.jsp</h1>
<input type="button" id="btn" value="AjaxTest">
<div id="result" style="border:1px red solid; width:200px; height:200px">
</div>

<script type="text/javascript">
//	let obj={url:"access",method:'post'}	
	let data={id:'aaa',pw:'1111',name:'SiHyeon'}
	$('#btn').click(()=>{
		$.ajax({
			method:'post',
			url:'ajax-test',
			data:data,
			//서버응답 정보의 타입
			dataType:'json' //json,text(html)
		}).done(res1=>{
			console.log(res1)/* 
			$('#result').html(res1) */
		}).fail(err=>consloe.log(err))
	})//click End
</script>
</body>
</html>