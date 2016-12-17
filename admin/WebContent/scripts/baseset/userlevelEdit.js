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
		integral: {
			required: true,
			digits: true
		}
	},
	messages: {
		integral: {
			required: "请输入积分",
			digits: "积分必须是整数"
		}
	}
    });
});

