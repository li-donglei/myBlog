$(function(){

	// $(".personal").mousewheel=function(){
	// 	var h = $(".personal").offset();
	// 	console.log(h);
	// };
	var navH = $(".personal").offset().top;
	console.log(navH);
	window.onscroll=function(){
		var scroH = $(this).scrollTop();
		if(scroH>=navH-10){
			$(".personal").css({"position":"fixed","top":20});
		}else {
			$(".personal").css({"position":"fixed","top":navH-scroH});

		}
		console.log(scroH);
	};
})