$(function() {
	
	$('#categoryCarousel').carousel();
	 
    $("#addImageButton").on("click", function() {
        // 새로운 이미지 입력 필드를 생성하고 파일 선택 다이얼로그를 띄웁니다.
        var imageInput = $("<input type='file' class='form-control' name='additionalImages' style='display:none'>");
        $("#imageContainer").append(imageInput);
        imageInput.click();

        // 이미지 업로드 인풋이 변경됐을 때의 이벤트 핸들러
        imageInput.on("change", function() {
            // 이미지 미리보기 업데이트
            var imagePreview = $("<img class='img-thumbnail'>");
            var imageDivRow = $("<div class='row my-3'></div>");
            var imageDivCol = $("<div class='col my-3'></div>");
            imageDivRow.append(imageDivCol);
            imageDivCol.append(imagePreview);
            $("#imageContainer").append(imageDivRow);

            displayImagePreview(this, imagePreview);
            
            // 다음 추가를 위해 새로운 + 버튼 생성
            var newAddButton = $("<button type='button' class='btn btn-outline-primary' id='changeImageButton'>사진 수정하기</button>");
            imageDivCol.append(newAddButton);
            
            newAddButton.on("click",function(){
            	$("#changeImageButton").parent().parent().prev().click();
            })
        });
    });

    // 이미지 미리보기 업데이트 함수
    function displayImagePreview(input, preview) {
        // 선택한 이미지를 미리보기로 업데이트
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                preview.attr("src", e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
});
