$(function() {
    	$("#beginTime").datePicker({clickInput:true,startDate:"1900-01-01"});
    	$("#endTime").datePicker({clickInput:true,startDate:"1900-01-01"});
    	htmlVal = $('#showBox').html();
    	$('#showBox').empty();
    });
var htmlVal;
function resetSupplyForm(){
	jQuery("#title").attr("value","");
	jQuery("#publisher").attr("value","");
	jQuery("#beginTime").attr("value","");
	jQuery("#endTime").attr("value","");
	jQuery("#supplyStatus").attr("value","");
	jQuery("#supplyType").attr("value","");
}

function show(idVal){
	dialog = art.dialog({
		title:'请填写禁用原因',
	    content: htmlVal,
	    width:300,
	    height:150,
	    lock: true,
	    resize:false
	});
	$('#infoId').val(idVal);//当dialog执行以后才能设置infoID的值
 }

function submitCheck(){
	var reason = $("#reasonID").val();
	if(reason == null || reason == ''){
		alert("请输入内容!");
		return false;
	}else
		return true;
}

function closeDialog(){
	dialog.close();
}