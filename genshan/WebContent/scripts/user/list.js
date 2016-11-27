$(function() {
			$("#pwdResetDialog").dialog({
						autoOpen : false,
						bgiframe : true,
						modal : true,
						position : ['center', 160],
						width : 300,
						title : "����������ʾ",
						buttons : {
							"ȷ��" : function() {
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
	if (confirm("ȷ������")) {
		userAccount = account;
		passwordType = type;
		var urlKey = $("#sourceUrlKey").val();
		this.url = appServer + "/" + urlKey
				+ "/password/reset.htm?userAccount=";
		$("#pwdResetDialog").dialog("open");
	}
}

/** ************** ���ú������û�����****** */
function changeUserStatus(status, account) {
	/** �������״̬��Ϊ�෴�ģ���F�ı�ΪN��N�ı�ΪF */
	var opsite_status = 'N';
	var operate_name = "����";
	if (opsite_status == status) {
		opsite_status = 'F';
		operate_name = "����";
	}
	var urlKey = $("#sourceUrlKey").val();
	this.url = appServer + "/" + urlKey + "/changeStatus.htm"
	/** ajax��������/�����û� */
	if (confirm("ȷ��Ҫ" + operate_name + "���û���")) {
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
							alert("ʧ��");
					}
				});
	}
}