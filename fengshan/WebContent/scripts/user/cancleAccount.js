function cancleAccount(){
	if(confirm("您的操作将使您不能再使用此平台，确认销户？")){
		window.location.href = appServer + "/user/delete.htm";
	}
}