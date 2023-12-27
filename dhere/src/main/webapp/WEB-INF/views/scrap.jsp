<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width">
			<title>마이페이지</title>
<link href="resources/bootstrap/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/member.js"></script>
<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/js/formcheck.js"></script>
<script src="resources/js/member.js"></script>
	</head>
<body>
			<!-- 개인정보 -->
			<div class="row">
					<div class="col-3 offset-1 my-3">
					<h1 style="font-weight: bold">마이 페이지</h1>
					</div>
					<div>
				<ul class="nav nav-underline offset-1">
					<li class="nav-item text-center" style="width: 170px">
					  <a class="nav-link active categoryBtn" aria-current="page" style="font-size: 25px; color: black" data-bs-toggle="pill">회원정보</a>
					</li>
					<li class="nav-item text-center" style="width: 170px">
					  <a class="nav-link categoryBtn" href="/mypageUpdateForm" style="font-size: 25px; color: black" data-bs-toggle="pill">회원정보 수정</a>
					</li>
					<li class="nav-item text-center" style="width: 170px">
					  <a class="nav-link categoryBtn"  style="font-size: 25px; color: black" data-bs-toggle="pill">1:1문의하기</a>
					</li>
					<li class="nav-item text-center" style="width: 170px">
					  <a class="nav-link categoryBtn"  style="font-size: 25px; color: black" data-bs-toggle="pill">로그아웃</a>
					</li>
				</ul>			
				
					<div class="row justify-content-center" id="profile">
						<div class="col-8 m-3 p-1 rounded-4">
					<div class="row-4">
					<!-- 프사 -->
					<c:if test="${ empty sessionScope.member.picture }">
					프사
					<!-- 귀여운그림 -->
					</c:if>
					<c:if test="${ not empty sessionScope.member.picture }">
						<img src="resources/images/profile/${ sessionScope.member.picture}" alt="50*50 size image" style="width: 50px; height: 50px; object-fit: cover; border-radius: 70%; border: 3px solid gray">
					</c:if>
				</div>
				<div class="col">
				
				${sessionScope.member.nickname}님	( ${sessionScope.member.email} )<br>
				${sessionScope.member.job} <br>
					좋아요 00개
				</div>
				</div>				
				</div>
			</div>
		</div>
		<div>
			<div>
			<!-- 내정보 끝 -->
			<div class="row">
				<div class="col-3 offset-1 my-3">
					<h1 style="font-weight: bold">게시물 보기</h1>
				</div>
			</div>
			<ul class="nav nav-underline offset-1">
				<li class="nav-item text-center" style="width: 170px">
				  <a class="nav-link active categoryBtn" aria-current="page" style="font-size: 25px; color: black" data-bs-toggle="pill">All</a>
				</li>
				<li class="nav-item text-center" style="width: 170px">
				  <a class="nav-link categoryBtn"  style="font-size: 25px; color: black" data-bs-toggle="pill">나의 게시물</a>
				</li>
				<li class="nav-item text-center" style="width: 170px">
				  <a class="nav-link categoryBtn"  style="font-size: 25px; color: black" data-bs-toggle="pill">나의 스크랩</a>
				</li>
				<li class="nav-item text-center" style="width: 170px">
				  <a class="nav-link categoryBtn"  style="font-size: 25px; color: black" data-bs-toggle="pill">팔로잉 목록</a>
				</li>
			</ul>
			<div class="row justify-content-center" id="categoryList">
			<c:forEach var="p" items="${pList}">
			<div class="col-3 m-3 p-1 rounded-4" style="width: 350px; height: 380px; background: #F3F3F3; cursor:pointer;" onclick="location.href='productDetail?productNo=${p.productNo}'">
				<div class="row">
				    <div class="col d-flex justify-content-center align-items-center" style="height: 200px; overflow: hidden;">
				        <img src="resources/images/products/${p.productImage}" id="preview" class="img-fluid rounded-top-4" alt="${p.productImage}" style="width: 100%; height: 100%;">
				    </div>
				</div>
	
				<div class="row">
					<div class="col p-3">
						<div class="row">
				    <div class="col d-flex justify-content  mb-3" style="overflow: hidden; font-size: 15px; color: #5E5E5E">
				    	${p.brandName}
					</div>
				</div>
				
				<div style="width: 100%; height: 2px; background-color: #5E5E5E"></div>
				
				<div class="row">
				    <div class="col mt-3 d-flex justify-content" style="overflow: hidden; font-size: 23px">
				        <b>${p.productName}</b>
				    </div>
				</div>
					</div>
				</div>
			</div>
			</c:forEach>
			</div>
			
			
			<input type="button" value="morepage">
		<%@ include file="/WEB-INF/template/footer.jsp"%>
		<script src="resources/bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>