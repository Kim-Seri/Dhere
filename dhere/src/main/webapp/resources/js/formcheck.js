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

// 링크 복사 버튼
function copyToClipboard() {
    var copyText = document.getElementById('copyTxt');
    
    copyText.select();
    
    try {
        var success = document.execCommand('copy');
    
        if (success) {
            alert('주소가 복사되었습니다.');
        } else {
            alert('복사에 실패했습니다. 텍스트를 선택한 후 수동으로 복사해주세요.');
        }
    } catch (err) {
        console.error('복사 동작이 지원되지 않습니다.', err);
        alert('이 브라우저에서는 복사 기능이 지원되지 않습니다. 텍스트를 선택한 후 수동으로 복사해주세요.');
    }
}

function enterkey() {
  if (window.event.keyCode == 13) {
    addHashtag();
  }
}

function removeHashtag(hashtag) {
  document.getElementById(hashtag).remove();
}

function addHashtag() {
  let hashtag = $("#hashtag").val();
  let item = getHashtagItem(hashtag);
  $("#hashtagList").append(item);
  $("#hashtag").val("");
}

function getHashtagItem(hashtag) {
  let item = `<div class="col-auto hashtag" id="${hashtag}">
			<div class="row my-3">
				<div class="col border border-primary-subtle pe-0">
					<span class="hashtag-value text-primary">#${hashtag}</span>&nbsp;
					<button type="button" class="btn btn-outline-primary border border-0 " onclick="removeHashtag('${hashtag}')">×</button>
				</div>&nbsp;&nbsp;
			</div>
		</div>`;

  return item;
}

$(function() {
	 //폼 엔터키 눌러도 자동으로submit 안되게 제한
   $("form").keydown(function () {
    if (event.keyCode === 13) {
      event.preventDefault();
    }
  });

  $("#categoryCarousel").carousel();

  $("#addImageButton").on("click", function () {
    // 새로운 이미지 입력 필드를 생성하고 파일 선택 다이얼로그를 띄웁니다.
    var imageInput = $(
      "<input type='file' class='form-control' name='additionalImages' style='display:none'>"
    );
    $("#imageContainer").append(imageInput);
    imageInput.click();

    // 이미지 업로드 인풋이 변경됐을 때의 이벤트 핸들러
    imageInput.on("change", function () {
      // 이미지 미리보기 업데이트
      var imagePreview = $("<img class='img-thumbnail'>");
      var changeButton = $(
        "<button type='button' class='btn btn-outline-primary' id='changeImageButton'>사진 수정하기</button>"
      );
      var imageDivRow = $("<div class='row my-3'></div>");
      var imageDivCol = $("<div class='col my-3'></div>");
      var imageDivRow2 = $("<div class='row my-3'></div>");
      var imageDivCol2 = $("<div class='col my-3'></div>");
      var imageDivRow3 = $("<div class='row my-3'></div>");
      var imageDivCol3 = $("<div class='col my-3 text-center'></div>");
      var deleteButton = $(
        "<button type='button' class='btn btn-outline-danger' id='deleteImageButton'>삭제하기</button>"
      );
      var markerButton = $(
        "<button type='button' class='btn btn-outline-primary' id='addMarkerButton'>마커 추가하기</button>"
      );
      imagePreview.append(deleteButton);
      imagePreview.append(markerButton);
      imageDivRow.append(imageDivCol);
      imageDivCol.append(imageDivRow2);
      imageDivRow2.append(imageDivCol2);
      imageDivCol2.append(imagePreview);

      imageDivCol.append(imageDivRow3);
      imageDivRow3.append(imageDivCol3);
      imageDivCol3.append(changeButton);
      $("#imageContainer").append(imageDivRow);

      displayImagePreview(this, imagePreview);

      changeButton.on("click", function () {
        $(this).parent().parent().parent().parent().prev().click();
      });
    });
  });

  // 이미지 미리보기 업데이트 함수
  function displayImagePreview(input, preview) {
    // 선택한 이미지를 미리보기로 업데이트
    if (input.files && input.files[0]) {
      var reader = new FileReader();
      reader.onload = function (e) {
        preview.attr("src", e.target.result);
      };
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
<div class="col-3 m-3 p-1 rounded-4" style="width: 350px; height: 380px; background: #F3F3F3; cursor: pointer" onclick="location.href='productDetail?productNo=`+i.productNo+`'">
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