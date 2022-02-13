<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>time line</title>
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
			<!-- <a href="/post/other_feed_view?userId=8&&userName=소현">other</a> -->
			<c:forEach var="timelinePost" items="${timelinePosts }">
			
				<div class="d-flex justify-content-center mt-5">
					<div class="postBox border">
						<div class="bg-primary postHeader d-flex justify-content-between">
								<div class="ml-3">
								<a href="/post/other_feed_view?userId=${timelinePost.userId }&&userName=${timelinePost.userName}" class="text-white font-italic ">
								${timelinePost.userName }</a>
								</div>
						</div>
						<div class="d-flex justify-content-center mt-4">
							<img src="${timelinePost.imagePath }"  class="postImgBox border border-white">
						</div>
						<div>
							
						</div>
						<div>
							<h6 class="mt-3 ml-3">${timelinePost.content }</h6>
						</div>
					</div>
				</div>
				
			</c:forEach>
		</section>
	
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	
	</div>
	

</body>
</html>