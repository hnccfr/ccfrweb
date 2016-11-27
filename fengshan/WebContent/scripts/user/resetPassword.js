$(document).ready(function(){    
	jQuery.validator.setDefaults({ 
		submitHandler: function(form) { 
			form.submit();
		} 
	}); 
	
	jQuery.validator.addMethod("passwordType", function(value,element) { 
		var reg = /[\W_]/;
		return this.optional(element) || !reg.test(value);
	},"密码必须是数字或者字母，或者二者的组合");
	
	jQuery.validator.addMethod("isSame",function(value,element) {
		var oldPassword = $("#oldPassword").val();
		if(oldPassword == value)
			return false;
		return true;
	},"新密码和旧密码不能相同");
	
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
             	 required	: 	"请输入原密码" ,
             	 minlength	:	"密码长度至少为6位" ,
             	 maxlength	:	"密码长度最多为32位"
            },			
            newPassword:{
				 required	:   "请输入要修改的新密码" ,
             	 minlength	:	"密码长度至少为6位" ,
             	 maxlength	:	"密码长度最多为32位"
			},
			newPasswordAgain:{
				 required	:   "请再次输入要修改的新密码" ,
             	 minlength	:	"密码长度至少为6位" ,
             	 maxlength	:	"密码长度最多为32位" ,
             	 equalTo	:	"两次输入密码不一致"
			}
 		 }
 		});  
 });

function resetPassword(){
	if(confirm("您确定要修改该密码吗？")){
		$("#resetPasswordForm").submit();
	}
}