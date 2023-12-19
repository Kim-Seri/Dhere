/**
 * 
 */
$(function() {
	$("#addImageButton").on("click",function(){
		 addImageInput();
	})
	
	$(document).on("change", "input[name='additionalImages']", function() {
        var preview = $(this).siblings("img");
        displayImagePreview(this, preview);
    });
	
	 function addImageInput() {
	        // 이미지 추가 칸을 담을 div 생성
	        var imageDiv = $("<div class='col my-3'></div>");

	        // 이미지 미리보기를 담을 img 엘리먼트 생성
	        var imagePreview = $("<img class='img-thumbnail'>");
	        imageDiv.append(imagePreview);

	        // 이미지 업로드 인풋 생성
	        var imageInput = $("<input type='file' class='form-control' name='additionalImages'>");
	        imageDiv.append(imageInput);

	        // 생성한 div를 이미지 추가 칸을 담은 부모 div에 추가
	        $("#imageContainer").append(imageDiv);
	    }

	    function displayImagePreview(input, preview) {
	        // 선택한 이미지를 미리보기로 업데이트
	        if (input.files && input.files[0]) {
	            var reader = new FileReader();
	            reader.onload = function (e) {
	                preview.attr("src", e.target.result);
	            }
	            reader.readAsDataURL(input.files[0]);
	        }
	    }
	
}
)