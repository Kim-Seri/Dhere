<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="resources/css/header.css">


<div class="row p-5" id="header">
    <div class="col">
        <img src="resources/images/icon/logo2.png" id="header_logo" onclick="location.href='main'">
    </div>
    <c:choose>
        <c:when test='${not empty sessionScope.member}'>${sessionScope.member.email}</c:when>
        <c:otherwise>너희들이 지금 로그인을 <br>한 상태인지, 아닌지 <br>구분하기 쉽게 해주려고 <br>내가 친히 만든 영역이야.</c:otherwise>
    </c:choose>

    <div class="col justify-content-end d-flex align-items-center">
        <a href="main" class="text-decoration-none text-white" id="header_menu">Home</a>
        <a href="mainProduct" class="text-decoration-none text-white" id="header_menu">Product</a>
        <a href="mainAbout" class="text-decoration-none text-white" id="header_menu">About</a>
        <a href="mainNotice" class="text-decoration-none text-white" id="header_menu">Notice</a>
        
        <img src="resources/images/icon/profile_white.png" 
             id="login_menu"
             tabindex="0" 
             data-bs-html="true" 
             data-bs-placement="bottom" 
             data-bs-toggle="popover" 
             data-bs-trigger="focus" 
             data-bs-title="<c:choose><c:when test='${not empty sessionScope.member}'>${sessionScope.member.email}</c:when><c:otherwise>로그인이<br><br>필요합니다</c:otherwise></c:choose>" 
             data-bs-content="
                <c:choose>
                    <c:when test='${empty sessionScope.member}'>
                        <a href='loginForm' class='text-decoration-none text-dark'>Login</a>
                        <br>
                        <br>
                        <a href='joinForm' class='text-decoration-none text-dark'>Join</a>
                    </c:when>
                    <c:otherwise>
                        <!-- 로그인 성공한 경우의 내용 -->
                        <a href='scrap' class='text-decoration-none text-dark'>MyPage</a>
                        <br>
                        <br>
                        <a href='logout' class='text-decoration-none text-dark'>Logout</a>
                    </c:otherwise>
                </c:choose>
             ">
    </div>
</div>
