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
	
	jQuery("#smlsAdd").validate({
	errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		},
	rules: {
		listUnturnover: {
			required: true,
			proPortion: true
		},
		listTurnover: {
			required: true,
			proPortion: true
		},
		orderUnturnover: {
			required: true,
			proPortion: true
		},
		orderTurnover: {
			required: true,
			proPortion: true
		}
	},
	messages: {
		listUnturnover: {
			required: "此项为必填项"
		},
		listTurnover: {
			required: "此项为必填项"
		},
		orderUnturnover: {
			required: "此项为必填项"
		},
		orderTurnover: {
			required: "此项为必填项"
		}
	}
    });
});