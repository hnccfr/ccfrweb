$(function() {
	try{
			$("#startDate").datePicker({
						clickInput : true,
						startDate : "1970-01-01"
					});
			$("#endDate").datePicker({
						clickInput : true,
						startDate : "1970-01-01"
					});
	}catch(e){}
		});

$(function() {
	$("#orderBuyConfirmDialog").dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		position : ['center', 40],
		width : 750,
		title : "����ȷ��",
		buttons : {
			"ȡ��" : function() {
				$(this).dialog("close");
			},
			"ȷ��" : function() {
				var _this = this;
				if ($("#confirmForm").size() > 0) {
					jQuery.ajax({
						type : "POST",
						url : $("#confirmForm").attr("action"),
						data : $("#confirmForm").serializeArray(),
						dataType : "json",
						async : false,
						cache : false,
						success : function(result) {
							if (result.errorInfo && result.errorInfo.length > 0) {
//								alert(result.errorInfo);
								showMsg(result.errorInfo);
							} else {
								$(_this).dialog("close");
								$("#searchForm").submit();
							}
						},
						error : function() {
							alert('������æ�����Ժ�����');
						}
					});
				} else {
					$(this).dialog("close");
				}
			}

		}
	});
	$("#orderBuyConfirmDialog").bind("dialogopen", function(event, ui) {
		$("#orderBuyConfirmDialog").load(appServer
				+ "/order/buy/confirm.htm?orderNo=" + orderNo + "&dd="
				+ new Date().getTime());
	});
	$("#orderBuyConfirmDialog").bind("dialogclose", function(event, ui) {
				$(this).empty();
			});
});

$(function() {
	$("#orderSellConfirmDialog").dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		position : ['center', 40],
		width : 750,
		title : "����ȷ��",
		buttons : {
			"ȡ��" : function() {
				$(this).dialog("close");
			},
			"ȷ��" : function() {
				var _this = this;
				if ($("#confirmForm").size() > 0) {
					jQuery.ajax({
						type : "POST",
						url : $("#confirmForm").attr("action"),
						data : $("#confirmForm").serializeArray(),
						dataType : "json",
						async : false,
						cache : false,
						success : function(result) {
							if (result.errorInfo && result.errorInfo.length > 0) {
//								alert(result.errorInfo);
								showMsg(result.errorInfo);
							} else {
								$(_this).dialog("close");
								$("#searchForm").submit();
							}
						},
						error : function() {
							alert('������æ�����Ժ�����');
						}
					});
				} else {
					$(this).dialog("close");
				}
			}
		}
	});
	$("#orderSellConfirmDialog").bind("dialogopen", function(event, ui) {
		$("#orderSellConfirmDialog").load(appServer
				+ "/order/sell/confirm.htm?orderNo=" + orderNo + "&dd="
				+ new Date().getTime());
	});
	$("#orderSellConfirmDialog").bind("dialogclose", function(event, ui) {
				$(this).empty();
			});
});

$(function() {
	$("#sendgoodConfirmDialog").dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		position : ['center', 40],
		width : 750,
		title : "����ȷ��",
		buttons : {
			"ȡ��" : function() {
				$(this).dialog("close");
			},
			"ȷ��" : function() {
				var _this = this;
				if ($("#sendgoodsForm").size() > 0) {
					jQuery.ajax({
						type : "POST",
						url : $("#sendgoodsForm").attr("action"),
						data : $("#sendgoodsForm").serializeArray(),
						dataType : "json",
						async : false,
						cache : false,
						success : function(result) {
							if (result.errorInfo && result.errorInfo.length > 0) {
//								alert(result.errorInfo);
								showMsg(result.errorInfo);
							} else {
								$(_this).dialog("close");
								$("#searchForm").submit();
							}
						},
						error : function() {
							alert('������æ�����Ժ�����');
						}
					});
				} else {
					$(this).dialog("close");
				}
			}

		}
	});
	$("#sendgoodConfirmDialog").bind("dialogopen", function(event, ui) {
		$("#sendgoodConfirmDialog").load(appServer
				+ "/order/sell/sendgoods.htm?orderNo=" + orderNo + "&dd="
				+ new Date().getTime());
	});
	$("#sendgoodConfirmDialog").bind("dialogclose", function(event, ui) {
				$(this).empty();
			});
});
$(function() {
	$("#paygoodsConfirmDialog").dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		position : ['center', 40],
		width : 750,
		title : "����ȷ��",
		buttons : {
			"ȡ��" : function() {
				$(this).dialog("close");
			},
			"ȷ��" : function() {
				var _this = this;
				if ($("#paygoodsForm").size() > 0) {
					jQuery.ajax({
						type : "POST",
						url : $("#paygoodsForm").attr("action"),
						data : $("#paygoodsForm").serializeArray(),
						dataType : "json",
						async : false,
						cache : false,
						success : function(result) {
							if (result.errorInfo && result.errorInfo.length > 0) {
//								alert(result.errorInfo);
								showMsg(result.errorInfo);
							} else {
								$(_this).dialog("close");
								$("#searchForm").submit();
							}
						},
						error : function() {
							alert('������æ�����Ժ�����');
						}
					});
				} else {
					$(this).dialog("close");
				}
			}

		}
	});
	$("#paygoodsConfirmDialog").bind("dialogopen", function(event, ui) {
		$("#paygoodsConfirmDialog").load(appServer
				+ "/order/buy/paygoods.htm?orderNo=" + orderNo + "&dd="
				+ new Date().getTime());
	});
	$("#paygoodsConfirmDialog").bind("dialogclose", function(event, ui) {
				$(this).empty();
			});
});

$(function() {
	$("#orderCheckGoodsDialog").dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		position : ['center', 40],
		width : 750,
		title : "ȷ�Ͻ���",
		buttons : {
			"ȡ��" : function() {
				$(this).dialog("close");
			},
			"ȷ��" : function() {
				var _this = this;
				if ($("#checkGoodsForm").size() > 0) {
					jQuery.ajax({
						type : "POST",
						url : $("#checkGoodsForm").attr("action"),
						data : $("#checkGoodsForm").serializeArray(),
						dataType : "json",
						async : false,
						cache : false,
						success : function(result) {
							if (result.errorInfo && result.errorInfo.length > 0) {
//								alert(result.errorInfo);
								showMsg(result.errorInfo);
							} else {
								$(_this).dialog("close");
								$("#searchForm").submit();
							}
						},
						error : function() {
							alert('������æ�����Ժ�����');
						}
					});
				} else {
					$(this).dialog("close");
				}
			}
		}
	});
	$("#orderCheckGoodsDialog").bind("dialogopen", function(event, ui) {
		$("#orderCheckGoodsDialog").load(appServer
				+ "/order/buy/checkgoods.htm?orderNo=" + orderNo + "&dd="
				+ new Date().getTime());
	});
	$("#orderCheckGoodsDialog").bind("dialogclose", function(event, ui) {
				$(this).empty();
			});
});

$(function() {
	$("#orderCheckTicketDialog").dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		position : ['center', 40],
		width : 750,
		title : "��Ʊȷ��",
		buttons : {
			"ȡ��" : function() {
				$(this).dialog("close");
			},
			"ȷ��" : function() {
				var _this = this;
				if ($("#checkTicketForm").size() > 0) {
					jQuery.ajax({
						type : "POST",
						url : $("#checkTicketForm").attr("action"),
						data : $("#checkTicketForm").serializeArray(),
						dataType : "json",
						async : false,
						cache : false,
						success : function(result) {
							if (result.errorInfo && result.errorInfo.length > 0) {
//								alert(result.errorInfo);
								showMsg(result.errorInfo);
							} else {
								$(_this).dialog("close");
								$("#searchForm").submit();
							}
						},
						error : function() {
							alert('������æ�����Ժ�����');
						}
					});
				} else {
					$(this).dialog("close");
				}
			}
		}
	});
	$("#orderCheckTicketDialog").bind("dialogopen", function(event, ui) {
		$("#orderCheckTicketDialog").load(appServer
				+ "/order/buy/checkticket.htm?orderNo=" + orderNo + "&dd="
				+ new Date().getTime());
	});
	$("#orderCheckTicketDialog").bind("dialogclose", function(event, ui) {
				$(this).empty();
			});
});

var orderNo = "";
function orderBuyConfirm(_orderNo) {
	orderNo = _orderNo;
	$("#orderBuyConfirmDialog").dialog("open");
}

function orderSellConfirm(_orderNo) {
	orderNo = _orderNo;
	$("#orderSellConfirmDialog").dialog("open");
}

function sendgoodsConfirm(_orderNo) {
	orderNo = _orderNo;
	$("#sendgoodConfirmDialog").dialog("open");
}
function orderPaygoodsConfirm(_orderNo) {
	orderNo = _orderNo;
	$("#paygoodsConfirmDialog").dialog("open");
}
function orderCheckGoods(_orderNo) {
	orderNo = _orderNo;
	$("#orderCheckGoodsDialog").dialog("open");
}
function orderCheckTicket(_orderNo) {
	orderNo = _orderNo;
	$("#orderCheckTicketDialog").dialog("open");
}

function showMsg(msg) {
	if ($("#ajax_show_msg").size() <= 0) {
		$("body").append("<div id='ajax_show_msg' ></div>");
		$("#ajax_show_msg").dialog({
					autoOpen : false,
					bgiframe : true,
					modal : true,
					position : ['center', 40],
					width : 400,
					title : "��Ϣ��ʾ",
					buttons : {
					"ȷ��" : function() {
						$(this).dialog("close");
					}}
				});
	}
	$("#ajax_show_msg").html("");
		$("#ajax_show_msg").bind("dialogopen", function(event, ui) {
			if (msg){
				msg = jQuery.trim(msg);
				if (msg == '��������' || msg == '�˻�����'|| msg == '��ȡ����'){
//					msg += '&nbsp;<<a target="_blank" href="'+appServer+'/funds/in.htm"><font color="#468100">�˻���ֵ</font></a>>';
				}
			}
			$("#ajax_show_msg").html(msg);
		});
		$("#ajax_show_msg").bind("dialogclose", function(event, ui) {
					$(this).empty();
				});
	
	$("#ajax_show_msg").dialog("open");
}



var orderListUrl = "";
function justSubmit(_orderListUrl){
	orderListUrl = _orderListUrl;
	jQuery.ajax({
						type : "POST",
						url : $("#confirmForm").attr("action"),
						data : $("#confirmForm").serializeArray(),
						dataType : "json",
						async : false,
						cache : false,
						success : function(result) {
							if (result.errorInfo && result.errorInfo.length > 0) {
								showMsg(result.errorInfo);
							} else {
								alert("����ȷ�ϳɹ���");
									window.location.href = orderListUrl;
							}
						},
						error : function() {
							alert('������æ�����Ժ�����');
						}
					});
}