<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
	<form class="col-6 offset-3 mt-5 border border-3">
	<input type="hidden" name="no" id="no" value="${product.productNo}"/>
	<%-- <input type="hidden" name="memberId" id="memberId" value="${product.email}"> --%>
		<div class="row m-3">
			<div class="col fs-1 text-center">
				제품 상세보기
			</div>
		</div>
		<div class="row bg-white m-3 rounded-4 p-5">
			<div class="col">
				<div class="row mt-5 mb-2">
					<div class="col-md-6 offset-md-3 text-center">
		             	<img src="resources/images/products/${product.productImage}" id="preview" class="img-fluid" alt="${product.productImage}"/>
		            </div>
				</div>
				<div class="row mb-3 justify-content-center">
		        </div>
				<div class="row mb-5 text-center">
					<div class="col">
						제품명(${product.productCategory })<br>
						<input type="text" id="price" class="order border border-1 rounded-4 text-center" value="${product.productName }" readonly>			
					</div>
				</div>
				<div class="row mb-5 text-center">
					<div class="col">
						<input type="text" class="form-control" id="title" value="${product.brandName}" readonly>
					</div>
				</div>
				<div class="row mb-5 text-center">
					<div class="col">
						<pre><textarea class="form-control" id="detailedDescription" rows="15" readonly>${product.productContent}</textarea></pre>
					</div>
				</div>
			 	<div class="row">
			 		<div class="col text-center">
			 			<a href="${product.productLink}">상품 구매</a>
			 		</div>
				</div>
				<!-- <div class="row text-center mb-5">
					<div class="col">
						<input type="button" value=Update name="update" id="updateBtn" class="btn text-white" style="background-color:#93a5a8"></input>
					</div>
					<div class="col">
						<input type="button" value=Bidding name="bidding" id="biddingBtn" class="btn text-white" style="background-color:#93a5a8"></input>
					</div>
					<div class="col">
						<input type="button" value="Delete" name="delete" id="deleteBtn" class="btn text-white" style="background-color:#93a5a8"></input>
					</div>
				</div> -->
			</div>
		</div>
	</form>
</div>
