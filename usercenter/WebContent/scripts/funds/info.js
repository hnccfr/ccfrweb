$(document).ready(function(){    
	jQuery.validator.setDefaults({ 
		submitHandler: function(form) {
			form.submit();
		} 
	});

	jQuery.validator.addMethod("isMoney", function(value, element) {
		if(value!=null && value!=""){
			var reg = /^\d*(\.\d{1,2})?$/;   
			return this.optional(element) || reg.test(value);
		}else{return true;}
	}, "��������ྫȷ���ֵ���ȷ�Ľ��");
	
	$("#cashChangeForm").validate({
		errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		},
		success: function(label) {
			label.text("");
		},
   		rules: {    
			cash: {    
            	 required	:	true,
            	 isMoney	:	true
            }
  		},      
  		messages: {    
  			cash: {    
             	 required	: 	"��������"
            }
 		}
	});  
});

function changeType(cashType){
	if(cashType == 'inCash'){
		$("#inCash").attr("class","cursor");
		$("#outCash").attr("class","");
		$("#cashType").attr("value","income");
	}
	else{
		$("#outCash").attr("class","cursor");
		$("#inCash").attr("class","");	
		$("#cashType").attr("value","outcome");
	}
}