$(function() {
	$("#bidrecordDialog").dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		position : ['center', 200],
		width : 400,
		title : "�鿴������ʷ����",
		cache : false,
		buttons : {
			"�ر�" : function() {
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
				$("#bidrecordDialog").html('δ��ѯ�����ɱ���');
			}
		},
		error : function(XMLHttpRequest,textStatus) {
			$("#bidrecordDialog").html('������æ�����Ժ����ԣ�');
		}
    });
	$("#bidrecordDialog").dialog("open");
}

