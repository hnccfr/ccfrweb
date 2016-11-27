$(document).ready(function(){    
	jQuery.validator.setDefaults({ 
		submitHandler: function(form) { 
			form.submit();
		} 
	}); 
	
	jQuery.validator.addMethod("isId", function(value,element) {       
		var reg = /^\d+$/;
		return this.optional(element) || reg.test(value);
	},"������ID����������");
	
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
             	 required	: 	"�����ı�Ų���Ϊ��" ,
             	 maxlength	:	"�����ı�� ���ܳ���18λ"
            },			
            name:{
				 required	:   "���������Ʋ���Ϊ��" ,
             	 maxlength	:	"���������� ���ܳ���16����"
			}
 		 }
 		});  
 });