function auditBid(projectCode,bidderAccount,operator){
	
	var content = "<form id=\"auditForm\">"
			+ "<input type=\"hidden\" name=\"projectCode\" value=\""+projectCode+"\"  />"
			+ "<input type=\"hidden\" name=\"bidderAccount\" value=\""+bidderAccount+"\"  />"
			+ "<input type=\"hidden\" name=\"operator\" value=\""+operator+"\"  />"
			+"<table width=\"100%\" class=\"tb2\">"
			+ "<tr><th style=\"vertical-align:top;\"><span style=\"color:red;\">*</span>取消原因：</th><td>" 
			+"<textarea id=\"remark\" name=\"remark\" style=\"width:200px;height:80px;resize:none;font-size: 12px;\"></textarea>"
			+"<p style=\"font-size: 12px;\">取消原因为必填且不超过666个字</p><span id=\"markErr\" style=\"color:red;\"></span></td></tr></table></form>";
	var op = {
		id : "auditBidDialog",
		title : '报价评审',
		drag : false,
		lock : true,
		content : content,
		yesFn : function(){
			var reason = $("#remark").val();
			if(reason.length < 1){
				$("#markErr").text("取消原因不能为空");
				return false;
			}else if(reason.length > 666){
				$("#markErr").text("取消原因过长");
				return false;
			}else{
				auditAjax();//报价
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
						showMessage("操作成功！",true);
						
					}
				},
				error : function() {
					showMessage('服务器忙，请稍后再试！',false);
				}
			});
}
function showMessage(message,refresh) {
	var op = {
		id : "msg",
		title : '信息提示',
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