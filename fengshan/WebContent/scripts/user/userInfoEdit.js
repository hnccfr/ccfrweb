$(document).ready(function(){    
	jQuery.validator.setDefaults({ 
		submitHandler: function(form) { 
			form.submit();
		} 
	});    
	
	jQuery.validator.addMethod("isZip", function(value,element) {       
		var reg = /^\d{6}$/;
		return this.optional(element) || reg.test(value);
	},"邮编必须是六位数字，请正确填写");
	
	jQuery.validator.addMethod("isRequiredBank", function(value,element) {  
		return !(document.getElementById("userClass").value != "common" && !value);
	},"此项为必填项");
	
	$("#editUserAccountForm").validate({
		errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		},
		success: function(label) {
			label.text("");
		},
   		 rules: {    
			name: {    
            	 required	:	true,
            	 maxlength	:	30
            },			
            mobile:{
	           	 required	:	true,
	           	 maxlength	:	20
			},
			area:{
	           	 required	:	true
			},
			zipCode:{
				isZip		:	true
			},
			address:{
				maxlength	:	80
			},
			phone:{
				maxlength	:	20
			},
			fullName:{
				maxlength	:	60
			},
			homePage:{
				maxlength	:	28
			},
			scope:{
				maxlength	:	150
			},
			intro:{
				maxlength	:	300
			},
			bank:{
				isRequiredBank		:	true
			},
			bankCard:{
				isRequiredBank		:	true
			}
  		 },      
  		 messages: {    
  			name: {    
             	 required	: 	"请输入您的姓名",
             	 maxlength	:	"您输入姓名太长，最多为30个字符"
            },			
            mobile:{
				 required	:   "请填写您的手机号码",
				 maxlength	:	"您输入的手机号码错误，请重新输入"
			},
			area:{
				 required	:   "请填写您所在的省市区"
			},
			address:{
				maxlength	:	"您输入的详细地址信息太长，最多为80个字符"
			},
			phone:{
				maxlength	:	"您输入的电话号码太长，最多为20个字符"
			},
			fullName:{
				maxlength	:	"您输入的全称太长，最多为60个字符"
			},
			homePage:{
				maxlength	:	"您输入的门户太长了，最多为28个字符"
			},
			scope:{
				maxlength	:	"您输入的太长了经营范围太长了，最多为150个字符"
			},
			intro:{
				maxlength	:	"您输入的简介太长了，最多为300个字符"
			}
 		 }
	});  
 });

function safeInfo(){
	if(confirm("您确定要修改吗？")){
		$("#editUserAccountForm").submit();
	}
}