function readURL(input) {
    if (input.files && input.files[0]) {
      var reader = new FileReader();
      reader.onload = function(e) {
        document.getElementById('preview').src = e.target.result;
      };
      reader.readAsDataURL(input.files[0]);
    } else {
      document.getElementById('preview').src = "";
    }
}

function goBack() {
window.history.back();
}

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

        //제품 카테고리 별 리스트 출력
	    $(".categoryBtn").on("click", function() {
	    	let productCategory = $(this).text();
	    	console.log(productCategory);
	    	$.ajax({
	    		url: "categoryList",
	    		data: "productCategory=" + productCategory,
	    		type: "POST",
	    		dataType: "json",
	    		success: function(res) {
	    		$("#categoryList").empty();
	    		console.log(res.category);
	    		$(res.category).each(function(v, i) {
	    			$("#categoryList").append(`
<div class="col-3 m-3 p-1 rounded-4" style="width: 350px; height: 380px; background: #F3F3F3" onclick="location.href='productDetail?productNo=`+i.productNo+`'">
			<div class="row">
			    <div class="col d-flex justify-content-center align-items-center" style="height: 200px; overflow: hidden;">
			        <img src="resources/images/products/`+i.productImage+`" id="preview" class="img-fluid rounded-top-4" alt="`+i.productImage+`" style="width: 100%; height: 100%;">
			    </div>
			</div>

			<div class="row">
				<div class="col p-3">
					<div class="row">
			    <div class="col d-flex justify-content  mb-3" style="overflow: hidden; font-size: 15px">
			    	`+i.brandName+`
				</div>
			</div>
			
			<div style="width: 100%; height: 2px; background-color: black"></div>
			
			<div class="row">
			    <div class="col mt-3 d-flex justify-content" style="overflow: hidden; font-size: 23px">
			        <b>`+i.productName+`</b>
			    </div>
			</div>
				</div>
			</div>
		</div>
`)
	    		})
	    	}, error: function() {
	    		console.log("err");
	    	}
	    	})
	    })

	
}
)