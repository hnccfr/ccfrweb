$(function() {
	changeType();
});

$(function() {
	$(".c1").change(function(){
    	$(".c2").css("width", "auto");
    	$(".c3").css("width", "auto");
    });

    $(".c2").mousedown(function(){
        	$(this).data("origWidth", $(this).css("width")).css("width", "auto");
        }).change(function(){
        	$(this).css("width", $(this).data("origWidth"));
        	$(".c3").data("origWidth", $(this).css("width")).css("width", "auto");
        });
    $(".c3").mousedown(function(){
    			$(this).data("origWidth", $(this).css("width")).css("width", "auto");
    		}).change(function(){
    			$(this).css("width", $(this).data("origWidth"));
    });

});

$(function() {
	$('.tips').poshytip({
		className: 'tip-yellowsimple',
		showOn: 'focus',
		alignTo: 'target',
		alignX: 'right',
		alignY: 'center',
		offsetX: 5
	});
});


function changeType() {
	if ($("#type").val() == "P") {
		$("#personal").css("display", "block");
		$("#enterprise").css("display", "none");
		$("#pe_bank").show();//ǿ����ʾ
		$("#en_bank").hide();//ǿ�����أ�������IE6�¿��ܵ�����
		$("#pe_area_select").show();
		$("#en_area_select").hide();
		
	} else if ($("#type").val() == "C") {
		$("#personal").css("display", "none");
		$("#enterprise").css("display", "block");
		$("#pe_bank").hide();
		$("#en_bank").show();
		$("#pe_area_select").hide();
		$("#en_area_select").show();
	}

}
function register() {
	if ($("#argument").attr("checked")) {
		if ($("#type").val() == "P") {
			if (validateData()) {
				$("#personal").submit();
			}
		} else if ($("#type").val() == "C") {
			if (validateData()) {
				$("#enterprise").submit();
			}
		}
	} else {
		alert("�����Ķ���վ����Э�飡");
	}
}
function changeCheckcode() {
	var src = appServer+"/checkcode/simple.htm?t=" + (new Date()).getTime();
	$('#imgCheckCode1').attr('src', src);
	$('#imgCheckCode2').attr('src', src);
}
function validateData() {
	var re = true;
	//�����û�
	if ($("#type").val() == "P") {
		if ($("#pe_account").val() == "") {
			$("#err_pe_account").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_pe_account").text("");
		}
		
		if ($("#pe_email").val() == "") {
			$("#err_pe_email").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_pe_email").text("");
		}
		
		if ($("#pe_password").val() == "") {
			$("#err_pe_password").text("����Ϊ����");
			 re = false;
		} else {
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
		
		if ($("#pe_certificateNum").val() == "") {
			$("#err_pe_certificateNum").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_pe_certificateNum").text("");
		}
		
//		if ($("#pe_bank").val() == "") {
		if ($("#pe_bank").val() == "" && "common" != $("#pe_userClass").val()) { // ��ͨ�û����м����п��Ų��Ǳ�����
			$("#err_pe_bank").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_pe_bank").text("");
		}
		
//		if ($("#pe_bankCard").val() == "") {
		if ($("#pe_bankCard").val() == "" && "common" != $("#pe_userClass").val()) { // ��ͨ�û����м����п��Ų��Ǳ�����
			$("#err_pe_bankCard").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_pe_bankCard").text("");
		}
		
		if ($("#pe_city").val() == "") {
			$("#err_pe_area").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_pe_area").text("");
		}
		
		if ($("#checkCode1").val() == "") {
			$("#err_checkCode1").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_checkCode1").text("");
		}
		
		return  re ;
	}
	//��ҵ�û�
	if ($("#type").val() == "C") {
		if ($("#en_account").val() == "") {
			$("#err_en_account").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_en_account").text("");
		}
		
		if ($("#en_email").val() == "") {
			$("#err_en_email").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_en_email").text("");
		}
		
		if ($("#en_password").val() == "") {
			$("#err_en_password").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_en_password").text("");
		}
		
		if ($("#en_passwordConfirm").val() == "") {
			$("#err_en_passwordConfirm").text("����Ϊ����");
			 re = false;
		}else if ($("#en_passwordConfirm").val() != $("#en_password").val()) {
			$("#err_en_passwordConfirm").text("���ε�¼�������벻һ��");
			 re = false;
		}else {
			$("#err_en_passwordConfirm").text("");
		}
		
		if ($("#en_fundPassword").val() == "") {
			$("#err_en_fundPassword").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_en_fundPassword").text("");
		}
		
		if ($("#en_fundPasswordConfirm").val() == "") {
			$("#err_en_fundPasswordConfirm").text("����Ϊ����");
			 re = false;
		}else if ($("#en_fundPasswordConfirm").val() != $("#en_fundPassword").val()) {
			$("#err_en_fundPasswordConfirm").text("����֧���������벻һ��");
			 re = false;
		} else {
			$("#err_en_fundPasswordConfirm").text("");
		}

		
		if ($("#en_name").val() == "") {
			$("#err_en_name").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_en_name").text("");
		}
		
		if ($("#en_mobile").val() == "") {
			$("#err_en_mobile").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_en_mobile").text("");
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
		} else {
			$("#err_en_phone").text("");
		}
		
		if ($("#en_certificateNum").val() == "") {
			$("#err_en_certificateNum").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_en_certificateNum").text("");
		}
		
//		if ($("#en_bank").val() == "") {
		if ($("#en_bank").val() == "" && "common" != $("#en_userClass").val()) { // ��ͨ�û����м����п��Ų��Ǳ�����
			$("#err_en_bank").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_en_bank").text("");
		}
		
//		if ($("#en_bankCard").val() == "") {
		if ($("#en_bank").val() == "" && "common" != $("#en_userClass").val()) { // ��ͨ�û����м����п��Ų��Ǳ�����
			$("#err_en_bankCard").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_en_bankCard").text("");
		}
		
		if($("#en_taxNum").val() == "") {
			$("#err_en_taxNum").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_en_taxNum").text("");
		}
		
		if ($("#en_city").val() == "") {
			$("#err_en_area").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_en_area").text("");
		}
		
		if ($("#checkCode2").val() == "") {
			$("#err_checkCode2").text("����Ϊ����");
			 re = false;
		} else {
			$("#err_checkCode2").text("");
		}
		
		return  re ;
	}

}
function showLevel(){
	var op = {
			title : 'ע�ἶ��˵��',
			drag : false,
			lock:true,
			content :'��ͨ�û����û����Բ����������Ϲ���Ȼ������ܣ����ҿ��Է���������Ϣ�����ǲ��ܽ����κ��뽻����صĲ�����<br />'+
			'�м��û���������ͨ�û������й��ܣ����Խ����µ��������뽻�ס�<br />'+
			'�߼��û��������м��û������й��ܣ����Խ��й��Ʋ�����',
			yesFn : true,
			yesText : '�ر�'
		};
		art.dialog(op);
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

