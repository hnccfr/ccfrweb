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
	
	$("#wishOrderWritFrom").validate({
		errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		},
		success: function(label) {
			label.text("");
		},
   		 rules: {    
			linkMan: {    
            	 required	:	true,
            	 minlength	: 	2,
            	 maxlength	:	32
            },			
            phone:{
	           	 required	:	true,
	        	 maxlength	:	20
			},
			area:{
	           	 required	:	true
			},
			address:{
				required	:	true,
				maxlength	:	80
			},
			zipCode:{
				isZip		:	true
			},
			storehouse:{
				maxlength	:	30
			},
			comments:{
				maxlength	:	160
			}
  		 },      
  		 messages: {    
  			linkMan: {    
             	 required	: 	"请输入姓名" ,
             	 minlength	:	"姓名至少为2位" ,
             	 maxlength	:	"姓名最大长度不能超过32位"
            },			
            phone:{
				 required	:   "请输入电话号码" ,
             	 maxlength	:	"电话号码过长，请输入正确的电话号码"
			},
			area:{
				 required	:   "请选择您所在的区域"
			},
			address:{
				required	:	"请输入您的详细地址",
				maxlength	:	"您输入的详细地址信息太长"
			},
			storehouse:{
				maxlength	:	"您输入的仓库名称太长"
			},
			comments:{
				maxlength	:	"您输入的备注信息太长"
			}
 		 }
 		});  
 });
