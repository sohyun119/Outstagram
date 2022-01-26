<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
		<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	
	<div id="wrap">
		
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<section class="content d-flex justify-content-center">
			<div class="joinBox bg-white">
				<h1 class="text-center mt-5">Outstagram</h1>
				<div class="mx-3">
					<h4 class="text-secondary mt-3 mx-3">친구들의 사진과 동영상을 보려면 가입하세요.</h4>
					<input type="text" id="emailInput" placeholder="이메일 주소" class="form-control bg-light mt-4">
					<input type="text" id="nameInput" placeholder="성명" class="form-control bg-light mt-4">
					<input type="text" id="loginIdInput" placeholder="아이디" class="form-control bg-light mt-4">
					<input type="password" id="passwordInput" placeholder="비밀번호" class="form-control bg-light mt-4">
					<input type="password" id="passwordConfirmInput" placeholder="비밀번호 확인" class="form-control bg-light mt-4">
					<button type="button" id="joinBtn" class="btn btn-primary mt-3 btn-block">가입</button>
					<div class="text-center mt-3"><a href="/user/signin_view">로그인</a></div>
				</div>
			</div>
		
		</section>
	
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	
	</div>
	
	<script>
		$(document).ready(function(){
			
			$("#joinBtn").on("click", function(){
				var email = $("#emailInput").val();
				var name = $("#nameInput").val();
				var loginId = $("#loginIdInput").val();
				var password = $("#passwordInput").val();
				var passwordConfirm = $("#passwordConfirmInput").val();
				
				if(email == ""){
					alert("이메일을 입력해주세요.");
					return;
				}
				if(name == ""){
					alert("이름을 입력해주새요.");
					return;
				}
				if(loginId == ""){
					alert("아이디를 입력해주세요.");
					return;
				}
				if(password == ""){
					alert("비밀번호를 입력해주세요.");
					return;
				}
				if(password != passwordConfirm){
					alert("비밀번호가 같지 않습니다.");
					return;
				}
				
				
				$.ajax({
					type:"post",
					url:"/user/sign_up",
					data:{"email":email,"name":name,"loginId":loginId,"password":password},
					success:function(data){
						if(data.result == "success"){
							alert("회원가입 완료!");
							location.href = "/user/signin_view";
						}else{
							alert("회원가입을 실패했습니다.");
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