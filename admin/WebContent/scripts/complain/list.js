$(function() {
        $("#gmtCreateFrom").datePicker({
            clickInput : true,
            startDate:"1970-01-01"
        });
        $("#gmtCreateTo").datePicker({
            clickInput : true,
            startDate:"1970-01-01"
        });
});

function clearMsg(){
	jQuery("#ccType").attr("value","");
	jQuery("#orderCcNum").attr("value","");
	jQuery("#orderNo").attr("value","");
	jQuery("#status").attr("value","");
	jQuery("#gmtCreateFrom").attr("value","");
	jQuery("#gmtCreateTo").attr("value","");
}