function changeTrColor(obj){
	$(obj).mouseover(function(){
		$(obj).children("td").addClass("bgco2");
	});
	$(obj).mouseleave(function(){
		$(obj).children("td").removeClass("bgco2");
	});
}
