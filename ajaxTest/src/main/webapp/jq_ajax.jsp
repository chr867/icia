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

//try~catch~finally, async, await로 콜백지옥 해결
async function fetchMovies2(){
	try{
		let res=await $.get('https://www.omdbapi.com/?apikey=7035c60c&s=midsommar')
		console.log('1:',res)
		$h3Els[0].textContent=res.Search[0].Title
		$imgEls[0].src=res.Search[0].Poster
		
		res=await $.get('https://www.omdbapi.com/?apikey=7035c60c&s=avengers')
		console.log('2:',res)
		$h3Els[1].textContent=res.Search[1].Title
		$imgEls[1].src=res.Search[1].Poster	
	}catch(err){ //주의 : 서버통신 이외의 모든 예외를 처리
		console.log(err)
	}finally{
		console.log("항상 처리되는 추가할 코드")
	}
}
fetchMovies2();



function fetchMovies1(){
	//Promise 와 비슷한 Deffered 객체 반환
	$.ajax({
		method:'get',
		url:'https://www.omdbapi.com/',
		data:{apikey:'7035c60c',s:'squid'},
		timeout:3000,
		//지정하지 않으면 서버에서 리턴하는 타입
		dataType:'json'
/* 		success : res=>{
			console.log(res)
			
		},error : err=>console.log(err)
	})*/
	}).done(res=>{
		console.log(res)
		$($h3Els[0]).html(res.Search[0].Title)
		$($imgEls[0]).attr('src',res.Search[0].Poster)
		
		$.ajax({
			method:'get',
			url:'https://www.omdbapi.com/',
			data:{apikey:'7035c60c',s:'squid'},
			//지정하지 않으면 서버에서 리턴하는 타입
			dataType:'json'
	/* 		success : res=>{
				console.log(res)
				
			},error : err=>console.log(err)
		})*/
			}).done(res=>{
				console.log(res)
				$($h3Els[1]).html(res.Search[0].Title)
				$($imgEls[1]).attr('src',res.Search[0].Poster)
			}).fail(err=>console.log(err))
		})
}
/* fetchMovies1();
 */
function fetchMovies(){
	$.get('https://www.omdbapi.com/?apikey=7035c60c&s=frozen')
	.done(res =>{
		console.log(res)
		$('h3').first().html(res.Search[0].Title)
		$('img').first().attr('src',res.Search[0].Poster)
		}).fail(err=>console.log(err))
	//.then(성공콜백,실패콜백)
}
/* 	fetchMovies();
 */
</script>

</body>
</html>