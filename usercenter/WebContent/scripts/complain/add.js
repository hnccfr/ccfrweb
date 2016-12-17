function validate(){
	if(jQuery("#descript").val().length < 1){
		jQuery("#descriptErr").text("投诉原因为必填！");
		return false;
	}
	if(jQuery("#descript").val().length >100){
		jQuery("#descriptErr").text("投诉原因过长！");
		return false;
	}
	return true;
}