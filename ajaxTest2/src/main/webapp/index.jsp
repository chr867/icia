<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<style type="text/css">
div{
	border : 1px solid red;
	width : 200px;
	height : 200px;
	overflow: auto;
}
</style>
</head>
<body>
<h1>index.jsp</h1>
<a href="./test?id=aaa&pw=1111">일반 controller</a>
<button onclick="goAjax()">restController</button>
<h1>회원 정보</h1>
<div id="memberInfo"></div><br>

<button onclick="goAjax2()">restController2</button>
<h1>회원리스트 정보</h1>
<div id="memberInfo2"></div>


<script type="text/javascript">
function goAjax(){
	$.ajax({
		method:'get',
		url:'member/info',
		data:{data:JSON.stringify({id:'aaa',pw:'1234'})},
		dataType:'json',
		timeout:'1000', //요청 타임 아웃
	}).done(function(res){
		console.log(res)
		$('#memberInfo').append(res.id+"<br>"+res.pw+"<br>")
	}).fail(function(err){
		console.log(err)
	})
}

let obj1={id:'aaa', pw:'1234'}
let obj2={id:'bbb', pw:'5678'}
let arr=[obj1,obj2]

let obj={data:arr}
//let obj={}
//obj.data=arr
obj.val=100
//console.log(obj)

for(let key in obj){
//	console.log(key,obj[key])
	if(key=='data'){
		for(let i of obj[key]){
			console.log('of',i,i.id)
		}
		obj[key].forEach(arr=>{
			console.log('each',arr,arr.id)
		})
	}
}

function goAjax2(){
	$.ajax({
		method : 'get',
		url:'member/list', //대분류/중분류/소분류 //[],{} 특수문자,한글은 url 인코딩 때문에 깨짐
		data:{arr:JSON.stringify(obj.data)}, //{arr:[{obj1},{obj2}]}
		dataType: 'json',
		timeout: '1000'
	}).done(function(res){
		console.log("res",res)
		res.forEach(obj=>{
			console.log("obj:",obj)
			for(let key in obj){
				$('#memberInfo2').append(key,": ",obj[key],"<br>")
			}
			$('#memberInfo2').append("<br>")
		})
	}).fail(function(err){
		console.log(err)
	})
}
</script>

</body>
</html>