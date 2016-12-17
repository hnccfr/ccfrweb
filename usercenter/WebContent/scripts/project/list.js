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
		title : '提示',
		drag : false,
		content : '确认删除本项目！',
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
							content : '操作成功',
							yesFn : function() {
								window.location.reload();
							}
						});
					} else if (msg == "1001") {
						art.dialog( {
							drag : false,
							content : '资金账户不存在！',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "1002") {
						art.dialog( {
							drag : false,
							content : '账户已被撤销!',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2002") {
						art.dialog( {
							drag : false,
							content : '可用余额不足！',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2004") {
						art.dialog( {
							drag : false,
							content : '冻结资金不足！',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2011") {
						art.dialog( {
							drag : false,
							content : '当前操作不在交易时段！',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2018") {
						art.dialog( {
							drag : false,
							content : '账户对应银行信息不存在！',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else {
						art.dialog( {
							drag : false,
							content : '操作失败'
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
		title : '提示',
		drag : false,
		content : '确定要将本项目提交审核',
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
							content : '操作成功',
							yesFn : function() {
								window.location.reload();
							}
						});
					} else if (msg == "logicError") {
						art.dialog( {
							drag : false,
							content : '本项目已不能进行此操作！',
							yesFn : true
						});
					} else if (msg == "1001") {
						art.dialog( {
							drag : false,
							content : '资金账户不存在！',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "1002") {
						art.dialog( {
							drag : false,
							content : '账户已被撤销!',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2002") {
						art.dialog( {
							drag : false,
							content : '可用余额不足！',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2004") {
						art.dialog( {
							drag : false,
							content : '冻结资金不足！',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2011") {
						art.dialog( {
							drag : false,
							content : '当前操作不在交易时段！',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "2018") {
						art.dialog( {
							drag : false,
							content : '账户对应银行信息不存在！',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else if (msg == "fundAccountEmpty") {
						art.dialog( {
							drag : false,
							content : '资金账户不存在！',
							yesFn : true
						});
					} else {
						art.dialog( {
							drag : false,
							content : '操作失败',
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
				title : "提交审核挂牌项目",
				buttons : {
					"取消" : function() {
						$(this).dialog("close");
					},
					"确定" : function() {
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

									alert("服务器忙，请稍后再试" + errorThrown
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
 * 提交审核挂牌项目
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
				title : '提交审核挂牌项目',
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
									showMsg("提交审核成功!");
									// art.dialog.close();
								}
							},
							error : function(XMLHttpRequest, textStatus,
									errorThrown) {
								alert("服务器忙，请稍后再试" + errorThrown
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
			alert("服务器忙，请稍后再试" + errorThrown + "  textStatus" + textStatus
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
		if (msg == '可用余额不足' || msg == '账户余额不足' || msg == '可取余额不足') {
//			msg += '&nbsp;<<a target="_blank" href="' + appServer + '/funds/in.htm"><font color="#468100">账户充值</font></a>>';
		}
	}
	if ($("#ajax_show_msg").size() <= 0) {
		$("body").append("<div id='ajax_show_msg' ></div>");
	}
	var op = {
		id : "ajax_show_msg",
		title : "信息提示!",
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