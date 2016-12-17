$(document).ready(function(){    
	jQuery.validator.setDefaults({ 
		submitHandler: function(form) { 
			form.submit();
		} 
	}); 
	
	jQuery.validator.addMethod("isId", function(value,element) {       
		var reg = /^\d+$/;
		return this.optional(element) || reg.test(value);
	},"分中心ID请输入整数");
	
	$('#substationAdd').validate({
   		 rules: {    
			id: {    
            	 required	:	true,
            	 maxlength	:	18,
            	 isId:	true
            },			
            name:{
	           	 required	:	true,
	        	 maxlength	:	16
			}
  		 },      
  		 messages: {    
  			id: {    
             	 required	: 	"分中心编号不能为空" ,
             	 maxlength	:	"分中心编号 不能超过18位"
            },			
            name:{
				 required	:   "分中心名称不能为空" ,
             	 maxlength	:	"分中心名称 不能超过16个字"
			}
 		 }
 		});  
 });