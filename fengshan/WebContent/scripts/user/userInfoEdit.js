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
	
	jQuery.validator.addMethod("isRequiredBank", function(value,element) {  
		return !(document.getElementById("userClass").value != "common" && !value);
	},"����Ϊ������");
	
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
             	 required	: 	"��������������",
             	 maxlength	:	"����������̫�������Ϊ30���ַ�"
            },			
            mobile:{
				 required	:   "����д�����ֻ�����",
				 maxlength	:	"��������ֻ������������������"
			},
			area:{
				 required	:   "����д�����ڵ�ʡ����"
			},
			address:{
				maxlength	:	"���������ϸ��ַ��Ϣ̫�������Ϊ80���ַ�"
			},
			phone:{
				maxlength	:	"������ĵ绰����̫�������Ϊ20���ַ�"
			},
			fullName:{
				maxlength	:	"�������ȫ��̫�������Ϊ60���ַ�"
			},
			homePage:{
				maxlength	:	"��������Ż�̫���ˣ����Ϊ28���ַ�"
			},
			scope:{
				maxlength	:	"�������̫���˾�Ӫ��Χ̫���ˣ����Ϊ150���ַ�"
			},
			intro:{
				maxlength	:	"������ļ��̫���ˣ����Ϊ300���ַ�"
			}
 		 }
	});  
 });

function safeInfo(){
	if(confirm("��ȷ��Ҫ�޸���")){
		$("#editUserAccountForm").submit();
	}
}