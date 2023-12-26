<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="resources/css/main.css">
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<div class="container">
<div class="row">
	<div class="col">
	
		<!-- 언이 글쓰기 버튼 -->
		<input type="button" class="btn btn-primary" onclick="location.href='postWriteForm'" value="글쓰기"/>
		
		
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
		
		<!-- 카테고리 -->
		<div class="row">
		<div class="col">
			
		</div>
		</div>
		
		<!-- 검색창 -->
		<div class="row">
		<div class="col d-flex justify-content-center">
			<form class="row my-5 " action="#">
			<div class="col">
				<input type="text" placeholder=" &nbsp;#데스크셋업" class="border border-primary border-3 rounded-4 TagSearchBox"> &nbsp;&nbsp;
				<img src="resources/images/icon/search.png" style="width: 35px;">
			</div>
			</form>
		</div>
		</div>
		
		<!-- 게시글 타이틀, 필터, 정렬 -->
		<div class="row align-items-center">
		<div class="col-2" style="font-weight: bold; font-size: 2.0em;">
			 ⎸ 전체 게시글
		</div>
		<div class="col align-items-center">
			<button type="button" class="btn btn-outline-secondary btn-sm rounded-4">#데스크셋업	x</button>&nbsp;
			<button type="button" class="btn btn-outline-secondary btn-sm rounded-4">#개발자		x</button>
		</div>
		<div class="col text-end">
			<select class="selectBox" onchange="">
				<option value="">최신순 정렬</option>
				<option value="">인기순 정렬</option>
			</select>
		</div>
		</div>

		<!-- 데스크셋업 리스트 -->
		<div class="row">
		<div class="col">
			
			<!-- 게시물 전체 -->
			<div class="row">
			<div class="col">
			
			<!-- 게시물 한칸 -->
			<div class="row d-flex justify-content-center">
			<c:forEach var="s" items="${sList}">
			<div class="col-3 m-4 rounded-4" style="background: #F3F3F3;">
			
				<!-- 데스크셋업 썸네일 -->
				<div class="row rounded-top-4" style="height: 200px; background-size: cover; background-position: center; background-image: url('resources/images/desk/${s.fileName}');">
				<div class="col">				
				</div>
				</div>
				
				<!-- 프로필, 닉네임, 날짜 -->
				<div class="row">
				<div class="col offset-1 p-3" style="color: #636363;">
					<img src="resources/images/profile/${s.picture}" alt="50*50 size image" style="width: 50px; height: 50px; object-fit: cover; border-radius: 70%; border: 2px solid #5E5E5E;">&nbsp;&nbsp;&nbsp;
					${s.nickname}
				</div>
				<div class="col text-end pt-1 pe-4" style="color:#5E5E5E; font-size: smaller;">
					<fmt:formatDate value="${s.regDate}" pattern="yyyy-MM-dd" var="formattedDate" />
					${formattedDate}
				</div>
				</div>
				
				<!-- 제목 -->
				<div class="row">
				<div class="col-10 offset-1 py-3" style="font-weight: bold; border-bottom: 2px solid #bfbfbf;">
					<a href="storyDetail?storyNo=${s.storyNo }" class="link-dark link-underline-opacity-0">${s.title}</a>
				</div>
				</div>
				
				<!-- 태그 -->
				<div class="row">
				<div class="col-11 offset-1 pt-3" style="color:#5E5E5E;">
					<c:forEach var="tag" items="${s.tags}" varStatus="loop">
				            #${tag.tagName} 
			        </c:forEach>
				</div>
				</div>
				
				<!-- 조회수, 좋아요 -->
				<div class="row">
				<div class="col text-end pe-4 py-3" style="color:#5E5E5E; font-size: smaller;">
					<img src="resources/images/icon/eye_eyes_view_count.png" id="icon_count" style="width: 20px;">
					${s.readCount} &nbsp;&nbsp;
					<img src="resources/images/icon/heart.png" id="icon_heart" style="width: 20px;">
					${s.thank}
				</div>
				</div>

			
			</div>
			</c:forEach>
			</div>
			
			</div>
			</div>
		
		
		
		</div>
		</div>
		

		
		<!-- 경진 -->
			<div class="row">
				<div class="col-3 offset-1 my-3">
					<h1 style="font-weight: bold">장비 리스트</h1>
				</div>
			</div>
			<ul class="nav nav-underline offset-1">
				<li class="nav-item text-center" style="width: 170px">
				  <a class="nav-link active categoryBtn" aria-current="page" style="font-size: 25px; color: black" data-bs-toggle="pill">All</a>
				</li>
				<li class="nav-item text-center" style="width: 170px">
				  <a class="nav-link categoryBtn"  style="font-size: 25px; color: black" data-bs-toggle="pill">Lap-top</a>
				</li>
				<li class="nav-item text-center" style="width: 170px">
				  <a class="nav-link categoryBtn"  style="font-size: 25px; color: black" data-bs-toggle="pill">Monitor</a>
				</li>
				<li class="nav-item text-center" style="width: 170px">
				  <a class="nav-link categoryBtn"  style="font-size: 25px; color: black" data-bs-toggle="pill">Mouse</a>
				</li>
				<li class="nav-item text-center" style="width: 170px">
				  <a class="nav-link categoryBtn"  style="font-size: 25px; color: black" data-bs-toggle="pill">Keyboard</a>
				</li>
				<li class="nav-item text-center" style="width: 170px">
				  <a class="nav-link categoryBtn"  style="font-size: 25px; color: black" data-bs-toggle="pill">Others</a>
				</li>
			</ul>
			<div class="row justify-content-center" id="categoryList">
			<c:forEach var="p" items="${pList}">
			<div class="col-3 m-3 p-1 rounded-4" style="width: 350px; height: 380px; background: #F3F3F3;" onclick="location.href='productDetail?productNo=${p.productNo}'">
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
			
			
			
			
	
		</div>
	</div>
</div>
	

</div>
</body>
</html>

	
