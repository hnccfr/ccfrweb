$(document).ready(function(){    
	jQuery.validator.addMethod("isMoney", function(value, element) {
		if(value!=null && value!=""){
			var reg = /^\d+(\.\d{1,2})?$/;   
			return this.optional(element) || reg.test(value);
		}else{return true;}
	}, "请输入最多精确到分的正确的金额");
	
	$("#activeForm").validate({
		submitHandler: function(form) {
			if(confirm("确定要激活吗？")){
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
  			   required	:	"此项为必填项"
           },
           fundAccount: {    
          	   required	:	"此项为必填项"
           },
           bankNo: {
           	   required	:	"此项为必填项"
	       },
	       bankAccount: {
           	   required	:	"此项为必填项"
	       },
	       balance: {
           	   required	:	"此项为必填项"
	       },
	       idKind: {
           	   required	:	"此项为必填项"
	       },
	       idNo: {
           	   required	:	"此项为必填项"
	       }
 		}
	});  
});