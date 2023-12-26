<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="resources/css/storyDetail.css">
<%@ page session="false" %>
<html>
<head>
    <title>Story Detail</title>
</head>
<body>
						
	<div class="container">
	<div class="row">
		<div class="col">
		
		
		
		<c:forEach var="a" items="${ story }" varStatus="status">
			<c:if test="${ status.index == 0 }">
				<!-- 직무 카테고리 시작 -->
				<div class="row" id="category_view_btn">
					<div class="col">
						<button type="button" class="btn btn-primary fs-5 fw-bolder"><img src="resources/images/icon/name_tag_white.png" id="icon_tag_category_view_btn">&nbsp;&nbsp;디자이너${a.categoryNo }</button>
					</div>
				</div>
				<!-- 직무 카테고리 끝 -->
				<!-- 제목 시작 -->
				<div class="row mt-3">
					<div class="col border-bottom border-primary">
						<h1 id="title">${ a.title }</h1>
					</div>
				</div>
				<!-- 제목 끝 -->				
				<!-- 프로필 사진, 닉네임, 날짜, 조회수, 좋아요 시작 -->
				<div class="row mt-4">
					<!-- 프로필 사진 시작 -->
					<div class="col-1">
						<img src="resources/images/profile/${ a.picture }" id="profile">
					</div>
					<!-- 프로필 사진 끝 -->
					<!-- 닉네임 시작 -->
					<div class="col d-flex align-items-center ms-3" id="nickname">
						${ a.nickname }
					</div>
					<!-- 닉네임 끝 -->
					<!-- 날짜 시작 -->
					<div class="col-3 text text-end" id="regDate">
						${ a.regDate }
					</div>
					<!-- 날짜 끝 -->
					<!-- 조회수 시작 -->
					<div class="col-1 text text-end" id="count_num">
						<img src="resources/images/icon/eye_eyes_view_count.png" id="icon_count">
						${ a.readCount }
					</div>
					<!-- 조회수 끝 -->
					<!-- 좋아요 시작 -->
					<div class="col-1 text text-end" id="heart_num">
						<img src="resources/images/icon/heart.png" id="icon_heart">
						${ a.thank }
					</div>
					<!-- 좋아요 끝 -->
				</div>
				<!-- 팔로우, 스크랩 버튼 시작 -->
				<div class="row text text-end mb-5">
					<div class="col">
						<button type="button" class="btn btn-outline-primary fs-5" id="followBtn">팔로우</button>
						<button type="button" class="btn btn-outline-primary fs-5" id="scrapBtn">스크랩</button>
					</div>
				</div>
				<!-- 팔로우, 스크랩 버튼 끝 -->
<!--################################## 사진 출력 영역 시작 ##################################-->
				 <c:forEach var="s" items="${story}">
						<div class="row">
							<div class="col text text-center">
								<img src="resources/images/desk/${ s.fileName }" id="fileName">
							</div>
						</div>
		        </c:forEach>
<!--################################## 사진 출력 영역 끝 ##################################-->
<!--################################## content 영역 시작 ##################################-->
				<!-- content 1 시작 -->
				<div class="row">
					<div class="col">
					
						<div class="row" id="Q_text">
							<div class="col">
								Q. 당신의 데스크 셋업은 어떤 생각으로 구성했나요?
							</div>
						</div>
						<div class="row" id="A-text">
							<div class="col">
								${ a.content1 }
								<br>
								<br>
								${ a.content1 }
								${ a.content1 }
								${ a.content1 }
							</div>
						</div>
						
					</div>
				</div>
				<!-- content 1 끝 -->
				<!-- content 2 시작 -->
				<div class="row">
					<div class="col">
					
						<div class="row" id="Q_text">
							<div class="col">
								Q. 추천하는 기기는 무엇인가요?
							</div>
						</div>
						<div class="row" id="A-text">
							<div class="col">
								${ a.content2 }
								${ a.content2 }
								<br>
								<br>
								${ a.content2 }
								${ a.content2 }
							</div>
						</div>
						
					</div>
				</div>
				<!-- content 2 끝 -->
				<!-- content 3 시작 -->
				<div class="row">
					<div class="col">
					
						<div class="row" id="Q_text">
							<div class="col">
								Q. 추천하는 업무용 툴이나 기타 프로그램이 무엇인가요?
							</div>
						</div>
						<div class="row" id="A-text">
							<div class="col">
								${ a.content3 }
							</div>
						</div>
						
					</div>
				</div>
				<!-- content 3 끝 -->
				<!-- content 4 시작 -->
				<div class="row">
					<div class="col">
					
						<div class="row" id="Q_text">
							<div class="col">
								Q. 당신의 데스크 셋업에서 보완하고 싶은 부분이 있다면 무엇인가요?
							</div>
						</div>
						<div class="row" id="A-text">
							<div class="col">
								${ a.content4 }
							</div>
						</div>
						
					</div>
				</div>
				<!-- content 4 끝 -->
<!--################################## content 영역 끝 ##################################-->				
<!--############################# 공유, 하트, 신고 버튼 영역 시작 ############################-->
				<div class="row" id="share_heart_siren_btn">
					<div class="col text text-center">
						<button type="button" class="btn btn-outline-primary">
							<img src="resources/images/icon/shara_export.png" id="icon_share_btn">
						</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-outline-primary fs-4">
							+<img src="resources/images/icon/heart.png" id="icon_heart_btn">
						</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-outline-primary">
							<img src="resources/images/icon/siren_police.png" id="icon_siren_btn">
						</button>
						<button type="button" class="btn btn-secondary"
						        data-bs-toggle="tooltip" data-bs-placement="top"
						        data-bs-custom-class="custom-tooltip"
						        data-bs-title="This top tooltip is themed via CSS variables.">
						  Custom tooltip
						</button>
					</div>
				</div>
<!--############################# 공유, 하트, 신고 버튼 영역 끝 ############################-->
				<div class="row" id="tag">
				    <div class="col">
				        <img src="resources/images/icon/name_tag.png" id="icon_tag">
				            <c:forEach var="tag" items="${a.tags}">
				                ${tag.tagName}<br>
				            </c:forEach>
				    </div>
				</div>
				
				
				
				
				
				
				
				
				
			</c:if>
		</c:forEach>
		
		
		</div>
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
