$(document).ready(function(){
    		
	var menu = $('.menu ul:nth-child(1) a');
	
	$('#top').click(function(){
		
		$('html, body').animate({'scrollTop': 0});
	});
	
	menu.click(function(e){
		e.preventDefault();
		var i = $(this).parent().index();
		
		$('html, body').animate({'scrollTop': 622+(733*i)});
	});
});