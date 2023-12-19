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
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div class="row justify-content-center">
<c:forEach var="p" items="${pList}">
<div class="col-3 border border-3 m-3 p-3" style="width: 300px;" onclick="location.href='productDetail?productNo=${p.productNo}'">
	<div class="row">
		<div class="col" style="height: 300px;">
		    <img src="resources/images/products/${p.productImage}" id="preview" class="img-fluid" alt="${p.productImage}" class="col d-flex justify-content-center align-items-center"></div>
	</div>
	<div class="row">
		<div class="col text-center" style="height: 100px;border: 1px solid red">
			<h2>${p.productName}</h2>
		</div>
	</div>
	<div class="row">
		<div class="col mt-3 text-black-50">
			${p.productCategory}
		</div>
	</div>
</div>
</c:forEach>
</div>

</body>
</html>
