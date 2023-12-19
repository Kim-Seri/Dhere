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
		<!-- 게시글리스트 전체 영역 시작 -->
		<div class="row bg-danger" >		
			<div class="col">
			
			<!-- 게시글 양식 시작 -->
				<div class="row p-1">
					<c:forEach var="s" items="${sList}">
					
					
					
						<div class="col-4 border border-info p-3">
							<!-- 데스크셋업 이미지 -->
							<div class="row">
								<div class="col">
									<a href="storyDetail?storyNo=${s.storyNo }">
										<input type="button" class="bg-black text-white" value="More">
									</a>
									<img src="http://via.placeholder.com/400x200">
								</div>
							</div>
							<!-- 사진 하단 부분 전체 영역 시작 -->
							<div class="row bg-secondary">
								<div class="col">
												<!-- 프로필 이미지, 닉네임, 좋아요, 공감 -->
												<div class="row py-3">
													<div class="col">
														<img src="http://via.placeholder.com/50x50">
													</div>
													<div class="col">
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
												<div class="row py-5">
													<div class="col">
														tag, tag_post 테이블 참조 ..
													</div>
												</div>
												<div class="row py-3 text-end">
													<div class="col">
														${s.regDate}
													</div>
												</div>
											</div>
								</div>				
							</div>		
							<!-- 사진 하단 부분 전체 영역 끝 -->			
					</c:forEach>
				</div>
				<!-- 게시글 양식 끝 -->
			</div>
		</div>
		<!-- 게시글 리스트 전체 영역 끝 -->
		
		
	
	</div>
</div>
	
</body>
</html>

	
