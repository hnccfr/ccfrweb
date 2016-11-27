 $(function() {
        $("#complain_start_from").datePicker({
            clickInput : true,
            startDate:"1970-01-01"
        });
        $("#complain_start_to").datePicker({
            clickInput : true,
            startDate:"1970-01-01"
        });
});
function clearMsg() {
		jQuery("#orderCcNum").attr("value", "");
		jQuery("#orderNo").attr("value", "");
		jQuery("#status").attr("value", "");
		jQuery("#complain_start_from").attr("value", "");
		jQuery("#complain_start_to").attr("value", "");
		jQuery("#infoType").attr("value", "");
		
}