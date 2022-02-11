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
					<!--  <h5 class="text-secondary font-italic" id="feedUserLoginId">${feedUserLoginId }</h5>-->
					<h5 class="text-secondary ml-3 font-italic" id="feedUserName">${feedUserName }</h5>
				</div>
				<div class="mt-3">
					<!-- follow상태에 따른 버튼을 각기 -->
					<c:choose>
						<c:when test="${followState eq 0 }">
							<button type="button" class="btn btn-primary btn-sm mr-3" id="followBtn">follow 하기</button>
						</c:when>
						<c:when test="${followState != 0 }">
							<button type="button" class="btn btn-primary btn-sm mr-3" id="unfollowBtn">follow 취소</button>
						</c:when>
					</c:choose>
					
					<button type="button" class="btn btn-secondary btn-sm">follow list</button>
					<button type="button" class="btn btn-secondary btn-sm">following list</button>
					
				</div>
				<div class="feedImgBox d-flex mt-5 flex-wrap">
					<c:forEach var="feedPost" items="${feedPost }">
						<div >
							<img src="${feedPost.imagePath }" class="feedImg border border-white">
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
	
		$(document).ready(function(){
			var feedUserId = $("#feedUserId").text();
			var feedUserName = $("#feedUserName").text();
			
			$("#followBtn").on("click",function(){ 
				
				
				$.ajax({
					type:"get",
					url:"/post/follow",
					data:{"feedUserId":feedUserId,"feedUserName":feedUserName},
					success:function(data){
						if(data.result == "success"){
						}
						else{
						}
					},
					error:function(){
						alert("에러발생");
					}
				});
				
			});
			
			
			$("#unfollowBtn").on("click",function(){
				
				$.ajax({
					type:"get",
					url:"/post/unfollow",
					data:{"feedUserId":feedUserId,"feedUserName":feedUserName},
					success:function(data){
						if(data.result == "success"){
						}
						else{
						}
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