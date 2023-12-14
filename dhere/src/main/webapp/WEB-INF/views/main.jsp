<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Home</title>
</head>
<body>

	<div class="row" id="global-content">
	<div class="col">
		
		<div class="row">
		<div class="col">
			<c:if test="${not empty sList}">
                        <c:forEach var="s" items="${sList}">
                            <p>Title: ${s.title}</p>
                            <p>Content: ${s.content}</p>
                            <p>Email: ${s.email}</p>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty sList}">
                        <p>게시글이존재하지 않습니다.</p>
                    </c:if>
		</div>
		</div>
		
	</div>
	</div>

</body>
</html>
