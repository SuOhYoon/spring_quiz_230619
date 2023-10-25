<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통나무 펜션</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<!-- jquery 원본 -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<!-- 내가 만든 stylesheet -->
<link rel="stylesheet" type="text/css" href="/css/booking/style.css">
</head>
<body>
	<div id="wrap" class="container">
		<header class="d-flex justify-content-center align-items-center">
			<div class="display-4">통나무 펜션</div>
		</header>
		<nav>
			<ul class="nav nav-fill">
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">팬션소개</a></li>
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
				<li class="nav-item"><a href="/lesson06/add-booking-view" class="nav-link text-white font-weight-bold">예약하기</a></li>
				<li class="nav-item"><a href="/lesson06/booking-list-view" class="nav-link text-white font-weight-bold">예약목록</a></li>
			</ul>
		</nav>
		<section class="contents">
			<div>
				<img class="banner" src="/img/test06_banner4.jpg" />
			</div>
			<div class="main row mx-0">
		      <div class="col-md-4 text-area py-5"><div class="display-4 justify-content-center align-items-center text-white">실시간 예약하기</div></div>
		      <div class="col-md-4 input-area pt-3">
		      	<h4 class="text-white">예약 확인</h4>
		      	<div>
		      		<div class="d-flex">
		      			<div class="subject-text my-2 text-white px-3">이름</div>
						<input type="text" class="form-control col-7" name="name">
		      		</div>
					<div class="d-flex">
		      			<div class="subject-text my-2 text-white">전화번호</div>
						<input type="text" class="form-control col-7" name="phoneNumber">
		      		</div>
		      		<button type="button" id="selectBtn" class="btn btn-success w-100 mt-3">조회하기</button>
		      	</div>
		      </div>
		      <div class="col-md-4 text-area" >.col-md-4</div>
		    </div>
		</section>
		<footer>
		    <small class="text-secondary">
		        제주특별자치도 제주시 애월읍<br>
		        사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목<br>
		        Copyright 2025 tongnamu. All right reserved.
		    </small>
		</footer>
	</div>
	<script>
		$(document).ready(function(){
			$('#selectBtn').on('click',function(){
				let name = $('input[name=name]').val().trim();
				let phoneNumber = $('input[name=phoneNumber]').val().trim();
				
				if(!name){
					alert("이름을 입력하세요.");
				}
				if(!phoneNumber){
					alert("전화번호를 입력하세요.");
				}
				
				$.ajax({
					// request
					type:"POST"
					, url: "/lesson06/search-booking"
					, data:{"name":name, "phoneNumber":phoneNumber}
				
					// response
					, success:function(data){
						// {"code":400, "error_message":"데이터가 존재하지 않습니다."}
						// {"code":200, "result":booking}
						if(data.code="200"){
							alert(data.result);
						} else if(data.code == 400){
							alert(data.error_message);
						}
					}
					, error:function(request, status, error){
						alert("예약이 조회되지 않습니다. 관리자에게 문의하세요.");
					}
				});
			});
		});
	</script>
</body>
</html>