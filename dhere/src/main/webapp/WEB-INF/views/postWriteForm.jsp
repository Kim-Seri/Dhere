<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row p-5 my-5 border border-primary rounded-4 border-3">
	<div class="col">
		<form action="postWrite" method="post" id="postWriteForm"
			name="postWriteForm" enctype="multipart/form-data">
			<div class="row ">
				<div class="col text-start">
					<h3 class="text-secondary">직종 선택</h3>
				</div>
			</div>


			<div class="row my-3 py-3">
				<div class="col">
					<div id="categoryCarousel" class="carousel slide"
						data-bs-ride="carousel" data-bs-interval="5000">
						<div class="carousel-inner">
							<c:forEach var="jList" items="${jList}" varStatus="status">
								<div
									class="carousel-item ${status.index == 0 ? 'active' : ''} text-center">
									<input type="radio" class="btn-check" name="category"
										id="category${jList.categoryNo}" value="${jList.categoryNo}"> 
										<label
										class="btn btn-outline-primary"
										for="category${jList.categoryNo}">${jList.categoryName}</label>
								</div>
							</c:forEach>
						</div>
						<button class="carousel-control-prev" type="button"
							data-bs-target="#categoryCarousel" data-bs-slide="prev">
							<span class="carousel-control-prev-icon bg-primary"
								aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#categoryCarousel" data-bs-slide="next">
							<span class="carousel-control-next-icon bg-primary"
								aria-hidden="true"></span> <span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>
			</div>


			<div class="row my-5">
				<div class="col text-center ">
					<input type="text"
						class="form-control form-control-lg border-0 border-bottom"
						name="title" placeholder="제목을 입력하세요" id="postTitle"
						name="postTitle" style="height: 100px">
				</div>
			</div>

			<div class="row ">
				<div class="col text-start">
					<h3 class="text-secondary">사진 등록</h3>
				</div>
			</div>

			<div class="row ">
				<div class="col"  id="imageContainer">
				
				</div>
			</div>
			<div class="row my-5">
				<div class="col text-center">
					<button type="button" class="btn btn-outline-primary"
						id="addImageButton">+사진 추가</button>
				</div>
			</div>
			<div class="row my-5">
				<div class="col">
					<div class="row my-3">
						<div class="col">
							<h3 class="text-primary fw-bold">당신의 데스크셋업은 어떤 생각으로 구성했나요?</h3>
						</div>
					</div>
					<div class="row">
						<div class="col text-center fw-bold">
							<textarea class="form-control fs-4 " placeholder="내용을 입력하세요"
								name="content1" id="floatingTextarea2" style="height: 400px"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="row my-5">
				<div class="col">
					<div class="row my-3">
						<div class="col">
							<h3 class="text-primary">추천하는 기기는 무엇인가요?</h3>
						</div>
					</div>
					<div class="row">
						<div class="col text-center ">
							<textarea class="form-control fs-4 " placeholder="내용을 입력하세요"
								name="content2" id="floatingTextarea2" style="height: 300px"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="row my-5">
				<div class="col">
					<div class="row my-3">
						<div class="col">
							<h3 class="text-primary">추천하는 업무용 툴이나 기타 프로그램이 무엇인가요?</h3>
						</div>
					</div>
					<div class="row">
						<div class="col text-center ">
							<textarea class="form-control fs-4 " placeholder="내용을 입력하세요"
								name="content3" id="floatingTextarea2" style="height: 200px"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="row my-5">
				<div class="col">
					<div class="row my-3">
						<div class="col">
							<h3 class="text-primary">당신의 데스크셋업에서 보완하고 싶은 부분이 있다면 무엇인가요?</h3>
						</div>
					</div>
					<div class="row">
						<div class="col text-center ">
							<textarea class="form-control fs-4 " placeholder="내용을 입력하세요"
								name="content4" id="floatingTextarea2" style="height: 200px"></textarea>
						</div>
					</div>
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