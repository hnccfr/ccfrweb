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
	var audit_N = $('#auditResult_N').attr('checked');
	if(audit_N == true){
		var remarkVal = $("#remark").val();
		remarkVal = remarkVal.replace(/^\s+|\s+$/g,"");
		if(remarkVal.length <= 0){
			alert("�����벻ͨ��ԭ��");
			return false
		}else if(jQuery("#remark").val().length > 340){
			alert("������һ�����������340���ַ�����");
			return false;
		}
	}
	return true;
}

function showRemarkTxt(obj){
	if(obj.value == 'Y')
		$('#auditRemarkId').hide();
	else if(obj.value == 'N')
		$('#auditRemarkId').show();
}