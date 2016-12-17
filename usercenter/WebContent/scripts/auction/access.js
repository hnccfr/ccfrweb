
var second;//项目开始剩余时间（秒）
var clk;//倒计时器
$(function() {
	if (key == "406") {
		if(msec <= 0){
			msec = 0 ;
		}
		second = Math.floor(msec / 1000);
		clk = self.setInterval("clock()", 1000);
	}
});
function clock() {
	//var _hh = "00"+Math.floor(second / 3600);
	var _mm = "00"+Math.floor(second / 60);
	var _ss = "00"+second % 60;
	var t = 
			//_hh.substring(_hh.length-2, _hh.length)
			//+ "时" + 
			_mm.substring(_mm.length-2, _mm.length) 
			+ "分" 
			+ _ss.substring(_ss.length-2, _ss.length)
			+ "秒";
	$("#timeArea").html("");
	$("#timeArea").html(t);
	second = second - 1;
	if (second <= 0) {
		window.clearInterval(clk);
		$('#joinForm').submit();
	}
}