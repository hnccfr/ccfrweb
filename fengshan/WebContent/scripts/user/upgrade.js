function upGrade(roleName){
	jQuery.ajax({
      		type	:   'POST',
       	 	url     :   appServer+'/user/upgrade/apply.htm',
        	data   	:   {roleName   :   roleName},
        	success :   function(msn){
							if(msn > 0){
								document.getElementById("success").innerHTML = "�����ύ�ɹ����������뽫�ᾡ�챻����";
								document.getElementById("success").style.display = "block";
								document.getElementById("fail").style.display = "none";
								//alert("�����ύ�ɹ����������뽫�ᾡ�챻����");
								//window.location.href = appServer+'/user/upgrade/apply.htm';
							}else if(msn == 0){
								document.getElementById("fail").innerHTML = "�������쳣�������ύʧ�ܣ������ԣ�";
								document.getElementById("fail").style.display = "block";
								document.getElementById("success").style.display = "none";
							}else if(msn == -1){
								document.getElementById("fail").innerHTML = "��������������������У������ٴ��ύ����";
								document.getElementById("fail").style.display = "block";
								document.getElementById("success").style.display = "none";
							}else{
								document.getElementById("fail").innerHTML = "�Բ���������Ľ�ɫ���ڵ�ǰ���Ľ�ɫ";
								document.getElementById("fail").style.display = "block";
								document.getElementById("success").style.display = "none";
							}
						}
	});
}