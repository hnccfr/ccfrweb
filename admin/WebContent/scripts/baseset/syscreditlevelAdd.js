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
			required: "请输入信用等级"
		},
		levelName: {
			required: "请输入等级名称"
		},
		integralStart: {
			required: "请输入积分开始值",
			digits: "积分必须是整数"
		},
		integralEnd: {
			required: "请输入积分结束值",
			digits: "积分必须是整数"
		}
	}
    });
});