$(document).ready(function(){    
	jQuery.validator.setDefaults({ 
		submitHandler: function(form) { 
			form.submit();
		} 
	}); 
	
	$('#sendMessageForm').validate({
		 errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		 },
		 success: function(label) {
			label.text("");
		 },
   		 rules: {    
			userAccounts: {    
            	 required	:	true
            },			
            title:{
	           	 required	:	true,
	           	 maxlength	:	30
			},
			content:{
	           	 required	:	true,
	           	 maxlength	:	300
			}
  		 },      
  		 messages: {    
  			userAccounts: {    
             	 required	: 	"请输入收件人账号"
            },			
            title:{
				 required	:   "请输入站内信标题",
				 maxlength	:	"您输入的标题太长，最多为30个字符"
			},
			content:{
				 required	:   "请输入站内信内容",
				 maxlength	:	"您输入的内容太长，最多为300个字符"
			}
 		 }
 		});  
});

function deleteUserMessage(id){
	if(confirm("您的操作将会使该用户不再看到此条站内信，确认删除吗？")){
		window.location.href = appServer + '/message/delete.htm?id=' + id;
	}
}

function goToList(){
	window.location.href = appServer + '/message/list.htm';
}

function getMore(id,systemMessageId){
	jQuery.ajax({
		type	:	"POST",
		url		:	appServer + "/message/more.htm",
		data	:	{
						id	:	id,
						systemMessageId	:systemMessageId
					},
		success	:	function(msn){
			if(msn != null){
				if(msn.length == 0){
					$("#receAccount").append("<span>该站内信并无其他的接收者</span>");
				}
				for(var i=0; i<msn.length; i++){
					$("#receAccount").append("<span>"+msn[i]+"</span>");			
				}
				$("#more").attr("style","display:none");
			}
		}
	})
}

function deleteAll(id){
	if(confirm("您的操作将会使所有收件人不再看到此条站内信，确认删除吗？")){
		window.location.href = appServer + '/message/deleteAll.htm?id=' + id;
	}
}
