jQuery().ready(function(){
	jQuery.validator.setDefaults({    
	   submitHandler: function(form) {
		   form.submit(); 
		}
	});
	
	// 比例设置
	jQuery.validator.addMethod("proPortion", function(value, element) {
		if(value!=null && value!=""){
			var reg = /^[0-9]\d?(\.\d{1,2})?$/;   
			return this.optional(element) || reg.test(value);
		}else{return true;}
	}, "请输入不超过100的两位小数");
	
	jQuery.validator.addMethod("isMoney", function(value, element) {
		if(value!=null && value!=""){
			var reg = /^\d+(\.\d{1,2})?$/;   
			return this.optional(element) || reg.test(value);
		}else{return true;}
	}, "请输入最多精确到分的正确的金额");
	
	jQuery("#smlsAdd").validate({
	errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		},
	rules: {
		turnoverAmount: {
			isMoney: true
		},
		listUnturnover: {
			proPortion: true
		},
		listTurnover: {
			proPortion: true
		},
		orderUnturnover: {
			proPortion: true
		},
		orderTurnover: {
			proPortion: true
		}
	},
	messages: {
		
	}
    });
});