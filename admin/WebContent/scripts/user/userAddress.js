function selectAddressType(userAccount, type){
	window.location.href = appServer + '/user/address.htm?userAccount='+userAccount+'&type='+type;
}

function goToList(){
	window.location.href = appServer + '/user/list.htm';
}