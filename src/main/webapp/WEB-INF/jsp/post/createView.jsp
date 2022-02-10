<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>createPost</title>
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
	
		<section class="d-flex justify-content-center mt-5">
			<div class="w-50 h-50 border rounded">
				<textarea class="form-control w-100 border-0 non-resize" id="contentInput"></textarea>
				<div class="d-flex justify-content-between my-3 mx-3">
					<span class="img-icon"><i class="bi bi-card-image" id="imgBtn"></i></span>
					<input type="file" id="fileInput" class="d-none">
					<button type="button" id="saveBtn" class="btn btn-secondary">업로드</button>
				</div>
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		
	
	</div>
	
	<script>
		
		$(document).ready(function(){
			
			$("#imgBtn").on("click",function(){
				$("#fileInput").click();
			});
			
			$("#saveBtn").on("click",function(){
				var content = $("#contentInput").val();
				
				if($("#fileInput")[0].files.length == 0){
					alert("사진을 업로드하세요.");
					return;
				}
				
				var formData = new FormData();
				formData.append("content", content);
				formData.append("file", $("#fileInput")[0].files[0]);
				
				$.ajax({
					type:"post",
					url:"/post/create",
					data:formData,
					enctype:"multipart/form-data",
					processData:false,
					contentType:false,
					success:function(data){
						if(data.result == "success"){
							alert("업로드 완료");
						}else{
							alert("업로드 실패");
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