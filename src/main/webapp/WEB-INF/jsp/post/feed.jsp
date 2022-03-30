<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>feed</title>
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
		
		<section class="content d-flex justify-content-center">
			<div class="feedBox mt-5">
				<div class="d-flex">
					<h5 class="d-none" id="feedUserId">${feedUserId }</h5>
					<h5 class="text-secondary ml-3 font-italic" id="feedUserName"><i class="bi bi-person-circle"></i> ${feedUserName }</h5>
				</div>
				<div class="mt-3">
					<!-- follow상태에 따른 버튼을 각기 -->
					<c:choose>
						<c:when test="${(followState eq 0) and (my_feed != true)}">
							<button type="button" class="btn btn-primary btn-sm mr-3" id="followBtn">follow 하기</button>
						</c:when>
						<c:when test="${(followState != 0) and(my_feed != true)}">
							<button type="button" class="btn btn-primary btn-sm mr-3" id="unfollowBtn">follow 취소</button>
						</c:when>
					</c:choose>
					<!-- follow & following list -->
					<button type="button" class="btn btn-light btn-sm" id="followListBtn">${follwCount } 팔로워</button>
					<button type="button" class="btn btn-light btn-sm" id="followingListBtn">${follwingCount } 팔로잉</button>
					
				</div>
				<!-- feed post list -->
				<div class="feedImgBox d-flex mt-5 flex-wrap">
					<c:forEach var="feedPost" items="${feedPost }">
						<div >
							<a href="/post/detail_view?postId=${feedPost.id }">
								<img src="${feedPost.imagePath }" class="feedImg border border-white">
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
	
		$(document).ready(function(){
			var feedUserId = $("#feedUserId").text(); // this일때는 저장이 안되고 있음
			var feedUserName = $("#feedUserName").text();
			//alert(feedUserId);
			
			$("#followBtn").on("click",function(){ 
				
				$.ajax({
					type:"get",
					url:"/post/follow",
					data:{"feedUserId":feedUserId,"feedUserName":feedUserName},
					success:function(data){
						if(data.result == "success"){
							alert("팔로우 완료");
							location.reload(); // 새로고침
						}
						else{
							alert("문제 발생");
						}
					},
					error:function(){
						alert("에러 발생");
					}
				});
				
			});
			
			
			$("#unfollowBtn").on("click",function(){
				
				$.ajax({
					type:"get",
					url:"/post/unfollow",
					data:{"feedUserId":feedUserId},
					success:function(data){
						if(data.result == "success"){
							alert("팔로우 취소 완료");
							location.reload();
						}
						else{
							alert("문제 발생");
						}
					},
					error:function(){
						alert("에러 발생");
					}
				});
				
			});
			
			
			$("#followListBtn").on("click",function(){
				var followNameList = "";
				
				$.ajax({
					type:"get",
					url:"/post/followList",
					data:{"feedUserId":feedUserId},
					success:function(data){
						$(data).each(function(){
							followNameList = followNameList + (this + "\n");
						});
						alert("=== 팔로우 목록 ===\n" + followNameList);
					},
					error:function(){
						alert("에러 발생");
					}
				});
				
			});
			
			
			$("#followingListBtn").on("click",function(){
				var followingNameList = "";
				
				$.ajax({
					type:"get",
					url:"/post/followingList",
					data:{"feedUserId":feedUserId},
					success:function(data){
						$(data).each(function(){
							followingNameList += (this + "\n");
						});
						alert("== 팔로잉 목록 ==\n" + followingNameList);
					},
					error:function(){
						alert("에러 발생");
					}
				});
				
			});
			
			
			
			
		});
	
	
	
	
	
	
	</script>
	

	

</body>
</html>