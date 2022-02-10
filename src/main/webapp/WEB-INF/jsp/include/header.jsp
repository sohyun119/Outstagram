<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	
    <header class="d-flex justify-content-center bg-primary">
    	<c:if test="${not empty userId }">
    		<div class="headerBox ">
    			<div class="display-4 text-center text-white">Outstagram</div>
    			<ul class="nav justify-content-end">
    				<li class="nav-item">
    					<a href="/user/sign_out" class="nav-link text-white">로그아웃</a>
    				</li>
    				<li class="nav-item">
    					<a href="/post/create_view" class="nav-link text-white">글쓰기</a>
    				</li>
    				<li class="nav-item">
    					<a href="#" class="nav-link text-white">검색</a>
    				</li>
    			</ul>
    		</div>
    	</c:if>
    </header>