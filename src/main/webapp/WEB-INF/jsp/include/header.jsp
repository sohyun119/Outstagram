<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

    <header >
    	<c:if test="${not empty userId }">
    		<h1 class="text-center">Outstagram</h1>
    		<a href="/user/sign_out" class="text-white">로그아웃</a>
    	</c:if>
    </header>