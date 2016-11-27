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
	if (confirm("ȷ��Ҫ�ύ�����")) {
		var id = id;
		jQuery.ajax( {
			type : 'POST',
			url : '$!{appServer}/tradeWishOrder/audit.htm',
			data : {
				id : id
			},
			success : function(msg) {
				if (msg == "success") {
					alert("�����ɹ���");
					window.location.reload();
				} else {
					alert("����ʧ�ܣ�");

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
	},"�ƺű�������λ����");

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
				required	:	"�ƺŲ���Ϊ��"
			},
  			auditNodeRemark:{
  			 	required	:	"��ע��Ϣ����Ϊ��",
				maxlength	:	"������ı�ע��Ϣ̫��"
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
