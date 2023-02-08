<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
<h1>axios.jsp</h1>

<h3>영화 제목1</h3>
<img alt="#" src="" width="200px">
<h3>영화 제목2</h3>
<img alt="#" src="" width="200px">

<script type="text/javascript">
const h3El= document.querySelector('h3')
const imgEl = document.querySelector('img')
const h3Els= document.querySelectorAll('h3')
const imgEls = document.querySelectorAll('img')

/* 	function fetchMovies(){
		axios.get('https://www.omdbapi.com/?apikey=7035c60c&s=frozen')
		.then(res=>{ //통신에 성공
			console.log(res)
			h3El.innerHTML = res.data.Search[0].Title
			imgEl.src = res.data.Search[0].Poster
		})
		.catch(err=>console.log(err)); //통신에 실패

	console.log("일반코드")
	}
fetchMovies();
 */
 
 //callback hell() 콜백 지옥
 //async와 await로 (Promise 객체) 콜백지옥 해결하기
/* 	async function fetchMovies1(){
	const h3Els=document.querySelectorAll('h3')
	const imgEls = document.querySelectorAll('img')
	let res=await axios.get('https://www.omdbapi.com/?apikey=7035c60c&s=frozen')
	console.log(res)
	h3Els[0].innerHTML = res.data.Search[0].Title
	imgEls[0].src = res.data.Search[0].Poster

	res=await axios.get('https://www.omdbapi.com/?apikey=7035c60c&s=shining')
	h3Els[1].innerHTML = res.data.Search[0].Title
	imgEls[1].src = res.data.Search[0].Poster
		
	 }
	fetchMovies1();	 */

/* 	async	function fetchMovies2(){
		try{
			let res = await axios.get('https://www.omdbapi.com/?apikey=7035c60c&s=frozen')
			console.log("1:",res)
			h3Els[0].innerHTML = res.data.Search[0].Title
			imgEls[0].src = res.data.Search[0].Poster
			
			res = await axios.get('https://www.omdbapi.com/?apikey=7035c60c&s=shining')
			console.log("2:",res)
			h3Els[1].innerHTML = res.data.Search[0].Title
			imgEls[1].src = res.data.Search[0].Poster		
		}catch(all_err){
			console.log(all_err)
		}
	}
	fetchMovies2(); */
	
	//promise 체이닝으로 콜백지옥 해결
	function fetchMovies2_1(){
		axios.get('https://www.omdbapi.com/?apikey=7035c60c&s=frozen')
		.then(res =>{
			console.log("1:",res)
			h3Els[0].innerHTML = res.data.Search[0].Title
			imgEls[0].src = res.data.Search[0].Poster
			return axios.get('https://www.omdbapi.com/?apikey=7035c60c&s=shining')
		}).then(res =>{
			console.log("2:",res)
			h3Els[1].innerHTML = res.data.Search[0].Title
			imgEls[1].src = res.data.Search[0].Poster		
		}).catch(err=>console.log(err))
	}
	fetchMovies2_1();

	 async function fetchMovies3(){
		try{
			await getFirstMovie();
			await getSecondMovie();
		}catch(all_err){
			console.log(all_err)
		}
	}
	fetchMovies3();
	
	async function getFirstMovie(){
		let res=await axios.get('https://www.omdbapi.com/?apikey=7035c60c&s=frozen')
		h3Els[0].innerHTML = res.data.Search[0].Title
		imgEls[0].src = res.data.Search[0].Poster
		console.log("first",res)
	}
	
	async function getSecondMovie(){
		let res=await axios.get('https://www.omdbapi.com/?apikey=7035c60c&s=shining')		
		h3Els[1].innerHTML = res.data.Search[0].Title
		imgEls[1].src = res.data.Search[0].Poster		
		console.log("second",res)
	}
	
</script>

</body>
</html>