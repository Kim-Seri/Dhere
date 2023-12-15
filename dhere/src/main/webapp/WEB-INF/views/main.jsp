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
				 <c:forEach var="s" items="${sList}">
		            ${s.title}
		            ${s.content}
		        </c:forEach>
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
			<div class="col">
				<div class="row">
					<div class="col">
						<img src="resources/images/DeskSetUpSample00.png">
					</div>
				</div>
				<div class="row">
					<div class="col">
						<img src="resources/images/userIcon.png">
						닉네임
					</div>
					<div class="col">
						<img src="resources/images/likeIcon.png">
					</div>
					<div class="col">
						라이크-카운트
					</div>
					<div class="col">
						하트
					</div>
					<div class="col">
						하트-카운트
					</div>
				</div>
				<div class="row border-bottom">
					<div class="col">
						title
					</div>
				</div>
				<div class="row">
					<div class="col">
						#content#content#content#content
					</div>
				</div>
				<div class="row text-end">
					<div class="col">
						date
					</div>
				</div>
			</div>
		</div>
		<!-- 게시글리스트 시작 -->
	</div>
</div>
	
</body>
</html>

	
