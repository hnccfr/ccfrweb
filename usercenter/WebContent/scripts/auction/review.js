function auditBid(projectCode,bidderAccount,operator){
	
	var content = "<form id=\"auditForm\">"
			+ "<input type=\"hidden\" name=\"projectCode\" value=\""+projectCode+"\"  />"
			+ "<input type=\"hidden\" name=\"bidderAccount\" value=\""+bidderAccount+"\"  />"
			+ "<input type=\"hidden\" name=\"operator\" value=\""+operator+"\"  />"
			+"<table width=\"100%\" class=\"tb2\">"
			+ "<tr><th style=\"vertical-align:top;\"><span style=\"color:red;\">*</span>ȡ��ԭ��</th><td>" 
			+"<textarea id=\"remark\" name=\"remark\" style=\"width:200px;height:80px;resize:none;font-size: 12px;\"></textarea>"
			+"<p style=\"font-size: 12px;\">ȡ��ԭ��Ϊ�����Ҳ�����666����</p><span id=\"markErr\" style=\"color:red;\"></span></td></tr></table></form>";
	var op = {
		id : "auditBidDialog",
		title : '��������',
		drag : false,
		lock : true,
		content : content,
		yesFn : function(){
			var reason = $("#remark").val();
			if(reason.length < 1){
				$("#markErr").text("ȡ��ԭ����Ϊ��");
				return false;
			}else if(reason.length > 666){
				$("#markErr").text("ȡ��ԭ�����");
				return false;
			}else{
				auditAjax();//����
				return true;
			}
		},
		noFn : true
	};
	art.dialog(op);
	
}
function auditAjax(){
	jQuery.ajax({
				type : "POST",
				contentType:"application/x-www-form-urlencoded; charset=UTF-8",
				url : appServer + "/auction/reviewer/review.htm",
				data : $("#auditForm").serializeArray(),
				dataType : "json",
				async : false,
				cache : false,
				success : function(result) {
					if (result.errorInfo && result.errorInfo.length > 0) {
						showMessage(result.errorInfo,false);
					} else {
						showMessage("�����ɹ���",true);
						
					}
				},
				error : function() {
					showMessage('������æ�����Ժ����ԣ�',false);
				}
			});
}
function showMessage(message,refresh) {
	var op = {
		id : "msg",
		title : '��Ϣ��ʾ',
		drag : true,
		lock : true,
		content : message,
		yesFn : function(){
			if(refresh){
				window.location.reload();
			}
		}
	};
	art.dialog(op);
}

function validateInputReason(reason){
	var res = reason;
	var result = true;
	if(res.length < 1 || res.length > 666){
		result = false;
	}
	return result;
}