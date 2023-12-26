<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<div class="container">
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
				<div class="col">
					<input type="button" class="btn btn-primary" onclick="location.href='postWriteForm'" value="글쓰기"/>
				</div>
			</div>
			<!-- 검색창 끝 -->
			<!-- 게시글 타이틀 시작 -->
			<div class="row my-5">
				<div class="col-3 bg-success m-0">
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
			
			<!-- 리셋해보자 -->
			=============================================================================================================
			<!-- 데스크셋업 리스트 -->
			<div class="row">
			<div class="col">
			
				<div class="row">
				
				<!-- 게시물 한칸 -->
				<c:forEach var="s" items="${sList}">
				<div class="col-3">
				
					<!-- 데스크셋업 썸네일 -->
					<div class="row border border-success bg-info">
					<div class="col" style="margin-left: 0px;">
						<img src="resources/images/desk/${s.fileName}" alt="${s.fileName}" style="width: 100px; height: 100px; object-fit: cover;">
					</div>
					</div>
					
					<!-- 프로필, 닉네임, 조회수, 좋아요 -->
					<div class="row border border-success bg-warning">
					<div class="col">
						<img src="resources/images/profile/${s.picture}" alt="50*50 size image" style="width: 50px; height: 50px; object-fit: cover; border-radius: 70%; border: 3px solid gray"><br/>
						${s.nickname}<br/>
						${s.readCount}<br/>
						${s.thank}
					</div>
					</div>
					
					<!-- 제목 -->
					<div class="row border border-success">
					<div class="col" class="bg-danger" >
						${s.title}
					</div>
					</div>
					
					<!-- 태그 -->
					<div class="row border border-success">
					<div class="col">
						<c:forEach var="tag" items="${s.tags}" varStatus="loop">
					            #${tag.tagName} 
				        </c:forEach>
					</div>
					</div>
					
					<!-- 날짜 -->
					<div class="row border border-success">
					<div class="col">
						<fmt:formatDate value="${s.regDate}" pattern="yyyy-MM-dd" var="formattedDate" />
						${formattedDate}
					</div>
					</div>
				
				</div>
				</c:forEach>
				
				</div>
			
			
			
			</div>
			</div>
			
			
			
			=============================================================================================================
			<!-- 게시글리스트 시작 -->
			<div class="row">
			
				<c:forEach var="s" items="${sList}">
				<div class="col-4 py-4 my-3" style="border-radius: 3%">
				
	
		
		
					<!-- 데스크셋업 이미지 -->
					<div class="row">
						<div class="col offset-1">
							<img src="resources/images/desk/${s.fileName}" alt="400*200 size image" style="width: 350px; height: 200px; object-fit: cover;">
						</div>
					</div>
					
			<div class="row">
			<div class="col offset-1 bg-warning">
					
					<!-- 프로필 이미지, 닉네임, 좋아요, 공감 -->
					<div class="row justify-content-center ">
						<div class="col offset-1 bg-primary">
							<div class="row my-3 align-items-center">
								<div class="col-2 bg-warning">
									<img src="resources/images/profile/${s.picture}" alt="50*50 size image" style="width: 50px; height: 50px; object-fit: cover; border-radius: 70%; border: 3px solid gray">
								</div>
								<div class="col-4 bg-primary">
									${s.nickname} (닉네임)
								</div>
								<div class="col bg-warning">
									${s.readCount} (조회수)
								</div>
								<div class="col bg-info">
									${s.thank} (좋아요)
								</div>
								<div class="col-1"></div>
							</div>
						</div>
					</div>
					
					<!-- 타이틀 -->
					<div class="row border-bottom py-3">
						<div class="col offset-1 bg-primary">
							<a href="storyDetail?storyNo=${s.storyNo }" class="link-dark link-underline-opacity-0">${s.title}</a>
						</div>
						<div class="col-1"></div>
					</div>
					<!-- 태그 -->
					<div class="row py-3">
						<div class="col offset-1 bg-primary">
					        <c:forEach var="tag" items="${s.tags}" varStatus="loop">
					            #${tag.tagName} 
					        </c:forEach>
						</div>
						<div class="col-1"></div>
					</div>
					<fmt:formatDate value="${s.regDate}" pattern="yyyy-MM-dd" var="formattedDate" />
					<div class="row text-end py-3">
						<div class="col offset-1 bg-primary">
						${formattedDate}
						</div>
						<div class="col-1"></div>
					</div>
		</div>
		</div>			
				</div>
				</c:forEach>
				
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
			
			
			
			
	
		</div>
	</div>
</div>


</body>
</html>

	
