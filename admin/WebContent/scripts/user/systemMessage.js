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
             	 required	: 	"�������ռ����˺�"
            },			
            title:{
				 required	:   "������վ���ű���",
				 maxlength	:	"������ı���̫�������Ϊ30���ַ�"
			},
			content:{
				 required	:   "������վ��������",
				 maxlength	:	"�����������̫�������Ϊ300���ַ�"
			}
 		 }
 		});  
});

function deleteUserMessage(id){
	if(confirm("���Ĳ�������ʹ���û����ٿ�������վ���ţ�ȷ��ɾ����")){
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
					$("#receAccount").append("<span>��վ���Ų��������Ľ�����</span>");
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
	if(confirm("���Ĳ�������ʹ�����ռ��˲��ٿ�������վ���ţ�ȷ��ɾ����")){
		window.location.href = appServer + '/message/deleteAll.htm?id=' + id;
	}
}
