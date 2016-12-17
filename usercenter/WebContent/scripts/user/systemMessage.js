function deleteMessage(id){
	if(confirm("确定要删除该条站内信吗？")){
		jQuery.ajax({
			type	:	'POST',
			url		:	appServer + '/user/message/delete.htm',
			data	:	{id	:	id},
			success	:	function(msn){
							if(msn > 0){
								alert("删除成功");
								goBackToList(); 
							}
							if(msn == 0){
								alert("删除失败，请重试");
								goBackToList(); 
							}
						},
			error	:	function(){
							alert("删除失败，服务器错误");
							goBackToList(); 
						}
		});
	}
}

function goBackToList(){
	window.location.href = appServer + '/user/message/list.htm';
}