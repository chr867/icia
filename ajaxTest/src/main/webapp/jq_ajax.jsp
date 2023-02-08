<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
<h1>jq_ajax.jsp</h1>

<h3>영화 제목1</h3>
<img alt="#" src="" width="200px">
<h3>영화 제목2</h3>
<img alt="#" src="" width="200px">


<script type="text/javascript">
const $h3Els = $('h3')
const $imgEls = $('img')

function fetchMovies1(){
	//Promise 와 비슷한 Deffered 객체 반환
	$.ajax({
		method:'get',
		url:'https://www.omdbapi.com/',
		data:{apikey:'7035c60c',s:'squid'},
		//지정하지 않으면 서버에서 리턴하는 타입
		dataType:'json',
		success : res=>{
			console.log(res)
			
		},error : err=>console.log(err)
	})
}
	/* .done(res=>{
		console.log(res)
	}).fail(err=>console.log(err))
} */
fetchMovies1();

function fetchMovies(){
	$.get('https://www.omdbapi.com/?apikey=7035c60c&s=frozen')
	.done(res =>{
		console.log(res)
		$('h3').first().html(res.Search[0].Title)
		$('img').first().attr('src',res.Search[0].Poster)
		}).fail(err=>console.log(err))
	//.then(성공콜백,실패콜백)
}
	fetchMovies();

</script>

</body>
</html>