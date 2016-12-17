$(document).ready(function(){    
	jQuery.validator.addMethod("isMoney", function(value, element) {
		if(value!=null && value!=""){
			var reg = /^\d+(\.\d{1,2})?$/;   
			return this.optional(element) || reg.test(value);
		}else{return true;}
	}, "��������ྫȷ���ֵ���ȷ�Ľ��");
	
	$("#cashChangeForm").validate({
		submitHandler: function(form) {
			if(confirm(submitMsg)){
				form.submit();
			}
		},
		errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		},
		success: function(label) {
			label.text("");
		},
   		rules: {    
   			money: {    
            	 required	:	true,
            	 isMoney	:	true
            }
  		},      
  		messages: {    
  			money: {    
             	 required	: 	"��������"
            }
 		}
	});  
});
