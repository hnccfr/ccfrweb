function deleteMessage(id){
	if(confirm("ȷ��Ҫɾ������վ������")){
		jQuery.ajax({
			type	:	'POST',
			url		:	appServer + '/user/message/delete.htm',
			data	:	{id	:	id},
			success	:	function(msn){
							if(msn > 0){
								alert("ɾ���ɹ�");
								goBackToList(); 
							}
							if(msn == 0){
								alert("ɾ��ʧ�ܣ�������");
								goBackToList(); 
							}
						},
			error	:	function(){
							alert("ɾ��ʧ�ܣ�����������");
							goBackToList(); 
						}
		});
	}
}

function goBackToList(){
	window.location.href = appServer + '/user/message/list.htm';
}