function checkSubmit(){
	var sD = $("#startDate").val();
	if(sD==null || sD==""){
		alert("请选择开始时间");
		return false;
	}
	var eD = $("#endDate").val();
	if(eD==null || eD==""){
		alert("请选择结束时间");
		return false;
	}
	return true;
}
