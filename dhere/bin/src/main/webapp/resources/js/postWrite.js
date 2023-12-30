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
					<span class="hashtag-value text-primary" name="hashtag" value="${hashtag}">#${hashtag}</span>&nbsp;
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
    	
		if (!this.files.length) {
	        return;
	      }
    	
      // 이미지 미리보기 업데이트
      var imagePreview = $("<img class='img-thumbnail' id='postImg'/>");
      var changeButton = $(
        "<button type='button' class='btn btn-outline-primary' id='changeImageButton'>사진 수정하기</button>"
      );
      var imageDivRow = $("<div class='row my-3'></div>");
      var imageDivCol = $("<div class='col my-3 position-relative'></div>");
      var imageDivRow2 = $("<div class='row my-3'></div>");
      var imageDivCol2 = $("<div class='col my-3 text-center position-relative'></div>");
      var imageDivRow3 = $("<div class='row my-3'></div>");
      var imageDivCol3 = $("<div class='col my-3 text-center position-relative'></div>");
      var deleteButton = $(
        "<button type='button' class='btn btn-secondary' id='deleteImageButton'>삭제하기</button>"
      );
      var markerButton = $(
        "<button type='button' class='btn btn-secondary' id='addMarkerButton'>마커 추가하기</button>"
      );
      
  
     
      imageDivRow.append(imageDivCol);
      imageDivCol.append(imageDivRow2);
      imageDivRow2.append(imageDivCol2);
      
      imageDivCol2.append(imagePreview);
      imageDivCol2.append(markerButton);
      imageDivCol2.append(deleteButton);

      imageDivCol.append(imageDivRow3);
      imageDivRow3.append(imageDivCol3);
      imageDivCol3.append(changeButton);
      $("#imageContainer").append(imageDivRow);

      displayImagePreview(this, imagePreview);
      
      // 이미지 미리보기와 버튼을 감싸는 부모 요소에 CSS 적용
      imageDivCol.css({
        position: 'relative',
        overflow: 'hidden'
      });

      imageDivCol2.css({
        position: 'absolute',
        top: 0,
        left: 0,
        width: '100%',
        height: '100%',
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'space-between',
        alignItems: 'center'
      });
    });
    
  });
  
  //이미지 삭제하기 버튼 눌렸을 때
  $("#imageContainer").on("click", "#deleteImageButton", function(){
	   $(this).parent().parent().parent().parent().prev().remove();
	   $(this).parent().parent().parent().parent().remove();
	});
  
  //마커 추가하기 버튼 눌렀을 때
  $("#imageContainer").on("click", "#addMakerButton", function(){
	  
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
}
)