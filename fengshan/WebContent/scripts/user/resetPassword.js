$(document).ready(function(){    
	jQuery.validator.setDefaults({ 
		submitHandler: function(form) { 
			form.submit();
		} 
	}); 
	
	jQuery.validator.addMethod("passwordType", function(value,element) { 
		var reg = /[\W_]/;
		return this.optional(element) || !reg.test(value);
	},"������������ֻ�����ĸ�����߶��ߵ����");
	
	jQuery.validator.addMethod("isSame",function(value,element) {
		var oldPassword = $("#oldPassword").val();
		if(oldPassword == value)
			return false;
		return true;
	},"������;����벻����ͬ");
	
	$('#resetPasswordForm').validate({
   		 rules: {    
			oldPassword: {    
            	 required	:	true,
            	 minlength	: 	6,
            	 maxlength	:	32,
            	 passwordType:	true
            },			
            newPassword:{
	           	 required	:	true,
	        	 minlength	: 	6,
	        	 maxlength	:	32,
	        	 isSame		:	true,
	        	 passwordType:	true
			},
			newPasswordAgain:{
	           	 required	:	true,
	        	 minlength	: 	6,
	        	 maxlength	:	32,
	        	 equalTo	:	"#newPassword",
	        	 passwordType:	true
			}
  		 },      
  		 messages: {    
  			oldPassword: {    
             	 required	: 	"������ԭ����" ,
             	 minlength	:	"���볤������Ϊ6λ" ,
             	 maxlength	:	"���볤�����Ϊ32λ"
            },			
            newPassword:{
				 required	:   "������Ҫ�޸ĵ�������" ,
             	 minlength	:	"���볤������Ϊ6λ" ,
             	 maxlength	:	"���볤�����Ϊ32λ"
			},
			newPasswordAgain:{
				 required	:   "���ٴ�����Ҫ�޸ĵ�������" ,
             	 minlength	:	"���볤������Ϊ6λ" ,
             	 maxlength	:	"���볤�����Ϊ32λ" ,
             	 equalTo	:	"�����������벻һ��"
			}
 		 }
 		});  
 });

function resetPassword(){
	if(confirm("��ȷ��Ҫ�޸ĸ�������")){
		$("#resetPasswordForm").submit();
	}
}