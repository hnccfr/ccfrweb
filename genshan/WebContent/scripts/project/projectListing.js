/**
 * ��˹���
 */
function audit(projectListingId) {
	if (!(/^\d*$/.test(projectListingId)))
		return;// ��ĿID�������ֿ϶����Ǵ��

	/* artDialog ʵ�� */
	var op = {
		id 		: "auditDataBox",
		title 	: '�������',
		drag 	: true,
		lock 	: true,
		padding : 3
	};
	art.dialog.load(appServer + "/project/audit.htm?projectListingId="
			+ projectListingId, op, false);

	/* jQuery UI ʵ�� */
	// $(function() {
	// $("#auditDialog").dialog({
	// autoOpen : false,
	// bgiframe : true,
	// modal : true,
	// drag : true,
	// position : ['center', 160],
	// width : 600,
	// title : "���"
	// });
	// $("#auditDialog").bind("dialogopen", function(event, ui) {
	// $("#auditDialog").load(appServer + "/project/audit.htm?projectListingId="
	// + projectListingId);
	// });
	// $("#auditDialog").bind("dialogclose", function(event, ui) {
	// $(this).empty();
	// });
	// });
	// $("#auditDialog").dialog("open");
}

/**
 * �ύ�������
 */
function doAudit(auditResult) {
	// var url = appServer + "/project/audit.htm";
	$("#auditResult").val(auditResult);
	var memo = $("#auditMemo").val();
	if ("N" == auditResult && memo.length < 1) {
//		alert("��˲�ͨ��ʱ������д˵��");
		art.dialog.alert("��˲�ͨ��ʱ������д˵��");
	} else if (memo.length > 150) {
//		alert("���˵�� ���ó���150�ַ�");
		art.dialog.alert("���˵�� ���ó���150�ַ�");
	} else
		document.auditForm.submit();
}