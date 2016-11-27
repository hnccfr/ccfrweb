jQuery(function() {
       jQuery( "#open_bid" ).dialog({
			autoOpen: false,			
			width: 460,
			modal: true,
			buttons: {
				"确定": function() {
				    if(checkPassword()){
				       goto();
					   jQuery( this ).dialog( "close" );  
					}
				},
				"关闭": function() {
					jQuery( this ).dialog( "close" );
				}
			}
		});
		
	});
	var retFunc;
	var appServer;
	function goto(){
	  eval(  retFunc+'()');	  
	}
	function funcCheck(url,funcCode,callback){
		appServer =  url;
	    jQuery("#funcCode").val(funcCode);
	    if(callback==''){
	       alert('请传入回调函数');
	       return false;
	    }
	    retFunc = callback;	   
		jQuery.ajax({
    		type : 'POST',
    		async : false,
    		url :  appServer+ '/sys/get_func_checker.htm',
    		data : {funcCode : funcCode},
    		success : function(data) {    		
			  if(data==null||data.length==0){
			     goto();		    
				 return ;
			  }
			   var tempStr;				
			   if(data.length==1){
			      tempStr = "<input type=\"hidden\" id=\"checker\" name=\"checker\" value='"+data[0].account+"' />"
			      tempStr += data[0].name;
			   }else{
			      tempStr="<select id=\"checker\" name=\"checker\">";
			      for(var i=0;i<data.length;i++){
                    tempStr+="<option value='"+data[i].account+"'>"+data[i].name+"</option>";
				  }
				  tempStr+="</select>";
			   }
			   jQuery("#checker_tr").html(tempStr);
			   jQuery( "#open_bid" ).dialog( "open" );
			}
		});			 
	}	
	function checkPassword(){
	    var funcCode = jQuery("#funcCode").val();
	    var checker = jQuery("#checker").val();
	    var password = jQuery("#password").val();
		if(checker==''){
		  alert('复核人不能为空');
		  return false;
		}
		if(jQuery.trim(password)==''){
		  alert('复核密码不能为空');
		  return false;
		}
		var flag=true;
		jQuery.ajax({
        		type : 'POST',
        		async : false,
        		url :  appServer+'/sys/check_password.htm',
        		data : {funcCode : funcCode,checker:checker,password:password},
        		success : function(msg) {
				   if(msg=='userError'){
				      alert("该审核人无权审核该功能");
					  flag=false;
				   }else if(msg=='nullUser'){
				      alert("审核人不存在");
					  flag=false;
				   }else if(msg=='passwordFail'){
				      alert("复核密码输入有误，请重新输入");
					  flag=false;
				   }
				}
		});
	    return flag;
	}