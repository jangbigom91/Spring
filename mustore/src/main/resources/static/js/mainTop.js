$(document).ready(function(){
    		
	var menu = $('.menu .category:nth-child(1) a');
	
	$('#top').click(function(){
		
		$('html, body').animate({'scrollTop': 0});
	});
	
	menu.click(function(e){
		e.preventDefault();
		var i = $(this).parent().index();
		
		$('html, body').animate({'scrollTop': 621+(733*i)});
	});
});