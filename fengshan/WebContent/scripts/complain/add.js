function validate(){
	if(jQuery("#descript").val().length < 1){
		jQuery("#descriptErr").text("Ͷ��ԭ��Ϊ���");
		return false;
	}
	if(jQuery("#descript").val().length >100){
		jQuery("#descriptErr").text("Ͷ��ԭ�������");
		return false;
	}
	return true;
}