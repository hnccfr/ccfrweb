$(document).ready(function() {
	var tType = jQuery("#tradeTypeValue").val();
	prjTradeForm(tType);// ���ؽ��׶�̬����
		var pTypeCode = jQuery("#projectTypeCode").val();
		var pTypeName = jQuery("#projectTypeName").val();
		var sId = $("#breedStandard").val();
		if (pTypeName != "") {
			prjMetaFrom(pTypeCode, pTypeName);// ������Ŀ��̬����
		} else if (sId != "") {// ������Ŀ��׼����
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
 * ��֤�½���������
 * 
 * @return
 */
function validateForm() {
	var listingStartTimeObj = $("#listingStartTime");
	var listingEndTimeObj = $("#listingEndTime");
	var listingTypeObj = $("#listingType"); // ���׷�ʽ

	var quantityObj = $('#quantity'); // �û�ʵ����д�µ���
	var maxQuantityObj = $('#maxQuantity'); // ����µ���
	var minQuantityObj = $('#minQuantity'); // ��С�µ���
	var multipleBaseObj = $('#multipleBase'); // �µ�����
	var leaveQuantityObj = $('#leaveQuantity'); // ��Ŀ�����
	var breedStandardObj = $("#breedStandard");
	var breedStandardIdObj = $("#breedStandardId");
	if (!validatePrice()) {
		return false;
	}

	if (quantityObj) {
		var quantity = quantityObj.val();
		if (quantity == "") {
			showRemaindMessage('quantity_remind_show_message', '��������Ϊ�����');
			return false;
		} else if (!isDigit(quantity)) {
			quantityObj.focus();
			showRemaindMessage('quantity_remind_show_message', '��������ȷ������!');
			return false;
		} else {
			clearRemindMessage('quantity_remind_show_message'); // �����ʾ
		}
		quantity = Number(quantity);
	}
	if (maxQuantityObj) {
		var maxQuantity = maxQuantityObj.val();
		if (maxQuantity == "") {
			showRemaindMessage('maxQuantity_remind_show_message', '����µ���Ϊ�����');
			return false;
		} else if (!isDigit(maxQuantity)) {
			maxQuantityObj.focus();
			showRemaindMessage('maxQuantity_remind_show_message',
					'��������ȷ������µ���!');
			return false;
		} else {
			clearRemindMessage('maxQuantity_remind_show_message'); // �����ʾ
		}
		maxQuantity = Number(maxQuantity);

	}
	if (minQuantityObj) {
		var minQuantity = minQuantityObj.val();

		if (minQuantity == "") {
			showRemaindMessage('minQuantity_remind_show_message', '��С�µ���Ϊ�����');
			return false;
		} else if (!isDigit(minQuantity)) {
			minQuantityObj.focus();
			showRemaindMessage('minQuantity_remind_show_message',
					'��������ȷ����С�µ���!');
			return false;
		} else {
			clearRemindMessage('minQuantity_remind_show_message'); // �����ʾ
		}
		minQuantity = Number(minQuantity);
	}
	if (multipleBaseObj) {
		var multipleBase = multipleBaseObj.val();
		if (multipleBase == "") {
			showRemaindMessage('multipleBase_remind_show_message',
					'�µ���������Ϊ�����');
			return false;
		} else if (!isDigit(minQuantity)) {
			multipleBaseObj.focus();
			showRemaindMessage('multipleBase_remind_show_message',
					'��������ȷ���µ���������!');
			return false;
		} else {
			clearRemindMessage('multipleBase_remind_show_message'); // �����ʾ
		}
		multipleBase = Number(multipleBase);
	}

	if (quantity % multipleBase != 0) { // �µ���������Ϊ����������������
		multipleBaseObj.focus();
		showRemaindMessage('multipleBase_remind_show_message',
				'�µ���������Ϊ����������������!');
		return false;
	} else if (multipleBase > quantity) {
		multipleBaseObj.focus();
		showRemaindMessage('multipleBase_remind_show_message', '�µ���������ҪС�ڹ�������!');
	} else {
		clearRemindMessage('multipleBase_remind_show_message'); // �����ʾ
	}

	if (maxQuantity > quantity) { // ����µ������ڿ����
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message', '����µ�������ҪС�ڹ�������!');
		return false;
	} else {
		clearRemindMessage('maxQuantity_remind_show_message'); // �����ʾ
	}

	if (minQuantity > maxQuantity) { // ����µ�������Ҫ���ڵ�����СС����
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message',
				'����µ�������Ҫ���ڵ�����СС����!');
		return false;
	} else {
		clearRemindMessage('maxQuantity_remind_show_message'); // �����ʾ
	}

	if (listingStartTimeObj && listingEndTimeObj) {
		var listingStartTime = listingStartTimeObj.val();
		var listingEndTime = listingEndTimeObj.val();
		if (listingStartTime == "") {
			showRemaindMessage('listingStartTime_remind_show_message',
					'���ƿ�ʼʱ��Ϊ�����');
			return false;
		} else {
			clearRemindMessage('listingStartTime_remind_show_message');
		}
		if (listingEndTime == "") {
			showRemaindMessage('listingEndTime_remind_show_message',
					'���ƽ���ʱ��Ϊ������');
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
					'���ƽ���ʱ�����Ҫ���ڵ��ڽ��죡');
			return false;
		} else {
			clearRemindMessage('listingEndTime_remind_show_message');
		}
		if (days <= 0) {
			showRemaindMessage('listingEndTime_remind_show_message',
					'���ƿ�ʼʱ�����Ҫ���ڽ���ʱ��');
			return false;
		} else {
			clearRemindMessage('listingEndTime_remind_show_message');
		}
		return true;
	} else {
		showRemaindMessage('listingEndTime_remind_show_message', '��������ڸ�ʽ����ȷ��');
		return false;
	}

	return true;

}

function validatePrice() {
	var listingPriceObj = $("#listingPrice"); // ���Ƶ���
	var valuationUnitObj = $("#valuationUnit"); // �Ƽ۵�λ
	if (listingPriceObj && valuationUnitObj) {
		var listingPrice = listingPriceObj.val();
		var valuationUnit = valuationUnitObj.val();
		if (listingPrice == "") {
			showRemaindMessage('listingPrice_remind_show_message', '���Ƶ���Ϊ�����');
			return false;
		} else {
			clearRemindMessage('listingPrice_remind_show_message');
		}
		if (valuationUnit == "") {
			showRemaindMessage('valuationUnit_remind_show_message', '�Ƽ۵�λΪ��ѡ�');
			return false;
		} else {
			clearRemindMessage('valuationUnit_remind_show_message');
		}
		if ("fen" == valuationUnit) { // ����Ƽ۵�λΪ�֣�����Ƶ���ֻ����������
			if (!isNumber(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'�Է�Ϊ��λֻ������������!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message'); // �����ʾ
			}
		} else if ("jiao" == valuationUnit) {
			if (!isDecimal1(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'�Խ�Ϊ��λֻ�����벻������1λС����ֵ!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message'); // �����ʾ
				// listingPrice = listingPrice.toString().movePoint(1);
				// listingPriceObj.val(listingPrice);
			}

		} else if ("yuan" == valuationUnit) {
			if (!isDecimal2(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'��ԪΪ��λֻ�����벻������2λС����ֵ!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message'); // �����ʾ
				// listingPrice = listingPrice.toString().movePoint(2);
				// listingPriceObj.val(listingPrice);
			}
		} else if ("wanyuan" == valuationUnit) {
			if (!isDecimal6(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'����ԪΪ��λֻ�����벻������6λС����ֵ!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message'); // �����ʾ
				// listingPrice = listingPrice.toString().movePoint(7);
				// listingPriceObj.val(listingPrice);
			}
		} else if ("yiyuan" == valuationUnit) {
			if (!isDecimal10(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'����ԪΪ��λֻ�����벻������10λС����ֵ!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message'); // �����ʾ
				// listingPrice = listingPrice.toString().movePoint(10);
				// listingPriceObj.val(listingPrice);
			}
		}
		return true;
	} else {
		alert("����Ƽ۵�λ�ͼ۸�Ԫ���Ƿ���ڣ�");
		return false;
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
							// ƴװ���յ�ַ
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
								required : "��Ϊ������",
								maxlength : "���볤�������100���ַ���"
							},
							quantity : {
								required : "��Ϊ������",
								digits : "������������"
							},
							listingPriceDesc : {
								required : "��Ϊ������",
								number : "������Ϸ�������"
							},
							projectTypeCode : {
								required : "����Ϊ������"
							},

							tradeTypeValue : {
								required : "��ѡ���׷�ʽ"
							},
							paymentType : {
								required : "��Ϊ������",
								minlength : "����Ҫѡ��1��"
							},
							deliveryType : {
								required : "��Ϊ������",
								minlength : "����Ҫѡ��1��"
							},
							invoice : {
								required : "��Ϊ������",
								minlength : "����Ҫѡ��1��"
							},
							phone : {
								required : "��Ϊ������",
								maxlength : "���ܳ���20���ַ�����"
							},
							linkMan : {
								required : "��Ϊ������",
								maxlength : "���ܳ���30���ַ�����"
							},
							address : {
								required : "��Ϊ������",
								maxlength : "���ܳ���80���ַ�����"
							},
							storehouse : {
								maxlength : "���ܳ���30���ַ�����"
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
		$("#standardAndType").text("��׼������Ŀ����ѡ��һ��");
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