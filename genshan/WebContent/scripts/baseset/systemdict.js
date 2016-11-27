jQuery().ready(function(){
	jQuery.validator.setDefaults({    
	   submitHandler: function(form) {
		   form.submit(); 
		}
	});
	
	jQuery.validator.addMethod("checkParaCode", function(value,element) {       
		var reg = /^[a-zA-Z][a-zA-Z0-9_]{3,32}$/;
		return this.optional(element) || reg.test(value);
	},"参数编码必须是字母开头允许3-32字节，允许字母数字下划线");
	
	//中文字两个字节       
	jQuery.validator.addMethod("byteRangeLength", function(value, element, param) {       
		var length = value.length;
		for(var i = 0; i < value.length; i++){
			if(value.charCodeAt(i) > 127){
				length++;
			}
		}
		return this.optional(element) && ( length >= param[0] && length <= param[1] );
	}, "请确保输入的值在3-32个字节之间(一个中文字算2个字节)");
	
	//验证比例设置
	jQuery.validator.addMethod("paraPortion", function(value, element) {
		var ckPCode = jQuery("#paraCode").val();
		if(ckPCode=="listing_jy_proportion" || ckPCode=="listing_js_proportion" || ckPCode=="order_jy_proportion" || ckPCode=="order_js_proportion" || ckPCode=="jy_liquidated_damages" || ckPCode=="js_liquidated_damages" || ckPCode=="goods_pay_proportion"  ){
			var reg = /^[0-9]\d?(\.\d{1,2})?$/;   
			return this.optional(element) || reg.test(value);
		}else{return true;}
	}, "请输入不超过100的两位小数");
	
	
	jQuery("#smlsAdd").validate({
	errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		},
	rules: {
	    paraCode: {
			required: true,
			checkParaCode:true
		},
		paraName: {
			required: true
		},
		paraValue: {
			required: true,
			paraPortion: true
		}
	},
	messages: {
		paraCode: {
			required: "请输入参数编码",
			checkParaCode:"参数编码必须是字母开头允许3-32字节，允许字母数字下划线"
		},
		paraName: {
			required: "请输入参数名称"
		},
		paraValue: {
			required: "请输入参数值"
		}
	}
    });
});