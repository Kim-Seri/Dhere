<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="resources/css/login.css">
<style>
</style>
<div class="row align-items-center h-100">
	<div class="col">
				<div class="row ">
					<div class="col text-center">
						<h6>개인정보 보호를 위해 비밀번호를 입력해주세요</h6>
					</div>
				</div>
		<input type="hidden" id= "pass10" value= "${ sessionScope.member.pass }">
				<div class="row">
				<div class="col text-center">
                    <c:if test="${ empty sessionScope.member.picture }"><!-- 귀여운그림 -->
                    <img src="" alt="150*150" style="width:150px; height:150px; object-fit: cover; border-radius: 70%; border: 3px solid blue" />
                    </c:if>
                    <c:if test="${ not empty sessionScope.member.picture }">
                        <div class="col center">
                        <img src="resources/upload/${sessionScope.member.picture}" alt="150*150 크기 이미지" 
                        style="width: 150px; height: 150px; object-fit: cover; border-radius: 70%; border: 3px solid blue"></div>
                    </c:if>           
                </div>
                </div>
		
			<div class="row" style="width:100px; height:100px">
				<div class="col" >
					<input type="password" class="form-control rounded" name="pass1" id="pass1">
				</div>
				</div>
				<div class="row">
				<div class="col text-center">
					<input type="button" id="mypageUpdateBtn" class="btn btn-light text-primary fw-bold" value="확인">
				</div>
				</div>
			</div>
		
	</div>

