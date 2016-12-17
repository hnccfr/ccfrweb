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
	    memberLevel: {
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
		memberLevel: {
			required: "请输入会员级别"
		},
		levelName: {
			required: "请输入级别名称"
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
