$(document).ready(function(){    
	jQuery.validator.setDefaults({ 
		submitHandler: function(form) { 
			form.submit();
		} 
	});    
	
	jQuery.validator.addMethod("isZip", function(value,element) {       
		var reg = /^\d{6}$/;
		return this.optional(element) || reg.test(value);
	},"�ʱ��������λ���֣�����ȷ��д");
	
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
             	 required	: 	"����������" ,
             	 minlength	:	"��������Ϊ2λ" ,
             	 maxlength	:	"������󳤶Ȳ��ܳ���32λ"
            },			
            phone:{
				 required	:   "������绰����" ,
             	 maxlength	:	"�绰�����������������ȷ�ĵ绰����"
			},
			area:{
				 required	:   "��ѡ�������ڵ�����"
			},
			address:{
				required	:	"������������ϸ��ַ",
				maxlength	:	"���������ϸ��ַ��Ϣ̫��"
			},
			storehouse:{
				maxlength	:	"������Ĳֿ�����̫��"
			},
			comments:{
				maxlength	:	"������ı�ע��Ϣ̫��"
			}
 		 }
 		});  
 });
