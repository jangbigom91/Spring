$(function(){
    // Faq list
    $(".faqbtn").click(function () {
        if( $(this).parent().is(".hover") ){			
            $(this).parent().removeClass("hover")
            $(".faqanswer").hide(300)
        }else{
            $(".faqanswer").hide(300)
            $(".faqbtn").parent().removeClass("hover")
            $(this).siblings(".faqanswer").show(300).parent().addClass("hover");
        }
    });
});