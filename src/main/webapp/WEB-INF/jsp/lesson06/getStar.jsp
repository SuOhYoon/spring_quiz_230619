<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<body>
	<div class="container">
		<h1>즐겨찾기 목록</h1>
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="star" varStatus="status">
				<tr>
					<td>${star.id}</td>
					<td>${star.name}</td>
					<td><a href="${star.url}" target="_blank">${star.url}</a></td>
					<td>
						<button type="button" class="del-btn btn btn-danger" data-star-id="${star.id}">삭제</button>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<script>
$(document).ready(function(){
	// 삭제 버튼 클릭
	$(".del-btn").on("click", function(){
		// let id = $(this).val();
		// -- data -- -> data("star-id") 함수 사용
		let id = $(this).data('star-id');	
		
		// alert(id);
		$.ajax({
			// request
			type:"DELETE"
			, url:"/lesson06/quiz02/delete-star"
			, data:{"id":id}
			//
			, success:function(data){
				if(data.code == 200){
					location.reload(true); // 새로고침을 해도 스크롤 위치가 바꾸지 않음	
				} else {
					alert("삭제를 하는데 실패했습니다. 다시 시도해주세요.");
				}
			}
		});
	});
});
</script>
</body>
</html>