$(document).ready(function(){    
	jQuery.validator.addMethod("isMoney", function(value, element) {
		if(value!=null && value!=""){
			var reg = /^\d+(\.\d{1,2})?$/;   
			return this.optional(element) || reg.test(value);
		}else{return true;}
	}, "��������ྫȷ���ֵ���ȷ�Ľ��");
	
	$("#activeForm").validate({
		submitHandler: function(form) {
			if(confirm("ȷ��Ҫ������")){
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
   			tradeAccount: {    
            	 required	:	true
            },
            fundAccount: {    
           	 required	:	true
            },
            bankNo: {
            	required	:	true
	        },
	        bankAccount: {
            	required	:	true
	        },
	        balance: {
            	required	:	true,
	           	isMoney	:	true
	        },
	        idKind: {
            	required	:	true
	        },
	        idNo: {
            	required	:	true
	        }
            
  		},      
  		messages: {
  		   tradeAccount: {    
  			   required	:	"����Ϊ������"
           },
           fundAccount: {    
          	   required	:	"����Ϊ������"
           },
           bankNo: {
           	   required	:	"����Ϊ������"
	       },
	       bankAccount: {
           	   required	:	"����Ϊ������"
	       },
	       balance: {
           	   required	:	"����Ϊ������"
	       },
	       idKind: {
           	   required	:	"����Ϊ������"
	       },
	       idNo: {
           	   required	:	"����Ϊ������"
	       }
 		}
	});  
});