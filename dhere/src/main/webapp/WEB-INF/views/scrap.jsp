<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>마이페이지</title>
<link href="resources/bootstrap/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/js/formcheck.js"></script>
</head>
<body>
	<div>
		<div>
			<!-- 개인정보 -->
			<p class="fs-2 fw-bold">
			마이페이지
			</p>
			<div class="p-5">
				<div class="row">
				<div class="col-2">
				
					<!-- 프사 -->
					<c:if test="${ empty scrap.picture }">
					프사
					<!-- 귀여운그림 -->
					</c:if>
					<c:if test="${ not empty scrap.picture }">
						${ scrap.picture } 
					</c:if>
				</div>
				<div class="col">
				
				${scrap.nickname}님	( ${scrap.email} )<br>
				${scrap.job} <br>
					좋아요 00개
				</div>
				</div>				
				</div>
			</div>
		</div>
		<div>
			<div>
			<!-- 내정보 끝 -->
			<p class="fs-4 fw-bold">
			게시물 보기 
			</p>
			<div>
				<p class="text-center">
				나의 게시물 | 나의 스크랩 | 팔로잉 목록
				</p>
			</div>
			</div>
			<div>
				<!-- 이미지/제목/닉네임/조회수/좋아요/날짜 -->

			</div>
			<div>
				<input type="button" value="morepage">
			</div>
		</div>
		<div>
		</div>
		<%@ include file="/WEB-INF/template/footer.jsp"%>
		<script src="resources/bootstrap/bootstrap.bundle.min.js"></script>
	</div>
</body>
</html>