$(document).ready(function(){    
    
	jQuery.validator.setDefaults({    
	   submitHandler: function(form) {
		   form.submit(); 
		}    
	});    
	 
	// 属性key
	jQuery.validator.addMethod("isKey", function(value, element) {
		var reg = /^\w+$/;
		return this.optional(element) || reg.test(value);
	}, "只能输入英文字母、数字或者下划线");
	
	// 排序号
	jQuery.validator.addMethod("isRank", function(value, element) {
		var reg = /^\d{1,2}$/;
		return this.optional(element) || reg.test(value);
	}, "只能输入2位数字");
	
	// 预设值 hasText
	jQuery.validator.addMethod("hasText", function(value, element,para) {
		var ckTyep = jQuery(para).val();
		var length = value.length;
		if(ckTyep=="checkbox" || ckTyep=="CHECKBOX" || ckTyep=="radio" || ckTyep=="RADIO" || ckTyep=="select" || ckTyep=="SELECT"){
			var reg = /^[a-zA-Z0-9_\u4e00-\u9fa5]+[:|：][a-zA-Z0-9_\u4e00-\u9fa5]+(-[a-zA-Z0-9_\u4e00-\u9fa5]+[:|：][a-zA-Z0-9_\u4e00-\u9fa5]+)*$/;   
			return this.optional(element) || ( length>1 && reg.test(value));
		}else{return true;}
	}, "请输入预设值,格式：key1:value1-key2:value2");

	$('#addForm').validate({
		errorPlacement: function(error, element) {
			element.siblings("p[class='red']").text(error.text());
		},
		success: function(label) {
			label.text("");
	    },
					    
	    rules: {
	    	keyName: {    
	    		required: true,
	    		isKey: true
	    	},
	    	keyTitle: {    
	    		required: true    
	    	},
	    	inputType: {    
	    		required: true    
	    	},
	    	text:{
	    		hasText:"#inputType"
	    	},
	    	rank: {    
	    		required: true,
	    		isRank: true
	    	}
	   },      
	   messages: {    
		   keyName: {    
			   required: "此项必填"    
		   },
		   keyTitle: {    
			   required: "此项必填"    
		   },
		   inputType: {    
			   required: "此项必填"    
		   },
		   rank: {    
			   required: "此项必填"    
		   }
	  }
	});  
	  
});  

