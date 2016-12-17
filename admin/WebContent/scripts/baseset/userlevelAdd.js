jQuery().ready(function(){
	jQuery.validator.setDefaults({    
	   submitHandler: function(form) {
		   form.submit(); 
		}
	});
	
	jQuery("#smlsAdd").validate({
	errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		},
	rules: {
	    userAccount: {
			required: true
		},
		integral: {
			required: true,
			digits: true
		}
	},
	messages: {
		userAccount: {
			required: "�������Ա�ʺ�"
		},
		integral: {
			required: "���������",
			digits: "���ֱ���������"
		}
	}
    });
});