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
			required: "����Ϊ������"
		},
		listTurnover: {
			required: "����Ϊ������"
		},
		orderUnturnover: {
			required: "����Ϊ������"
		},
		orderTurnover: {
			required: "����Ϊ������"
		}
	}
    });
});