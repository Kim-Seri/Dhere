<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col">
		<form action="/postWrite" method="post" id="postWriteForm"
			name="postWriteForm">
			
			<div class="row my-3 py-3">
			<div class="col ">
				<div class="row">
					<div class="col text-center">
						
						<div class="btn-group btn-group-lg my-3" role="group" aria-label="Basic radio toggle button group">
							<div class="row g-3">
								<div class="col-3">
									<input type="radio" class="btn-check" name="category" id="developer" value="1" checked>
								    <label class="btn btn-outline-primary" for="developer">개발</label>
								</div>
								<div class="col-3">
									<input type="radio" class="btn-check" name="category" id="marketer" value="2">
								  	<label class="btn btn-outline-primary" for="marketer">마케터</label>
								</div>
								<div class="col-3">
									<input type="radio" class="btn-check" name="category" id="designer" value="3">
								  	<label class="btn btn-outline-primary" for="designer">디자이너</label>
								</div>	
								<div class="col-3">
									<input type="radio" class="btn-check" name="category" id="pd" value="4">
								  	<label class="btn btn-outline-primary" for="pd">PD</label>
								</div>	  	
								<div class="col-3">
									<input type="radio" class="btn-check" name="category" id="writer" value="5">
								  	<label class="btn btn-outline-primary" for="writer">작가</label>
								</div>	  	  						
	
								  <div class="col-3">
									<input type="radio" class="btn-check" name="category" id="researcher" value="6">
								    <label class="btn btn-outline-primary" for="researcher">연구원</label>
								</div>
								<div class="col-3">
									<input type="radio" class="btn-check" name="category" id="teacher" value="7">
								  	<label class="btn btn-outline-primary" for="teacher">선생님</label>
								</div>
								<div class="col-3">
									<input type="radio" class="btn-check" name="category" id="accountant" value="8">
								  	<label class="btn btn-outline-primary" for="accountant">회계사</label>
								</div>	 					
							</div>
						
						</div>
				
					</div>
				</div>
				
			</div>
		</div>
			<div class="row my-5">
				<div class="col text-center ">
					<input type="text" class="form-control form-control-lg"
						name="title" placeholder="제목을 입력하세요" id="postTitle"
						name="postTitle" style="height: 100px">
				</div>
			</div>

			<div class="row my-5 " id="imageContainer">
				<div class="col  ">
					<label for="formFile" class="form-label">책상 사진을 업로드해 주세요.</label> <input
						class="form-control" type="file" id="formFile" name="fileName">
				</div>
			</div>
			<button type="button" class="btn btn-outline-primary" id="addImageButton">+</button>
			<div class="row my-5">
				<div class="col text-center ">
					<textarea class="form-control fs-4 " placeholder="내용을 입력하세요"
						name="content" id="floatingTextarea2" style="height: 500px"></textarea>
				</div>
			</div>
			<div class="row my-5">
				<div class="col text-center ">
					<input type="submit" class="btn btn-outline-primary" value="작성하기"
						id="btnWrite"> &nbsp;&nbsp; <input type="button"
						class="btn btn-outline-primary" value="뒤로가기"
						onclick="location.href='main'">

				</div>
			</div>

		</form>
	</div>
</div>