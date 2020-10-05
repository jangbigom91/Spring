// 추천, 최신, 할인 상태변수
var isCompleteTraining = false;
var isCompleteRetro = false;
var isCompleteGift = false;
var isCompleteSale = false;

$(document).ready(function(){
	
	$(window).scroll(function(){
		
		// section 객체 선택
		var sectionKits = $('section.kits');
		var sectionTraining = $('section.training');
		var sectionRetro = $('section.retro');
		var sectionGift = $('section.gift');
		var sectionSale = $('section.sale');
		
		var pos = $(this).scrollTop();
		
		if(pos >= 200 && !isCompleteTraining) {
			isCompleteTraining = true;
			getProducts(sectionTraining,'/mustore/main/training');
			
		}else if(pos >= 400 && !isCompleteRetro) {
			isCompleteRetro = true;
			getProducts(sectionRetro,'/mustore/main/retroItems');
		}else if(pos >= 600 && !isCompleteGift) {
			isCompleteGift = true;
			getProducts(sectionGift,'/mustore/main/giftItems');
		}else if(pos >= 800 && !isCompleteSale) {
			isCompleteSale = true;
			getProducts(sectionSale, '/mustore/main/saleItems');
		}
		
	});// scroll end
	
	function getProducts(section, url) {
		$.ajax({
			url: url,
			type: 'get',
			dataType: 'json',
			success: function(data){
				
				section.find('img').remove();
				
				$.each(data, function(i, item){
					var dom = $('.kits > article:eq(0)').clone();
					
					var imgUrl = '/mustore/thumb/'+item.cate1+"/"+item.cate2+"/"+item.thumb1;
					dom.find('.mu > img').attr('src', imgUrl);
					
					dom.find('h2').text(item.name);
					dom.find('p').text(item.descript);
					dom.find('.org_price > del').text(item.price.toLocaleString()); // toLocaleString-> 숫자 천단위마다 , 찍어주는 내장함수
					dom.find('.org_price > span').text(item.discount+'%');
					
					dom.find('.dis_price > ins').text(item.salePrice.toLocaleString());
					
					// 배송비가 0 이상이면 무료배송이미지 사라지게 함
					if(item.delivery > 0) {
						dom.find('.dis_price > span').remove();
					}
					
					section.append(dom);
					
				});
				
				/*
				for(var item in data) {
					var dom = $('.hit > article:eq(0)').clone();
					$('.recommend').append(dom);
				}
				*/
				
			}
		});
	}
	
});// jquery end