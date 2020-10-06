// 이메일 정규 표현식
var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

// 최종 점검을 위한 상태변수 선언
var isEmailOk = false;

$(function(){
	
	$('input[name=email]').focusout(function(){
						
		var email = $(this).val();
		
		if(regEmail.test(email) == false) {
			alert('이메일 형식으로 입력하세요.');
			return false;
		}else {
			isEmailOk = true;
		}
	});	
});