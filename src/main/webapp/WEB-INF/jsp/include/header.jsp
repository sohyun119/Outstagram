<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	
    <header class="d-flex justify-content-center">
    	<c:if test="${not empty userId }">
    		<div class="headerBox ">
    			<div class="display-4 text-center font-italic">Outstagram</div>
    			<div class="d-flex justify-content-between">
	    			<ul class="nav">
	    				<li class="nav-item">
	    					<a href="/post/feed_view" class="nav-link text-dark">feed</a>
	    				</li>
	    				<li class="nav-item">
	    					<a href="/post/timeline_view" class="nav-link text-dark">time line</a>
	    				</li>
	    			</ul>
	    			
	    			<ul class="nav">
	    				<li class="nav-item">
	    					<a href="/post/create_view" class="nav-link text-dark"><i class="bi bi-plus-square"></i></a>
	    				</li>
	    				<li class="nav-item">
	    					<a href="/user/search_view" class="nav-link text-dark"><i class="bi bi-search"></i></a>
	    				</li>
	    				<li class="nav-item">
	    					<a href="/user/sign_out" class="nav-link text-dark">logout</a>
	    				</li>
	    			</ul>
    			</div>
    			<hr>
    		</div>
    		
    	</c:if>
    </header>