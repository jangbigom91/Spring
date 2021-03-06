// 추천, 최신, 할인 상태변수
var isCompleteReco = false;
var isCompleteNew = false;
var isCompleteDisc = false;

$(document).ready(function(){
	
	$(window).scroll(function(){
		
		// section 객체 선택
		var sectionHit = $('section.hit');
		var sectionRecommend = $('section.recommend');
		var sectionNew = $('section.new');
		var sectionDiscount = $('section.discount');
		
		var pos = $(this).scrollTop();
		
		if(pos >= 200 && !isCompleteReco) {
			isCompleteReco = true;
			getProducts(sectionRecommend,'/kmarket/main/recommend');
			
		}else if(pos >= 400 && !isCompleteNew) {
			isCompleteNew = true;
			getProducts(sectionNew,'/kmarket/main/newItems');
		}else if(pos >= 600 && !isCompleteDisc) {
			isCompleteDisc = true;
			getProducts(sectionDiscount,'/kmarket/main/discountItems');
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
					var dom = $('.hit > article:eq(0)').clone();
					
					var imgUrl = '/kmarket/thumb/'+item.cate1+"/"+item.cate2+"/"+item.thumb1;
					dom.find('.thumb > img').attr('src', imgUrl);
					
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