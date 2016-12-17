$(function() {
    	$("#beginTime").datePicker({clickInput:true,startDate:"1900-01-01"});
    	$("#endTime").datePicker({clickInput:true,startDate:"1900-01-01"});
    });

function resetSupplyForm(){
	jQuery("#title").attr("value","");
	jQuery("#reportType").attr("value","");
	jQuery("#endTime").attr("value","");
	jQuery("#beginTime").attr("value","");
	jQuery("#reportStatus").attr("value","");
}