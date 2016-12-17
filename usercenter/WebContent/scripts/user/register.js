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
		$("#pe_bank").show();//强制显示
		$("#en_bank").hide();//强制隐藏，避免在IE6下可能的隐患
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
		alert("请先阅读网站服务协议！");
	}
}
function changeCheckcode() {
	var src = appServer+"/checkcode/simple.htm?t=" + (new Date()).getTime();
	$('#imgCheckCode1').attr('src', src);
	$('#imgCheckCode2').attr('src', src);
}
function validateData() {
	var re = true;
	//个人用户
	if ($("#type").val() == "P") {
		if ($("#pe_account").val() == "") {
			$("#err_pe_account").text("此项为必填");
			 re = false;
		} else {
			$("#err_pe_account").text("");
		}
		
		if ($("#pe_email").val() == "") {
			$("#err_pe_email").text("此项为必填");
			 re = false;
		} else {
			$("#err_pe_email").text("");
		}
		
		if ($("#pe_password").val() == "") {
			$("#err_pe_password").text("此项为必填");
			 re = false;
		} else {
			$("#err_pe_password").text("");
		}
		
		if ($("#pe_passwordConfirm").val() == "") {
			$("#err_pe_passwordConfirm").text("此项为必填");
			 re = false;
		}else if ($("#pe_passwordConfirm").val() != $("#pe_password").val()) {
			$("#err_pe_passwordConfirm").text("两次登录密码输入不一致");
			 re = false;
		} else {
			$("#err_pe_passwordConfirm").text("");
		}

		if ($("#pe_fundPassword").val() == "") {
			$("#err_pe_fundPassword").text("此项为必填");
			 re = false;
		} else {
			$("#err_pe_fundPassword").text("");
		}
		
		if ($("#pe_fundPasswordConfirm").val() == "") {
			$("#err_pe_fundPasswordConfirm").text("此项为必填");
			 re = false;
		}else if ($("#pe_fundPasswordConfirm").val() != $("#pe_fundPassword").val()) {
			$("#err_pe_fundPasswordConfirm").text("两次支付密码输入不一致");
			 re = false;
		} else {
			$("#err_pe_fundPasswordConfirm").text("");
		}
		
		if ($("#pe_name").val() == "") {
			$("#err_pe_name").text("此项为必填");
			 re = false;
		} else {
			$("#err_pe_name").text("");
		}
		
		if ($("#pe_mobile").val() == "") {
			$("#err_pe_mobile").text("此项为必填");
			 re = false;
		} else {
			$("#err_pe_mobile").text("");
		}
		
		if ($("#pe_certificateNum").val() == "") {
			$("#err_pe_certificateNum").text("此项为必填");
			 re = false;
		} else {
			$("#err_pe_certificateNum").text("");
		}
		
//		if ($("#pe_bank").val() == "") {
		if ($("#pe_bank").val() == "" && "common" != $("#pe_userClass").val()) { // 普通用户银行及银行卡号不是必填项
			$("#err_pe_bank").text("此项为必填");
			 re = false;
		} else {
			$("#err_pe_bank").text("");
		}
		
//		if ($("#pe_bankCard").val() == "") {
		if ($("#pe_bankCard").val() == "" && "common" != $("#pe_userClass").val()) { // 普通用户银行及银行卡号不是必填项
			$("#err_pe_bankCard").text("此项为必填");
			 re = false;
		} else {
			$("#err_pe_bankCard").text("");
		}
		
		if ($("#pe_city").val() == "") {
			$("#err_pe_area").text("此项为必填");
			 re = false;
		} else {
			$("#err_pe_area").text("");
		}
		
		if ($("#checkCode1").val() == "") {
			$("#err_checkCode1").text("此项为必填");
			 re = false;
		} else {
			$("#err_checkCode1").text("");
		}
		
		return  re ;
	}
	//企业用户
	if ($("#type").val() == "C") {
		if ($("#en_account").val() == "") {
			$("#err_en_account").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_account").text("");
		}
		
		if ($("#en_email").val() == "") {
			$("#err_en_email").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_email").text("");
		}
		
		if ($("#en_password").val() == "") {
			$("#err_en_password").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_password").text("");
		}
		
		if ($("#en_passwordConfirm").val() == "") {
			$("#err_en_passwordConfirm").text("此项为必填");
			 re = false;
		}else if ($("#en_passwordConfirm").val() != $("#en_password").val()) {
			$("#err_en_passwordConfirm").text("两次登录密码输入不一致");
			 re = false;
		}else {
			$("#err_en_passwordConfirm").text("");
		}
		
		if ($("#en_fundPassword").val() == "") {
			$("#err_en_fundPassword").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_fundPassword").text("");
		}
		
		if ($("#en_fundPasswordConfirm").val() == "") {
			$("#err_en_fundPasswordConfirm").text("此项为必填");
			 re = false;
		}else if ($("#en_fundPasswordConfirm").val() != $("#en_fundPassword").val()) {
			$("#err_en_fundPasswordConfirm").text("两次支付密码输入不一致");
			 re = false;
		} else {
			$("#err_en_fundPasswordConfirm").text("");
		}

		
		if ($("#en_name").val() == "") {
			$("#err_en_name").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_name").text("");
		}
		
		if ($("#en_mobile").val() == "") {
			$("#err_en_mobile").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_mobile").text("");
		}
		
		if ($("#en_fullName").val() == "") {
			$("#err_en_fullName").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_fullName").text("");
		}
		
		if ($("#en_phone").val() == "") {
			$("#err_en_phone").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_phone").text("");
		}
		
		if ($("#en_certificateNum").val() == "") {
			$("#err_en_certificateNum").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_certificateNum").text("");
		}
		
//		if ($("#en_bank").val() == "") {
		if ($("#en_bank").val() == "" && "common" != $("#en_userClass").val()) { // 普通用户银行及银行卡号不是必填项
			$("#err_en_bank").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_bank").text("");
		}
		
//		if ($("#en_bankCard").val() == "") {
		if ($("#en_bank").val() == "" && "common" != $("#en_userClass").val()) { // 普通用户银行及银行卡号不是必填项
			$("#err_en_bankCard").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_bankCard").text("");
		}
		
		if($("#en_taxNum").val() == "") {
			$("#err_en_taxNum").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_taxNum").text("");
		}
		
		if ($("#en_city").val() == "") {
			$("#err_en_area").text("此项为必填");
			 re = false;
		} else {
			$("#err_en_area").text("");
		}
		
		if ($("#checkCode2").val() == "") {
			$("#err_checkCode2").text("此项为必填");
			 re = false;
		} else {
			$("#err_checkCode2").text("");
		}
		
		return  re ;
	}

}
function showLevel(){
	var op = {
			title : '注册级别说明',
			drag : false,
			lock:true,
			content :'普通用户：用户可以操作个人资料管理等基本功能，并且可以发布供求信息，但是不能进行任何与交易相关的操作。<br />'+
			'中级用户：包含普通用户的所有功能，可以进行下单或报名参与交易。<br />'+
			'高级用户：包含中级用户的所有功能，可以进行挂牌操作。',
			yesFn : true,
			yesText : '关闭'
		};
		art.dialog(op);
}

/*
 * 注册普通用户时银行和银行卡号不为必填项
 */
function changeClass(classVal) {
	var spFront = "";
	if("P" == $("#type").val()) spFront = "pe_"; // 个人用户前缀
	else if("C" == $("#type").val()) spFront = "en_"; // 企业用户前缀
	if("common" == classVal) {
		$('#' + spFront + 'bankSp').text("");
		$('#' + spFront + 'bankCardSp').text("");
	} else {
		$('#' + spFront + 'bankSp').text("*");
		$('#' + spFront + 'bankCardSp').text("*");
	}
}

