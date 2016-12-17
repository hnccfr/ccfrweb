/**
$(function() {
	$("#li_end_form").datePicker( {
		clickInput : true,
		startDate : "1970-01-01"
	});
	$("#li_end_to").datePicker( {
		clickInput : true,
		startDate : "1970-01-01"
	});
});
**/
function deletePro(id) {
	var op = {
		title : '��ʾ',
		drag : false,
		content : 'ȷ��ɾ������Ŀ��',
		yesFn : function() {
			var prjId = id;
			jQuery.ajax( {
				type : 'POST',
				cache:false,
				url : appServer + '/project/delete.htm',
				data : {
					id : prjId
				},
				success : function(msg) {
					if (msg == "success") {
						art.dialog( {
							drag : false,
							content : '�����ɹ�',
							yesFn : function() {
								window.location.reload();
							}
						});
					} else if (msg == "1001") {
						art.dialog( {
							drag : false,
							content : '�ʽ��˻������ڣ�',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "1002") {
						art.dialog( {
							drag : false,
							content : '�˻��ѱ�����!',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2002") {
						art.dialog( {
							drag : false,
							content : '�������㣡',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2004") {
						art.dialog( {
							drag : false,
							content : '�����ʽ��㣡',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2011") {
						art.dialog( {
							drag : false,
							content : '��ǰ�������ڽ���ʱ�Σ�',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2018") {
						art.dialog( {
							drag : false,
							content : '�˻���Ӧ������Ϣ�����ڣ�',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else {
						art.dialog( {
							drag : false,
							content : '����ʧ��'
						});
					}
				}
			});
		},
		noFn : true
	};
	art.dialog(op);
}

function audit(id) {
	var op = {
		title : '��ʾ',
		drag : false,
		content : 'ȷ��Ҫ������Ŀ�ύ���',
		yesFn : function() {
			var prjId = id;
			jQuery.ajax( {
				type : 'POST',
				cache:false,
				url : appServer + '/project/subAudit.htm',
				data : {
					projectId : prjId
				},
				success : function(msg) {
					if (msg == "success") {
						art.dialog( {
							drag : false,
							content : '�����ɹ�',
							yesFn : function() {
								window.location.reload();
							}
						});
					} else if (msg == "logicError") {
						art.dialog( {
							drag : false,
							content : '����Ŀ�Ѳ��ܽ��д˲�����',
							yesFn : true
						});
					} else if (msg == "1001") {
						art.dialog( {
							drag : false,
							content : '�ʽ��˻������ڣ�',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "1002") {
						art.dialog( {
							drag : false,
							content : '�˻��ѱ�����!',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2002") {
						art.dialog( {
							drag : false,
							content : '�������㣡',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2004") {
						art.dialog( {
							drag : false,
							content : '�����ʽ��㣡',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2011") {
						art.dialog( {
							drag : false,
							content : '��ǰ�������ڽ���ʱ�Σ�',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2018") {
						art.dialog( {
							drag : false,
							content : '�˻���Ӧ������Ϣ�����ڣ�',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "fundAccountEmpty") {
						art.dialog( {
							drag : false,
							content : '�ʽ��˻������ڣ�',
							yesFn : true
						});
					} else {
						art.dialog( {
							drag : false,
							content : '����ʧ��',
							yesFn : true
						});
					}
				}
			});
		},
		noFn : true
	};
	art.dialog(op);
}
var projectId = "";

$(function() {
	$("#auditSellProjectConfirmDialog").dialog(
			{
				autoOpen : false,
				bgiframe : true,
				modal : true,
				position : [ 'center', 40 ],
				width : 750,
				title : "�ύ��˹�����Ŀ",
				buttons : {
					"ȡ��" : function() {
						$(this).dialog("close");
					},
					"ȷ��" : function() {
						var _this = this;
						if ($("#confirmForm").size() > 0) {
							jQuery.ajax( {
								type : "POST",
								url : $("#confirmForm").attr("action"),
								data : {
									"projectId" : $("#projectId").val()
								},
								dataType : "json",
								async : false,
								success : function(result) {
									if (result.errorInfo
											&& result.errorInfo.length > 0) {
										// alert(result.errorInfo);
										showMsg(result.errorInfo);
									} else {
										$(_this).dialog("close");
										$("#searchForm").submit();
									}
								},
								error : function(XMLHttpRequest, textStatus,
										errorThrown) {

									alert("������æ�����Ժ�����" + errorThrown
											+ "  textStatus" + textStatus
											+ "  XMLHttpRequest"
											+ XMLHttpRequest);
								}
							});
						} else {
							$(this).dialog("close");
						}
					}
				}
			});
	$("#auditSellProjectConfirmDialog")
			.bind(
					"dialogopen",
					function(event, ui) {
						$("#auditSellProjectConfirmDialog")
								.load(
										appServer
												+ "/project/sell/submitAuditConfirm.htm?projectId="
												+ projectId + "&dd="
												+ new Date().getTime());
					});
	$("#auditSellProjectConfirmDialog").bind("dialogclose",
			function(event, ui) {
				$(this).empty();
			});
});
/**
 * �ύ��˹�����Ŀ
 * 
 * @param _projectId
 * @return
 */
function auditSellProjectConfirm(_projectId) {
	projectId = _projectId;
	var op = "";
	jQuery.ajax( {
		type : 'GET',
		cache:false,
		url : appServer + "/project/sell/submitAuditConfirm.htm",
		data : {
			projectId : projectId
		},
		success : function(contents) {
			op = {
				id : "auditSellProjectConfirmDialog",
				title : '�ύ��˹�����Ŀ',
				drag : true,
				lock : true,
				width : 400,
				height : 300,
				content : contents,
				yesFn : function() {
					var _this = this;
					if ($("#confirmForm").size() > 0) {
						jQuery.ajax( {
							type : "POST",
							cache:false,
							url : $("#confirmForm").attr("action"),
							data : {
								"projectId" : $("#projectId").val()
							},
							dataType : "json",
							async : false,
							success : function(result) {
								// alert(result);
								if (result.errorInfo
										&& result.errorInfo.length > 0) {
									showMsg(result.errorInfo);
								} else {
									showMsg("�ύ��˳ɹ�!");
									// art.dialog.close();
								}
							},
							error : function(XMLHttpRequest, textStatus,
									errorThrown) {
								alert("������æ�����Ժ�����" + errorThrown
										+ "  textStatus" + textStatus
										+ "  XMLHttpRequest" + XMLHttpRequest);
							}
						});
					} else {
						art.dialog.close();
					}
				},
				noFn : true
			};
			art.dialog(op);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("������æ�����Ժ�����" + errorThrown + "  textStatus" + textStatus
					+ "  XMLHttpRequest" + XMLHttpRequest);
		}
	});

}
function clearMsg() {
	jQuery("#projectTypeName").attr("value", "");
	jQuery("#projectTypeCode").attr("value", "");

	jQuery("#title").attr("value", "");
	jQuery("#status").attr("value", "");
	jQuery("#code").attr("value", "");
	jQuery("#projectCode").attr("value", "");
	jQuery("#infoType").attr("value", "");
	jQuery("#effectiveStartDateFrom").attr("value", "");
	jQuery("#effectiveStartDateTo").attr("value", "");
	jQuery("#effectiveEndDateFrom").attr("value", "");
	jQuery("#effectiveEndDateTo").attr("value", "");
	jQuery("#li_end_form").attr("value", "");
	jQuery("#li_end_to").attr("value", "");
}

function showMsg(msg) {
	if (msg) {
		msg = jQuery.trim(msg);
		if (msg == '��������' || msg == '�˻�����' || msg == '��ȡ����') {
//			msg += '&nbsp;<<a target="_blank" href="' + appServer + '/funds/in.htm"><font color="#468100">�˻���ֵ</font></a>>';
		}
	}
	if ($("#ajax_show_msg").size() <= 0) {
		$("body").append("<div id='ajax_show_msg' ></div>");
	}
	var op = {
		id : "ajax_show_msg",
		title : "��Ϣ��ʾ!",
		drag : true,
		lock : true,
		padding : 0,
		width : 220,
		height : 120,
		fixed : true,
		content : msg,
		yesFn : function() {
			window.location.reload();
		},
		noFn : true
	};
	art.dialog(op);
}