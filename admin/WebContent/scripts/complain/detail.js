$(function() {
	$("#replay_area").hide();
	$("#submit").hide();
	$("#cancel").hide();

});
function doShow() {
	jQuery("#replay_area").show();
	jQuery("#message").focus();
	jQuery("#submit").show();
	jQuery("#cancel").show();
	jQuery("#repaly").hide();
	jQuery("#msgRrror").text("");
}
function abolish() {
	jQuery("#replay_area").hide();
	jQuery("#submit").hide();
	jQuery("#cancel").hide();
	jQuery("#repaly").show();
	jQuery("#message").text("");
}
function validate(){
	//alert(jQuery("#message").val().length);
	if(jQuery("#message").val().length >100){
		alert("������һ�����������100���ַ�����");
		return false;
	}
	return true;
}