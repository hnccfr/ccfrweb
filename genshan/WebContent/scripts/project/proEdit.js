$(document).ready(
		function() {
			var tType = $("#tradingType").val();
			var projectId = $("#projectId").val();
			var projectTypeCode = jQuery("#projectTypeCode").val();
			//loadPrjTradeTypeFormURL(tType, "prjTradeTypeBoxId", projectId);
			var bsType = $("#listingType").val();
			loadPrjTradeTypeDisByBsType(tType, "prjTradeTypeBoxId", projectId, bsType);// ���ؽ��׶�̬����,�����Ʒ������
			loadPrjTypeMetaFormURL(projectTypeCode, "", "", "prjTypeMetaBox",
					projectId);
		});

$(function() {
	$.validator.setDefaults( {
		submitHandler : function(form) {
			// ƴװ���յ�ַ
			var pe_province = $("#pe_province").find("option:selected");
			var pe_city = $("#pe_city").find("option:selected");
			var pe_area = $("#pe_area").find("option:selected");
			var strAddress = pe_province.text()
						+ (pe_city.text() != "��ѡ��" ? pe_city.text() : "") 
						+ (pe_area.text() != "��ѡ��" ? pe_area.text() : "")
						+ $("#address").val();
			$("#deliveryPlace").val(strAddress);
			
			if (!validateForm()) {
				return false;
			} else {
				// ƴװ���յ�ַ
//				var pe_province = $("#pe_province").find("option:selected");
//				var pe_city = $("#pe_city").find("option:selected");
//				var pe_area = $("#pe_area").find("option:selected");
//				var strAddress = pe_province.text()
//							+ (pe_city.text() != "��ѡ��" ? pe_city.text() : "") 
//							+ (pe_area.text() != "��ѡ��" ? pe_area.text() : "")
//							+ $("#address").val();
//				$("#deliveryPlace").val(strAddress);
				form.submit();
			}
		}
	});
	$("#projectListingEdit").validate( {
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
			},
			area : {
				required : true
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
			},
			area : {
				required : "����д��������"
			}
		}
	});

	// $("#projectListingEdit").validate();
});
/**
 * �µ���������У��
 * 
 * @return
 */
function placeOrderValidate() {
	var maxQuantityObj = $('#maxQuantity'); // ����µ���
	var minQuantityObj = $('#minQuantity'); // ��С�µ���
	var multipleBaseObj = $('#multipleBase'); // �µ�����
	var quantityObj = $('#quantity'); // �û�ʵ����д�µ���
	if (maxQuantityObj) {
		var maxQuantity = maxQuantityObj.val();
		if (maxQuantity == "") {
			showRemaindMessage('maxQuantity_remind_show_message', '����µ���Ϊ�����');
			return false;
		} else if (!isDigitPositive(maxQuantity)) {
			maxQuantityObj.focus();
			showRemaindMessage('maxQuantity_remind_show_message', '��������ȷ������!');
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
		} else if (!isDigitPositive(minQuantity)) {
			minQuantityObj.focus();
			showRemaindMessage('minQuantity_remind_show_message', '��������ȷ������!');
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
		} else if (!isDigitPositive(multipleBase)) {
			multipleBaseObj.focus();
			showRemaindMessage('multipleBase_remind_show_message', '��������ȷ������!');
			return false;
		} else if (multipleBase > quantity) { // ����µ������ڿ����
			minQuantityObj.focus();
			showRemaindMessage('multipleBase_remind_show_message', '����ҪС�ڹ�������!');
			return false;
		} else {
			clearRemindMessage('multipleBase_remind_show_message'); // �����ʾ
		}
		multipleBase = Number(multipleBase);
	}
	if (quantityObj) {
		var quantity = quantityObj.val();
		if (quantity == "") {
			showRemaindMessage('quantity_remind_show_message', '��������Ϊ�����');
			return false;
		} else if (!isDigitPositive(quantity)) {
			quantityObj.focus();
			showRemaindMessage('quantity_remind_show_message', '��������ȷ������!');
			return false;
		} else {
			clearRemindMessage('quantity_remind_show_message'); // �����ʾ
		}
		quantity = Number(quantity);
	}

	if (quantity % multipleBase != 0) { // �µ���������Ϊ����������������
		multipleBaseObj.focus();
		showRemaindMessage('multipleBase_remind_show_message', '�����ܱ���������������');
		return false;
	} else if (multipleBase > quantity) {
		multipleBaseObj.focus();
		showRemaindMessage('multipleBase_remind_show_message', '�µ���������ҪС�ڹ�������!');
	} else {
		clearRemindMessage('multipleBase_remind_show_message'); // �����ʾ
	}

	if (minQuantity > quantity) { // ����µ������ڿ����
		minQuantityObj.focus();
		showRemaindMessage('minQuantity_remind_show_message', '��С�µ�������ҪС�ڹ�������!');
		return false;
	} else if (minQuantity % multipleBase != 0) { // ����µ�������Ϊ�µ�������������
		minQuantityObj.focus();
		showRemaindMessage('minQuantity_remind_show_message', '����Ϊ�µ�������������!');
		return false;
	} else {
		clearRemindMessage('minQuantity_remind_show_message'); // �����ʾ
	}

	if (maxQuantity > quantity) { // ����µ������ڿ����
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message', '����µ�������ҪС�ڹ�������!');
		return false;
	} else if (maxQuantity % multipleBase != 0) { // ����µ�������Ϊ�µ�������������
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message', '����Ϊ�µ�������������!');
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
	return true;
}
/**
 * �����������Ե�У��
 * 
 * @return
 */
function bidOrderValidate() {
	var haveAuctioneerObj = $("input:[id='haveAuctioneer']:radio:checked"); // �Ƿ�������ʦ
	var haveAuctioneerTemp = "";
	if (haveAuctioneerObj) {
		var haveAuctioneer = haveAuctioneerObj.val();
		if (typeof (haveAuctioneer) == "undefined" || haveAuctioneer == "") {
			haveAuctioneerObj.focus();
			showRemaindMessage('haveAuctioneer_remind_show_message', '����Ϊ������!');
			return false;
		} else {
			clearRemindMessage('haveAuctioneer_remind_show_message'); // �����ʾ
		}
		haveAuctioneerTemp = haveAuctioneer;
	}
	var auctioneerAccountObj = $("#auctioneerAccount"); // ����ʦ�˺�
	if (auctioneerAccountObj) {
		var auctioneerAccount = auctioneerAccountObj.val();
		if (haveAuctioneerTemp == "Y"
				&& (typeof (auctioneerAccount) == "undefined" || auctioneerAccount == "")) {
			auctioneerAccountObj.focus();
			showRemaindMessage('auctioneerAccount_remind_show_message',
					'����Ϊ������!');
			return false;
		} else {
			clearRemindMessage('auctioneerAccount_remind_show_message');
		}
	}
	var watchPasswordObj = $("#watchPassword"); // �ۿ���Ȩ��
	if (watchPasswordObj) {
		var watchPassword = watchPasswordObj.val();
		if (typeof (watchPassword) != "undefined" && watchPassword != ""
				&& watchPassword.length > 16) {
			watchPasswordObj.focus();
			showRemaindMessage('watchPassword_remind_show_message',
					'���ܳ���16�ַ�����!');
			return false;
		} else {
			clearRemindMessage('watchPassword_remind_show_message');
		}
	}

	var supportPriorityObj = $("input:[id='supportPriority']:radio:checked")// ����Ȩ
	if (supportPriorityObj) {
		var supportPriority = supportPriorityObj.val();
		if (typeof (supportPriority) == "undefined" || supportPriority == "") {
			supportPriorityObj.focus();
			showRemaindMessage('supportPriority_remind_show_message', '����Ϊ������!');
			return false;
		} else {
			clearRemindMessage('supportPriority_remind_show_message');
		}
	}
	var bidStartPriceObj = $("#bidStartPrice"); // ���ļ۸�
	if (bidStartPriceObj) {
		var bidStartPrice = bidStartPriceObj.val();
		if (typeof (bidStartPrice) == "undefined" || bidStartPrice == "") {
			bidStartPriceObj.focus();
			showRemaindMessage('bidStartPrice_remind_show_message', '����Ϊ������!');
			return false;
		} else if (!isMoneyInput(bidStartPrice)) {
			showRemaindMessage('bidStartPrice_remind_show_message', '��������ȷ�Ľ��!');
			return false;
		} else {
			clearRemindMessage('bidStartPrice_remind_show_message');
		}
		if (!validateMoney("bidStartPrice", "valuationUnit")) {
			return false;
		}
	}
	var allowWatchObj = $("input:[id='allowWatch']:radio:checked")// �Ƿ�����ۿ�
	if (allowWatchObj) {
		var allowWatch = allowWatchObj.val();
		if (typeof (allowWatch) == "undefined" || allowWatch == "") {
			allowWatchObj.focus();
			showRemaindMessage('allowWatch_remind_show_message', '����Ϊ������!');
			return false;
		} else {
			clearRemindMessage('allowWatch_remind_show_message');
		}
	}
	var priceDirectionObj = $("input:[id='priceDirection']:radio:checked")// ���۷���
	if (priceDirectionObj) {
		var priceDirection = priceDirectionObj.val();
		if (typeof (priceDirection) == "undefined" || priceDirection == "") {
			priceDirection.focus();
			showRemaindMessage('priceDirection_remind_show_message', '����Ϊ������!');
			return false;
		} else {
			clearRemindMessage('priceDirection_remind_show_message');
		}
	}
	var bidRateObj = $("#bidRate"); // ���۷���
	if (bidRateObj) {
		var bidRate = bidRateObj.val();
		if (typeof (bidRate) != "undefined" && bidRate != ""
				&& !isMoneyInput(bidRate)) {
			bidRateObj.focus();
			showRemaindMessage('bidRate_remind_show_message', '��������ȷ�Ľ��!');
			return false;
		} else {
			clearRemindMessage('bidRate_remind_show_message');
		}
		if (bidRate != "" && !validateMoney("bidRate", "valuationUnit")) {
			return false;
		}
	}
	var haveReservePriceObj = $("input:[id='haveReservePrice']:radio:checked")// �Ƿ��б�����
	var haveReservePriceTemp = "";
	if (haveReservePriceObj) {
		var haveReservePrice = haveReservePriceObj.val();
		if (typeof (haveReservePrice) == "undefined" || haveReservePrice == "") {
			haveReservePriceObj.focus();
			showRemaindMessage('haveReservePrice_remind_show_message',
					'����Ϊ������!');
			return false;
		} else {
			clearRemindMessage('haveReservePrice_remind_show_message');
		}
		haveReservePriceTemp = haveReservePrice;
	}
	var reservePriceObj = $("#reservePrice"); // ������
	if (reservePriceObj) {
		var reservePrice = reservePriceObj.val();
		if (haveReservePriceTemp == "Y"
				&& (typeof (reservePrice) == "undefined" || reservePrice == "")) {
			reservePriceObj.focus();
			showRemaindMessage('reservePrice_remind_show_message', '����Ϊ������!');
			return false;
		} else if (typeof (reservePrice) != "undefined" && reservePrice != ""
				&& !isMoneyInput(reservePrice)) {
			reservePriceObj.focus();
			showRemaindMessage('reservePrice_remind_show_message', '��������ȷ�Ľ��!');
			return false;
		} else {
			clearRemindMessage('reservePrice_remind_show_message');
		}
		if (reservePrice != ""
				&& !validateMoney("reservePrice", "valuationUnit")) {
			return false;
		}

	}
	var firstWaitTimeObj = $("#firstWaitTime"); // �״α���ʱ��(��)
	if (firstWaitTimeObj) {
		var firstWaitTime = firstWaitTimeObj.val();
		if (typeof (firstWaitTime) == "undefined" || firstWaitTime == "") {
			firstWaitTimeObj.focus();
			showRemaindMessage('firstWaitTime_remind_show_message', '����Ϊ������!');
			return false;
		} else if (!isDigitPositive(firstWaitTime)) {
			showRemaindMessage('firstWaitTime_remind_show_message', '������������!');
			return false;
		} else {
			clearRemindMessage('firstWaitTime_remind_show_message');
		}
	}
	var bidLimitedPeriodObj = $("#bidLimitedPeriod"); // ������ʱ����(��)
	if (firstWaitTimeObj) {
		var bidLimitedPeriod = bidLimitedPeriodObj.val();
		if (typeof (bidLimitedPeriod) == "undefined" || bidLimitedPeriod == "") {
			bidLimitedPeriodObj.focus();
			showRemaindMessage('bidLimitedPeriod_remind_show_message',
					'����Ϊ������!');
			return false;
		} else if (!isDigitPositive(bidLimitedPeriod)) {
			showRemaindMessage('bidLimitedPeriod_remind_show_message',
					'������������!');
			return false;
		} else {
			clearRemindMessage('bidLimitedPeriod_remind_show_message');
		}
	}
	var applyStartTimeObj = $("#applyStartTime"); // ������ʼʱ��
	var applyStartTimeTmp = "";
	if (applyStartTimeObj) {
		var applyStartTime = applyStartTimeObj.val();
		if (typeof (applyStartTime) == "undefined" || applyStartTime == "") {
			applyStartTimeObj.focus();
			showRemaindMessage('applyStartTime_remind_show_message', '����Ϊ������!');
			return false;
		} else {
			clearRemindMessage('applyStartTime_remind_show_message');
		}
		// var sTime = millisecondBetween(applyStartTime, listingStartTimeTemp);
		// var eTime = millisecondBetween(listingEndTimeTemp, applyStartTime);
		if (!(comptime(listingStartTimeTemp, applyStartTime) && comptime(
				applyStartTime, listingEndTimeTemp))) {
			// if (!(sTime >= 0 && eTime >= 0)) {
			applyStartTimeObj.focus();
			showRemaindMessage('applyStartTime_remind_show_message',
					'�����ڹ��Ƶ���Чʱ�䷶Χ��!');
			return false;
		} else {
			clearRemindMessage('applyStartTime_remind_show_message');
		}
		applyStartTimeTmp = applyStartTime;
	}
	var applyEndTimeObj = $("#applyEndTime"); // ��������ʱ��
	var applyEndTimeTemp = "";
	if (applyEndTimeObj) {
		var applyEndTime = applyEndTimeObj.val();
		if (typeof (applyEndTime) == "undefined" || applyEndTime == "") {
			applyEndTimeObj.focus();
			showRemaindMessage('applyEndTime_remind_show_message', '����Ϊ������!');
			return false;
		} else {
			clearRemindMessage('applyEndTime_remind_show_message');
		}
		// var applyMlsd = millisecondBetween(applyEndTime, applyStartTimeTmp);
		// if (applyMlsd <= 0) {
		if (!comptime(applyStartTimeTmp, applyEndTime)) {
			showRemaindMessage('applyEndTime_remind_show_message',
					'��������ʱ��Ҫ���ڱ�����ʼʱ��!');
			return false;
		} else {
			clearRemindMessage('applyEndTime_remind_show_message');
		}
		// var sTime = millisecondBetween(applyEndTime, listingStartTimeTemp);
		// var eTime = millisecondBetween(listingEndTimeTemp, applyEndTime);
		// if (!(sTime >= 0 && eTime >= 0)) {
		if (!(comptime(listingStartTimeTemp, applyEndTime) && comptime(
				applyEndTime, listingEndTimeTemp))) {
			// if (!(applyEndTime >= listingStartTimeTemp && listingEndTimeTemp
			// >= applyEndTime)) {
			applyEndTimeObj.focus();
			showRemaindMessage('applyEndTime_remind_show_message',
					'�����ڹ��Ƶ���Чʱ�䷶Χ��!');
			return false;
		} else {
			clearRemindMessage('applyEndTime_remind_show_message');
		}
		applyEndTimeTemp = applyEndTime;
	}

	var bidStartTimeObj = $("#bidStartTime"); // ���ۿ�ʼʱ��
	if (bidStartTimeObj) {
		var bidStartTime = bidStartTimeObj.val();
		if (typeof (bidStartTime) == "undefined" || bidStartTime == "") {
			bidStartTimeObj.focus();
			showRemaindMessage('bidStartTime_remind_show_message', '����Ϊ������!');
			return false;
		} else {
			clearRemindMessage('bidStartTime_remind_show_message');
		}
		// var bidMlsd = millisecondBetween(bidStartTime, applyEndTimeTemp);
		// if (bidMlsd <= 0) {
		if (!comptime(applyEndTimeTemp, bidStartTime)) {
			showRemaindMessage('bidStartTime_remind_show_message',
					'���ۿ�ʼʱ��Ҫ���ڱ�������ʱ��!');
			return false;
		} else {
			clearRemindMessage('bidStartTime_remind_show_message');
		}

		// var sTime = millisecondBetween(bidStartTime, listingStartTimeTemp);
		// var eTime = millisecondBetween(listingEndTimeTemp, bidStartTime);
		// if (!(sTime >= 0 && eTime >= 0)) {
		if (!(comptime(listingStartTimeTemp, bidStartTime) && comptime(
				bidStartTime, listingEndTimeTemp))) {
			// if (!(bidStartTime >= listingStartTimeTemp && listingEndTimeTemp
			// >= bidStartTime)) {
			bidStartTimeObj.focus();
			showRemaindMessage('bidStartTime_remind_show_message',
					'�����ڹ��Ƶ���Чʱ�䷶Χ��!');
			return false;
		} else {
			clearRemindMessage('bidStartTime_remind_show_message');
		}
	}
	return true;
}

/**
 * ��֤�½���������
 * 
 * @return
 */
function validateForm() {
	var listingStartTimeObj = $("#listingStartTime");
	var listingEndTimeObj = $("#listingEndTime");
	var tradingTypeObj = $("input[name='tradingType']:radio:checked"); // ���׷�ʽ
	tradingType = tradingTypeObj.val();
	if (typeof (tradingType) == "undefined" || tradingType == "") {
		tradingType = $("#tradingType").val();
	}
	if ("placeOrder" == tradingType) {
		if (!placeOrderValidate()) {
			return false;
		}
	} else if ("bidOrder" == tradingType || "mulitBidOrder" == tradingType) {
		if (!bidOrderValidate()) {
			return false;
		}
	}
	var leaveQuantityObj = $('#leaveQuantity'); // ��Ŀ�����
	var breedStandardObj = $("#breedStandard");
	var breedStandardIdObj = $("#breedStandardId");
	if (!validatePrice()) {
		return false;
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
function validateMoney(priceObj, valuationUnitObj) {
	if (priceObj && valuationUnitObj && valuationUnitObj != ""
			&& priceObj != "") {
		var listingPrice = $("#" + priceObj).val();
		var valuationUnit = $("#" + valuationUnitObj).val();
		/*
		 * if (listingPrice == "") { showRemaindMessage(priceObj +
		 * '_remind_show_message', '��������'); return false; } else {
		 * clearRemindMessage(priceObj + '_remind_show_message'); } if
		 * (valuationUnit == "") {
		 * showRemaindMessage('valuationUnit_remind_show_message', '�Ƽ۵�λΪ��ѡ�');
		 * return false; } else {
		 * clearRemindMessage('valuationUnit_remind_show_message'); }
		 */
		if ("fen" == valuationUnit) { // ����Ƽ۵�λΪ�֣�����Ƶ���ֻ����������
			if (!isNumber(listingPrice)) {
				$("#" + priceObj).focus();
				showRemaindMessage(priceObj + '_remind_show_message',
						'�Է�Ϊ��λֻ������������!');
				return false;
			} else {
				clearRemindMessage(priceObj + '_remind_show_message');
			}
		} else if ("jiao" == valuationUnit) {
			if (!isDecimal1(listingPrice)) {
				$("#" + priceObj).focus();
				showRemaindMessage(priceObj + '_remind_show_message',
						'�Խ�Ϊ��λֻ�����벻������1λС����ֵ!');
				return false;
			} else {
				clearRemindMessage(priceObj + '_remind_show_message');
				// listingPrice = listingPrice.toString().movePoint(1);
				// listingPriceObj.val(listingPrice);
			}

		} else if ("yuan" == valuationUnit) {
			if (!isDecimal2(listingPrice)) {
				$("#" + priceObj).focus();
				showRemaindMessage(priceObj + '_remind_show_message',
						'��ԪΪ��λֻ�����벻������2λС����ֵ!');
				return false;
			} else {
				clearRemindMessage(priceObj + '_remind_show_message');
				// listingPrice = listingPrice.toString().movePoint(2);
				// listingPriceObj.val(listingPrice);
			}
		} else if ("wanyuan" == valuationUnit) {
			if (!isDecimal6(listingPrice)) {
				$("#" + priceObj).focus();
				showRemaindMessage(priceObj + '_remind_show_message',
						'����ԪΪ��λֻ�����벻������6λС����ֵ!');
				return false;
			} else {
				clearRemindMessage(priceObj + '_remind_show_message');
				// listingPrice = listingPrice.toString().movePoint(7);
				// $("#" + priceObj).val(listingPrice);
			}
		} else if ("yiyuan" == valuationUnit) {
			if (!isDecimal10(listingPrice)) {
				$("#" + priceObj).focus();
				showRemaindMessage(priceObj + '_remind_show_message',
						'����ԪΪ��λֻ�����벻������10λС����ֵ!');
				return false;
			} else {
				clearRemindMessage(priceObj + '_remind_show_message');
				// listingPrice = listingPrice.toString().movePoint(10);
				// $("#" + priceObj).val(listingPrice);
			}
		}
		return true;
	} else {
		alert("����Ƽ۵�λ�ͼ۸�Ԫ���Ƿ���ڣ�");
		return false;
	}

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
				clearRemindMessage('listingPrice_remind_show_message');
			}
		} else if ("jiao" == valuationUnit) {
			if (!isDecimal1(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'�Խ�Ϊ��λֻ�����벻������1λС����ֵ!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message');
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
				clearRemindMessage('listingPrice_remind_show_message');
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
				clearRemindMessage('listingPrice_remind_show_message');
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
				clearRemindMessage('listingPrice_remind_show_message');
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
function doUploadImage(imgUrlObj) {
	if (imgUrlObj) {
		var imgUrl = imgUrlObj.value;
		// $.ajax( {
		// url : "",
		// context : document.body,
		// success : function() {
		// $(this).addClass("done");
		// }
		// });
		$("#pictureMain").attr("src", imgUrl);
	}
}
$(document).ready(function() {
	$("#measureUnit").bind('change', function() {
		var selectValue = $(this).val();
		if ("zong" == selectValue) {
			$("tr[name='choose']").attr("style", "display:none;");
		} else {
			$("tr[name='choose']").attr("style", "display:;");
		}
	});

});

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
