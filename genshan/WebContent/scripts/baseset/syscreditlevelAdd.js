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
	    creditLevel: {
			required: true
		},
	    levelName: {
			required: true
		},
		integralStart: {
			required: true,
			digits: true
		},
		integralEnd: {
			required: true,
			digits: true
		}
	},
	messages: {
		creditLevel: {
			required: "���������õȼ�"
		},
		levelName: {
			required: "������ȼ�����"
		},
		integralStart: {
			required: "��������ֿ�ʼֵ",
			digits: "���ֱ���������"
		},
		integralEnd: {
			required: "��������ֽ���ֵ",
			digits: "���ֱ���������"
		}
	}
    });
});