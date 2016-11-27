jQuery().ready(function(){
	jQuery.validator.setDefaults({    
	   submitHandler: function(form) {
		   form.submit(); 
		}
	});
	
	jQuery.validator.addMethod("checkParaCode", function(value,element) {       
		var reg = /^[a-zA-Z][a-zA-Z0-9_]{3,32}$/;
		return this.optional(element) || reg.test(value);
	},"���������������ĸ��ͷ����3-32�ֽڣ�������ĸ�����»���");
	
	//�����������ֽ�       
	jQuery.validator.addMethod("byteRangeLength", function(value, element, param) {       
		var length = value.length;
		for(var i = 0; i < value.length; i++){
			if(value.charCodeAt(i) > 127){
				length++;
			}
		}
		return this.optional(element) && ( length >= param[0] && length <= param[1] );
	}, "��ȷ�������ֵ��3-32���ֽ�֮��(һ����������2���ֽ�)");
	
	//��֤��������
	jQuery.validator.addMethod("paraPortion", function(value, element) {
		var ckPCode = jQuery("#paraCode").val();
		if(ckPCode=="listing_jy_proportion" || ckPCode=="listing_js_proportion" || ckPCode=="order_jy_proportion" || ckPCode=="order_js_proportion" || ckPCode=="jy_liquidated_damages" || ckPCode=="js_liquidated_damages" || ckPCode=="goods_pay_proportion"  ){
			var reg = /^[0-9]\d?(\.\d{1,2})?$/;   
			return this.optional(element) || reg.test(value);
		}else{return true;}
	}, "�����벻����100����λС��");
	
	
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
			required: "�������������",
			checkParaCode:"���������������ĸ��ͷ����3-32�ֽڣ�������ĸ�����»���"
		},
		paraName: {
			required: "�������������"
		},
		paraValue: {
			required: "���������ֵ"
		}
	}
    });
});