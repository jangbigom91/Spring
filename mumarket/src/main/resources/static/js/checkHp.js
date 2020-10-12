// 휴대폰 정규 표현식
var msgHp = /^\d{3}-\d{4}-\d{4}$/;

$(document).ready(function(){
			
	var msgHp = $('.msgHp');
	
	$('input[name=hp]').focusout(function(){
		
		var value = $(this).val();
			
		var param = {'hp': value};
			
			$.get('/mumarket/member/checkHp', param, function(data){
				
				if(data.result == 1) {
					msgHp.css('color', '#ef3f43').text('이미 사용중인 번호입니다.');		
				}else {
					msgHp.css('color', '#45ad4a').text('사용 가능한 번호입니다.');
				}
				
			});
		
	});
	
});