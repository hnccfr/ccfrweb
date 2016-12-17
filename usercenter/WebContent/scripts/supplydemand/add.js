$(function() {
	changeType();
});

function changeType() {
	if ($("input[name='infoType']:checked").val() == "supply") {
		$("#takedeliveryA").hide();
		$("#deliveryA").show();
		$("#storehouse1").show();
		$("#storehouse2").show();
		$("#takedeliveryS").hide();
		$("#deliveryS").show();
	}else if ($("input[name='infoType']:checked").val() == "demand") {
		$("#deliveryA").hide();
		$("#takedeliveryA").show();
		$("#storehouse1").hide();
		$("#storehouse2").hide();
		$("#deliveryS").hide();
		$("#takedeliveryS").show();
	}
}

/**
 * 验证供求信息数据
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
			showRemindMessage('quantity_remind_show_message', '数量为必填项！');
			return false;
		} else if (quantity.length > 12) {
			quantityObj.focus();
			showRemindMessage('quantity_remind_show_message', '数量为输入长度过长！');
			return false;
		} else if (!(re.test(quantity))) {
			quantityObj.focus();
			showRemindMessage('quantity_remind_show_message', '请输入正确的数量，必须整数!');
			return false;
		} else {
			clearRemindMessage('quantity_remind_show_message'); // 清除提示
		}
		quantity = Number(quantity);
	}
	
	if (!validatePrice()) {
		return false;
	}
	
//	if(!(validatePic('fileChoose0') && validatePic('fileChoose1') && validatePic('fileChoose2') && validatePic('fileChoose3') && validatePic('fileChoose4'))){
//		return false;
//	}
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
					'开始时间为必填项！');
			return false;
		} else {
			clearRemindMessage('effectiveStartDate_remind_show_message');
		}
		if (effectiveEndDate == "") {
			effectiveEndDateObj.focus();
			showRemindMessage('effectiveEndDate_remind_show_message',
					'截止时间为必填项');
			return false;
		} else {
			clearRemindMessage('effectiveEndDate_remind_show_message');
		}
		if (deliveryDate == "") {
			deliveryDateObj.focus();
			showRemindMessage('deliveryDate_remind_show_message', '交货时间为必填项！');
			return false;
		} else {
			clearRemindMessage('deliveryDate_remind_show_message'); // 清除提示
		}
		var days = daysBetween(effectiveEndDate, effectiveStartDate);
		var today = new Date();
		var day = today.getDate();
		var month = today.getMonth()+1;
		var year = today.getFullYear();
		if (daysBetween(effectiveEndDate, year + "-" + month + "-" + day) < 0) {
			effectiveEndDateObj.focus();
			showRemindMessage('effectiveEndDate_remind_show_message',
					'截止时间必须要大于等于今天！');
			return false;
		} else {
			clearRemindMessage('effectiveEndDate_remind_show_message');
		}
		if (days < 0) {
			effectiveStartDateObj.focus();
			showRemindMessage('effectiveStartDate_remind_show_message',
					'开始时间必须要早于截止时间！');
			return false;
		} else {
			clearRemindMessage('effectiveStartDate_remind_show_message');
		}
		if (!(daysBetween(deliveryDate, effectiveStartDate) >= 0 && daysBetween(deliveryDate, effectiveEndDate) <= 0)){
			deliveryDateObj.focus();
			showRemindMessage('deliveryDate_remind_show_message',
			'交货时间必须要在开始和截止时间之间！');
			return false;
		} else if (daysBetween(deliveryDate, year + "-" + month + "-" + day) < 0  ) {
			deliveryDateObj.focus();
			showRemindMessage('deliveryDate_remind_show_message',
			'交货时间必须大于等于今天！');
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
			showRemindMessage('phone_remind_show_message', '联系电话为必填项！');
			return false;
		} else if (phone.length > 20){
			phoneObj.focus();
			showRemindMessage('phone_remind_show_message', '联系电话长度过长！');
			return false;
		} /*else if (!(re.test(phone))) {
			phoneObj.focus();
			showRemindMessage('phone_remind_show_message', '输入的电话号码格式不正确!');
			return false;
		}*/ else {
			clearRemindMessage('phone_remind_show_message'); // 清除提示
		}
	}
	
	if (zipCodeObj) {
		var zipCode = zipCodeObj.val();
		var re = /^[0-9]{6}$/;
		if (zipCode != "" && !(re.test(zipCode)) ){
			zipCodeObj.focus();
			showRemindMessage('zipCode_remind_show_message', '邮政编码格式不正确！');
			return false;
		} else {
			clearRemindMessage('zipCode_remind_show_message'); // 清除提示
		}
	}

	return true;
}

function validatePrice() { return true;
	var priceObj = $("#price"); // 供求信息单价
	var flag = priceObj.val().indexOf(".");
	if (flag == -1) {
		var priceStr = priceObj.val() + ".";
	} else {
		var priceStr = priceObj.val();
	}
	var flag = priceStr.indexOf(".");
	var priceStr2 = priceStr.substring(0,flag);
	var valuationUnitObj = $("#valuationUnit"); // 计价单位
	if (priceObj && valuationUnitObj) {
		var price = priceObj.val();
		var valuationUnit = valuationUnitObj.val();
		if (price == "") {
			priceObj.focus();
			showRemindMessage('price_remind_show_message', '价格为必填项！');
			return false;
		} else if (price.length > 15) {
			priceObj.focus();
			showRemindMessage('price_remind_show_message', '价格长度过长！');
			return false;
		} else {
			clearRemindMessage('price_remind_show_message');
		}
		if (valuationUnit == "") {
			valuationUnitObj.focus();
			showRemindMessage('valuationUnit_remind_show_message', '计价单位为必选项！');
			return false;
		} else {
			clearRemindMessage('valuationUnit_remind_show_message');
		}
		if ("fen" == valuationUnit) { // 如果计价单位为分，则挂牌单价只能输入整数
			if (!isNumber(price)) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'以分为单位只能输入正整数!');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // 清除提示
			}
		} else if ("jiao" == valuationUnit) {
			if (!isDecimal1(price)) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'以角为单位只能输入不超过带1位小数的值!');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // 清除提示
			}

		} else if ("yuan" == valuationUnit) {
			if (!isDecimal2(price)) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'以元为单位只能输入不超过带2位小数的值!');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // 清除提示
			}
		} else if ("wanyuan" == valuationUnit) {
			if (!isDecimal6(price)) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'以万元为单位只能输入不超过带6位小数的值!');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // 清除提示
			}
			if (priceStr2.length > 11) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'以万元为单位整数部分不超过11位');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // 清除提示
			}
			if (priceStr2.length > 11) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'以万元为单位整数部分不超过11位!');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // 清除提示
			}
		} else if ("yiyuan" == valuationUnit) {
			if (!isDecimal10(price)) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'以亿元为单位只能输入不超过带10位小数的值!');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // 清除提示
			}
			if (priceStr2.length > 7) {
				priceObj.focus();
				showRemindMessage('price_remind_show_message',
						'以亿元为单位不能超过9999999');
				return false;
			} else {
				clearRemindMessage('price_remind_show_message'); // 清除提示
			}
		}
		return true;
	} else {
		alert("请检查计价单位和价格元素是否存在！");
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
			showRemindMessage('fileChoose0_remind_show_message','图片格式只能是gif、jpg、jpeg、png!');
			return false;
		}else{
			clearRemindMessage('fileChoose0_remind_show_message');
		}
	}
	if(fileChoose1){
		if(!/.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG)$/.test(fileChoose1)){
			fileChooseObj1.focus();
			showRemindMessage('fileChoose1_remind_show_message','图片格式只能是gif、jpg、jpeg、png!');
			return false;
		}else{
			clearRemindMessage('fileChoose1_remind_show_message');
		}
	}
	if(fileChoose2){
		if(!/.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG)$/.test(fileChoose2)){
			fileChooseObj2.focus();
			showRemindMessage('fileChoose2_remind_show_message','图片格式只能是gif、jpg、jpeg、png!');
			return false;
		}else{
			clearRemindMessage('fileChoose2_remind_show_message');
		}
	}
	if(fileChoose3){
		if(!/.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG)$/.test(fileChoose3)){
			fileChooseObj3.focus();
			showRemindMessage('fileChoose3_remind_show_message','图片格式只能是gif、jpg、jpeg、png!');
			return false;
		}else{
			clearRemindMessage('fileChoose3_remind_show_message');
		}
	}
	if(fileChoose4){
		//var fileChoose4 = fileChooseObj4.val();
		if(!/.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG)$/.test(fileChoose4)){
			fileChooseObj4.focus();
			showRemindMessage('fileChoose4_remind_show_message','图片格式只能是gif、jpg、jpeg、png!');
			return false;
		}else{
			clearRemindMessage('fileChoose4_remind_show_message');
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
				showRemindMessage(pictureId + '_remind_show_message','图片格式只能是gif、jpg、jpeg、png!');
			}
			return false;
		}else{
			clearRemindMessage(pictureId + '_remind_show_message');
			return true;
		}
	}
}

/**
 * 清除提示内容信息
 * 
 * @param Object
 * @return
 */
function clearRemindMessage(Object) {
	$('#' + Object).html('');
}

/**
 * 显示页面提示信息
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
			// 拼装交收地址
			var province = $("#pe_province").find(
					"option:selected");
			var city = $("#pe_city").find("option:selected");
			var area = $("#pe_area").find("option:selected");
			var strAddress = province.text()
					+ (city.text() != "请选择" ? city.text() : "") + (area.text() != "请选择" ? area.text() : "");
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
			}
			,
			storehouse : {
				maxlength : 30
			}
		},
		messages : {
			title : {
				required : "项目名称为必填项",
				maxlength : "输入长度请小于40个字"
			},
			projectTypeCode : {
				required : "项目类型为必填项"
			},
			linkMan : {
				required : "此项为必填项",
				maxlength : "不能超过30个字符长度"
			},
			amount : {
				required : "此项为必填项",
				maxlength : "不能超过30个字符长度"
			},
			city : {
				required : "请填写所在区域"
			},
			address : {
				required : "请填写详细地址",
				maxlength : "不能超过80个字符长度"
			}
			,
			storehouse : {
				maxlength : "不能超过30个字符长度"
			}
		}
	});
});



function clearMsg() {
	jQuery("#title").attr("value", "");
	jQuery("#projectTypeName").attr("value", "");
	jQuery("#projectTypeCode").attr("value", "");
//	jQuery("#breedStandardSelect").attr("value", "0");
	//jQuery(".infoType").attr("checked","").parent().find(":first").attr("checked","checked");
	jQuery(".infoType:first").attr("checked","checked");
	jQuery("#quantity").attr("value", "");
	jQuery("#valuationUnit").attr("value", "yuan");
	jQuery("#measureUnit").attr("value", "zong");
	jQuery("#price").attr("value", "");
	jQuery("#effectiveStartDate").attr("value", "");
	jQuery("#effectiveEndDate").attr("value", "");
	jQuery(".retail:last").attr("checked","checked");
	jQuery(".invoice:last").attr("checked","checked");
	jQuery(".deliveryType:last").attr("checked","checked");
	jQuery("#deliveryDate").attr("value", "");
	jQuery("#storehouse").attr("value", "");
	jQuery("#linkMan").attr("value", "");
	jQuery("#amount").attr("value", "");
	jQuery("#phone").attr("value", "");
	jQuery("#zipCode").attr("value", "");
	jQuery("#pe_province").attr("value", "");
	jQuery("#pe_city").attr("value", "");
	jQuery("#pe_area").attr("value", "");
	jQuery("#address").attr("value", "");
	jQuery("#fileChoose0").attr("value", "");
	jQuery("#fileChoose1").attr("value", "");
	jQuery("#fileChoose2").attr("value", "");
	jQuery("#fileChoose3").attr("value", "");
	jQuery("#fileChoose4").attr("value", "");
	jQuery("#description").attr("value", "");
}

function clearPic(){
	jQuery("#fileChoose0").attr("value", "");
	jQuery("#picturePath").attr("value", "");
}

function clearPic1(){
	jQuery("#fileChoose1").attr("value", "");
	jQuery("#picturePath1").attr("value", "");
}

function clearPic2(){
	jQuery("#fileChoose2").attr("value", "");
	jQuery("#picturePath2").attr("value", "");
}

function clearPic3(){
	jQuery("#fileChoose3").attr("value", "");
	jQuery("#picturePath3").attr("value", "");
}

function clearPic4(){
	jQuery("#fileChoose4").attr("value", "");
	jQuery("#picturePath4").attr("value", "");
}