/**
 * 审核挂牌
 */
function audit(projectListingId) {
	if (!(/^\d*$/.test(projectListingId)))
		return;// 项目ID不是数字肯定就是错的

	/* artDialog 实现 */
	var op = {
		id 		: "auditDataBox",
		title 	: '挂牌审核',
		drag 	: true,
		lock 	: true,
		padding : 3
	};
	art.dialog.load(appServer + "/project/audit.htm?projectListingId="
			+ projectListingId, op, false);

	/* jQuery UI 实现 */
	// $(function() {
	// $("#auditDialog").dialog({
	// autoOpen : false,
	// bgiframe : true,
	// modal : true,
	// drag : true,
	// position : ['center', 160],
	// width : 600,
	// title : "审核"
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
 * 提交审核请求
 */
function doAudit(auditResult) {
	// var url = appServer + "/project/audit.htm";
	$("#auditResult").val(auditResult);
	var memo = $("#auditMemo").val();
	if ("N" == auditResult && memo.length < 1) {
//		alert("审核不通过时必须填写说明");
		art.dialog.alert("审核不通过时必须填写说明");
	} else if (memo.length > 150) {
//		alert("审核说明 不得超过150字符");
		art.dialog.alert("审核说明 不得超过150字符");
	} else
		document.auditForm.submit();
}