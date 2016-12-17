jQuery().ready(function(){
	jQuery.validator.setDefaults({    
	   submitHandler: function(form) {
		   form.submit(); 
		}
	});
	
	// ��������
	jQuery.validator.addMethod("proPortion", function(value, element) {
		if(value!=null && value!=""){
			var reg = /^[0-9]\d?(\.\d{1,2})?$/;   
			return this.optional(element) || reg.test(value);
		}else{return true;}
	}, "�����벻����100����λС��");
	
	jQuery.validator.addMethod("isMoney", function(value, element) {
		if(value!=null && value!=""){
			var reg = /^\d+(\.\d{1,2})?$/;   
			return this.optional(element) || reg.test(value);
		}else{return true;}
	}, "��������ྫȷ���ֵ���ȷ�Ľ��");
	
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