// 휴대폰 정규 표현식
var regHp = /^\d{3}-\d{4}-\d{4}$/;

$(function(){

	$('input[name=hp]').focusout(function(){

		var hp = $(this).val();
		var json = {'hp':hp};
		
		$.ajax({
			url: '/sboard/user/hpCheck',
			method: 'get',
			data: json,
			dataType: 'json',
			success: function(data) {

				if(data.result == 0) {
					$('.resultHp').css('color', 'green').text('사용할 수 있는 번호입니다.');
				}else {
					$('.resultHp').css('color', 'red').text('이미 있는 번호입니다.');
				}
			}
		});

	});
});