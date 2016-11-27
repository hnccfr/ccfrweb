$(document).ready(function(){    
    
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
//			   digits: "������������"    
//		   },
//		   badComment: {    
//			   digits: "������������"    
//		   }
	  }
	});  
	  
});  

