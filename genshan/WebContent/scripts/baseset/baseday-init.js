var second = 2;//��Ŀ��ʼʣ��ʱ�䣨�룩
var clk;//����ʱ��

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