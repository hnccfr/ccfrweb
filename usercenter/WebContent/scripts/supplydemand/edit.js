$(function() {
	changeType();
});

function changeType() {
	if ($("input[name='infoType']:checked").val() == "supply") {
		$("#storehouse1").show();
		$("#storehouse2").show();
		$("#takedeliveryS").hide();
		$("#deliveryS").show();
	}else if ($("input[name='infoType']:checked").val() == "demand") {
		$("#storehouse1").hide();
		$("#storehouse2").hide();
		$("#deliveryS").hide();
		$("#takedeliveryS").show();
		jQuery("#storehouse").attr("value","");
	}
}

/**
 * ��֤������Ϣ����
 * @author tanhl
 * @return
 */
function validateForm() {
	var effectiveStartDateObj = $("#effectiveStartDate");
	var effectiveEndDateObj = $("#effectiveEndDate");
	var deliveryDateObj = $("#deliveryDate");
	var quantityObj = $('#quantity'); 
	var zipCodeObj = $("#zipCode");
	var phoneObj = $("#phone");
	
	if (quantityObj) {
		var quantity = quantityObj.val();
		var re = /^[\d]+$/;
		if (quantity == "") {
			quantityObj.focus();
			showRemindMessage('quantity_remind_show_message', '����Ϊ�����');
			return false;
		} else if (quantity.length > 12) {
			quantityObj.focus();
			showRemindMessage('quantity_remind_show_message', '����Ϊ���볤�ȹ�����');
			return false;
		} else if (!(re.test(quantity))) {
			quantityObj.focus();
			showRemindMessage('quantity_remind_show_message', '��������ȷ����������������!');
			return false;
		} else {
			clearRemindMessage('quantity_remind_show_message'); // �����ʾ
		}
		quantity = Number(quantity);
	}
	
	if (!validatePrice()) {
		return false;
	}
	

	if(!validatePictures()){
		return false;
	}

	if (effectiveStartDateObj && effectiveEndDateObj && deliveryDateObj) {
		var effectiveStartDate = effectiveStartDateObj.val();
		var effectiveEndDate = effectiveEndDateObj.val();
		var deliveryDate = deliveryDateObj.val();
		if (effectiveStartDate == "") {
			effectiveStartDateObj.focus();
			showRemindMessage('effectiveStartDate_remind_show_message',
					'��ʼʱ��Ϊ�����');
			return false;
		} else {
			clearRemindMessage('effectiveStartDate_remind_show_message');
		}
		if (effectiveEndDate == "") {
			effectiveEndDateObj.focus();
			showRemindMessage('effectiveEndDate_remind_show_message',
					'��ֹʱ��Ϊ������');
			return false;
		} else {
			clearRemindMessage('effectiveEndDate_remind_show_message');
		}
		if (deliveryDate == "") {
			deliveryDateObj.focus();
			showRemindMessage('deliveryDate_remind_show_message', '����ʱ��Ϊ�����');
			return false;
		} else {
			clearRemindMessage('deliveryDate_remind_show_message'); // �����ʾ
		}
		var days = daysBetween(effectiveEndDate, effectiveStartDate);
		var today = new Date();
		var day = today.getDate();
		var month = today.getMonth()+1;
		var year = today.getFullYear();
		if (daysBetween(effectiveEndDate, year + "-" + month + "-" + day) < 0) {
			effectiveEndDateObj.focus();
			showRemindMessage('effectiveEndDate_remind_show_message',
					'��ֹʱ�����Ҫ���ڵ��ڽ��죡');
			return false;
		} else {
			clearRemindMessage('effectiveEndDate_remind_show_message');
		}
		if (days < 0) {
			effectiveStartDateObj.focus();
			showRemindMessage('effectiveStartDate_remind_show_message',
					'��ʼʱ�����Ҫ���ڽ�ֹʱ�䣡');
			return false;
		} else {
			clearRemindMessage('effectiveStartDate_remind_show_message');
		}
		if (!(daysBetween(deliveryDate, effectiveStartDate) >= 0 && daysBetween(deliveryDate, effectiveEndDate) <= 0)){
			deliveryDateObj.focus();
			showRemindMessage('deliveryDate_remind_show_message',
			'����ʱ�����Ҫ�ڿ�ʼ�ͽ�ֹʱ��֮�䣡');
			return false;
		} else if (daysBetween(deliveryDate, year + "-" + month + "-" + day) < 0  ) {
			deliveryDateObj.focus();
			showRemindMessage('deliveryDate_remind_show_message',
			'����ʱ�������ڵ��ڽ��죡');
			return false;
		}else {
			clearRemindMessage('deliveryDate_remind_show_message');
		}
	}
	
	if (phoneObj) {
		var phone = phoneObj.val();
		//var re = /^[\d]+$/;
		if (phone == "") {
			phoneObj.focus();
			showRemindMessage('phone_remind_show_message', '��ϵ�绰Ϊ�����');
			return false;
		} else if (phone.length > 20){
			phoneObj.focus();
			showRemindMessage('phone_remind_show_message', '��ϵ�绰���ȹ�����');
			return false;
		} /*else if (!(re.test(phone))) {
			phoneObj.focus();
			showRemindMessage('phone_remind_show_message', '����ĵ绰�����ʽ����ȷ!');
			return false;
		}*/ else {
			clearRemindMessage('phone_remind_show_message'); // �����ʾ
		}
	}
	
	if (zipCodeObj) {
		var zipCode = zipCodeObj.val();
		var re = /^[0-9]{6}$/;
		if (zipCode != "" && !(re.test(zipCode)) ){
			zipCodeObj.focus();
			showRemindMessage('zipCode_remind_show_message', '���������ʽ����ȷ��');
			return false;
		} else {
			clearRemindMessage('zipCode_remind_show_message'); // �����ʾ
		}
	}

	return true;
}

function validatePrice() {return true;
	var priceObj = $("#priceDesc"); // ������Ϣ����
	var flag = priceObj.val().indexOf(".");
	if (flag == -1) {
		var priceStr = priceObj.val() + ".";
	} else {
		var priceStr = priceObj.val();
	}
	var flag = priceStr.indexOf(".");
	var priceStr2 = priceStr.substring(0,flag);
	var valuationUnitObj = $("#valuationUnit"); // �Ƽ۵�λ
	if (priceObj && valuationUnitObj) {
		var price = priceObj.val();
		var valuationUnit = valuationUnitObj.val();
		if (price == "") {
			priceObj.focus();
			showRemindMessage('price_remind_show_message', '�۸�Ϊ�����');
			return false;
		} else if (price.length > 15) {
			priceObj.focus();
			showRemindMessage('price_remind_show_message', '�۸񳤶ȹ�����');
			return false;
		} else {
			clearRemindMessage('price_remind_show_message');
		}
		if (valuationUnit == "") {
			valuationUnitObj.focus();
			showRemindMessage('valuationUnit_remind_show_message', '�Ƽ۵�λΪ��ѡ�');
			return false;
		} else {
			clearRemindMessage('valuationUnit_remind_show_message');
		}
		if ("fen" == valuationUnit) { // ����Ƽ۵�λΪ�֣�����Ƶ���ֻ����������
			if (!isNumber(price)) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'�Է�Ϊ��λֻ������������!');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // �����ʾ
			}
		} else if ("jiao" == valuationUnit) {
			if (!isDecimal1(price)) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'�Խ�Ϊ��λֻ�����벻������1λС����ֵ!');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // �����ʾ
			}

		} else if ("yuan" == valuationUnit) {
			if (!isDecimal2(price)) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'��ԪΪ��λֻ�����벻������2λС����ֵ!');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // �����ʾ
			}
		} else if ("wanyuan" == valuationUnit) {
			if (!isDecimal6(price)) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'����ԪΪ��λֻ�����벻������6λС����ֵ!');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // �����ʾ
			}
			if (priceStr2.length > 11) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'����ԪΪ��λ�������ֲ�����11λ');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // �����ʾ
			}
		} else if ("yiyuan" == valuationUnit) {
			if (!isDecimal10(price)) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'����ԪΪ��λֻ�����벻������10λС����ֵ!');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // �����ʾ
			}
			if (priceStr2.length > 7) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'����ԪΪ��λ���ܳ���9999999');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // �����ʾ
			}
		}
		return true;
	} else {
		alert("����Ƽ۵�λ�ͼ۸�Ԫ���Ƿ���ڣ�");
		return false;
	}
}

function validatePictures(){
	var fileChooseObj0 = $("#fileChoose0");
	var fileChooseObj1 = $("#fileChoose1");
	var fileChooseObj2 = $("#fileChoose2");
	var fileChooseObj3 = $("#fileChoose3");
	var fileChooseObj4 = $("#fileChoose4");
	var fileChoose0 = fileChooseObj0.val();
	var fileChoose1 = fileChooseObj1.val();
	var fileChoose2 = fileChooseObj2.val();
	var fileChoose3 = fileChooseObj3.val();
	var fileChoose4 = fileChooseObj4.val();
	if(fileChoose0){
		if(!/.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG)$/.test(fileChoose0)){
			fileChooseObj0.focus();
			showRemindMessage('fileErrorDiv_remind_show_message','ͼƬ��ʽֻ����gif��jpg��jpeg��png!');
			return false;
		}else{
			clearRemindMessage('fileErrorDiv_remind_show_message');
		}
	}
	if(fileChoose1){
		if(!/.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG)$/.test(fileChoose1)){
			fileChooseObj1.focus();
			showRemindMessage('fileErrorDiv_remind_show_message','ͼƬ��ʽֻ����gif��jpg��jpeg��png!');
			return false;
		}else{
			clearRemindMessage('fileErrorDiv_remind_show_message');
		}
	}
	if(fileChoose2){
		if(!/.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG)$/.test(fileChoose2)){
			fileChooseObj2.focus();
			showRemindMessage('fileErrorDiv_remind_show_message','ͼƬ��ʽֻ����gif��jpg��jpeg��png!');
			return false;
		}else{
			clearRemindMessage('fileErrorDiv_remind_show_message');
		}
	}
	if(fileChoose3){
		if(!/.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG)$/.test(fileChoose3)){
			fileChooseObj3.focus();
			showRemindMessage('fileErrorDiv_remind_show_message','ͼƬ��ʽֻ����gif��jpg��jpeg��png!');
			return false;
		}else{
			clearRemindMessage('fileErrorDiv_remind_show_message');
		}
	}
	if(fileChoose4){
		//var fileChoose4 = fileChooseObj4.val();
		if(!/.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG)$/.test(fileChoose4)){
			fileChooseObj4.focus();
			showRemindMessage('fileErrorDiv_remind_show_message','ͼƬ��ʽֻ����gif��jpg��jpeg��png!');
			return false;
		}else{
			clearRemindMessage('fileErrorDiv_remind_show_message');
		}
	}
	return true;
}

function validatePic(pictureId){
	var pictureObj = $("#" + pictureId);
	if(pictureObj){
		var picture = pictureObj.val();
		if(picture != null && picture != ""){
			if(!/.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG)$/.test(picture)){
				pictureObj.focus();
				showRemindMessage(pictureId + '_remind_show_message','ͼƬ��ʽֻ����gif��jpg��jpeg��png!');
			}
			return false;
		}else{
			clearRemindMessage(pictureId + '_remind_show_message');
			return true;
		}
	}
}

/**
 * �����ʾ������Ϣ
 * 
 * @param Object
 * @return
 */
function clearRemindMessage(Object) {
	$('#' + Object).html('');
}

/**
 * ��ʾҳ����ʾ��Ϣ
 * 
 * @param Object
 * @param message
 * @return
 */
function showRemindMessage(Object, message) {
	$('#' + Object).html(message);
}

$(document).ready(function() {
	jQuery.validator.setDefaults( {
		submitHandler : function(form) {
			if (!validateForm()) {
				return false;
			}
			// ƴװ���յ�ַ
			var province = $("#pe_province").find(
					"option:selected");
			var city = $("#pe_city").find("option:selected");
			var area = $("#pe_area").find("option:selected");
			var strAddress = province.text()
					+ (city.text() != "��ѡ��" ? city.text() : "") + (area.text() != "��ѡ��" ? area.text() : "");
			$("#deliveryPlace").val(strAddress);
			form.submit();
		}
	});
	
	$('#infoForm').validate( {
		rules : {
			title : {
				required : true,
				maxlength : 40
			},
			projectTypeCode : {
				required : true
			},
			linkMan : {
				required : true,
				maxlength : 30
			},
			amount : {
				required : true,
				maxlength : 30
			},
			city : {
				required : true
			},
			address : {
				required : true,
				maxlength : 80
			},
			storehouse : {
				maxlength : 30
			}
		},
		messages : {
			title : {
				required : "��Ŀ����Ϊ������",
				maxlength : "���볤����С��40����"
			},
			projectTypeCode : {
				required : "��Ŀ����Ϊ������"
			},
			linkMan : {
				required : "����Ϊ������",
				maxlength : "���ܳ���30���ַ�����"
			},
			amount : {
				required : "����Ϊ������",
				maxlength : "���ܳ���30���ַ�����"
			},
			city : {
				required : "����д��������",
			},
			address : {
				required : "����д��ϸ��ַ",
				maxlength : "���ܳ���80���ַ�����"
			},
			storehouse : {
				maxlength : "���ܳ���30���ַ�����"
			}
		}
	});
});

/*function deletePic(pathId, proId) {
	if ("del0" == pathId) {
		reflushImg("img0", imageServer + "/images/nophoto.jpg");
	}
	//alert(id);
	var pathId = pathId;
	var proId = proId;
	jQuery.ajax( {
		type : 'POST',
		url : appServer + '/supplydemand/deletePic.htm',
		data : {
			pathId : pathId,
			proId : proId
		},
	});
}*/