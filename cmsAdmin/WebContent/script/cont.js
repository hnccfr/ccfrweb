var isSame=false;

$(function() {
//增加批量转移对话框 zhuhao 2012-11-2
	companyMove=  $("#moveDialog").dialog({
		autoOpen: false,
		modal: true,
		width: 380,
		height: 150,
		bgiframe:true,
		position: ["center",50],
		buttons: {
			"确定": function() {
				if(isSame){
					moveSubmit();
			    }else{
			    	$(this).dialog("close");
			    }
			}
		}

	});

	companyMove.parent().appendTo("form:eq(2)");

//增加栏目批量转移对话框 zhuhao 2012-11-9
	 $("#channelmoveDialog").dialog({
		autoOpen: false,
		modal: true,
		width: 380,
		height: 200,
		bgiframe:true,
		position: ["center",50],
		buttons: {
			"确定": function() {
					channelMoveSubmit();
			}
		}

	});

	$("#rejectDialog").dialog({
		autoOpen: false,
		modal: true,
		width: 380,
		height: 200,
		bgiframe:true,
		position: ["center",50],
		buttons: {
			"关闭": function(){
				$(this).dialog("close");
			},
			"确定": function() {
				rejectSubmit();
			}
		}
	});
});
function optCheck() {
	if(Pn.checkedCount('ids')<=0) {
		alert("<@s.m 'error.checkRecord'/>");
		return;
	}
	var f = getTableForm();
	f.action="o_check.do";
	f.submit();
}
function optReject() {
	if(Pn.checkedCount('ids')<=0) {
		alert("<@s.m 'error.checkRecord'/>");
		return;
	}
	$("#rejectDialog").dialog("open");
}
function rejectSubmit() {
	$("input[name=rejectOpinion]").val($("#rejectOpinion").val());
	$("input[name=rejectStep]").val($("#rejectStep").val());
	$("#rejectDialog").dialog("close");
	var f = getTableForm();
	f.action="o_reject.do";
	f.submit();
}
function chgStatus() {
	var queryStatus = $("input[name=queryStatus]:checked").val();
	location.href="v_list.do?cid=${cid!}&queryStatus=" + queryStatus;
}
