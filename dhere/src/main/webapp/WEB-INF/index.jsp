<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resources/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <script src="resources/js/formcheck.js"></script>
    <script src="resources/js/member.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <title>인덱스다아아아아아</title>
</head>
<body>
 
        <%@ include file="template/header.jsp" %>        
        <jsp:include page="${param.body}" />
        <%@ include file="template/footer.jsp" %>       
   
    
    <script>
	// 팝오버 초기화
	var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'));
	var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
	   return new bootstrap.Popover(popoverTriggerEl);
	});
	</script>
	<script>
		// 페이지가 로드될 때 툴팁을 초기화합니다.
		document.addEventListener('DOMContentLoaded', function() {
	    var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
	    var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
			return new bootstrap.Tooltip(tooltipTriggerEl);
		  });
		});
	</script>
</body>
</html>
