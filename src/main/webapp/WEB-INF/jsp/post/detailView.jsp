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
						<!-- post header -->
						<div class=" postHeader d-flex justify-content-between mt-3">
							<div class="ml-4">
								<i class="bi bi-camera"></i>
								<a href="/post/other_feed_view?userId=${postDetail.post.userId }&&userName=${postDetail.post.userName}" class="text-dark ml-1 mt-3">
								${postDetail.post.userName }</a>
							</div>
							<c:if test="${postDetail.post.userId eq thisId }">
								<div>
									<a href="#" class="btn mr-3 text-dark" data-toggle="modal" data-target="#exampleModalCenter">
									<i class="bi bi-trash"></i>
									</a>
								</div>
							</c:if>
						</div>
						<hr>
						<!-- 게시물 이미지 -->
						<div class="d-flex justify-content-center mt-4">
							<img src="${postDetail.post.imagePath }"  class="postImgBox border border-white">
						</div>
						<!-- 좋아요 기능 -->
						<div class="mt-3 ml-4 d-flex">
							<a href="#" class="likeBtn text-danger mr-2">
								<c:choose>
									<c:when test="${postDetail.isLike == false}">
										<h5><i class="bi bi-heart"></i></h5>
									</c:when>
									<c:when test="${postDetail.isLike == true}">
										<h5><i class="bi bi-heart-fill"></i></h5>
									</c:when>
								</c:choose>
							</a>
							
							<div>좋아요 ${postDetail.likeCount }개</div>
						</div>
						
						<!-- 게시글 글 -->
						<div class="ml-4">
							<div>${postDetail.post.userName } - ${postDetail.post.content }</div>
						</div>
						<hr class="mx-4">
						
						<!-- 댓글 -->
						<div class="mx-4">
							
							<c:forEach var="Comment" items="${postDetail.commentList }">
								<div class="d-flex">
									<div>${Comment.userName } - ${Comment.comment }</div>
									<c:if test="${Comment.userId eq thisId }">
										<a href="#" class="ml-3 deleteCommentBtn" data-comment-id="${Comment.id }"><small>삭제</small></a>
									</c:if>
								</div>
							</c:forEach>
							
							<div class="d-flex mt-2">
								<input type="text" class="form-control" id="commentInput">
								<button type="button" class="btn btn-info commentBtn">게시</button>
							</div>
						</div>
						
						<!-- 게시물 작성 날짜 -->
						<div class="ml-4 mt-2 mb-4">
							<small><fmt:formatDate value="${postDetail.post.createdAt }" pattern="yyyy년 M월 d일" /></small>
						</div>
					</div>
				</div>
			
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	

	<!-- Modal (뒤에 어둡게하고 창 띄우기)-->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-body">
	      	<button type="button" class="btn btn-info form-control" id="deleteBtn">삭제하기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script>
			
		$(document).ready(function(){
			
			$("#deleteBtn").on("click", function(e){
				e.preventDefault();
				let postId = ${postDetail.post.id };
				
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
			
			
			$(".likeBtn").on("click", function(e){
				e.preventDefault();
				let postId = ${postDetail.post.id };
				
				$.ajax({
					type:"get",
					url:"/post/like",
					data:{"postId":postId},
					success:function(data){
						location.reload();
					},
					error:function(){
						alert("좋아요 에러 발생");
					}
				});
			});
			
			
			$(".commentBtn").on("click",function(e){
				e.preventDefault();
				let postId = ${postDetail.post.id };
				let comment = $("#commentInput").val();
				
				$.ajax({
					type:"post",
					url:"/post/add_comment",
					data:{"postId":postId,"comment":comment},
					success:function(data){
						location.reload();
					},
					error:function(){
						alert("댓글 쓰기 에러");
					}	
				});
			});
			
			
			$(".deleteCommentBtn").on("click", function(e){
				e.preventDefault();
				let commentId = $(this).data("comment-id");
				
				$.ajax({
					type:"get",
					url:"/post/delete_comment",
					data:{"commentId":commentId},
					success:function(data){
						location.reload();
					},
					error:function(){
						alert("댓글 삭제 에러");
					}
				});
			});
			
			
		});
	
	
	
	</script>
	
	
	
	
	
	
	
	
	

</body>
</html>