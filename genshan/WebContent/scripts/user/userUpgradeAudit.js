function upGradeAudit(result){
	if( "" == $("#auditNodeRemark").val()){
		$("#auditNodeRemarkError").html("此项信息必须填写");
	}else{
		if(result && $("#status").val() == 'U'){
			alert("必须等用户激活资金账号后,才能审核通过！");
		}else{
			$("#auditNodeResult").attr("value",result);
			$("#upgradeAuditFrom").submit();
		}
	}
}

function goBackToList(){
	window.location.href = appServer + "/user/audit/list.htm";
}