$(document).ready(function(){    
    
	jQuery.validator.setDefaults({    
	   submitHandler: function(form) {
		   form.submit(); 
		}    
	});    
	 	
	// 比例设置
	jQuery.validator.addMethod("proPortion", function(value, element) {
		if(value!=null && value!=""){
			var reg = /^[0-9]\d?(\.\d{1,2})?$/;   
			return this.optional(element) || reg.test(value);
		}else{return true;}
	}, "请输入不超过100的两位小数");
	
	$('#addForm').validate({
		errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		},
		success: function(label) {
			label.text("");
	    },
					    
	    rules: {
//	    	goodComment: {    
//	    		digits: true
//	    	},
//	    	badComment: {    
//	    		digits: true    
//	    	},
	    	listingJyProportion: {    
	    		proPortion: true    
	    	},
	    	listingJsProportion:{
	    		proPortion: true
	    	},
	    	orderJyProportion: {    
	    		proPortion: true
	    	},
	    	orderJsProportion: {    
	    		proPortion: true
	    	}
	   },      
	   messages: {    
//		   goodComment: {    
//			   digits: "必须输入数字"    
//		   },
//		   badComment: {    
//			   digits: "必须输入数字"    
//		   }
	  }
	});  
	  
});  

