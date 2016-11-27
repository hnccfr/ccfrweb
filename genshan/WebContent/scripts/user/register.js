$(function() {
	changeType();
});

function changeType() {
	if ($("#type").val() == "P") {
		$("#personal").css("display", "block");
		$("#enterprise").css("display", "none");
		$("#pe_area_select").show();//ǿ����ʾ
		$("#en_area_select").hide();//ǿ�����أ�������IE6�¿��ܵ�����
		/*****������Ϊnameֵһ���Ӷ����´�ֵʱ���ֶ���******/
		document.getElementById("en_name").disabled=true;
		document.getElementById("en_mobile").disabled=true;
		document.getElementById("en_certificateType").disabled=true;
		document.getElementById("en_certificateNum").disabled=true;
		document.getElementById("en_bank").disabled=true;
		document.getElementById("en_bankCard").disabled=true;
		document.getElementById("en_province").disabled=true;
		document.getElementById("en_city").disabled=true;
		document.getElementById("en_area").disabled=true;
		document.getElementById("en_address").disabled=true;
		document.getElementById("en_zipCode").disabled=true;
		
		document.getElementById("pe_name").disabled=false;
		document.getElementById("pe_mobile").disabled=false;
		document.getElementById("pe_certificateType").disabled=false;
		document.getElementById("pe_certificateNum").disabled=false;
		document.getElementById("pe_bank").disabled=false;
		document.getElementById("pe_bankCard").disabled=false;
		document.getElementById("pe_province").disabled=false;
		document.getElementById("pe_city").disabled=false;
		document.getElementById("pe_area").disabled=false;
		document.getElementById("pe_address").disabled=false;
		document.getElementById("pe_zipCode").disabled=false;
		
	} else if ($("#type").val() == "C") {
		$("#personal").css("display", "none");
		$("#enterprise").css("display", "block");
		$("#pe_area_select").hide();
		$("#en_area_select").show();
		document.getElementById("pe_name").disabled=true;
		document.getElementById("pe_mobile").disabled=true;
		document.getElementById("pe_certificateType").disabled=true;
		document.getElementById("pe_certificateNum").disabled=true;
		document.getElementById("pe_bank").disabled=true;
		document.getElementById("pe_bankCard").disabled=true;
		document.getElementById("pe_province").disabled=true;
		document.getElementById("pe_city").disabled=true;
		document.getElementById("pe_area").disabled=true;
		document.getElementById("pe_address").disabled=true;
		document.getElementById("pe_zipCode").disabled=true;
		
		document.getElementById("en_name").disabled=false;
		document.getElementById("en_mobile").disabled=false;
		document.getElementById("en_certificateType").disabled=false;
		document.getElementById("en_certificateNum").disabled=false;
		document.getElementById("en_bank").disabled=false;
		document.getElementById("en_bankCard").disabled=false;
		document.getElementById("en_province").disabled=false;
		document.getElementById("en_city").disabled=false;
		document.getElementById("en_area").disabled=false;
		document.getElementById("en_address").disabled=false;
		document.getElementById("en_zipCode").disabled=false;
	}
}

function validate(){
	var re= true;
	var phone=$("#en_phone").val();
	var password=$("#pe_password").val();
	var fundPassword=$("#pe_fundPassword").val();
	var tphone=/^[0-9]{1,21}$/;
	var tpassword=/^[A-Za-z0-9]{6,32}$/;
	var tfundPassword=/^[A-Za-z0-9]{6,32}$/;
	
	
	if ($("#pe_class").val() == "") {
		$("#err_pe_class").text("����Ϊ����");
		 re = false;
	} else {
		$("#err_pe_class").text("");
	}
	
	if ($("#pe_account").val() == "") {
		$("#err_pe_account").text("����Ϊ����");
		 re = false;
	}else {
		$("#err_pe_account").text("");
	}
	
	if ($("#pe_email").val() == "") {
		$("#err_pe_email").text("����Ϊ����");
		 re = false;
	}else {
		$("#err_pe_email").text("");
	}
	
	if ($("#pe_password").val() == "") {
		$("#err_pe_password").text("����Ϊ����");
		re = false;
	}else if(!(tpassword.test(password))){ 
		$("#err_pe_password").text("6~32λӢ�Ļ�����");
		re = false;
	}else {
		$("#err_pe_password").text("");
	}
	
	if ($("#pe_passwordConfirm").val() == "") {
		$("#err_pe_passwordConfirm").text("����Ϊ����");
		re = false;
	}else if ($("#pe_passwordConfirm").val() != $("#pe_password").val()) {
		$("#err_pe_passwordConfirm").text("���ε�¼�������벻һ��");
		re = false;
	} else {
		$("#err_pe_passwordConfirm").text("");
	}
	
	if ($("#pe_fundPassword").val() == "") {
		$("#err_pe_fundPassword").text("����Ϊ����");
		 re = false;
	}else if(!(tfundPassword.test(fundPassword))){ 
		$("#err_pe_fundPassword").text("6~32��Ӣ�Ļ�����");
		re = false;
	} else {
		$("#err_pe_fundPassword").text("");
	}
	
	if ($("#pe_fundPasswordConfirm").val() == "") {
		$("#err_pe_fundPasswordConfirm").text("����Ϊ����");
		 re = false;
	}else if ($("#pe_fundPasswordConfirm").val() != $("#pe_fundPassword").val()) {
		$("#err_pe_fundPasswordConfirm").text("����֧���������벻һ��");
		 re = false;
	} else {
		$("#err_pe_fundPasswordConfirm").text("");
	}
	
  if ($("#type").val() == "C") {
	if ($("#en_name").val() == "") {
		$("#err_en_name").text("����Ϊ����");
		 re = false;
	} else {
		$("#err_en_name").text("");
	}
	
	if ($("#en_fullName").val() == "") {
		$("#err_en_fullName").text("����Ϊ����");
		 re = false;
	} else {
		$("#err_en_fullName").text("");
	}
	
	if ($("#en_phone").val() == "") {
		$("#err_en_phone").text("����Ϊ����");
		 re = false;
	} else if(!(tphone.test(phone))){ 
		$("#err_pe_phone").text("�밴ʵ�������д");
		re = false;
	}else {
		$("#err_en_phone").text("");
	}
	
	if ($("#en_certificateType").val() == "") {
		$("#err_en_certificateType").text("����Ϊ����");
		 re = false;
	} else {
		$("#err_en_certificateType").text("");
	}
	
	if ($("#en_certificateNum").val() == "") {
		$("#err_en_certificateNum").text("����Ϊ����");
		 re = false;
	} else {
		$("#err_en_certificateNum").text("");
	}
	
//	if ($("#en_bank").val() == "") {
	if ($("#en_bank").val() == "" && "common" != $("#pe_class").val()) { // ��ͨ�û����м����п��Ų��Ǳ�����
		$("#err_en_bank").text("����Ϊ����");
		 re = false;
	} else {
		$("#err_en_bank").text("");
	}
	
//	if ($("#en_bankCard").val() == "") {
	if ($("#en_bankCard").val() == "" && "common" != $("#pe_class").val()) { // ��ͨ�û����м����п��Ų��Ǳ�����
		$("#err_en_bankCard").text("����Ϊ����");
		 re = false;
	} else if($("#en_bankCard").val().length >=30){
		$("#err_en_bankCard").text("��󳤶�Ϊ30");     //TODO
		re=false;
	}else {
		$("#err_en_bankCard").text("");
	}
	
	if($("#en_taxNum").val() == "") {
		$("#err_en_taxNum").text("����Ϊ����");
		 re = false;
	} else {
		$("#err_en_taxNum").text("");
	}
	
	if ($("#en_area").val() == "") {
		$("#err_en_area").text("����Ϊ����");
		 re = false;
	} else {
		$("#err_en_area").text("");
	}
	
  }else {
	  
	  if ($("#pe_name").val() == "") {
			$("#err_pe_name").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_pe_name").text("");
		}
		
		if ($("#pe_mobile").val() == "") {
			$("#err_pe_mobile").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_pe_mobile").text("");
		}
		
		if ($("#pe_certificateType").val() == "") {
			$("#err_pe_certificateType").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_pe_certificateType").text("");
		}
		
		if ($("#pe_certificateNum").val() == "") {
			$("#err_pe_certificateNum").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_pe_certificateNum").text("");
		}
		
//		if ($("#pe_bank").val() == "") {
		if ($("#pe_bank").val() == "" && "common" != $("#pe_class").val()) { // ��ͨ�û����м����п��Ų��Ǳ�����
			$("#err_pe_bank").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_pe_bank").text("");
		}
	if ($("#type").val() == "P"){
//		if ($("#pe_bankCard").val() == "") {
		if ($("#pe_bankCard").val() == "" && "common" != $("#pe_class").val()) { // ��ͨ�û����м����п��Ų��Ǳ�����
			$("#err_pe_bankCard").text("����Ϊ����");
			 re = false;
		}else if($("#pe_bankCard").val().length >=30){
			$("#err_pe_bankCard").text("��󳤶�Ϊ30");     //TODO
			re=false;
		}else {
			$("#err_pe_bankCard").text("");
		}
	}
		
		if ($("#pe_area").val() == "") {
			$("#err_pe_area").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_pe_area").text("");
		}
  }
	return re;
}

/*
 * ע����ͨ�û�ʱ���к����п��Ų�Ϊ������
 */
function changeClass(classVal) {
	var spFront = "";
	if("P" == $("#type").val()) spFront = "pe_"; // �����û�ǰ׺
	else if("C" == $("#type").val()) spFront = "en_"; // ��ҵ�û�ǰ׺
	if("common" == classVal) {
		$('#' + spFront + 'bankSp').text("");
		$('#' + spFront + 'bankCardSp').text("");
	} else {
		$('#' + spFront + 'bankSp').text("*");
		$('#' + spFront + 'bankCardSp').text("*");
	}
}