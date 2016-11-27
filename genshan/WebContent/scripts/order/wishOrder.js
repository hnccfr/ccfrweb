$(function() {
	$("#gmtCreateFrom").datePicker( {
		clickInput : true,
		startDate : "1970-01-01"
	});
	$("#gmtCreateTo").datePicker( {
		clickInput : true,
		startDate : "1970-01-01"
	});
});

function audit(id) {
	if (confirm("确定要提交审核吗？")) {
		var id = id;
		jQuery.ajax( {
			type : 'POST',
			url : '$!{appServer}/tradeWishOrder/audit.htm',
			data : {
				id : id
			},
			success : function(msg) {
				if (msg == "success") {
					alert("操作成功！");
					window.location.reload();
				} else {
					alert("操作失败！");

				}
			}
		});
	}
}
function clearMsg(){
	jQuery("#wishOrderNum").attr("value","");
	jQuery("#gmtCreateFrom").attr("value","");
	jQuery("#gmtCreateTo").attr("value","");
	jQuery("#status").attr("value","");
	jQuery("#projectName").attr("value","");
	jQuery("#paymentType").attr("value","");
}

$(document).ready(function(){    
	jQuery.validator.setDefaults({ 
		submitHandler: function(form) { 
			form.submit();
		} 
	});
	
	jQuery.validator.addMethod("trademarkType", function(value,element) { 
		var reg = /^\d{3}$/;
		return this.optional(element) || reg.test(value);
	},"牌号必须是三位数字");

	$("#wishOrderAuditForm").validate({
		errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		},
		success: function(label) {
			label.text("");
		},
   		 rules: {
			trademark:{
				required	:	true,
				trademarkType :	true
			},
			auditNodeRemark:{
				required	:	true,
				maxlength	:	160
			}
  		 },      
  		 messages: { 
 			trademark:{
				required	:	"牌号不能为空"
			},
  			auditNodeRemark:{
  			 	required	:	"备注信息不能为空",
				maxlength	:	"您输入的备注信息太长"
			}
 		 }
	});  
 });

function auctionAudit(result){
	if(result == 'true'){
		$("#auditResult").attr("value","Y");
	}
	else{
		$("#auditResult").attr("value","N");
	}
	$("#isSpecialMan").attr("value",$("#specialSign").val());
	$("#wishOrderAuditForm").submit();
}
