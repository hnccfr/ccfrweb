$(document).ready(function(){    
    
	jQuery.validator.setDefaults({    
	   submitHandler: function(form) {
		   form.submit(); 
		}    
	});    
	 
	$('#addForm').validate({
		errorPlacement: function(error, element) {
			element.siblings("p[class='red']").text(error.text());
		},
		success: function(label) {
			label.text("");
	    },
					    
	    rules: {
	    	proTypeCode: {    
	    		required: true    
	    	},
	    	name: {    
	    		required: true    
	    	},
	    	content:{
	    		required: true
	    	}
	   },      
	   messages: {    
		   proTypeCode: {    
			   required: "此项必填"    
		   },
		   name: {    
			   required: "此项必填"    
		   },
		   content: {    
			   required: "此项必填"    
		   }
	  }
	});  
	  
});  

