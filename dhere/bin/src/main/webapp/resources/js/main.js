document.addEventListener("DOMContentLoaded", function () {
	// 글쓰기 버튼 스크롤 위치 설정
	let button = document.querySelector(".fixed-write-button");
	let isLogin = false;

	window.addEventListener("scroll", function () {
    // 특정 위치 (예: 200px)에서 버튼이 나타나도록 설정
    if (window.scrollY > 200) {
      button.style.display = "block";
    } else {
      button.style.display = "none";
    }
  });
//	
//	button.addEventListener("click", function() {
//		  if(!isLogin) {
//			  alert("로그인 먼저 진행해주세요.");
//			  // 여기 오류 잡아야 함 
//			 history.back();
//			 return null; 
//		  } 
//	})

	console.log('s');
	/*
	document.querySelectorAll('.jobs').forEach(function (job, index) {
        job.addEventListener('click', function () {
            toggleSelection(index);
        });
    });*/
	
	// 전역변수로 배열 만들어 
	let selectedJob = new Array();
	
	
	
	$('.jobs').on("click", function(){
		
		if($(this).children().eq(1).text() == 'x') {
			$(this).children().eq(1).text("");
			$(this).css("background-color", "white");
			$(this).children().eq(0).css("color", "black");
			let index = selectedJob.indexOf($(this).children().eq(0).text());
			console.log(index);
			// 여기서 찾은 index 번호를 지워
			selectedJob.splice(index, 1);
			console.log(selectedJob);
			
		} else {
			$(this).children().eq(1).text($(this).children().eq(1).text()+"x");
			
			$(this).children().eq(0).css("color", "white");
			$(this).css("background-color", "#4370FF");
			selectedJob.push($(this).children().eq(0).text());
			
			console.log(selectedJob);
			// ajax : 카테고리가 PD인 데이터를 서버에서 받기, 눌린 버튼은 배열에 들어가도록하고 그 배열을 넘겨
//			$.ajax {
//				url : "jobSelectedCategory",
//				data : "jobSelectedCategory=" + jobSelectedCategory,
//				type: "POST",
//				dataType: "json",
//				success: function(res) {
//					$("#jobSelectedCategory").empty();
//					
//				}
//			
//			}
			
			
		}
		
		
	});
	
});

// 별도 함수 생성
function toggleSelection(index) {
    const job = document.querySelector(`#jobCategories-${index}`);
    const label = document.querySelector(`#jobCategoriesLabel-${index}`);
    const closeButton = document.querySelector(`#jobCategories-${index} .close-btn`);

    if (job.checked) {
        // 이미 선택된 경우 해제
        job.checked = false;
        clearSelection(index);
    } else {
        // 선택되지 않은 경우 선택
        job.checked = true;
        label.style.color = '#FFFFFF';
        job.parentElement.classList.add('selected');
        closeButton.style.display = 'block';
    }
}

function clearSelection(index) {
    const job = document.querySelector(`#jobCategories-${index}`);
    const label = document.querySelector(`#jobCategoriesLabel-${index}`);
    const closeButton = document.querySelector(`#jobCategories-${index} .close-btn`);

    job.checked = false;
    label.style.color = ''; // 원래의 색상으로 돌아가게 수정
    job.parentElement.classList.remove('selected');
    closeButton.style.display = 'none';
}
