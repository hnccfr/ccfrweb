function checkSubmit(){
	var sD = $("#startDate").val();
	if(sD==null || sD==""){
		alert("��ѡ��ʼʱ��");
		return false;
	}
	var eD = $("#endDate").val();
	if(eD==null || eD==""){
		alert("��ѡ�����ʱ��");
		return false;
	}
	return true;
}
