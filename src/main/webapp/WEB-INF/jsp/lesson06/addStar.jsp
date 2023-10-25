<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- AJAX를 사용하려면 반드시 jquery 원본 필요 -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" id="name" name="name" class="form-control col-5" >
		</div>
		<div class="form-group">
			<label for="url">주소</label>
			<div class="d-flex">
				<input type="text" id="url" name="url" class="form-control col-5" >
				<input type="button" id="urlCheckBtn" class="btn btn-info" value="중복확인">
			</div>
			<small id="urlStatusArea"></small>
		</div>
		<input type="button" id="joinBtn" class="btn btn-success" value="추가" />
	</div>
	<script>
	
	$(document).ready(function() {
		$('#urlCheckBtn').on('click', function(){
			let url = $("#url").val().trim();
			$(this).empty();
			
			$.ajax({
				// request
				type:"GET"
				, url:"/lesson06/quiz01/is-duplication"
				, data:{"url":url}
			
				// response
				, success:function(data){ // data는 string 또는 JSON -> dictionary
				  // {"code":200, "is_duplication":true}
				  if(data.is_duplication){
					  $('#urlStatusArea').append('<span class="text-danger">중복된 url입니다.</span>');
				  } else {
					  $('#urlStatusArea').append('<span class="text-success">입력 가능한 url입니다.</span>');
				  }
				}
				, error:function(request, status, error){
					alert("중복확인에 실패했습니다.");
				}
			});
		});
		
		$('#joinBtn').on('click', function() {
			// validation check
			let name = $("#name").val().trim();
			if (name == "") {
				alert("제목을 입력하세요");
				return; 
			}
			
			let url = $("#url").val().trim();
			if (url == "") {
				alert("주소를 입력하세요");
				return; 
			}
			
			if(url.startsWith("http://") == false && url.startsWith("https://") == false){
					alert("주소 형식이 잘못되었습니다.");
					return;
			}
		
			
			console.log(name);
			console.log(url);
			
			$.ajax({
				// request
				type: "POST"
				, url:"/lesson06/quiz01/add-star"
				, data:{"name":name, "url":url} // JSON String
				
				// response
				// call back 함수
				, success:function(data){ // data: response 결과 응답
					// data는 JSON String -> Object 변환된 상태로 사용 가능
					// jquery ajax 함수 기능
					// alert(data);
					/* alert(data.code);
					alert(data.result); */
					if(data.code == 200){
						location.href="/lesson06/quiz01/get-star";
					} 
				}
				, error:function(request, status, error){
					// 에러일 때 수행(400, 500...)
					alert(request);
					alert(status);
					alert(error);
				}		
			})
		});
	});
	</script>
</body>
</html>