<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<div class="row">
	<div class="col">
		<!-- 캐러셀 시작 -->
		<div class="row">
			<div class="col">
				<div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
					<div class="carousel-inner">
					  <div class="carousel-item active" data-bs-interval="10000">
					    <img src="resources/images/dhere_carousel.png" class="d-block w-100" alt="...">
					  </div>
					  <div class="carousel-item" data-bs-interval="2000">
					    <img src="resources/images/dhere_carousel.png" class="d-block w-100" alt="...">
					  </div>
					  <div class="carousel-item">
					    <img src="resources/images/dhere_carousel.png" class="d-block w-100" alt="...">
					  </div>
					</div>
					<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
					  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					  <span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
					  <span class="carousel-control-next-icon" aria-hidden="true"></span>
					  <span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>
		</div>
		<!-- 캐러셀 끝 -->
		<!-- 카테고리 시작 -->
		<div class="row bg-primary">
			<div class="col">
				category
			</div>
		</div>
		<!-- 카테고리 끝 -->
		<!-- 검색창 시작 -->
		<div class="row my-5 text-center justify-content-center">
			<div class="col">
				<form class="" action="#">	
					<div class="col">
						<input type="text" placeholder="need search">
						<button type="submit" class="btn btn-secondary" name="searchButton" id="searchButton">Search</button>
					</div>	
				</form>
			</div>
		</div>
		<!-- 검색창 끝 -->
		<!-- 게시글 타이틀 시작 -->
		<div class="row my-5">
			<div class="col-3 bg-success">
				전체 게시글
			</div>
			<div class="col-6">
				filter list 1, filter list 2, filter list 3,
			</div>
			<div class="col-3 bg-success text-end">
				최신순 정렬
			</div>
		</div>
		<!-- 게시글 타이틀 끝 -->
		<!-- 게시글리스트 시작 -->
		<div class="row my-3 p-5">
		
			<c:forEach var="s" items="${sList}">
			<div class="col-4">
				<!-- 데스크셋업 이미지 -->
				<div class="row">
					<div class="col">
						<img src="resources/images/desk/${s.thumbnail}" alt="400*200 size image" style="width: 400px; height: 200px; object-fit: cover;">
					</div>
				</div>
				<!-- 프로필 이미지, 닉네임, 좋아요, 공감 -->
				<div class="row my-3">
					<div class="col-2">
						<img src="resources/images/profile/${s.profile}" alt="50*50 size image" style="width: 50px; height: 50px; object-fit: cover; border-radius: 70%;">
					</div>
					<div class="col-4">
						${s.nickname} (닉네임)
					</div>
					<div class="col text-end">
						${s.readCount} (조회수)
					</div>
					<div class="col text-end">
						${s.thank} (좋아요)
					</div>
				</div>
				<!-- 타이틀 -->
				<div class="row border-bottom py-3">
					<div class="col">
						${s.title}
					</div>
				</div>
				<!-- 태그 -->
				<div class="row py-3">
					<div class="col">
						tag, tag_post 테이블 참조 ..
					</div>
				</div>
				<div class="row text-end py-3">
					<div class="col">
					${s.regDate}
					</div>
				</div>
				
			</div>
			</c:forEach>
			
		</div>
		

	</div>
</div>
	
</body>
</html>

	
