$(function() {
			$("#pwdResetDialog").dialog({
						autoOpen : false,
						bgiframe : true,
						modal : true,
						position : ['center', 160],
						width : 300,
						title : "密码重置提示",
						buttons : {
							"确认" : function() {
								$(this).dialog("close");
							}
						}
					});
			$("#pwdResetDialog").bind("dialogopen", function(event, ui) {
						$("#pwdResetDialog").load(url + userAccount + "&passwordType=" + passwordType);
					});
			$("#pwdResetDialog").bind("dialogclose", function(event, ui) {
						userAccount = "";
						passwordType = "";
						$(this).empty();
					});
		});

var userAccount = "";
var passwordType="";
var url = "";
function resetPassword(account,type) {
	if (confirm("确定重置")) {
		userAccount = account;
		passwordType = type;
		var urlKey = $("#sourceUrlKey").val();
		this.url = appServer + "/" + urlKey
				+ "/password/reset.htm?userAccount=";
		$("#pwdResetDialog").dialog("open");
	}
}

/** ************** 禁用和启用用户功能****** */
function changeUserStatus(status, account) {
	/** 将传入的状态变为相反的，即F的变为N，N的变为F */
	var opsite_status = 'N';
	var operate_name = "启用";
	if (opsite_status == status) {
		opsite_status = 'F';
		operate_name = "禁用";
	}
	var urlKey = $("#sourceUrlKey").val();
	this.url = appServer + "/" + urlKey + "/changeStatus.htm"
	/** ajax处理启用/禁用用户 */
	if (confirm("确定要" + operate_name + "该用户吗？")) {
		jQuery.ajax({
					type : "POST",
					url : url,
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					data : {
						status : opsite_status,
						account : account
					},
					success : function(msn) {
						if (msn > 0) {
							if (urlKey == "user") {
								location.href = appServer + "/user/list.htm";
							} else {
								location.href = appServer + "/user/" + urlKey
										+ "/list.htm";
							}
						} else
							alert("失败");
					}
				});
	}
}