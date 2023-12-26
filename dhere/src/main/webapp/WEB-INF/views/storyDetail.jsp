<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="resources/css/storyDetail.css">
<%@ page session="false" %>
<html>
<head>
    <title>Story Detail</title>
</head>
<body>
	
	<div class="row">
		<div class="col">
		
		
		
		<c:forEach var="a" items="${story}" varStatus="status">
			<c:if test="${status.index == 0}">
				<!-- 직무 카테고리 시작 -->
				<div class="row">
					<div class="col mt-5">
						<button type="button" class="btn btn-outline-primary">디자이너${a.categoryNo }</button>
					</div>
				</div>
				<!-- 직무 카테고리 끝 -->
				<!-- 제목 시작 -->
				<div class="row mt-3">
					<div class="col border-bottom border-primary">
						<h1 id="title">${a.title}</h1>
					</div>
				</div>
				<!-- 제목 끝 -->				
				<!-- 프로필 사진, 닉네임, 날짜, 조회수, 좋아요 시작 -->
				<div class="row align-items-center mt-3">
					<!-- 프로필 사진 시작 -->
					<div class="col-1">
						<img src="resources/images/profile/${a.picture}" id="profile">
					</div>
					<!-- 프로필 사진 끝 -->
					<!-- 닉네임 시작 -->
					<div class="col" id="nickname">
						${a.nickname }
					</div>
					<!-- 닉네임 끝 -->
					<!-- 날짜 시작 -->
					<div class="col-3 ext text-end" id="regDate">
						${a.regDate }
					</div>
					<!-- 날짜 끝 -->
					<!-- 조회수 시작 -->
					<div class="col-1 text text-end" id="count_num">
						<img src="resources/images/icon/eye_eyes_view_count.png" id="icon_count">
						${a.readCount }
					</div>
					<!-- 조회수 끝 -->
					<!-- 좋아요 시작 -->
					<div class="col-1 text text-end" id="heart_num">
						<img src="resources/images/icon/heart.png" id="icon_heart">
						${a.thank }
					</div>
					<!-- 좋아요 끝 -->
				</div>
				<!-- 팔로우, 스크랩 버튼 시작 -->
				<div class="row mt-3 text text-end">
					<div class="col">
						<button type="button" class="btn btn-outline-primary">팔로우</button>
						<button type="button" class="btn btn-outline-primary">스크랩</button>
					</div>
				</div>
				<!-- 팔로우, 스크랩 버튼 끝 -->
				
				
				        <c:forEach var="s" items="${story}">
								<div class="row mt-2">
									<div class="col text text-center">
										<img src="resources/images/desk/${s.fileName}" alt="800*600 size image" style="width: 800px; height: 600px; object-fit: contain;">
										<br><br><br><br>
									</div>
								</div>
				        </c:forEach>
			</c:if>
		</c:forEach>
		
		
		</div>
	</div>




	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br>
	<!-- 기존 코드 -->
    <div>
        <c:forEach var="a" items="${story}" varStatus="status">
            <c:if test="${status.index == 0}">
                ${a.storyNo }<br>
                ${a.title }<br>
                ${a.content1 }<br>
                ${a.content2 }<br>
                ${a.content3 }<br>
                ${a.content4 }<br>
                ${a.email }<br>
                ${a.regDate }<br>
                ${a.categoryNo }<br>
                ${a.readCount } <br>
                ${a.thank } <br>
                ${a.nickname }<br>
                ------------------------<br><br><br>
            </c:if>
        </c:forEach>
        
        
        <c:forEach var="s" items="${story}">
				<div class="row">
					<div class="col">
						<img src="resources/images/desk/${s.fileName}" alt="400*200 size image" style="width: 400px; height: 200px; object-fit: cover;">
					</div>
				</div>
        </c:forEach>
    </div>

</body>
</html>
