function clearMsg(){
	jQuery("#infoType").attr("value","");
	jQuery("#title").attr("value","");
	jQuery("#effectiveStartDateFrom").attr("value","");
	jQuery("#effectiveEndDateTo").attr("value","");
	jQuery("#effectiveStartDateTo").attr("value","");
	jQuery("#effectiveEndDateFrom").attr("value","");
	jQuery("#projectCode").attr("value","");
	
}

function validate(){
	if($("#title").val().length>=42){
		alert("请不要超过42个字！");
	}
}