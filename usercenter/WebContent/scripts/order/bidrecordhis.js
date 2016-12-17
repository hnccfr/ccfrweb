$(function() {
	$("#bidrecordDialog").dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		position : ['center', 200],
		width : 400,
		title : "查看自由历史报价",
		cache : false,
		buttons : {
			"关闭" : function() {
				$(this).dialog("close");
			}
		}
	});
	$("#bidrecordDialog").bind("dialogclose", function(event, ui) {
				$(this).empty();
			});
});


function getfreebid(projectCode) {
	var _projectCode = projectCode;
	jQuery.ajax({
		type : "GET",
		url  : appServer + "/auction/freebiddialog.htm?projectCode="+_projectCode+"&dd="+new Date().getTime(),
		dataType : "json",
		async : false,
		cache : false,
		success : function (data)  {
			if (data.priceDesc) {
				$("#bidrecordDialog").html(data.priceDesc);
			} else {
				$("#bidrecordDialog").html('未查询到自由报价');
			}
		},
		error : function(XMLHttpRequest,textStatus) {
			$("#bidrecordDialog").html('服务器忙，请稍后再试！');
		}
    });
	$("#bidrecordDialog").dialog("open");
}

