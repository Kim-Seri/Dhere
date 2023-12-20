<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Story Detail</title>
</head>
<body>

    <div>
        <c:forEach var="a" items="${story}" varStatus="status">
            <c:if test="${status.index == 0}">
                ${a.storyNo }<br>
                ${a.title }<br>
                ${a.content }<br>
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
            ${s.imageNo }<br>
            ${s.fileName }<br>
        </c:forEach>
    </div>

</body>
</html>
