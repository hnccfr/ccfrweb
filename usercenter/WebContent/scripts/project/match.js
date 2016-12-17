$(function() {
	$("#auditDiv").show();
	$("#ajaxResponseDivRepeat").hide();

	/*
	 * $("#machbox").dialog( { autoOpen : false, bgiframe : true, modal : true,
	 * position : [ 'center', 160 ], width : 800, height : 500, title : "撮合一把",
	 * buttons : { "关闭" : function() { $(this).dialog("close"); } } });
	 * 
	 * $("#machbox").bind("dialogopen", function(event, ui) { var projectId =
	 * $("#projectListingId").val(); $("#machbox").load(appServer +
	 * "/project/matche.htm?id=" + projectId); });
	 * $("#machbox").bind("dialogclose", function(event, ui) { $(this).empty();
	 * });
	 */
});

function doMatch() {
	var option = {
		title : '项目选择',
		drag : false,
		yesText : '关闭',
		yesFn : true
	};
	var projectId = $("#projectListingId").val();
	art.dialog.load(appServer + "/project/match.htm?id=" + projectId, option,
			false);
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
								cache : false,
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
	jQuery
			.ajax( {
				type : 'GET',
				cache : false,
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
								jQuery
										.ajax( {
											type : "POST",
											cache : false,
											url : $("#confirmForm").attr(
													"action"),
											data : {
												"projectId" : $("#projectId")
														.val()
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
													$("#loginAuditBtn")
															.detach();
													$("#loginAuditMsg").text(
															"提交审核成功！");
												}
											},
											error : function(XMLHttpRequest,
													textStatus, errorThrown) {
												alert("服务器忙，请稍后再试"
														+ errorThrown
														+ "  textStatus"
														+ textStatus
														+ "  XMLHttpRequest"
														+ XMLHttpRequest);
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
					alert("服务器忙，请稍后再试" + errorThrown + "  textStatus"
							+ textStatus + "  XMLHttpRequest" + XMLHttpRequest);
				}
			});

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
			if ("提交审核成功!" != msg) {
				window.location.reload();
			}

		},
		noFn : true
	};
	art.dialog(op);
}
