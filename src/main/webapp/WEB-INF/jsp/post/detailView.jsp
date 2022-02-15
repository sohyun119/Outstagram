<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
		
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
		<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<section class="content">
			<div class="d-flex justify-content-center mt-5">
					<div class="postBox border">
						<div class=" postHeader d-flex justify-content-between mt-3">
							<div class="ml-4">
								<i class="bi bi-camera"></i>
								<a href="/post/other_feed_view?userId=${post.userId }&&userName=${post.userName}" class="text-dark ml-1 mt-3">
								${post.userName }</a>
							</div>
							<c:if test="${post.userId eq thisId }">
								<div>
									<button type="button" class="btn mr-3" id="deleteBtn"><i class="bi bi-trash"></i></button>
								</div>
							</c:if>
						</div>
						<hr>
						<div class="d-flex justify-content-center mt-4">
							<img src="${post.imagePath }"  class="postImgBox border border-white">
						</div>
						<div class="mt-3 ml-4">
							<c:choose>
								<c:when test="">
									<button type="button" id="likeBtn"><i class="bi bi-heart"></i></button>
								</c:when>
								<c:when test="">
									<button type="button" id="likeCancleBtn"><i class="bi bi-heart-fill"></i></button>
								</c:when>
							</c:choose>
							
							<div>좋아요 개</div>
						</div>
						<div class="ml-4">
							<div class="mt-2">${post.userName } : ${post.content }</div>
							<small><fmt:formatDate value="${post.createdAt }" pattern="yyyy년 M월 d일" /></small>
						</div>
					</div>
				</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	
	<script>
			
		$(document).ready(function(){
			
			$("#deleteBtn").on("click", function(){
				var postId = ${post.id};
				
				$.ajax({
					type:"get",
					url:"/post/delete",
					data:{"postId":postId},
					success:function(data){
						alert("삭제 성공");
						location.href="/post/feed_view";
					},
					error:function(){
						alert("에러발생");
					}
				});
				
			});
			
			
			
		});
	
	
	
	</script>
	
	
	
	
	
	
	
	
	

</body>
</html>