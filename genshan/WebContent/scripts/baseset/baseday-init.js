var second = 2;//项目开始剩余时间（秒）
var clk;//倒计时器

$(function(){
	if($("#result").val() == "success"){
		clk = self.setInterval("clock()", 1000);
	}
});
function clock() {
	$("#time-count-down").text("");
	$("#time-count-down").text(""+second);
	second = second - 1;
	if (second <= 0) {
		window.clearInterval(clk);
		$('#tradeDayList').submit();
	}
}