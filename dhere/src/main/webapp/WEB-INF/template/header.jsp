<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="resources/css/header.css">




<div class="row p-5" id="header">
	<div class="col">
		<img src="resources/images/icon/logo2.png" id="header_logo" onclick="location.href='main'">
	</div>
	<div class="col justify-content-end d-flex align-items-center">
		<a href="main" class="text-decoration-none text-white" id="header_menu">Home</a>
		<a href="mainProduct" class="text-decoration-none text-white" id="header_menu">Product</a>
		<a href="mainAbout" class="text-decoration-none text-white" id="header_menu">About</a>
		<a href="mainNotice" class="text-decoration-none text-white" id="header_menu">Notice</a>
		
		<img src="resources/images/icon/profile_white.png" 
				id="login_menu"
				tabindex="0" 
				data-bs-html="true" 
				data-bs-placement="bottom" 
				data-bs-toggle="popover" 
				data-bs-trigger="focus" 
				data-bs-title="유저 닉네임" 
				data-bs-content="
				<a href='loginForm' class='text-decoration-none text-dark'>로그인</a>
				<br>
				<br>
				<a href='joinForm' class='text-decoration-none text-dark'>회원가입</a>
				">
	</div>
</div>