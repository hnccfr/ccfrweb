$(function() {
			$("#startDate").datePicker({
						clickInput : true,
						startDate : "1970-01-01"
					});
			$("#endDate").datePicker({
						clickInput : true,
						startDate : "1970-01-01"
					});
		});

$(function() {
	$("#orderCheckGoodsDialog").dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		position : ['center', 10],
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
						success : function(result) {
							if (result.errorInfo && result.errorInfo.length > 0) {
								alert(result.errorInfo);
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
						+ "/order/checkgoods.htm?orderNo=" + orderNo+"&dd="+new Date().getTime());
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
		position : ['center', 10],
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
						success : function(result) {
							if (result.errorInfo && result.errorInfo.length > 0) {
								alert(result.errorInfo);
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
						+ "/order/checkticket.htm?orderNo=" + orderNo+"&dd="+new Date().getTime());
	});
	$("#orderCheckTicketDialog").bind("dialogclose", function(event, ui) {
				$(this).empty();
			});
});

var orderNo = "";
function orderCheckGoods(_orderNo) {
	orderNo = _orderNo;
	$("#orderCheckGoodsDialog").dialog("open");
}
function orderCheckTicket(_orderNo) {
	orderNo = _orderNo;
	$("#orderCheckTicketDialog").dialog("open");
}