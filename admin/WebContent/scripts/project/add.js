$(document).ready(function() {
	var tType = jQuery("#tradeTypeValue").val();
	prjTradeForm(tType);// 加载交易动态属性
		var pTypeCode = jQuery("#projectTypeCode").val();
		var pTypeName = jQuery("#projectTypeName").val();
		var sId = $("#breedStandard").val();
		if (pTypeName != "") {
			prjMetaFrom(pTypeCode, pTypeName);// 加载项目动态属性
		} else if (sId != "") {// 加载项目标准属性
			var contentDesObj = $("#" + sId).val();
			$("#prjTypeMetaBox").html(contentDesObj);
		}
	});

$(document).ready(function() {
	$('#breedStandardSelect').change(function() {
		var selectObj = $("#breedStandardSelect").find("option:selected");
		$('#breedStandard').val(selectObj.text());
		$('#breedStandardId').val(selectObj.val());
	});
});
/**
 * 验证新建挂牌数据
 * 
 * @return
 */
function validateForm() {
	var listingStartTimeObj = $("#listingStartTime");
	var listingEndTimeObj = $("#listingEndTime");
	var listingTypeObj = $("#listingType"); // 交易方式

	var quantityObj = $('#quantity'); // 用户实际填写下单量
	var maxQuantityObj = $('#maxQuantity'); // 最大下单量
	var minQuantityObj = $('#minQuantity'); // 最小下单量
	var multipleBaseObj = $('#multipleBase'); // 下单基数
	var leaveQuantityObj = $('#leaveQuantity'); // 项目库存量
	var breedStandardObj = $("#breedStandard");
	var breedStandardIdObj = $("#breedStandardId");
	if (!validatePrice()) {
		return false;
	}

	if (quantityObj) {
		var quantity = quantityObj.val();
		if (quantity == "") {
			showRemaindMessage('quantity_remind_show_message', '挂牌数量为必填项！');
			return false;
		} else if (!isDigit(quantity)) {
			quantityObj.focus();
			showRemaindMessage('quantity_remind_show_message', '请输入正确的数量!');
			return false;
		} else {
			clearRemindMessage('quantity_remind_show_message'); // 清除提示
		}
		quantity = Number(quantity);
	}
	if (maxQuantityObj) {
		var maxQuantity = maxQuantityObj.val();
		if (maxQuantity == "") {
			showRemaindMessage('maxQuantity_remind_show_message', '最大下单量为必填项！');
			return false;
		} else if (!isDigit(maxQuantity)) {
			maxQuantityObj.focus();
			showRemaindMessage('maxQuantity_remind_show_message',
					'请输入正确的最大下单量!');
			return false;
		} else {
			clearRemindMessage('maxQuantity_remind_show_message'); // 清除提示
		}
		maxQuantity = Number(maxQuantity);

	}
	if (minQuantityObj) {
		var minQuantity = minQuantityObj.val();

		if (minQuantity == "") {
			showRemaindMessage('minQuantity_remind_show_message', '最小下单量为必填项！');
			return false;
		} else if (!isDigit(minQuantity)) {
			minQuantityObj.focus();
			showRemaindMessage('minQuantity_remind_show_message',
					'请输入正确的最小下单量!');
			return false;
		} else {
			clearRemindMessage('minQuantity_remind_show_message'); // 清除提示
		}
		minQuantity = Number(minQuantity);
	}
	if (multipleBaseObj) {
		var multipleBase = multipleBaseObj.val();
		if (multipleBase == "") {
			showRemaindMessage('multipleBase_remind_show_message',
					'下单数量基数为必填项！');
			return false;
		} else if (!isDigit(minQuantity)) {
			multipleBaseObj.focus();
			showRemaindMessage('multipleBase_remind_show_message',
					'请输入正确的下单数量基数!');
			return false;
		} else {
			clearRemindMessage('multipleBase_remind_show_message'); // 清除提示
		}
		multipleBase = Number(multipleBase);
	}

	if (quantity % multipleBase != 0) { // 下单基数必须为挂牌数量的整数倍
		multipleBaseObj.focus();
		showRemaindMessage('multipleBase_remind_show_message',
				'下单基数必须为挂牌数量的整数倍!');
		return false;
	} else if (multipleBase > quantity) {
		multipleBaseObj.focus();
		showRemaindMessage('multipleBase_remind_show_message', '下单基数必须要小于挂牌数量!');
	} else {
		clearRemindMessage('multipleBase_remind_show_message'); // 清除提示
	}

	if (maxQuantity > quantity) { // 最大下单量大于库存量
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message', '最大下单量必须要小于挂牌数量!');
		return false;
	} else {
		clearRemindMessage('maxQuantity_remind_show_message'); // 清除提示
	}

	if (minQuantity > maxQuantity) { // 最大下单量必须要大于等于最小小单量
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message',
				'最大下单量必须要大于等于最小小单量!');
		return false;
	} else {
		clearRemindMessage('maxQuantity_remind_show_message'); // 清除提示
	}

	if (listingStartTimeObj && listingEndTimeObj) {
		var listingStartTime = listingStartTimeObj.val();
		var listingEndTime = listingEndTimeObj.val();
		if (listingStartTime == "") {
			showRemaindMessage('listingStartTime_remind_show_message',
					'挂牌开始时间为必填项！');
			return false;
		} else {
			clearRemindMessage('listingStartTime_remind_show_message');
		}
		if (listingEndTime == "") {
			showRemaindMessage('listingEndTime_remind_show_message',
					'挂牌结束时间为必填项');
			return false;
		} else {
			clearRemindMessage('listingEndTime_remind_show_message');
		}
		var days = daysBetween(listingEndTime, listingStartTime);
		var today = new Date();
		var day = today.getDate();
		var month = today.getMonth() + 1;
		var year = today.getYear();
		if (daysBetween(listingEndTime, year + "-" + month + "-" + day) < 0) {
			showRemaindMessage('listingEndTime_remind_show_message',
					'挂牌结束时间必须要大于等于今天！');
			return false;
		} else {
			clearRemindMessage('listingEndTime_remind_show_message');
		}
		if (days <= 0) {
			showRemaindMessage('listingEndTime_remind_show_message',
					'挂牌开始时间必须要早于结束时间');
			return false;
		} else {
			clearRemindMessage('listingEndTime_remind_show_message');
		}
		return true;
	} else {
		showRemaindMessage('listingEndTime_remind_show_message', '输入的日期格式不正确！');
		return false;
	}

	return true;

}

function validatePrice() {
	var listingPriceObj = $("#listingPrice"); // 挂牌单价
	var valuationUnitObj = $("#valuationUnit"); // 计价单位
	if (listingPriceObj && valuationUnitObj) {
		var listingPrice = listingPriceObj.val();
		var valuationUnit = valuationUnitObj.val();
		if (listingPrice == "") {
			showRemaindMessage('listingPrice_remind_show_message', '挂牌单价为必填项！');
			return false;
		} else {
			clearRemindMessage('listingPrice_remind_show_message');
		}
		if (valuationUnit == "") {
			showRemaindMessage('valuationUnit_remind_show_message', '计价单位为必选项！');
			return false;
		} else {
			clearRemindMessage('valuationUnit_remind_show_message');
		}
		if ("fen" == valuationUnit) { // 如果计价单位为分，则挂牌单价只能输入整数
			if (!isNumber(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'以分为单位只能输入正整数!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message'); // 清除提示
			}
		} else if ("jiao" == valuationUnit) {
			if (!isDecimal1(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'以角为单位只能输入不超过带1位小数的值!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message'); // 清除提示
				// listingPrice = listingPrice.toString().movePoint(1);
				// listingPriceObj.val(listingPrice);
			}

		} else if ("yuan" == valuationUnit) {
			if (!isDecimal2(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'以元为单位只能输入不超过带2位小数的值!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message'); // 清除提示
				// listingPrice = listingPrice.toString().movePoint(2);
				// listingPriceObj.val(listingPrice);
			}
		} else if ("wanyuan" == valuationUnit) {
			if (!isDecimal6(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'以万元为单位只能输入不超过带6位小数的值!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message'); // 清除提示
				// listingPrice = listingPrice.toString().movePoint(7);
				// listingPriceObj.val(listingPrice);
			}
		} else if ("yiyuan" == valuationUnit) {
			if (!isDecimal10(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'以亿元为单位只能输入不超过带10位小数的值!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message'); // 清除提示
				// listingPrice = listingPrice.toString().movePoint(10);
				// listingPriceObj.val(listingPrice);
			}
		}
		return true;
	} else {
		alert("请检查计价单位和价格元素是否存在！");
		return false;
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
function showRemaindMessage(Object, message) {
	$('#' + Object).html(message);
}
$(document)
		.ready(
				function() {
					jQuery.validator.setDefaults( {
						submitHandler : function(form) {
							if (!validateForm()) {
								return false;
							}
							// 拼装交收地址
							var pe_province = $("#pe_province").find(
									"option:selected");
							var pe_city = $("#pe_city").find("option:selected");
							var pe_area = $("#pe_area").find("option:selected");
							var strAddress = pe_province.text()
									+ pe_city.text() + pe_area.text()
									+ $("#address").val();
							$("#deliveryPlace").val(strAddress);
							form.submit();
						}
					});
					$('#listingFrom').validate( {
						rules : {
							title : {
								required : true,
								maxlength : 100
							},
							quantity : {
								required : true,
								digits : true
							},
							listingPriceDesc : {
								required : true,
								number : true
							},
							projectTypeCode : {
								required : true
							},
							tradeTypeValue : {
								required : true
							},
							paymentType : {
								required : true,
								minlength : 1
							},
							deliveryType : {
								required : true,
								minlength : 1
							},
							invoice : {
								required : true,
								minlength : 1
							},
							phone : {
								required : true,
								maxlength : 20
							},
							linkMan : {
								required : true,
								maxlength : 30
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
								required : "此为必填项",
								maxlength : "输入长度最多是100的字符串"
							},
							quantity : {
								required : "此为必填项",
								digits : "必须输入整数"
							},
							listingPriceDesc : {
								required : "此为必填项",
								number : "请输入合法的数字"
							},
							projectTypeCode : {
								required : "此项为必填项"
							},

							tradeTypeValue : {
								required : "请选交易方式"
							},
							paymentType : {
								required : "此为必填项",
								minlength : "至少要选择1项"
							},
							deliveryType : {
								required : "此为必填项",
								minlength : "至少要选择1项"
							},
							invoice : {
								required : "此为必填项",
								minlength : "至少要选择1项"
							},
							phone : {
								required : "此为必填项",
								maxlength : "不能超过20个字符长度"
							},
							linkMan : {
								required : "此为必填项",
								maxlength : "不能超过30个字符长度"
							},
							address : {
								required : "此为必填项",
								maxlength : "不能超过80个字符长度"
							},
							storehouse : {
								maxlength : "不能超过30个字符长度"
							}
						}
					});
				});

$(document).ready(function() {
	$('#quantity').bind('focusout', function() {
		$('#totalPay').val($(this).val() * $('#listingPrice').val());
	});
});
function checkTypeAndStandard() {

	return false;
	if ($("#breedStandardSelect").val() == ""
			&& $("#projectTypeName").val() == "") {
		$("#standardAndType").text("标准规格或项目类型选填一项");
		return false;
	} else {
		$("#standardAndType").text("");
		return true;
	}
}
$(document).ready(
		function() {
			$('#projectTypeName').click(
					function() {
						showPrjTypeSel(this, '', 'projectTypeCode',
								'projectTypeName', 'prjTypeMetaBox');
					});

		});
function chooseProjectType(data) {
	jQuery("#projectTypeCode").val(data.code);
	jQuery("#projectTypeName").val(data.name);
}

function setStandProp(prjTypeMetaBox, htmContent) {
	jQuery("#" + prjTypeMetaBox).html(htmContent);
	jQuery("#projectTypeName").attr('disabled', 'disabled');
}