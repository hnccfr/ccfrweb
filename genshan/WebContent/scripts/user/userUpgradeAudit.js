function upGradeAudit(result){
	if( "" == $("#auditNodeRemark").val()){
		$("#auditNodeRemarkError").html("������Ϣ������д");
	}else{
		if(result && $("#status").val() == 'U'){
			alert("������û������ʽ��˺ź�,�������ͨ����");
		}else{
			$("#auditNodeResult").attr("value",result);
			$("#upgradeAuditFrom").submit();
		}
	}
}

function goBackToList(){
	window.location.href = appServer + "/user/audit/list.htm";
}